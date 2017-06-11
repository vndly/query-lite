package com.mauriciotogneri.query.common;

public class Column
{
    private final String name;
    private final DataType type;
    private final Boolean primary;
    private final Boolean autoincrement;
    private final Boolean unique;
    private final Boolean notNull;
    private final Object defaultValue;
    private final String check;

    private Column(String name, DataType type, Boolean primary, Boolean autoincrement, Boolean unique, Boolean notNull, Object defaultValue, String check)
    {
        this.name = name;
        this.type = type;
        this.primary = primary;
        this.autoincrement = autoincrement;
        this.unique = unique;
        this.notNull = notNull;
        this.defaultValue = defaultValue;
        this.check = check;
    }

    public Column(String name, DataType type)
    {
        this(name, type, false, false, false, false, null, null);
    }

    public Column primary()
    {
        return new Column(name, type, true, autoincrement, unique, notNull, defaultValue, check);
    }

    public Column autoincrement()
    {
        return new Column(name, type, primary, true, unique, notNull, defaultValue, check);
    }

    public Column unique()
    {
        return new Column(name, type, primary, autoincrement, true, notNull, defaultValue, check);
    }

    public Column notNull()
    {
        return new Column(name, type, primary, autoincrement, unique, true, defaultValue, check);
    }

    public Column defaultValue(Object value)
    {
        return new Column(name, type, primary, autoincrement, unique, notNull, value, check);
    }

    public Column check(String condition)
    {
        return new Column(name, type, primary, autoincrement, unique, notNull, defaultValue, condition);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s", name, type));

        if (primary)
        {
            builder.append(" PRIMARY KEY");
        }

        if (autoincrement)
        {
            builder.append(" AUTOINCREMENT");
        }

        if (unique)
        {
            builder.append(" UNIQUE");
        }

        if (notNull)
        {
            builder.append(" NOT NULL");
        }

        if (defaultValue != null)
        {
            builder.append(String.format(" DEFAULT %s", defaultValue));
        }

        if (check != null)
        {
            builder.append(String.format(" CHECK (%s)", check));
        }

        return builder.toString();
    }
}