package com.mauriciotogneri.query;

public class Select
{
    private final Projection projection;
    private final From from;
    private final GroupBy groupBy;

    private Select(Projection projection, From from, GroupBy groupBy)
    {
        this.projection = projection;
        this.from = from;
        this.groupBy = groupBy;
    }

    public Select(String... columns)
    {
        this(new Projection(columns), null, null);
    }

    public Select from(String table, String... tables)
    {
        return new Select(projection, new From(table, tables), groupBy);
    }

    public Select groupBy(String column, String... columns)
    {
        return new Select(projection, from, new GroupBy(column, columns));
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

        return String.format("SELECT%s", builder.toString());
    }
}