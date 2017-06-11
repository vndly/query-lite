package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.Query;

public class SelectGroupBy extends Query
{
    private final Query parent;
    private final ItemList columns;

    SelectGroupBy(Query parent, String... columns)
    {
        this.parent = parent;
        this.columns = new ItemList(columns);
    }

    public SelectHaving having(String condition)
    {
        return new SelectHaving(this, condition);
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
        builder.append(String.format(" GROUP BY %s", columns));

        return builder.toString();
    }
}