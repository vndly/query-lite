package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.Query;

public class SelectOrderBy extends Query
{
    private final Query parent;
    private final ItemList columns;

    SelectOrderBy(Query parent, String... columns)
    {
        this.parent = parent;
        this.columns = new ItemList(columns);
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
        builder.append(String.format(" ORDER BY %s", columns));

        return builder.toString();
    }
}