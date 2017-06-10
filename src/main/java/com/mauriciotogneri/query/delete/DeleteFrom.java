package com.mauriciotogneri.query.delete;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class DeleteFrom extends Query
{
    private final String table;

    DeleteFrom(String table)
    {
        this.table = table;
    }

    public DeleteWhere where(String condition)
    {
        return new DeleteWhere(this, new Where(condition));
    }

    @Override
    public String toString()
    {
        return String.format("DELETE FROM %s", table);
    }
}