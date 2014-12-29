# SQLiteQueryBuilder
This project is aimed at providing a simple API to build SQLite query statements. This library does nothing but build statements; it's not an ORM. The API syntax is inspired from the jOOQ library.

Currently, SQLiteQueryBuilder is under active development so you may find some features missing. If this is the case, please file an issue or open a pull request.

## Motivation
Although this project is written in Java and bears no dependencies to external frameworks (so far), it is/was developed specifically to be used on the Android platform. There are a few reasons why I started this project...

- Building SQLite statements in pure Java can be cumbersome and very unreadable at times
- Androids own SQLiteQueryBuilder is also cumbersome to use at times.
- Although the jOOQ library has a great API for building SQL statements, it comes with an entire suite of tools to build statements, connect to databases, write/read models to/from databases, etc. Due to the current nature of Dalvik (Androids application VM), there is a 64k method reference limit. jOOQ can contain over 10,000 referenced methods when in use. This may not seem like much in comparison to the limit, but if you consider other large libraries commonly used (such as Guava and Google Play Services), hitting that 64k limit becomes much easier.

## Usage
```java
String sql = SQLiteQueryBuilder
	.select()
	.from("accounts")
	.where("id = 1")
	.toString();
```

You can view more examples in the [src/test/java](https://github.com/alexfu/SQLiteQueryBuilder/tree/master/src/test/java) folder.
