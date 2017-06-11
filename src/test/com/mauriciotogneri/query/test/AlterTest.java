package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.alter.Alter;
import com.mauriciotogneri.query.common.Column;
import com.mauriciotogneri.query.common.DataType;
import com.mauriciotogneri.query.common.Query;

import org.junit.Test;

public class AlterTest extends BaseTest
{
    @Test
    public void rename()
    {
        Query alter = new Alter("Person")
                .rename("Human");

        check("ALTER TABLE Person RENAME TO Human;", alter);
    }

    @Test
    public void addColumn()
    {
        Query alter = new Alter("Person")
                .addColumn(new Column("name", DataType.TEXT).notNull());

        check("ALTER TABLE Person ADD COLUMN name TEXT NOT NULL;", alter);
    }
}