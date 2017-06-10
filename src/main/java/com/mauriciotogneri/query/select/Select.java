package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

public class Select implements Query
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

    public Select from(String table, String... tables)
    {
        return new Select(distinct, projection, new From(table, tables), where, groupBy, having, orderBy, limit);
    }

    public Select where(String condition)
    {
        return new Select(distinct, projection, from, new Where(condition), groupBy, having, orderBy, limit);
    }

    public Select groupBy(String column, String... columns)
    {
        return new Select(distinct, projection, from, where, new GroupBy(column, columns), having, orderBy, limit);
    }

    public Select having(String condition)
    {
        return new Select(distinct, projection, from, where, groupBy, new Having(condition), orderBy, limit);
    }

    public Select orderBy(String column, String... columns)
    {
        return new Select(distinct, projection, from, where, groupBy, having, new OrderBy(column, columns), limit);
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
            builder.append(projection.toString());
        }

        if (from != null)
        {
            builder.append(from.toString());
        }

        if (where != null)
        {
            builder.append(where.toString());
        }

        if (groupBy != null)
        {
            builder.append(groupBy.toString());
        }

        if (having != null)
        {
            builder.append(having.toString());
        }

        if (orderBy != null)
        {
            builder.append(orderBy.toString());
        }

        if (limit != null)
        {
            builder.append(limit.toString());
        }

        return String.format("SELECT%s;", builder.toString());
    }
}