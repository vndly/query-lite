package com.mauriciotogneri.query.insert;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.Query;

public class InsertValues extends Query
{
    private final InsertColumns insertColumns;
    private final ItemList values;

    InsertValues(InsertColumns insertColumns, ItemList values)
    {
        this.insertColumns = insertColumns;
        this.values = values;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(insertColumns.toString());

        if (values != null)
        {
            builder.append(String.format(" VALUES (%s)", values.toString()));
        }

        return builder.toString();
    }
}