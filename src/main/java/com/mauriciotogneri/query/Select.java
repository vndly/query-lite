package com.mauriciotogneri.query;

public class Select
{
    private final String[] projection;

    public Select(String... projection)
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

        return String.format("SELECT %s", builder.toString());
    }
}