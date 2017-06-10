package com.mauriciotogneri.query.update;

import com.mauriciotogneri.query.common.OldQuery;
import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class UpdateWhere extends Query implements OldQuery
{
    private final UpdateSet updateSet;
    private final Where where;

    UpdateWhere(UpdateSet updateSet, Where where)
    {
        this.updateSet = updateSet;
        this.where = where;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(updateSet.toString());

        if (where != null)
        {
            builder.append(where.toString());
        }

        return builder.toString();
    }
}