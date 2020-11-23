package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;

public abstract class ElementAbstractController {

    private final BuilderAbstractController builder;

    protected ElementAbstractController(BuilderAbstractController builder) {
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
