package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

public class SelectProjection
{
    private final Select select;
    private final ItemList columns;

    SelectProjection(Select select, String... columns)
    {
        this.select = select;
        this.columns = new ItemList(columns);
    }

    public SelectFrom from(String... tables)
    {
        return new SelectFrom(this, tables);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(select);

        if (columns.isEmpty())
        {
            builder.append(" *");
        }
        else
        {
            builder.append(String.format(" %s", columns));
        }

        return builder.toString();
    }
}