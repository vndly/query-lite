package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

public class OrderBy
{
    private final ItemList columns;

    OrderBy(String column, String... columns)
    {
        this.columns = new ItemList(column, columns);
    }

    @Override
    public String toString()
    {
        return String.format(" ORDER BY %s", columns.toString());
    }
}