package persistence.migration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MigrationStrategy {
    private final Connection connection;

    public void executeMigration() {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try (FileOutputStream fos = new FileOutputStream("liquibase.log")) {
            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));

            JdbcConnection jdbcConnection = new JdbcConnection(connection);
            try (Liquibase liquibase = new Liquibase("/db/changelog/db.changelog-master.yml",
                    new ClassLoaderResourceAccessor(), jdbcConnection)) {
                liquibase.update();
            }

        } catch (IOException | LiquibaseException e) {
            e.printStackTrace();
            System.setErr(originalErr);
            System.setOut(originalOut);
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}
