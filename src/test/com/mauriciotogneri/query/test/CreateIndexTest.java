package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.create.CreateIndex;

import org.junit.Test;

public class CreateIndexTest extends BaseTest
{
    @Test
    public void create()
    {
        CreateIndex create = new CreateIndex("index_name", "Person");

        check("CREATE INDEX index_name ON Person;", create);
    }

    @Test
    public void createUnique()
    {
        CreateIndex create = new CreateIndex("index_name", "Person").unique();

        check("CREATE UNIQUE INDEX index_name ON Person;", create);
    }

    @Test
    public void createIfNotExist()
    {
        CreateIndex create = new CreateIndex("index_name", "Person").ifNotExist();

        check("CREATE INDEX IF NOT EXISTS index_name ON Person;", create);
    }
}