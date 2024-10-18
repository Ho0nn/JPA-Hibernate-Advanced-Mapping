## JPA-Hibernate-Advanced-Mapping

## Project Overview 🎯
In this project, I explored advanced entity mappings using JPA (Java Persistence API) and Hibernate. This journey has helped me understand the key features of object-relational mapping (ORM) and how to manage complex relationships effectively.

##  Features 🚀
One-to-One Mapping:
I learned how to establish a one-to-one relationship between two entities. This was interesting because it allows for direct links, like a user and their profile.

One-to-Many and Many-to-One Mapping:
I discovered how to create unidirectional and bidirectional mappings. For example, how a department can have many employees, but each employee belongs to one department.

Many-to-Many Mapping:
This part was particularly fascinating! I managed complex relationships, like students enrolling in multiple courses and vice versa, using join tables.

Inheritance Mapping:
I explored different strategies for inheritance:

Single Table: All child classes share one table, which simplifies queries.

Joined Table: Child classes have their own tables, allowing more specialized attributes.

Table per Class: Each class gets its own table, which offers maximum flexibility.

Lifecycle Hooks:
I learned about @PrePersist, @PostPersist, and other lifecycle callbacks for managing entities. It’s great for performing actions automatically when certain events occur.

Lazy vs Eager Loading:
Understanding the difference between lazy and eager fetching strategies was crucial. I now know when to load data on-demand and when to load it upfront for better performance.


