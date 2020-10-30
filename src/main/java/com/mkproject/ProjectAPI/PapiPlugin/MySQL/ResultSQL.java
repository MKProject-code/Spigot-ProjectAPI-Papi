package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public final class ResultSQL {
    private ResultSet resultSet;
    private Statement statement;
    private ResultRowsList resultArrayList;

    ResultSQL(ResultSet resultSet, Statement statement) {
        this.resultSet = resultSet;
        this.statement = statement;
        this.resultArrayList = null;
    }

    public ResultSet getResultSet() {
        return this.resultSet;
    }

    public boolean isSuccess() {
        return this.resultSet != null;
    }
    public boolean isError() {
        return this.resultSet == null;
    }

    public ResultRowsList getResultArrayList() {
        if(this.resultArrayList != null)
            return this.resultArrayList;

        if(this.resultSet == null)
            return null;

        ResultRowsList list = new ResultRowsList();
        try {
            ResultSetMetaData md = this.resultSet.getMetaData();
            int columns = md.getColumnCount();
            while (this.resultSet.next()) {
                ResultRow row = new ResultRow(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(i, md.getColumnName(i), new ResultValue(this.resultSet.getObject(i)));
                }
                list.add(row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        this.resultArrayList = list;
        return this.resultArrayList;
    }

//    public ResultRowsList getResultArrayListDEF() {
//        if(this.resultArrayList != null)
//            return this.resultArrayList;
//
//        if(this.resultSet == null)
//            return null;
//
//        LinkedList<LinkedHashMap<String, ResultObject>> list = new LinkedList<>();
//        ResultSetMetaData md = null;
//        try {
//            md = this.resultSet.getMetaData();
//            int columns = md.getColumnCount();
//            while (this.resultSet.next()) {
//                LinkedHashMap<String, ResultObject> row = new LinkedHashMap<>(columns);
//                for (int i = 1; i <= columns; ++i) {
//                    row.put(md.getColumnName(i), new ResultObject(this.resultSet.getObject(i)));
//                }
//                list.add(row);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
//        this.resultArrayList = list;
//        return this.resultArrayList;
//    }

    public boolean close() {
        if(this.resultSet == null)
            return false;

        try {
            this.statement.close();
            this.resultSet = null;
            this.statement = null;
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

}
