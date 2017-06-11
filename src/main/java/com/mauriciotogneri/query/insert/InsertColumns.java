package com.mauriciotogneri.query.insert;

import com.mauriciotogneri.query.common.ItemList;

public class InsertColumns
{
    private final InsertInto insertInto;
    private final ItemList columns;

    InsertColumns(InsertInto insertInto, ItemList columns)
    {
        this.insertInto = insertInto;
        this.columns = columns;
    }

    public InsertValues values(Object... values)
    {
        return new InsertValues(this, new ItemList(values));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(insertInto.toString());

        if (columns != null)
        {
            builder.append(String.format(" (%s)", columns.toString()));
        }

        return builder.toString();
    }
}