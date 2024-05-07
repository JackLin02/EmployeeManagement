## Running environment conditions

1. MySQL Server 8.0

2. Apache tomcat 9.0.64 

## Project structure

```shell
src
  |-com.ssm.controller
    |-EmployeeController.java
    |-RoleController.java
    |-UserController.java
  |-com.ssm.dao
    |-EmployeeDao.java
    |-RoleDao.java
    |-UserDao.java
    |-UserRoleDao.java
    |-EmployeeDao.xml
    |-RoleDao.xml
    |-UserDao.xml
    |-UserRoleDao.xml
  |-com.ssm.model
    |-Employee.java
    |-Role.java
    |-UserRole.java
  |-com.ssm.service
    |-EmployeeService.java
    |-RoleService.java
    |-UserRoleService.java
    |-UserService.java
  |-com.ssm.service.impl
    |-EmployeeServiceImpl.java
    |-RoleServiceImpl.java
    |-UserRoleServiceImpl.java
    |-UserServiceImpl.java
  |-com.ssm.util
    |-AuthenticationInterceptor.java
    |-MySecurity.java
  |-jdbc.properties
  |-log4j.properties
  |-mybatis.cfg.xml
  |-springMvc.xml
WebContent
  |-static
    |-css
    |-fonts
    |-img
    |-js
    |-scss
  |-WEB-INF
    |-lib
    |-templates
      |-pages
    |-web.xml
```

## How to run this project?

1. Navigate to "src" floder, openning the "managementdb.sql" with text editor or visual studio code, copying the all sql statement.

2. Connectting the MySQL server and running the step 1 code.

3. Running this project code with Eclipse or IntelliJ IDEA


