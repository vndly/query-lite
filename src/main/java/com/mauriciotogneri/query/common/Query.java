package com.mauriciotogneri.query.common;

public class Query implements OldQuery
{
    public String query()
    {
        return String.format("%s;", toString());
    }
}