package com.mauriciotogneri.query.select;

import com.mauriciotogneri.query.common.Where;

public class Select
{
    private final Projection projection;
    private final From from;
    private final Where where;
    private final GroupBy groupBy;
    private final Having having;
    private final OrderBy orderBy;
    private final Limit limit;

    private Select(Projection projection, From from, Where where, GroupBy groupBy, Having having, OrderBy orderBy, Limit limit)
    {
        this.projection = projection;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.having = having;
        this.orderBy = orderBy;
        this.limit = limit;
    }

    public Select(String... columns)
    {
        this(new Projection(columns), null, null, null, null, null, null);
    }

    public Select from(String table, String... tables)
    {
        return new Select(projection, new From(table, tables), where, groupBy, having, orderBy, limit);
    }

    public Select where(String condition)
    {
        return new Select(projection, from, new Where(condition), groupBy, having, orderBy, limit);
    }

    public Select groupBy(String column, String... columns)
    {
        return new Select(projection, from, where, new GroupBy(column, columns), having, orderBy, limit);
    }

    public Select having(String condition)
    {
        return new Select(projection, from, where, groupBy, new Having(condition), orderBy, limit);
    }

    public Select orderBy(String column, String... columns)
    {
        return new Select(projection, from, where, groupBy, having, new OrderBy(column, columns), limit);
    }

    public Select limit(long limit)
    {
        return new Select(projection, from, where, groupBy, having, orderBy, new Limit(limit));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

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