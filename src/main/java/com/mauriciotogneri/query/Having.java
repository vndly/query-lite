package com.mauriciotogneri.query;

public class Having
{
    private final Condition condition;

    Having(Condition condition)
    {
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return String.format(" HAVING %s", condition.toString());
    }
}