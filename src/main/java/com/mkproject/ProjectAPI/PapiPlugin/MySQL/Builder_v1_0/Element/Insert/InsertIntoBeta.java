package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.ElementAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

import java.util.ArrayList;
import java.util.List;

public final class InsertIntoBeta extends ElementAbstractController {

    private final int columnsSize;

    protected InsertIntoBeta(BuilderAbstractController builder, int columnsSize) {
        super(builder);
        this.columnsSize = columnsSize;
    }

    public InsertIntoGamma valuesArray(String[]... valuesArray) {
        boolean startPrefix = true;
        for (String[] values : valuesArray) {
            List<String> valuesList = new ArrayList<>();
            for (String value : values) {
                valuesList.add(BuilderUtils.formatValue(value));
            }
            if(valuesList.size() != this.columnsSize)
                throw new IllegalArgumentException("The number of values ("+valuesList.size()+") is different from the number of columns ("+this.columnsSize+")");
            this.addBuilderSql(startPrefix ? "VALUES" : ",", "(" + String.join(", ", valuesList) + ")");
            startPrefix = false;
        }
        return new InsertIntoGamma(this.getBuilder());
    }

}
