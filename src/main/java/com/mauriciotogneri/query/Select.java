package com.mauriciotogneri.query;

public class Select
{
    private final Projection projection;
    private final From from;
    private final GroupBy groupBy;
    private final OrderBy orderBy;

    private Select(Projection projection, From from, GroupBy groupBy, OrderBy orderBy)
    {
        this.projection = projection;
        this.from = from;
        this.groupBy = groupBy;
        this.orderBy = orderBy;
    }

    public Select(String... columns)
    {
        this(new Projection(columns), null, null, null);
    }

    public Select from(String table, String... tables)
    {
        return new Select(projection, new From(table, tables), groupBy, orderBy);
    }

    public Select groupBy(String column, String... columns)
    {
        return new Select(projection, from, new GroupBy(column, columns), orderBy);
    }

    public Select orderBy(String column, String... columns)
    {
        return new Select(projection, from, groupBy, new OrderBy(column, columns));
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

        return String.format("SELECT%s", builder.toString());
    }
}