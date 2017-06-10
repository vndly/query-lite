package com.mauriciotogneri.query.update;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.common.Where;

import java.util.ArrayList;
import java.util.List;

public class UpdateSet extends Query
{
    private final UpdateTable updateTable;
    private final List<SetEntry> set;

    private UpdateSet(UpdateTable updateTable, List<SetEntry> set)
    {
        this.updateTable = updateTable;
        this.set = set;
    }

    UpdateSet(UpdateTable updateTable, String column, Object value)
    {
        this.updateTable = updateTable;
        this.set = new ArrayList<>();
        this.set.add(new SetEntry(column, value));
    }

    public UpdateSet set(String column, Object value)
    {
        this.set.add(new SetEntry(column, value));

        return new UpdateSet(updateTable, set);
    }

    public UpdateWhere where(String condition)
    {
        return new UpdateWhere(this, new Where(condition));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(updateTable.toString());

        if (set != null)
        {
            StringBuilder setBuilder = new StringBuilder();

            for (SetEntry entry : set)
            {
                if (setBuilder.length() != 0)
                {
                    setBuilder.append(", ");
                }

                setBuilder.append(entry.column);
                setBuilder.append(" = ");
                setBuilder.append(entry.value);
            }

            builder.append(String.format(" SET (%s)", setBuilder.toString()));
        }

        return builder.toString();
    }

    private static class SetEntry
    {
        private final String column;
        private final Object value;

        private SetEntry(String column, Object value)
        {
            this.column = column;
            this.value = value;
        }
    }
}