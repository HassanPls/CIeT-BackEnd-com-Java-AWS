package org.example.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.example.persistence.entity.EmployeeEntity;

import com.mysql.cj.jdbc.StatementImpl;

public class EmployeeParamDAO {
    public void insert(final EmployeeEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)");) {

            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime()));

            statement.executeUpdate();

            System.out.printf("Foram afetados %s registros\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl)
                entity.setId(impl.getLastInsertID());

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertWithProcedure(final EmployeeEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                CallableStatement statement = connection
                        .prepareCall("call prc_insert_employee (?, ?, ?, ?)");) {

            statement.registerOutParameter(1, Types.BIGINT);
            statement.setString(2, entity.getName());
            statement.setBigDecimal(3, entity.getSalary());
            statement.setTimestamp(4,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime()));
            statement.execute();

            System.out.printf("Foram afetados %s registros\n", statement.getUpdateCount());
            entity.setId(statement.getLong(1));

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insert(final List<EmployeeEntity> entities) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)");) {
                connection.setAutoCommit(false);
                for (EmployeeEntity entity : entities) {
                    statement.setString(1, entity.getName());
                    statement.setBigDecimal(2, entity.getSalary());
                    statement.setTimestamp(3, Timestamp
                            .valueOf(entity.getBirthday().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()));
                    statement.addBatch();
                    statement.executeBatch();
                }
                statement.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE employees SET name = ?, salary = ?, birthday = ? WHERE id = ?");) {

            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime()));
            statement.setLong(4, entity.getId());

            statement.executeUpdate();

            System.out.printf("Foram afetados %s registros\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl)
                entity.setId(impl.getLastInsertID());

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(final long id) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");) {

            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.printf("Foram afetados %s registros\n", statement.getUpdateCount());

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement();) {

            String sql = String.format("SELECT * FROM employees");

            statement.executeQuery(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                EmployeeEntity entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                entity.setBirthday(
                        OffsetDateTime.ofInstant(resultSet.getTimestamp("birthday").toInstant(), ZoneOffset.UTC));
                entities.add(entity);
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final long id) {
        EmployeeEntity entity = new EmployeeEntity();
        try (
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?");) {

            statement.setLong(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                entity.setBirthday(
                        OffsetDateTime.ofInstant(resultSet.getTimestamp("birthday").toInstant(), ZoneOffset.UTC));
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
        return entity;

    }

    public String formatOffsetDateTime(final OffsetDateTime dateTime) {
        OffsetDateTime utcDateTime = dateTime.withOffsetSameInstant(ZoneOffset.UTC);
        return utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
