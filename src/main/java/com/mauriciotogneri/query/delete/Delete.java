package com.mauriciotogneri.query.delete;

import com.mauriciotogneri.query.common.OldQuery;
import com.mauriciotogneri.query.common.Where;

public class Delete implements OldQuery
{
    private final String table;
    private final Where where;

    private Delete(String table, Where where)
    {
        this.table = table;
        this.where = where;
    }

    public Delete()
    {
        this(null, null);
    }

    public Delete from(String table)
    {
        return new Delete(table, where);
    }

    public Delete where(String condition)
    {
        return new Delete(table, new Where(condition));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (table != null)
        {
            builder.append(String.format(" %s", table));
        }

        if (where != null)
        {
            builder.append(where.toString());
        }

        return String.format("DELETE FROM%s;", builder.toString());
    }
}