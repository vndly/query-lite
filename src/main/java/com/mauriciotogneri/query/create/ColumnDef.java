package com.mauriciotogneri.query.create;

import com.mauriciotogneri.query.utils.Arrays;

public class ColumnDef
{
    private final String[] columns;

    ColumnDef(String column, String... columns)
    {
        this.columns = Arrays.join(column, columns);
    }

    @Override
    public String toString()
    {
        return String.format(" (%s)", Arrays.join(columns, ","));
    }
}