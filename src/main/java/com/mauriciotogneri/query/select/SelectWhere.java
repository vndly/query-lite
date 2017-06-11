package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.Query;

public class SelectWhere extends Query
{
    private final Query parent;
    private final String condition;

    SelectWhere(Query parent, String condition)
    {
        this.parent = parent;
        this.condition = condition;
    }

    public SelectGroupBy groupBy(String... columns)
    {
        return new SelectGroupBy(this, columns);
    }

    public SelectOrderBy orderBy(String... columns)
    {
        return new SelectOrderBy(this, columns);
    }

    public SelectLimit limit(Object limit)
    {
        return new SelectLimit(this, limit);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(parent);
        builder.append(String.format(" WHERE (%s)", condition));

        return builder.toString();
    }
}