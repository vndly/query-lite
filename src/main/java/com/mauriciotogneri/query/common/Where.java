package com.mauriciotogneri.query.common;

public class Where
{
    private final String condition;

    public Where(String condition)
    {
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return String.format(" WHERE (%s)", condition);
    }
}