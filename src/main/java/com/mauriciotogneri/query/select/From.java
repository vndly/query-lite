package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

public class From
{
    private final ItemList tables;

    From(String table, String... tables)
    {
        this.tables = new ItemList(table, tables);
    }

    @Override
    public String toString()
    {
        return String.format(" FROM %s", tables.toString());
    }
}