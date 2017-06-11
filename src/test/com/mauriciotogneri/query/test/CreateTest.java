package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Column;
import com.mauriciotogneri.query.common.DataType;
import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.create.Create;

import org.junit.Test;

public class CreateTest extends BaseTest
{
    @Test
    public void createTable()
    {
        Query create = new Create()
                .table("Person");

        check("CREATE TABLE Person;", create);
    }

    @Test
    public void createTableIfNotExist()
    {
        Query create = new Create()
                .table("Person").ifNotExist();

        check("CREATE TABLE IF NOT EXISTS Person;", create);
    }

    @Test
    public void createTableColumns()
    {
        Query create = new Create()
                .table("Person")
                .ifNotExist()
                .columns(new Column("id", DataType.INT).primary().notNull(),
                         new Column("name", DataType.TEXT).notNull());

        check("CREATE TABLE IF NOT EXISTS Person (id INT PRIMARY KEY NOT NULL, name TEXT NOT NULL);", create);
    }

    //==============================================================================================

    @Test
    public void createIndex()
    {
        Query create = new Create()
                .index("index_name")
                .on("Person");

        check("CREATE INDEX index_name ON Person;", create);
    }

    @Test
    public void createIndexUnique()
    {
        Query create = new Create()
                .index("index_name")
                .on("Person")
                .unique();

        check("CREATE UNIQUE INDEX index_name ON Person;", create);
    }

    @Test
    public void createIndexIfNotExist()
    {
        Query create = new Create()
                .index("index_name")
                .on("Person")
                .ifNotExist();

        check("CREATE INDEX IF NOT EXISTS index_name ON Person;", create);
    }

    @Test
    public void createIndexColumns()
    {
        Query create = new Create()
                .index("index_name")
                .on("Person")
                .columns("id, age, name");

        check("CREATE INDEX index_name ON Person (id, age, name);", create);
    }

    @Test
    public void createIndexWhere()
    {
        Query create = new Create()
                .index("index_name")
                .on("Person")
                .columns("id, age, name")
                .where("age >= ?");

        check("CREATE INDEX index_name ON Person (id, age, name) WHERE (age >= 18);", create, 18);
    }
}