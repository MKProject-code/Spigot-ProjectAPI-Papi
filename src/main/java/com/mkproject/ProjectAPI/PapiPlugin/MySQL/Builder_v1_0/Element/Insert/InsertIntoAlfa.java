package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.ElementAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

import java.util.ArrayList;
import java.util.List;

public final class InsertIntoAlfa extends ElementAbstractController {

    protected InsertIntoAlfa(BuilderAbstractController builder, String table) {
        super(builder);
        table = BuilderUtils.formatTable(table);
        this.addBuilderSql("INSERT INTO", table);
    }

    public InsertIntoBeta columns(String... columns) {
        List<String> columnsList = new ArrayList<>();
        for(String column : columns) {
            columnsList.add(BuilderUtils.formatColumn(column));
        }
        this.addBuilderSql("("+String.join(",",columnsList)+")");
        return new InsertIntoBeta(this.getBuilder(), columnsList.size());
    }

//    public InsertIntoAlfa addListKeyValueMaps(Collection<Map<String, String>> keyValueMapsList) {
//
//    }

}
