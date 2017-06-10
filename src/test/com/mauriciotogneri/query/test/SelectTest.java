package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.select.Select;

import org.junit.Test;

public class SelectTest extends BaseTest
{
    @Test
    public void selectAll()
    {
        Select select = new Select();

        check("SELECT *;", select);
    }

    @Test
    public void selectFields()
    {
        Select select = new Select("name", "age", "weight");

        check("SELECT name, age, weight;", select);
    }

    @Test
    public void selectFromTable()
    {
        Select select = new Select("name", "age", "weight").from("Person");

        check("SELECT name, age, weight FROM Person;", select);
    }

    @Test
    public void selectFromTables()
    {
        Select select = new Select("Person.name", "Person.age", "Person.weight", "Employee.id").from("Person", "Employee");

        check("SELECT Person.name, Person.age, Person.weight, Employee.id FROM Person, Employee;", select);
    }

    @Test
    public void selectWhere()
    {
        Select select = new Select("name").from("Person").where("age >= 18");

        check("SELECT name FROM Person WHERE (age >= 18);", select);
    }

    @Test
    public void selectGroupBy()
    {
        Select select = new Select("name").from("Person").groupBy("id", "age");

        check("SELECT name FROM Person GROUP BY id, age;", select);
    }

    @Test
    public void selectGroupByHaving()
    {
        Select select = new Select("name").from("Person").groupBy("id", "age").having("age >= 18");

        check("SELECT name FROM Person GROUP BY id, age HAVING (age >= 18);", select);
    }

    @Test
    public void selectOrderBy()
    {
        Select select = new Select("name").from("Person").orderBy("id", "age");

        check("SELECT name FROM Person ORDER BY id, age;", select);
    }

    @Test
    public void selectLimit()
    {
        Select select = new Select("name").from("Person").limit(1000);

        check("SELECT name FROM Person LIMIT 1000;", select);
    }
}