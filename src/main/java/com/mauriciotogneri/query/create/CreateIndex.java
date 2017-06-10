package com.mauriciotogneri.query.create;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class CreateIndex implements Query
{
    private final String name;
    private final String table;
    private final Boolean unique;
    private final Boolean ifNotExists;
    private final ItemList columns;
    private final Where where;

    private CreateIndex(String name, String table, Boolean unique, Boolean ifNotExists, ItemList columns, Where where)
    {
        this.name = name;
        this.table = table;
        this.unique = unique;
        this.ifNotExists = ifNotExists;
        this.columns = columns;
        this.where = where;
    }

    CreateIndex(String name)
    {
        this(name, null, false, false, null, null);
    }

    public CreateIndex on(String table)
    {
        return new CreateIndex(name, table, unique, ifNotExists, columns, where);
    }

    public CreateIndex unique()
    {
        return new CreateIndex(name, table, true, ifNotExists, columns, where);
    }

    public CreateIndex ifNotExist()
    {
        return new CreateIndex(name, table, unique, true, columns, where);
    }

    public CreateIndex columns(String column, String... columns)
    {
        return new CreateIndex(name, table, unique, ifNotExists, new ItemList(column, columns), where);
    }

    public CreateIndex where(String condition)
    {
        return new CreateIndex(name, table, unique, ifNotExists, columns, new Where(condition));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE");

        if (unique)
        {
            builder.append(" UNIQUE");
        }

        builder.append(" INDEX");

        if (ifNotExists)
        {
            builder.append(" IF NOT EXISTS");
        }

        if (name != null)
        {
            builder.append(String.format(" %s", name));
        }

        if (table != null)
        {
            builder.append(String.format(" ON %s", table));
        }

        if (columns != null)
        {
            builder.append(String.format(" (%s)", columns.toString()));
        }

        if (where != null)
        {
            builder.append(where.toString());
        }

        builder.append(";");

        return builder.toString();
    }
}