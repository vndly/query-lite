package com.mauriciotogneri.query.update;

public class UpdateTable
{
    private final String table;

    UpdateTable(String table)
    {
        this.table = table;
    }

    public UpdateSet set(String column, Object value)
    {
        return new UpdateSet(this, column, value);
    }

    @Override
    public String toString()
    {
        return String.format("UPDATE %s", table);
    }
}