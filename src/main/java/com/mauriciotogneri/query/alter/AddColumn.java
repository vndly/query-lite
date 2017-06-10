package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.Query;

public class AddColumn implements Query
{
    private final String table;
    private final String column;

    public AddColumn(String table, String column)
    {
        this.table = table;
        this.column = column;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (table != null)
        {
            builder.append(String.format(" %s", table));
        }

        if (column != null)
        {
            builder.append(String.format(" ADD COLUMN %s", column));
        }

        return String.format("ALTER TABLE%s;", builder.toString());
    }
}