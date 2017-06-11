package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.Query;

public class SelectFrom extends Query
{
    private final SelectProjection selectProjection;
    private final ItemList tables;

    SelectFrom(SelectProjection selectProjection, String... tables)
    {
        this.selectProjection = selectProjection;
        this.tables = new ItemList(tables);
    }

    public SelectWhere where(String condition)
    {
        return new SelectWhere(this, condition);
    }

    public SelectGroupBy groupBy(String... columns)
    {
        return new SelectGroupBy(this, columns);
    }

    public SelectOrderBy orderBy(String... columns)
    {
        return new SelectOrderBy(this, columns);
    }

    public SelectLimit limit(long limit)
    {
        return new SelectLimit(this, limit);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(selectProjection);
        builder.append(String.format(" FROM %s", tables));

        return builder.toString();
    }
}