package com.mauriciotogneri.query.common;

import com.mauriciotogneri.query.utils.Arrays;

public class ItemList
{
    private final Object[] items;

    public ItemList(Column... items)
    {
        this.items = items;
    }

    public ItemList(String... items)
    {
        this.items = items;
    }

    public Boolean isEmpty()
    {
        return (items.length == 0);
    }

    @Override
    public String toString()
    {
        return String.format("%s", Arrays.join(items, ","));
    }
}