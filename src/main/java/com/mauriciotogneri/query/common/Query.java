package com.mauriciotogneri.query.common;

public class Query
{
    public String query(Object... parameters)
    {
        String query = toString();
        Value[] values = values(parameters);

        for (Value value : values)
        {
            int index = query.indexOf("?");

            if (index > -1)
            {
                query = query.replaceFirst("\\?", value.toString());
            }
        }

        return String.format("%s;", query);
    }

    private Value[] values(Object... parameters)
    {
        Value[] values = new Value[parameters.length];

        for (int i = 0; i < parameters.length; i++)
        {
            values[i] = new Value(parameters[i]);
        }

        return values;
    }
}