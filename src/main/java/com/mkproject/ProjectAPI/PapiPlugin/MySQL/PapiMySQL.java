package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import java.sql.*;

/**
 * The type Papi MySQL Controller.
 */
public final class PapiMySQL {

    private final Connection conn;

    /**
     * Instantiates a new Papi MySQL Controller.
     *
     * @param hostname the hostname (default port: 3306)
     * @param database the database
     * @param username the username
     * @param password the password
     * @param ssl the ssl
     * @throws ClassNotFoundException the MySQL driver class not found exception
     * @throws SQLException           the sql exception
     */
    public PapiMySQL(String hostname, String database, String username, String password, boolean ssl) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        if(hostname.contains(":"))
            this.conn = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"+database + "?autoReconnect=true&useSSL=" + ssl, username, password);
        else
            this.conn = DriverManager.getConnection("jdbc:mysql://"+hostname+":3306/"+database + "?autoReconnect=true&useSSL=" + ssl, username, password);
    }

    /**
     * Query result set.
     *
     * @param query the query
     * @return the result set
     * @throws SQLException the sql exception
     */
    public ResultSet query(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        stmt.close();
        return resultSet;
    }

    /**
     * Update int.
     *
     * @param query the query
     * @return the int
     * @throws SQLException the sql exception
     */
    public int update(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(query);
        stmt.close();
        return result;
    }
}
