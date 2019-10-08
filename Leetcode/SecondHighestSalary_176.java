# Write your MySQL query statement below
SELECT MAX(Salary) as "SecondHighestSalary" from Employee where Salary < (SELECT MAX(Salary) from Employee);

# Write your MySQL query statement below
SELECT MAX(salary) AS "SecondHighestSalary"
  FROM employee
 WHERE salary < (SELECT MAX(salary)
                 FROM employee); 
# Write your MySQL query statement below
SELECT IFNULL((SELECT DISTINCT Salary FROM Employee ORDER BY Salary Desc LIMIT 1 OFFSET 1),NULL) AS "SecondHighestSalary";

/*
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
*/