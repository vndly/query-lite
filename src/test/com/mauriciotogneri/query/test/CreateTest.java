package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.OldQuery;
import com.mauriciotogneri.query.create.Create;

import org.junit.Test;

public class CreateTest extends BaseTest
{
    @Test
    public void createTable()
    {
        OldQuery create = new Create().table("Person");

        check("CREATE TABLE Person;", create);
    }

    @Test
    public void createTableIfNotExist()
    {
        OldQuery create = new Create().table("Person").ifNotExist();

        check("CREATE TABLE IF NOT EXISTS Person;", create);
    }

    @Test
    public void createTableColumns()
    {
        OldQuery create = new Create().table("Person").ifNotExist().columns("ID INT PRIMARY KEY NOT NULL", "NAME TEXT NOT NULL");

        check("CREATE TABLE IF NOT EXISTS Person (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL);", create);
    }

    //==============================================================================================

    @Test
    public void createIndex()
    {
        OldQuery create = new Create().index("index_name").on("Person");

        check("CREATE INDEX index_name ON Person;", create);
    }

    @Test
    public void createIndexUnique()
    {
        OldQuery create = new Create().index("index_name").on("Person").unique();

        check("CREATE UNIQUE INDEX index_name ON Person;", create);
    }

    @Test
    public void createIndexIfNotExist()
    {
        OldQuery create = new Create().index("index_name").on("Person").ifNotExist();

        check("CREATE INDEX IF NOT EXISTS index_name ON Person;", create);
    }

    @Test
    public void createIndexColumns()
    {
        OldQuery create = new Create().index("index_name").on("Person").columns("id, age, name");

        check("CREATE INDEX index_name ON Person (id, age, name);", create);
    }

    @Test
    public void createIndexWhere()
    {
        OldQuery create = new Create().index("index_name").on("Person").columns("id, age, name").where("age >= 18");

        check("CREATE INDEX index_name ON Person (id, age, name) WHERE (age >= 18);", create);
    }
}