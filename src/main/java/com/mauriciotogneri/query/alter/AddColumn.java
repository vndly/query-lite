package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.Query;

public class AddColumn extends Query
{
    private final Alter alter;
    private final String column;

    AddColumn(Alter alter, String column)
    {
        this.alter = alter;
        this.column = column;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(alter.toString());

        if (column != null)
        {
            builder.append(String.format(" ADD COLUMN %s", column));
        }

        return builder.toString();
    }
}