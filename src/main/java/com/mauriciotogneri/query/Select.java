package com.mauriciotogneri.query;

public class Select
{
    private final Projection projection;
    private final From from;

    private Select(Projection projection, From from)
    {
        this.projection = projection;
        this.from = from;
    }

    public Select(String... projection)
    {
        this(new Projection(projection), null);
    }

    public Select from(String table, String... tables)
    {
        return new Select(projection, new From(table, tables));
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

        return String.format("SELECT%s", builder.toString());
    }
}