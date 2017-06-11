package com.mauriciotogneri.query.drop;

import com.mauriciotogneri.query.common.Query;

public class DropIndex extends Query
{
    private final String name;
    private final Boolean ifExists;

    private DropIndex(String name, Boolean ifExists)
    {
        this.name = name;
        this.ifExists = ifExists;
    }

    DropIndex(String name)
    {
        this(name, false);
    }

    public DropIndex ifExist()
    {
        return new DropIndex(name, true);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DROP INDEX");

        if (ifExists)
        {
            builder.append(" IF EXISTS");
        }

        if (name != null)
        {
            builder.append(String.format(" %s", name));
        }

        return builder.toString();
    }
}