package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.create.Create;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateTest
{
    @Test
    public void create()
    {
        Create create = new Create("Person");

        assertEquals("CREATE TABLE Person;", create.toString());
    }

    @Test
    public void createIfNotExist()
    {
        Create create = new Create("Person").ifNotExist();

        assertEquals("CREATE TABLE IF NOT EXISTS Person;", create.toString());
    }

    @Test
    public void createColumns()
    {
        Create create = new Create("Person").ifNotExist().columns("ID INT PRIMARY KEY NOT NULL", "NAME TEXT NOT NULL");

        assertEquals("CREATE TABLE IF NOT EXISTS Person (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL);", create.toString());
    }
}