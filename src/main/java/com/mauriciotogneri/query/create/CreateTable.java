package com.mauriciotogneri.query.create;

import com.mauriciotogneri.query.common.ItemList;

public class CreateTable
{
    private final String name;
    private final Boolean ifNotExists;
    private final ItemList columns;

    private CreateTable(String name, Boolean ifNotExists, ItemList columns)
    {
        this.name = name;
        this.ifNotExists = ifNotExists;
        this.columns = columns;
    }

    public CreateTable(String name)
    {
        this(name, false, null);
    }

    public CreateTable ifNotExist()
    {
        return new CreateTable(name, true, columns);
    }

    public CreateTable columns(String column, String... columns)
    {
        return new CreateTable(name, ifNotExists, new ItemList(column, columns));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE");

        if (ifNotExists)
        {
            builder.append(" IF NOT EXISTS");
        }

        builder.append(String.format(" %s", name));

        if (columns != null)
        {
            builder.append(String.format(" (%s)", columns.toString()));
        }

        builder.append(";");

        return builder.toString();
    }
}