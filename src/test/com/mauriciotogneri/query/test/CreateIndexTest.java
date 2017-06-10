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

    @Test
    public void createColumns()
    {
        CreateIndex create = new CreateIndex("index_name", "Person").columns("id, age, name");

        check("CREATE INDEX index_name ON Person (id, age, name);", create);
    }

    @Test
    public void createWhere()
    {
        CreateIndex create = new CreateIndex("index_name", "Person").columns("id, age, name").where("age >= 18");

        check("CREATE INDEX index_name ON Person (id, age, name) WHERE (age >= 18);", create);
    }
}