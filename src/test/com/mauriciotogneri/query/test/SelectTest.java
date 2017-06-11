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
                .from("person");

        check("SELECT name, age, weight FROM person;", select);
    }

    @Test
    public void selectFromTables()
    {
        Query select = new Select()
                .columns("person.name", "person.age", "person.weight", "employee.id")
                .from("person", "employee");

        check("SELECT person.name, person.age, person.weight, employee.id FROM person, employee;", select);
    }

    @Test
    public void selectWhere()
    {
        Query select = new Select()
                .columns("name")
                .from("person")
                .where("age >= ?");

        check("SELECT name FROM person WHERE (age >= 18);", select, 18);
    }

    @Test
    public void selectGroupBy()
    {
        Query select = new Select()
                .columns("name")
                .from("person")
                .groupBy("id", "age");

        check("SELECT name FROM person GROUP BY id, age;", select);
    }

    @Test
    public void selectGroupByHaving()
    {
        Query select = new Select()
                .columns("name")
                .from("person")
                .groupBy("id", "age")
                .having("age >= ?");

        check("SELECT name FROM person GROUP BY id, age HAVING (age >= 18);", select, 18);
    }

    @Test
    public void selectOrderBy()
    {
        Query select = new Select()
                .columns("name")
                .from("person")
                .orderBy("id", "age");

        check("SELECT name FROM person ORDER BY id, age;", select);
    }

    @Test
    public void selectLimit()
    {
        Query select = new Select()
                .columns("name")
                .from("person")
                .limit("?");

        check("SELECT name FROM person LIMIT 1000;", select, 1000);
    }

    @Test
    public void selectFull()
    {
        Query select = new Select()
                .columns("id, email, name")
                .from("person")
                .where("age >= ?")
                .groupBy("age")
                .orderBy("age")
                .limit("?").offset("?");

        check("SELECT id, email, name FROM person WHERE (age >= 18) GROUP BY age ORDER BY age LIMIT 1000 OFFSET 10;", select, 18, 1000, 10);
    }
}