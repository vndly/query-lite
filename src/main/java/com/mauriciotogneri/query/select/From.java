package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.ItemList;

class From
{
    private final ItemList tables;

    From(String... tables)
    {
        this.tables = new ItemList(tables);
    }

    @Override
    public String toString()
    {
        return String.format(" FROM %s", tables.toString());
    }
}