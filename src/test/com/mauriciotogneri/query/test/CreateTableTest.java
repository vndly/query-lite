package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.create.Create;

import org.junit.Test;

public class CreateTableTest extends BaseTest
{
    @Test
    public void create()
    {
        Query create = new Create().table("Person");

        check("CREATE TABLE Person;", create);
    }

    @Test
    public void createIfNotExist()
    {
        Query create = new Create().table("Person").ifNotExist();

        check("CREATE TABLE IF NOT EXISTS Person;", create);
    }

    @Test
    public void createColumns()
    {
        Query create = new Create().table("Person").ifNotExist().columns("ID INT PRIMARY KEY NOT NULL", "NAME TEXT NOT NULL");

        check("CREATE TABLE IF NOT EXISTS Person (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL);", create);
    }
}