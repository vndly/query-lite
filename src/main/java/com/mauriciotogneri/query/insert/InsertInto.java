package com.mauriciotogneri.query.insert;

import com.mauriciotogneri.query.common.ItemList;

public class InsertInto
{
    private final String table;

    InsertInto(String table)
    {
        this.table = table;
    }

    public InsertColumns columns(String column, String... columns)
    {
        return new InsertColumns(this, new ItemList(column, columns));
    }

    @Override
    public String toString()
    {
        return String.format("INSERT INTO %s", table);
    }
}