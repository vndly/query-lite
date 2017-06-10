package com.mauriciotogneri.query.insert;

public class Insert
{
    public InsertInto into(String table)
    {
        return new InsertInto(table);
    }
}