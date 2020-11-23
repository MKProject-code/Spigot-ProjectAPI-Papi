package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;

public final class BuilderInsert extends BuilderAbstractController {

    public BuilderInsert(PapiMySQL papiMySQL) {
        super(papiMySQL);
    }

    public InsertIntoAlfa insertInto(String table) {
        return new InsertIntoAlfa(this, table);
    }
}
