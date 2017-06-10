package com.mauriciotogneri.query.select;

class Limit
{
    private final Long limit;

    Limit(Long limit)
    {
        this.limit = limit;
    }

    @Override
    public String toString()
    {
        return String.format(" LIMIT %s", limit);
    }
}