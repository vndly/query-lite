package com.mauriciotogneri.query;

public class Where
{
    private final Condition condition;

    Where(Condition condition)
    {
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return String.format(" WHERE %s", condition.toString());
    }
}