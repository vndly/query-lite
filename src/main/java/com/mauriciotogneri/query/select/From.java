package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.utils.Arrays;

public class From
{
    private final String[] tables;

    From(String table, String... tables)
    {
        this.tables = Arrays.join(table, tables);
    }

    @Override
    public String toString()
    {
        return String.format(" FROM %s", Arrays.join(tables, ","));
    }
}