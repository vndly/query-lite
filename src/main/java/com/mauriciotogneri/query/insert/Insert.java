package com.mauriciotogneri.query.insert;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.OldQuery;

public class Insert implements OldQuery
{
    private final String table;
    private final ItemList columns;
    private final ItemList values;

    private Insert(String table, ItemList columns, ItemList values)
    {
        this.table = table;
        this.columns = columns;
        this.values = values;
    }

    public Insert()
    {
        this(null, null, null);
    }

    public Insert into(String table)
    {
        return new Insert(table, columns, values);
    }

    public Insert columns(String column, String... columns)
    {
        return new Insert(table, new ItemList(column, columns), values);
    }

    public Insert values(Object value, Object... values)
    {
        return new Insert(table, columns, new ItemList(value, values));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (table != null)
        {
            builder.append(String.format(" %s", table));
        }

        if (columns != null)
        {
            builder.append(String.format(" (%s)", columns.toString()));
        }

        if (values != null)
        {
            builder.append(String.format(" VALUES (%s)", values.toString()));
        }

        return String.format("INSERT INTO%s;", builder.toString());
    }
}