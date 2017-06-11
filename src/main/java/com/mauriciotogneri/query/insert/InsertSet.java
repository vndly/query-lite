package com.mauriciotogneri.query.insert;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Value;
import com.mauriciotogneri.query.common.ValueEntry;

import java.util.ArrayList;
import java.util.List;

public class InsertSet extends Query
{
    private final InsertInto insertInto;
    private final List<ValueEntry> set;

    private InsertSet(InsertInto insertInto, List<ValueEntry> set)
    {
        this.insertInto = insertInto;
        this.set = set;
    }

    InsertSet(InsertInto insertInto, String column, Object value)
    {
        this.insertInto = insertInto;
        this.set = new ArrayList<>();
        this.set.add(new ValueEntry(column, new Value(value)));
    }

    public InsertSet set(String column, Object value)
    {
        this.set.add(new ValueEntry(column, new Value(value)));

        return new InsertSet(insertInto, set);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(insertInto);

        StringBuilder columnsBuilder = new StringBuilder();
        StringBuilder valuesBuilder = new StringBuilder();

        for (ValueEntry entry : set)
        {
            if (columnsBuilder.length() != 0)
            {
                columnsBuilder.append(", ");
            }

            if (valuesBuilder.length() != 0)
            {
                valuesBuilder.append(", ");
            }

            columnsBuilder.append(entry.column());
            valuesBuilder.append(entry.value());
        }

        builder.append(String.format(" (%s) VALUES (%s)", columnsBuilder, valuesBuilder));

        return builder.toString();
    }
}