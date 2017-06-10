package com.mauriciotogneri.query.utils;

public class Arrays
{
    public static String[] join(String first, String... rest)
    {
        String[] result = new String[rest.length + 1];
        result[0] = first;
        System.arraycopy(rest, 0, result, 1, rest.length);

        return result;
    }

    public static String join(String[] list, String separator)
    {
        StringBuilder builder = new StringBuilder();

        for (String element : list)
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