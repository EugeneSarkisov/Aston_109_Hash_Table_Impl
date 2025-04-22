# Aston_109_Hash_Table_Impl

### Task:
Implement console appliction which use _Hibernate_ to connect with PostgreSQL. Application must contain all _CRUD_ methods which allow to manipulate with _User_ data.

### The program contains:
- `model` contain _User_ data model class with _Hibernate_ annotations.
- `service` contain _UserService_ class which implement core functionality of application. Allow us to create, read, update or delete _Users_ in _DB_.
- `run` contain _Runner_ class which implement console implementation of our application. _Main_ method allow us to run application.
- `util` contain:
    - `dao` - layer, which contain _DAO_ pattern impl. Hiding all DB conntect logic.
    - `user_exception` - contain custom exceptions.
    - `validation` - contatin validation methods which checking _username_ and _age_ data. 
    - `HibernateUtil` - contain _Hibernate_ building session logic and utility methods which allow us to _get/rollback_ our _transactions_.

### The program also contains resources folder with:
- `hibernate.cfg.xml` - contain _Hibernate_ configuration.
- `log4j2-test.xml` - contain _Log4j2_ configuration.
