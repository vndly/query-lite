package com.mauriciotogneri.query;

public class Condition
{
    private final String condition;

    public Condition(String condition)
    {
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return condition;
    }
}