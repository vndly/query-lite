package com.mauriciotogneri.query;

public class Select
{
    private final Projection projection;
    private final From from;
    private final GroupBy groupBy;
    private final OrderBy orderBy;
    private final Limit limit;

    private Select(Projection projection, From from, GroupBy groupBy, OrderBy orderBy, Limit limit)
    {
        this.projection = projection;
        this.from = from;
        this.groupBy = groupBy;
        this.orderBy = orderBy;
        this.limit = limit;
    }

    public Select(String... columns)
    {
        this(new Projection(columns), null, null, null, null);
    }

    public Select from(String table, String... tables)
    {
        return new Select(projection, new From(table, tables), groupBy, orderBy, null);
    }

    public Select groupBy(String column, String... columns)
    {
        return new Select(projection, from, new GroupBy(column, columns), orderBy, null);
    }

    public Select orderBy(String column, String... columns)
    {
        return new Select(projection, from, groupBy, new OrderBy(column, columns), null);
    }

    public Select limit(long limit)
    {
        return new Select(projection, from, groupBy, orderBy, new Limit(limit));
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

        if (groupBy != null)
        {
            builder.append(groupBy.toString());
        }

        if (orderBy != null)
        {
            builder.append(orderBy.toString());
        }

        if (limit != null)
        {
            builder.append(limit.toString());
        }

        return String.format("SELECT%s", builder.toString());
    }
}