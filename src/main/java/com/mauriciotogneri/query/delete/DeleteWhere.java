package com.mauriciotogneri.query.delete;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class DeleteWhere extends Query
{
    private final DeleteFrom deleteFrom;
    private final Where where;

    DeleteWhere(DeleteFrom deleteFrom, Where where)
    {
        this.deleteFrom = deleteFrom;
        this.where = where;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(deleteFrom);

        if (where != null)
        {
            builder.append(where);
        }

        return builder.toString();
    }
}