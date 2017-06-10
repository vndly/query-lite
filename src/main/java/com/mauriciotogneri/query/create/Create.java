package com.mauriciotogneri.query.create;

public class Create
{
    private final String table;
    private final Boolean ifNotExist;
    private final ColumnDef columns;

    private Create(String table, Boolean ifNotExist, ColumnDef columns)
    {
        this.table = table;
        this.ifNotExist = ifNotExist;
        this.columns = columns;
    }

    public Create(String table)
    {
        this(table, false, null);
    }

    public Create ifNotExist()
    {
        return new Create(table, true, columns);
    }

    public Create columns(String column, String... columns)
    {
        return new Create(table, ifNotExist, new ColumnDef(column, columns));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE");

        if (ifNotExist)
        {
            builder.append(" IF NOT EXISTS");
        }

        builder.append(String.format(" %s", table));

        if (columns != null)
        {
            builder.append(columns.toString());
        }

        builder.append(";");

        return builder.toString();
    }
}