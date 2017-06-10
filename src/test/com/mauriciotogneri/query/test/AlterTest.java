package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.alter.Alter;
import com.mauriciotogneri.query.common.OldQuery;

import org.junit.Test;

public class AlterTest extends BaseTest
{
    @Test
    public void rename()
    {
        OldQuery create = new Alter("Person").rename("Human");

        check("ALTER TABLE Person RENAME TO Human;", create);
    }

    @Test
    public void addColumn()
    {
        OldQuery create = new Alter("Person").addColumn("NAME TEXT NOT NULL");

        check("ALTER TABLE Person ADD COLUMN NAME TEXT NOT NULL;", create);
    }
}