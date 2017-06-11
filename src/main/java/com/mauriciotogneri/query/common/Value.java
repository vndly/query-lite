package com.mauriciotogneri.query.common;

public class Value
{
    private final Object value;

    public Value(Object value)
    {
        this.value = value;
    }

    private Boolean isInt(Class<?> clazz)
    {
        return (clazz.equals(Integer.class) ||
                clazz.equals(int.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(long.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(short.class));
    }

    private Boolean isReal(Class<?> clazz)
    {
        return (clazz.equals(Float.class) ||
                clazz.equals(float.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(double.class));
    }

    private Boolean isString(Class<?> clazz)
    {
        return (clazz.equals(String.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(char.class));
    }

    @Override
    public String toString()
    {
        if (value == null)
        {
            return "NULL";
        }
        else
        {
            Class<?> clazz = value.getClass();

            if (isInt(clazz))
            {
                return value.toString();
            }
            else if (isReal(clazz))
            {
                return value.toString();
            }
            else if (isString(clazz))
            {
                return String.format("\"%s\"", value);
            }
            else
            {
                return value.toString();
            }
        }
    }
}