package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.Query;

public class Alter implements Query
{
    private final String name;

    public Alter(String name)
    {
        this.name = name;
    }

    public Rename rename(String newName)
    {
        return new Rename(name, newName);
    }

    public AddColumn addColumn(String column)
    {
        return new AddColumn(name, column);
    }

    @Override
    public String toString()
    {
        return "";
    }
}