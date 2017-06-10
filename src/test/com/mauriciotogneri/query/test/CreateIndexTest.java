package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.create.Create;

import org.junit.Test;

public class CreateIndexTest extends BaseTest
{
    @Test
    public void create()
    {
        Query create = new Create().index("index_name").on("Person");

        check("CREATE INDEX index_name ON Person;", create);
    }

    @Test
    public void createUnique()
    {
        Query create = new Create().index("index_name").on("Person").unique();

        check("CREATE UNIQUE INDEX index_name ON Person;", create);
    }

    @Test
    public void createIfNotExist()
    {
        Query create = new Create().index("index_name").on("Person").ifNotExist();

        check("CREATE INDEX IF NOT EXISTS index_name ON Person;", create);
    }

    @Test
    public void createColumns()
    {
        Query create = new Create().index("index_name").on("Person").columns("id, age, name");

        check("CREATE INDEX index_name ON Person (id, age, name);", create);
    }

    @Test
    public void createWhere()
    {
        Query create = new Create().index("index_name").on("Person").columns("id, age, name").where("age >= 18");

        check("CREATE INDEX index_name ON Person (id, age, name) WHERE (age >= 18);", create);
    }
}