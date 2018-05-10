package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Represents a connection to the database
 *
 * @author Janos Benyovszki
 */
class DataSource {

    //TODO move db to Default/ShadowCaster folder

    private static final String DB_NAME = "shadow_caster.db";
    private static final String CONNECTION = "jdbc:sqlite:src\\main\\java\\database\\" + DB_NAME;

    Connection open() {

        try {
            return DriverManager.getConnection(CONNECTION);
        } catch (SQLException e) {
            //TODO add error logging
            return null;
        }
    }

}