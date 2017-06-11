package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

class Projection
{
    private final ItemList columns;

    Projection(String... columns)
    {
        this.columns = new ItemList(columns);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (!columns.isEmpty())
        {
            builder.append(columns);
        }
        else
        {
            builder.append("*");
        }

        return String.format(" %s", builder);
    }
}