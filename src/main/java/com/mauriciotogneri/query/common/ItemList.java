package com.mauriciotogneri.query.common;

import com.mauriciotogneri.query.utils.Arrays;

public class ItemList
{
    private final String[] items;

    public ItemList(String item, String... items)
    {
        this.items = Arrays.join(item, items);
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