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

    // from
    // where
    // groupby
    // having
    // orderby
    // limit

    /*
    public Select having(String condition)
    {
        return new Select(distinct, selectProjection, from, where, groupBy, new Having(condition), orderBy, limit);
    }

    public Select orderBy(String... columns)
    {
        return new Select(distinct, selectProjection, from, where, groupBy, having, new OrderBy(columns), limit);
    }

    public Select limit(long limit)
    {
        return new Select(distinct, selectProjection, from, where, groupBy, having, orderBy, new Limit(limit));
    }*/

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