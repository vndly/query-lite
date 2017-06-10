package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.select.Condition;
import com.mauriciotogneri.query.select.Select;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectTest
{
    @Test
    public void selectAll()
    {
        Select select = new Select();

        assertEquals("SELECT *;", select.toString());
    }

    @Test
    public void selectFields()
    {
        Select select = new Select("name", "age", "weight");

        assertEquals("SELECT name, age, weight;", select.toString());
    }

    @Test
    public void selectFromTable()
    {
        Select select = new Select("name", "age", "weight").from("Person");

        assertEquals("SELECT name, age, weight FROM Person;", select.toString());
    }

    @Test
    public void selectFromTables()
    {
        Select select = new Select("Person.name", "Person.age", "Person.weight", "Employee.id").from("Person", "Employee");

        assertEquals("SELECT Person.name, Person.age, Person.weight, Employee.id FROM Person, Employee;", select.toString());
    }

    @Test
    public void selectWhere()
    {
        Select select = new Select("name").from("Person").where(new Condition("age >= 18"));

        assertEquals("SELECT name FROM Person WHERE age >= 18;", select.toString());
    }

    @Test
    public void selectGroupBy()
    {
        Select select = new Select("name").from("Person").groupBy("id", "age");

        assertEquals("SELECT name FROM Person GROUP BY id, age;", select.toString());
    }

    @Test
    public void selectGroupByHaving()
    {
        Select select = new Select("name").from("Person").groupBy("id", "age").having(new Condition("age >= 18"));

        assertEquals("SELECT name FROM Person GROUP BY id, age HAVING age >= 18;", select.toString());
    }

    @Test
    public void selectOrderBy()
    {
        Select select = new Select("name").from("Person").orderBy("id", "age");

        assertEquals("SELECT name FROM Person ORDER BY id, age;", select.toString());
    }

    @Test
    public void selectLimit()
    {
        Select select = new Select("name").from("Person").limit(1000);

        assertEquals("SELECT name FROM Person LIMIT 1000;", select.toString());
    }
}