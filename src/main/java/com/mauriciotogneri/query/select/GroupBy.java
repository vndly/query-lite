package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

class GroupBy
{
    private final ItemList columns;

    GroupBy(String... columns)
    {
        this.columns = new ItemList(columns);
    }

    @Override
    public String toString()
    {
        return String.format(" GROUP BY %s", columns.toString());
    }
}