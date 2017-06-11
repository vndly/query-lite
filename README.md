[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/query-lite/blob/master/LICENSE.md)
[![Download](https://api.bintray.com/packages/mauriciotogneri/maven/querylite/images/download.svg)](https://bintray.com/mauriciotogneri/maven/querylite/_latestVersion)

# Query Lite
Query builder library for SQLite.

## Examples

* [`Create table`](README.md#create-table)
* [`Create index`](README.md#create-index)
* [`Rename table`](README.md#rename-table)
* [`Add column`](README.md#add-column)
* [`Insert row`](README.md#insert-row)
* [`Update row`](README.md#update-row)

### Create table

```java
Query create = new Create()
                .table("person")
                .ifNotExist()
                .columns(new Column("id", DataType.INTEGER).primary().autoincrement().notNull(),
                         new Column("email", DataType.TEXT).unique().notNull(),
                         new Column("age", DataType.INTEGER).notNull().check("age >= 0"),
                         new Column("weight", DataType.REAL).notNull().check("weight >= 0"));
```

```sql
CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                                   email TEXT UNIQUE NOT NULL,
                                   age INTEGER NOT NULL CHECK (age >= 0),
                                   weight REAL NOT NULL CHECK (weight >= 0));
```

### Create index

```java
Query create = new Create()
                .index("index_email")
                .unique()
                .on("person")
                .columns("email");
```

```sql
CREATE UNIQUE INDEX index_email ON person (email);
```

### Rename table

```java
Query alter = new Alter("person")
                .rename("human");
```

```sql
ALTER TABLE person RENAME TO human;
```

### Add column

```java
Query alter = new Alter("person")
                .addColumn(new Column("name", DataType.TEXT).notNull());
```

```sql
ALTER TABLE person ADD COLUMN name TEXT NOT NULL;
```

### Insert row

```java
Query insert = new Insert()
                .into("person")
                .set("email", "john.doe@email.com")
                .set("name", "John Doe")
                .set("age", 45)
                .set("weight", 81.2);
```

```sql
INSERT INTO person (email, name, age, weight) VALUES ("john.doe@email.com", "John Doe", 45, 81.2);
```

### Update row

```java
Query insert = new Update()
                .table("person")
                .set("age", 18)
                .where("id = 100");
```

```sql
UPDATE person SET (age = 18) WHERE (id = 100);
```

## Installation

Add the following code to your **pom.xml**:

```xml
<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com</url>
    </repository>
</repositories>
```

and the dependency:

```xml
<dependency>
    <groupId>com.mauriciotogneri</groupId>
    <artifactId>query</artifactId>
    <version>0.3.0</version>
</dependency>
```

or if you use Gradle:

```groovy
dependencies
{
    compile 'com.mauriciotogneri:query:0.3.0'
}
```