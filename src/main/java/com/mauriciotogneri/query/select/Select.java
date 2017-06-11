package com.mauriciotogneri.query.select;

public class Select
{
    private final Boolean distinct;
    private final SelectProjection selectProjection;

    private Select(Boolean distinct, SelectProjection selectProjection)
    {
        this.distinct = distinct;
        this.selectProjection = selectProjection;
    }

    public Select()
    {
        this(false, null);
    }

    public Select distinct()
    {
        return new Select(true, selectProjection);
    }

    public SelectProjection columns(String... columns)
    {
        return new SelectProjection(this, columns);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT");

        if (distinct)
        {
            builder.append(" DISTINCT");
        }

        return builder.toString();
    }
}