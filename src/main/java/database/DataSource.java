package database;

import log.Log;
import log.LogMessage;
import log.LogTypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Represents a connection to the database
 *
 * @author Janos Benyovszki
 */
class DataSource {

    //TODO create ShadowCaster folder

    private static final String DB_LOCATION = System.getProperty("user.home") + "\\AppData\\Local\\ShadowCaster\\db\\";
    private static final String DB_NAME = "shadow_caster.db";
    private static final String CONNECTION = "jdbc:sqlite:" + DB_LOCATION + DB_NAME;

    Connection open() {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(CONNECTION);
        } catch (SQLException | ClassNotFoundException e) {

            if (e instanceof SQLException) {
                new Log().write(new LogMessage(LogTypes.ERROR, "SQL error " +
                        e.getMessage()));
            } else {
                new Log().write(new LogMessage(LogTypes.ERROR, "Driver error " +
                        e.getMessage()));
            }

            return null;
        }
    }

}
