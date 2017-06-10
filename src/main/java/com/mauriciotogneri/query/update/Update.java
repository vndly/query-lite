package com.mauriciotogneri.query.update;

public class Update
{
    public UpdateTable table(String table)
    {
        return new UpdateTable(table);
    }
}