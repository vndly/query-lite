package com.mauriciotogneri.query.utils;

public class Arrays
{
    public static Object[] join(Object first, Object... rest)
    {
        Object[] result = new Object[rest.length + 1];
        result[0] = first;
        System.arraycopy(rest, 0, result, 1, rest.length);

        return result;
    }

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