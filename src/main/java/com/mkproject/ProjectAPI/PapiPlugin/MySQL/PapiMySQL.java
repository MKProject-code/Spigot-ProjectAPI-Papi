package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import com.mkproject.ProjectAPI.PapiPlugin.PapiPlugin;

import java.sql.*;

/**
 * The type Papi MySQL Controller.
 */
public final class PapiMySQL {

    private final Connection conn;
    private final PapiPlugin papiPlugin;
    private boolean consoleDebug;

    /**
     * Instantiates a new Papi MySQL Controller.
     *
     * @param hostname the hostname (default port: 3306)
     * @param database the database
     * @param username the username
     * @param password the password
     * @param ssl      the ssl
     * @throws ClassNotFoundException the MySQL driver class not found exception
     * @throws SQLException           the sql exception
     */
    public PapiMySQL(PapiPlugin papiPlugin, String hostname, String database, String username, String password, boolean ssl) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        if (hostname.contains(":"))
            this.conn = DriverManager.getConnection("jdbc:mysql://" + hostname + "/" + database + "?autoReconnect=true&useSSL=" + ssl, username, password);
        else
            this.conn = DriverManager.getConnection("jdbc:mysql://" + hostname + ":3306/" + database + "?autoReconnect=true&useSSL=" + ssl, username, password);

        this.papiPlugin = papiPlugin;
        this.consoleDebug = false;
    }

    /**
     * Sets console debug.
     *
     * @param consoleDebug the console debug
     */
    public void setConsoleDebug(boolean consoleDebug) {
        this.consoleDebug = consoleDebug;
    }

    /**
     * Query result set.
     *
     * @param query the query
     * @return the result set
     */
    public ResultSQL query(String query) {
        if (this.consoleDebug)
            this.papiPlugin.getLogger().info("PapiMySQL console debug -> query: " + query);

        Statement stmt = null;
        try {
            stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return new ResultSQL(rs, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {
                }
            }
            return new ResultSQL(null, stmt);
        }
    }

    /**
     * Update int.
     *
     * @param query the query
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
     * @throws SQLException the sql exception
     */
    public int update(String query) throws SQLException {
        if (this.consoleDebug)
            this.papiPlugin.getLogger().info("PapiMySQL console debug -> update: " + query);

        Statement stmt = this.conn.createStatement();
        int result = stmt.executeUpdate(query);
        stmt.close();
        return result;
    }

    /**
     * SQL Builder v1.0.
     *
     * @return the SQL builder v1.0
     */
    public com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderSQL builder_v1_0() {
        return new com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderSQL(this);
    }
}
