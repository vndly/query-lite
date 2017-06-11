package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

class OrderBy
{
    private final ItemList columns;

    OrderBy(String... columns)
    {
        this.columns = new ItemList(columns);
    }

    @Override
    public String toString()
    {
        return String.format(" ORDER BY %s", columns);
    }
}