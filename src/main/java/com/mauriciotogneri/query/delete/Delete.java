package com.mauriciotogneri.query.delete;

public class Delete
{
    public DeleteFrom from(String table)
    {
        return new DeleteFrom(table);
    }
}