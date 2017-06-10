package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.create.CreateTable;

import org.junit.Test;

public class CreateTableTest extends BaseTest
{
    @Test
    public void create()
    {
        CreateTable create = new CreateTable("Person");

        check("CREATE TABLE Person;", create);
    }

    @Test
    public void createIfNotExist()
    {
        CreateTable create = new CreateTable("Person").ifNotExist();

        check("CREATE TABLE IF NOT EXISTS Person;", create);
    }

    @Test
    public void createColumns()
    {
        CreateTable create = new CreateTable("Person").ifNotExist().columns("ID INT PRIMARY KEY NOT NULL", "NAME TEXT NOT NULL");

        check("CREATE TABLE IF NOT EXISTS Person (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL);", create);
    }
}