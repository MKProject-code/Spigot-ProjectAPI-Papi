package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public abstract class BuilderElement {

    private final Builder builder;
//    private String sql = "";

    protected BuilderElement(Builder builder) {
        this.builder = builder;
    }

    protected Builder getBuilder() {
        return this.builder;
    }

//    protected void addSqlIfNotEmpty(String sql) {
//        if(!this.sql.equals("")) this.sql += sql;
//    }
//
//    protected void addSql(String sql) {
//        this.sql += sql;
//    }
//
//    protected String getSql() {
//        return this.sql;
//    }


    protected void addBuilderSql(String prefix, String sql, boolean includePrefix) {
        if (includePrefix) this.addBuilderSql(prefix, sql);
        else this.builder.addSql(sql);
    }

    protected void addBuilderSql(String prefix, String sql) {
        this.builder.addSql(prefix + (prefix.equals(",") ? "" : " ") + sql);
    }

    protected void addBuilderSql(String sql) {
        this.builder.addSql(sql);
    }
}
