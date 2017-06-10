package com.mauriciotogneri.query.select;

class Having
{
    private final String condition;

    Having(String condition)
    {
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return String.format(" HAVING (%s)", condition);
    }
}