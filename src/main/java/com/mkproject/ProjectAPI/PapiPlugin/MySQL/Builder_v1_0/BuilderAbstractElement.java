package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select.BuilderSelect;

public abstract class BuilderAbstractElement {

    private final BuilderAbstractController builder;

    protected BuilderAbstractElement(BuilderAbstractController builder) {
        this.builder = builder;
    }

    protected BuilderAbstractController getBuilder() {
        return this.builder;
    }

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
