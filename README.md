# School
 A Simple Spring Boot application showcasing @OneToMany, @ManyToOne and @ManyToMany relatioship between school entities like (Student, Subject, Teacher)
 
 Relationship between entities is as follows :
  1. A Single Subject can be taught by only 1 Teacher, A Teacher can teach many Subjects. (ManyToOne relationship between teacher and subject entities)
  2. A Single Subject can be taken by many Students, A Single Student can be enrolled in many Subjects. (ManyToMany relationship between student and subject entities)


Part-One branch:
Creating the basic project, Creating entities with basic info and no relationship between them, also creating controller, Service and Repository layer to enable basic functionality.

Part-Two branch:
Creating ManyToOne relatioship between teacher and subject entities and adding new endpoints for this relationship.

Mater branch:
Creating ManyToMany relationship between student and Teacher entities and adding new endpoints for this relationship.
