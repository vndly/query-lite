package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.utils.Arrays;

public class Projection
{
    private final String[] columns;

    Projection(String... columns)
    {
        this.columns = columns;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (columns.length > 0)
        {
            builder.append(Arrays.join(columns, ","));
        }
        else
        {
            builder.append("*");
        }

        return String.format(" %s", builder.toString());
    }
}