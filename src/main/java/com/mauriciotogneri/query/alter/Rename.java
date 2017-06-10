package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.OldQuery;

public class Rename implements OldQuery
{
    private final String oldName;
    private final String newName;

    public Rename(String oldName, String newName)
    {
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (oldName != null)
        {
            builder.append(String.format(" %s", oldName));
        }

        if (newName != null)
        {
            builder.append(String.format(" RENAME TO %s", newName));
        }

        return String.format("ALTER TABLE%s;", builder.toString());
    }
}