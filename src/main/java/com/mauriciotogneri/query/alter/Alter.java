package com.mauriciotogneri.query.alter;

import com.mauriciotogneri.query.common.Column;

public class Alter
{
    private final String table;

    public Alter(String table)
    {
        this.table = table;
    }

    public Rename rename(String newName)
    {
        return new Rename(this, newName);
    }

    public AddColumn addColumn(Column column)
    {
        return new AddColumn(this, column);
    }

    @Override
    public String toString()
    {
        return String.format("ALTER TABLE %s", table);
    }
}