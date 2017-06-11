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
                .table("person");

        check("CREATE TABLE person;", create);
    }

    @Test
    public void createTableIfNotExist()
    {
        Query create = new Create()
                .table("person").ifNotExist();

        check("CREATE TABLE IF NOT EXISTS person;", create);
    }

    @Test
    public void createTableColumns()
    {
        Query create = new Create()
                .table("person")
                .ifNotExist()
                .columns(new Column("id", DataType.INTEGER).primary().autoincrement().notNull(),
                         new Column("email", DataType.TEXT).unique().notNull(),
                         new Column("age", DataType.INTEGER).notNull().check("age >= 0"),
                         new Column("weight", DataType.REAL).notNull().check("weight >= 0"));

        check("CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, email TEXT UNIQUE NOT NULL, age INTEGER NOT NULL CHECK (age >= 0), weight REAL NOT NULL CHECK (weight >= 0));", create);
    }

    //==============================================================================================

    @Test
    public void createIndex()
    {
        Query create = new Create()
                .index("index_name")
                .on("person");

        check("CREATE INDEX index_name ON person;", create);
    }

    @Test
    public void createIndexUnique()
    {
        Query create = new Create()
                .index("index_name")
                .on("person")
                .unique();

        check("CREATE UNIQUE INDEX index_name ON person;", create);
    }

    @Test
    public void createIndexIfNotExist()
    {
        Query create = new Create()
                .index("index_name")
                .on("person")
                .ifNotExist();

        check("CREATE INDEX IF NOT EXISTS index_name ON person;", create);
    }

    @Test
    public void createIndexColumns()
    {
        Query create = new Create()
                .index("index_email")
                .unique()
                .on("person")
                .columns("email");

        check("CREATE UNIQUE INDEX index_email ON person (email);", create);
    }

    @Test
    public void createIndexWhere()
    {
        Query create = new Create()
                .index("index_name")
                .on("person")
                .columns("id, age, name")
                .where("age >= ?");

        check("CREATE INDEX index_name ON person (id, age, name) WHERE (age >= 18);", create, 18);
    }
}