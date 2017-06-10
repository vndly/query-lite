package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.utils.Arrays;

public class GroupBy
{
    private final String[] columns;

    GroupBy(String column, String... columns)
    {
        this.columns = Arrays.join(column, columns);
    }

    @Override
    public String toString()
    {
        return String.format(" GROUP BY %s", Arrays.join(columns, ","));
    }
}