package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.OldQuery;
import com.mauriciotogneri.query.common.Where;

public class Select implements OldQuery
{
    private final Boolean distinct;
    private final Projection projection;
    private final From from;
    private final Where where;
    private final GroupBy groupBy;
    private final Having having;
    private final OrderBy orderBy;
    private final Limit limit;

    private Select(Boolean distinct, Projection projection, From from, Where where, GroupBy groupBy, Having having, OrderBy orderBy, Limit limit)
    {
        this.distinct = distinct;
        this.projection = projection;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.having = having;
        this.orderBy = orderBy;
        this.limit = limit;
    }

    public Select()
    {
        this(false, new Projection(), null, null, null, null, null, null);
    }

    public Select distinct()
    {
        return new Select(true, projection, from, where, groupBy, having, orderBy, limit);
    }

    public Select columns(String... columns)
    {
        return new Select(distinct, new Projection(columns), from, where, groupBy, having, orderBy, limit);
    }

    public Select from(String... tables)
    {
        return new Select(distinct, projection, new From(tables), where, groupBy, having, orderBy, limit);
    }

    public Select where(String condition)
    {
        return new Select(distinct, projection, from, new Where(condition), groupBy, having, orderBy, limit);
    }

    public Select groupBy(String... columns)
    {
        return new Select(distinct, projection, from, where, new GroupBy(columns), having, orderBy, limit);
    }

    public Select having(String condition)
    {
        return new Select(distinct, projection, from, where, groupBy, new Having(condition), orderBy, limit);
    }

    public Select orderBy(String... columns)
    {
        return new Select(distinct, projection, from, where, groupBy, having, new OrderBy(columns), limit);
    }

    public Select limit(long limit)
    {
        return new Select(distinct, projection, from, where, groupBy, having, orderBy, new Limit(limit));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (distinct)
        {
            builder.append(" DISTINCT");
        }

        if (projection != null)
        {
            builder.append(projection);
        }

        if (from != null)
        {
            builder.append(from);
        }

        if (where != null)
        {
            builder.append(where);
        }

        if (groupBy != null)
        {
            builder.append(groupBy);
        }

        if (having != null)
        {
            builder.append(having);
        }

        if (orderBy != null)
        {
            builder.append(orderBy);
        }

        if (limit != null)
        {
            builder.append(limit);
        }

        return String.format("SELECT%s;", builder);
    }
}