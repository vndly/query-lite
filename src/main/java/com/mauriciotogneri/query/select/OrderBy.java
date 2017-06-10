package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.utils.Arrays;

public class OrderBy
{
    private final String[] columns;

    OrderBy(String column, String... columns)
    {
        this.columns = Arrays.join(column, columns);
    }

    @Override
    public String toString()
    {
        return String.format(" ORDER BY %s", Arrays.join(columns, ","));
    }
}