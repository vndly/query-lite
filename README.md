[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/query-lite/blob/master/LICENSE.md)
[![Download](https://api.bintray.com/packages/mauriciotogneri/maven/querylite/images/download.svg)](https://bintray.com/mauriciotogneri/maven/querylite/_latestVersion)

# Query Lite
Query builder library for SQLite.

## Examples

[`Create table`](README.md#create-table)

[`Create index`](README.md#create-index)

[`Rename table`](README.md#rename-table)

[`Add column`](README.md#add-column)

[`Insert row`](README.md#insert-row)

[`Update row`](README.md#update-row)

### Create table

```java
Query create = new Create()
                .table("Person")
                .ifNotExist()
                .columns(new Column("id", DataType.INT).primary().autoincrement().notNull(),
                         new Column("email", DataType.TEXT).unique().notNull(),
                         new Column("age", DataType.INT).notNull().check("age >= 0"),
                         new Column("weight", DataType.REAL).notNull().check("weight >= 0"));
```

Generates:

```sql
CREATE TABLE IF NOT EXISTS Person (id INT PRIMARY KEY AUTOINCREMENT NOT NULL, email TEXT UNIQUE NOT NULL, age INT NOT NULL CHECK (age >= 0), weight REAL NOT NULL CHECK (weight >= 0));
```

### Create index

```java
Query create = new Create()
                .index("index_email")
                .unique()
                .on("Person")
                .columns("email");
```

Generates:

```sql
CREATE UNIQUE INDEX index_email ON Person (email);
```

### Rename table

```java
Query alter = new Alter("Person")
                .rename("Human");
```

Generates:

```sql
ALTER TABLE Person RENAME TO Human;
```

### Add column

```java
Query alter = new Alter("Person")
                .addColumn(new Column("name", DataType.TEXT).notNull());
```

Generates:

```sql
ALTER TABLE Person ADD COLUMN name TEXT NOT NULL;
```

### Insert row

```java
Query insert = new Insert()
                .into("Person")
                .set("email", "john.doe@email.com")
                .set("name", "John Doe")
                .set("age", 45)
                .set("weight", 81.2);
```

Generates:

```sql
INSERT INTO Person (email, name, age, weight) VALUES ("john.doe@email.com", "John Doe", 45, 81.2);
```

### Update row

```java
Query insert = new Update()
                .table("Person")
                .set("age", 18)
                .where("id = 100");
```

Generates:

```sql
UPDATE Person SET (age = 18) WHERE (id = 100);
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