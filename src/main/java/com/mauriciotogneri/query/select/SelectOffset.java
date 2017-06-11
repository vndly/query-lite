package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.Query;

public class SelectOffset extends Query
{
    private final Query parent;
    private final Object offset;

    SelectOffset(Query parent, Object offset)
    {
        this.parent = parent;
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(parent);
        builder.append(String.format(" OFFSET %s", offset));

        return builder.toString();
    }
}