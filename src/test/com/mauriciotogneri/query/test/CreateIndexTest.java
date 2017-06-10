package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.create.CreateIndex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateIndexTest
{
    @Test
    public void create()
    {
        CreateIndex create = new CreateIndex("index_name", "Person");

        assertEquals("CREATE INDEX index_name ON Person;", create.toString());
    }

    @Test
    public void createUnique()
    {
        CreateIndex create = new CreateIndex("index_name", "Person").unique();

        assertEquals("CREATE UNIQUE INDEX index_name ON Person;", create.toString());
    }

    @Test
    public void createIfNotExist()
    {
        CreateIndex create = new CreateIndex("index_name", "Person").ifNotExist();

        assertEquals("CREATE INDEX IF NOT EXISTS index_name ON Person;", create.toString());
    }
}