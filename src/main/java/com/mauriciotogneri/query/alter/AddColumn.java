package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.Column;
import com.mauriciotogneri.query.common.Query;

public class AddColumn extends Query
{
    private final Alter alter;
    private final Column column;

    AddColumn(Alter alter, Column column)
    {
        this.alter = alter;
        this.column = column;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(alter);

        if (column != null)
        {
            builder.append(String.format(" ADD COLUMN %s", column));
        }

        return builder.toString();
    }
}