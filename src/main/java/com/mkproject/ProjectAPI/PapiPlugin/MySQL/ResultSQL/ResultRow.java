package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Set;

public final class ResultRow {
    private LinkedHashMap<Integer, ResultValue> columnsIndexesObjectMap = new LinkedHashMap<>();
    private LinkedHashMap<String, ResultValue> columnsNamesObjectMap = new LinkedHashMap<>();
    private int columns;

    ResultRow(int columns) {
        this.columns = columns;
    }

    void put(int columnIndex, String columnName, ResultValue resultObject) {
        this.columnsIndexesObjectMap.put(columnIndex, resultObject);
        this.columnsNamesObjectMap.put(columnName, resultObject);
    }

    public int getColumnsSize() {
        return this.columns;
    }
    public Set<String> getColumnsSet() {
        return this.columnsNamesObjectMap.keySet();
    }

    // Get ResultValue
    public ResultValue getValue(int columnIndex) {
        return this.columnsIndexesObjectMap.get(columnIndex);
    }
    public ResultValue getValue(String columnName) {
        return this.columnsNamesObjectMap.get(columnName);
    }

    // Get String
    public String getString(int column) {
        return this.getValue(column).getString();
    }
    public String getString(String columnName) {
        return this.getValue(columnName).getString();
    }

    // Get Integer
    public Integer getInt(int column) {
        return this.getValue(column).getInt();
    }
    public Integer getInt(String columnName) {
        return this.getValue(columnName).getInt();
    }

    // Get Boolean
    public Boolean getBoolean(int column) {
        return this.getValue(column).getBoolean();
    }
    public Boolean getBoolean(String columnName) {
        return this.getValue(columnName).getBoolean();
    }

    // Get Long
    public Long getLong(int column) {
        return this.getValue(column).getLong();
    }
    public Long getLong(String columnName) {
        return this.getValue(columnName).getLong();
    }

    // Get Long
    public Double getDouble(int column) {
        return this.getValue(column).getDouble();
    }
    public Double getDouble(String columnName) {
        return this.getValue(columnName).getDouble();
    }

    // Get LocalDateTime
    public LocalDateTime getDateTime(int column) {
        return this.getValue(column).getDateTime();
    }
    public LocalDateTime getDateTime(String columnName) {
        return this.getValue(columnName).getDateTime();
    }

    // Get LocalDateTime with pattern
    public LocalDateTime getDateTime(int column, String pattern) {
        return this.getValue(column).getDateTime(pattern);
    }
    public LocalDateTime getDateTime(String columnName, String pattern) {
        return this.getValue(columnName).getDateTime(pattern);
    }
}
