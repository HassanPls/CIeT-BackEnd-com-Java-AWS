import java.sql.Connection;
import java.sql.SQLException;

import persistence.config.ConnectionConfig;
import persistence.migration.MigrationStrategy;
import ui.MainMenu;

public class App {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionConfig.getConnection()) { 
            new MigrationStrategy(connection).executeMigration();
        } 

        new MainMenu().execute();
    }
}
