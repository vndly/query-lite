package com.mauriciotogneri.query.insert;

public class InsertInto
{
    private final String table;

    InsertInto(String table)
    {
        this.table = table;
    }

    public InsertSet set(String column, Object value)
    {
        return new InsertSet(this, column, value);
    }

    @Override
    public String toString()
    {
        return String.format("INSERT INTO %s", table);
    }
}