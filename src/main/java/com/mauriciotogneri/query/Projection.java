package com.mauriciotogneri.query;

public class Projection
{
    private final String[] projection;

    Projection(String... projection)
    {
        this.projection = projection;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (projection.length > 0)
        {
            for (String element : projection)
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

        return String.format(" %s", builder.toString());
    }
}