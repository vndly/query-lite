package com.mauriciotogneri.query.update;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class UpdateWhere extends Query
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
        builder.append(updateSet);

        if (where != null)
        {
            builder.append(where);
        }

        return builder.toString();
    }
}