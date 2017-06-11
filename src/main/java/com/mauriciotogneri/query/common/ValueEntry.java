package com.mauriciotogneri.query.common;

public class ValueEntry
{
    private final String column;
    private final Value value;

    public ValueEntry(String column, Value value)
    {
        this.column = column;
        this.value = value;
    }

    public String column()
    {
        return column;
    }

    public String value()
    {
        return value.toString();
    }
}