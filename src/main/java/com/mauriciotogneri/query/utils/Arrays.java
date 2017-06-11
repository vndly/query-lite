package com.mauriciotogneri.query.utils;

public class Arrays
{
    public static Object join(Object[] list, Object separator)
    {
        StringBuilder builder = new StringBuilder();

        for (Object element : list)
        {
            if (builder.length() != 0)
            {
                builder.append(separator).append(" ");
            }

            builder.append(element);
        }

        return builder.toString();
    }
}