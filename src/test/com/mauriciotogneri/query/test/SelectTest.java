package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.select.Select;

import org.junit.Test;

public class SelectTest extends BaseTest
{
    @Test
    public void selectFromTable()
    {
        Query select = new Select()
                .columns("name", "age", "weight")
                .from("Person");

        check("SELECT name, age, weight FROM Person;", select);
    }

    @Test
    public void selectFromTables()
    {
        Query select = new Select()
                .columns("Person.name", "Person.age", "Person.weight", "Employee.id")
                .from("Person", "Employee");

        check("SELECT Person.name, Person.age, Person.weight, Employee.id FROM Person, Employee;", select);
    }

    @Test
    public void selectWhere()
    {
        Query select = new Select()
                .columns("name")
                .from("Person")
                .where("age >= ?");

        check("SELECT name FROM Person WHERE (age >= 18);", select, 18);
    }

    @Test
    public void selectGroupBy()
    {
        Query select = new Select()
                .columns("name")
                .from("Person")
                .groupBy("id", "age");

        check("SELECT name FROM Person GROUP BY id, age;", select);
    }

    @Test
    public void selectGroupByHaving()
    {
        Query select = new Select()
                .columns("name")
                .from("Person")
                .groupBy("id", "age")
                .having("age >= ?");

        check("SELECT name FROM Person GROUP BY id, age HAVING (age >= 18);", select, 18);
    }

    @Test
    public void selectOrderBy()
    {
        Query select = new Select()
                .columns("name")
                .from("Person")
                .orderBy("id", "age");

        check("SELECT name FROM Person ORDER BY id, age;", select);
    }

    @Test
    public void selectLimit()
    {
        Query select = new Select()
                .columns("name")
                .from("Person")
                .limit("?");

        check("SELECT name FROM Person LIMIT 1000;", select, 1000);
    }
}