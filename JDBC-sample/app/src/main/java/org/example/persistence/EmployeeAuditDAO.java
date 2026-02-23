package org.example.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.persistence.entity.EmployeeAuditEntity;
import org.example.persistence.entity.OperationEnum;

public class EmployeeAuditDAO {
    public List<EmployeeAuditEntity> findAll() {
        List<EmployeeAuditEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement();) {

            String sql = String.format("SELECT * FROM view_employee_audit");

            statement.executeQuery(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                entities.add(new EmployeeAuditEntity(
                        resultSet.getLong("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("old_name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getBigDecimal("old_salary"),
                        Objects.isNull(resultSet.getTimestamp("birthday")) ? null
                                : OffsetDateTime.ofInstant(resultSet.getTimestamp("birthday").toInstant(),
                                        ZoneOffset.UTC),
                        Objects.isNull(resultSet.getTimestamp("old_birthday")) ? null
                                : OffsetDateTime.ofInstant(resultSet.getTimestamp("old_birthday").toInstant(),
                                        ZoneOffset.UTC),
                        OperationEnum.getByDbOperation(resultSet.getString("operation"))));
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
            e.printStackTrace();
        }
        return entities;
    }
}
