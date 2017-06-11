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
        Query alter = new Alter("person")
                .rename("human");

        check("ALTER TABLE person RENAME TO human;", alter);
    }

    @Test
    public void addColumn()
    {
        Query alter = new Alter("person")
                .addColumn(new Column("name", DataType.TEXT).notNull());

        check("ALTER TABLE person ADD COLUMN name TEXT NOT NULL;", alter);
    }
}