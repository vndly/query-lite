package com.mauriciotogneri.query;

public class From
{
    private final String[] tables;

    From(String table, String... tables)
    {
        this.tables = new String[tables.length + 1];
        this.tables[0] = table;
        System.arraycopy(tables, 0, this.tables, 1, tables.length);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (tables.length > 0)
        {
            for (String element : tables)
            {
                if (builder.length() != 0)
                {
                    builder.append(", ");
                }

                builder.append(element);
            }
        }
        else
        {
            builder.append("*");
        }

        return String.format(" FROM %s", builder.toString());
    }
}