package com.mauriciotogneri.query.common;

public class Query implements OldQuery
{
    public String query(Object... parameters)
    {
        // TODO
        return String.format("%s;", toString());
    }
}