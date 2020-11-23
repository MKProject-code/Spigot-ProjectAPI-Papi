package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import java.util.Iterator;
import java.util.LinkedList;

public final class ResultRowsList implements Iterable<ResultRow> {
    private final LinkedList<ResultRow> linkedList;

    ResultRowsList() {
        this.linkedList = new LinkedList<>();
    }

    void add(ResultRow resultRow) {
        this.linkedList.add(resultRow);
    }

    @Override
    public Iterator<ResultRow> iterator() {
        return this.linkedList.iterator();
    }
}
