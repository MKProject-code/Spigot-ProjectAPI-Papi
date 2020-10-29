package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import java.util.*;

//public enum OperatorSQL {
//    Equal("="),
//    GreaterThan(">"),
//    LessThan("<"),
//    GreaterThanOrEqual(">="),
//    LessThanOrEqual("<="),
//    NotEqual("<>"),
//    Between("<>"),
//    Like("<>"),
//    In("<>"),
//}

public final class SelectSQL {

    private boolean distinct = false;
    private Map<String, String> aliasTable = new HashMap<>();
    private Map<String, List<String>> tableSelectColumns = new HashMap<>();
    private Map<String, List<String>> tableSelectColumnsCount = new HashMap<>();
    private Map<String, List<String>> tableSelectColumnsAvg = new HashMap<>();
    private Map<String, List<String>> tableSelectColumnsSum = new HashMap<>();
    private Map<String, List<String>> tableWhereColumnsCondition = new HashMap<>();
    private WhereSQL conditions = null;

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public SelectSQL addTableAlias(String table, String alias) {
        this.aliasTable.put(alias, table);
        return this;
    }

//    public SelectSQL addSelect(String table, String... columns) {
//        List<String> columnsList = tableSelectColumns.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }
//
//    public SelectSQL addSelectCount(String table, String... columns) {
//        List<String> columnsList = tableSelectColumnsCount.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }
//
//    public SelectSQL addSelectAvg(String table, String... columns) {
//        List<String> columnsList = tableSelectColumnsAvg.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }
//
//    public SelectSQL addSelectSum(String table, String... columns) {
//        List<String> columnsList = tableSelectColumnsSum.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }

    public SelectSQL addSelect(String... columns) {
        for(String column : columns) {
            int dotIndex = column.indexOf(".");
            String table = null;
            if(dotIndex > 0) {
                table = column.substring(0, dotIndex);
                column = column.substring(dotIndex+1);
            }
            List<String> columnsList = tableSelectColumns.get(table);
            if (columnsList == null) tableSelectColumns.put(table, new ArrayList<>(Collections.singletonList(column)));
            else columnsList.add(column);
        }
        return this;
    }
//
//    public SelectSQL addSelectCount(String... columns) {
//        List<String> columnsList = tableSelectColumnsCount.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }
//
//    public SelectSQL addSelectAvg(String... columns) {
//        List<String> columnsList = tableSelectColumnsAvg.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }
//
//    public SelectSQL addSelectSum(String... columns) {
//        List<String> columnsList = tableSelectColumnsSum.putIfAbsent(table, new ArrayList<>(Arrays.asList(columns)));
//        if(columnsList != null) columnsList.addAll(Arrays.asList(columns));
//        return this;
//    }

    public SelectSQL setWhere(WhereSQL conditions) {
        this.conditions = conditions;
        return this;
    }

//    public String build() {
//
//    }
}
