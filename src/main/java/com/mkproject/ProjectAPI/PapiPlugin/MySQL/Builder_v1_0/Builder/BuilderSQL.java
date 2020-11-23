package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert.BuilderInsert;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert.InsertIntoAlfa;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Select.BuilderSelect;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Select.SelectAlfa;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;

public final class BuilderSQL {

    private final PapiMySQL papiMySQL;

    public BuilderSQL(PapiMySQL papiMySQL) {
        this.papiMySQL = papiMySQL;
    }

    public SelectAlfa select() {
        return (new BuilderSelect(this.papiMySQL)).select();
    }

    public InsertIntoAlfa insertInto(String table) {
        return (new BuilderInsert(this.papiMySQL)).insertInto(table);
    }
}
