-- Create a database for EmployeeManagement web application
CREATE DATABASE managementdb;

-- Create employees table
CREATE TABLE `employees` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `last_name` VARCHAR(25) CHARACTER SET utf8 NOT NULL,
  `email` VARCHAR(25) CHARACTER SET utf8 NOT NULL,
  `phone_number` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `hire_date` DATE NOT NULL,
  `job_id` VARCHAR(10) CHARACTER SET utf8 NOT NULL,
  `salary` DOUBLE(8,2) DEFAULT NULL,
  `commission_pct` DOUBLE(2,2) DEFAULT NULL,
  `manager_id` INT DEFAULT NULL,
  `department_id` INT DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert sample data into employees table
INSERT INTO `employees` VALUES
(NULL, 'Hermann', 'Baer', 'HBAER@gmail.com', '1231434356', '1994-06-07', 'PR_REP', 10000.00, NULL, 101, 70),
(NULL, 'Tomas', 'White', 'TWHITE@gmail.com', '0931434356', '2000-08-29', 'PR_REP', 20000.00, NULL, 101, 70);

-- Create user table
CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) CHARACTER SET utf8 DEFAULT NULL,
  `password` VARCHAR(40) CHARACTER SET utf8 DEFAULT NULL,
  `email` VARCHAR(60) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` DATE DEFAULT NULL,
  `status` TINYINT DEFAULT NULL COMMENT '0: pending approve; 1: normal; 2: deleted',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert sample data into user table
INSERT INTO `user` VALUES
(NULL, 'TOM Green', MD5('123456'), 'tomgreen@gmail.com', '2020-02-12', 1),
(NULL, 'Jerry White', MD5('123456'), 'jerrywhite@gmail.com', '2021-03-16', 1);

-- Create role table
CREATE TABLE `role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_id` VARCHAR(50) DEFAULT NULL,
  `role_name` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert sample data into role table
INSERT INTO `role` VALUES
(NULL, '1', 'employee administrator'),
(NULL, '2', 'system administrator'),
(NULL, '3', 'global administrator');

-- Create user_role table which is used to store the relationship of user table between role table
-- user : role = N : N
CREATE TABLE `user_role` (
  `uid` INT NOT NULL,
  `rid` INT NOT NULL,
  PRIMARY KEY (`uid`,`rid`),
  KEY `fk_user_role_rid` (`rid`),
  CONSTRAINT `fk_user_role_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert sample data into user_role table
INSERT INTO user_role VALUES
(1,2),
(2,3);