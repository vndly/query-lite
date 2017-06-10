package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.Query;

public class Rename extends Query
{
    private final Alter alter;
    private final String newName;

    Rename(Alter alter, String newName)
    {
        this.alter = alter;
        this.newName = newName;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(alter.toString());

        if (newName != null)
        {
            builder.append(String.format(" RENAME TO %s", newName));
        }

        return builder.toString();
    }
}