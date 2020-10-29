package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Insert;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select.BuilderSelect;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select.SelectAlfa;

public final class BuilderInsert extends BuilderAbstractController {

    public InsertIntoAlfa insertInto() {
        return new InsertIntoAlfa(this);
    }
}
