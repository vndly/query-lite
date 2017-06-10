package com.mauriciotogneri.query.update;

import com.mauriciotogneri.query.common.ItemList;
import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class Update implements Query
{
    private final String table;
    private final ItemList set;
    private final Where where;

    private Update(String table, ItemList set, Where where)
    {
        this.table = table;
        this.set = set;
        this.where = where;
    }

    public Update()
    {
        this(null, null, null);
    }

    public Update table(String table)
    {
        return new Update(table, set, where);
    }

    public Update set(String value, String... values)
    {
        return new Update(table, new ItemList(value, values), where);
    }

    public Update where(String condition)
    {
        return new Update(table, set, new Where(condition));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (table != null)
        {
            builder.append(String.format(" %s", table));
        }

        if (set != null)
        {
            builder.append(String.format(" SET (%s)", set.toString()));
        }

        if (where != null)
        {
            builder.append(where.toString());
        }

        return String.format("UPDATE%s;", builder.toString());
    }
}