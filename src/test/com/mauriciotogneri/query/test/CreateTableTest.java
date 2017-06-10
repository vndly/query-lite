package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.create.CreateTable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateTableTest
{
    @Test
    public void create()
    {
        CreateTable create = new CreateTable("Person");

        assertEquals("CREATE TABLE Person;", create.toString());
    }

    @Test
    public void createIfNotExist()
    {
        CreateTable create = new CreateTable("Person").ifNotExist();

        assertEquals("CREATE TABLE IF NOT EXISTS Person;", create.toString());
    }

    @Test
    public void createColumns()
    {
        CreateTable create = new CreateTable("Person").ifNotExist().columns("ID INT PRIMARY KEY NOT NULL", "NAME TEXT NOT NULL");

        assertEquals("CREATE TABLE IF NOT EXISTS Person (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL);", create.toString());
    }
}