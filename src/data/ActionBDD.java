package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an action to interact with a database and retrieve a list of programmers.
 */
public interface ActionBDD {

    /**
     * Sets the prepared statement and result set for executing a database query.
     *
     * @param query The SQL query to be executed.
     * @throws SQLException If a SQL exception occurs while preparing or executing the query.
     */
    public void setPreparedStatementAndResultSet(String query) throws SQLException;
    /**
     * Establishes a connection to the database.
     *
     * @throws Exception If a database connection cannot be established.
     */
    public void connect() throws Exception;

    /**
     * Disconnects from the database.
     *
     * @throws Exception If there is an issue while closing the database connection.
     */
    public void disconnect() throws Exception;

    /**
     * Retrieves programmer data from the result set and adds them to the list of programmers.
     *
     * @throws Exception If there is an issue while retrieving data or processing the result set.
     */
    public void insertProgrammeur() throws Exception;

    /**
     * Displays the list of programmers by calling the "afficher" method for each programmer.
     * @throws Exception 
     */
//    public void afficher() throws Exception;
}
