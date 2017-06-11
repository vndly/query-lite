package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.Query;

public class SelectLimit extends Query
{
    private final Query parent;
    private final Object limit;

    SelectLimit(Query parent, Object limit)
    {
        this.parent = parent;
        this.limit = limit;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(parent);
        builder.append(String.format(" LIMIT %s", limit));

        return builder.toString();
    }
}