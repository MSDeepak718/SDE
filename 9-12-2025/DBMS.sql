/*
Table 1: Students
This table stores student information including name, gender, date of birth, and department
affiliation.
Column Name Data Type Description
StudentID INT (PK) Unique ID for each student
FirstName VARCHAR(50) Student's first name
LastName VARCHAR(50) Student's last name
Gender VARCHAR(10) 'Male', 'Female', or 'Other'
DateOfBirth DATE Date of birth
CourseID INT (FK) References
Courses(CourseID)
DepartmentID INT (FK) References
Departments(DepartmentID)

Table 2: Courses
This table stores information about academic courses including course title, duration, and
associated department.
Column Name Data Type Description
CourseID INT (PK) Unique ID for each course
CourseName VARCHAR(100) Title of the course
Credits INT Number of credit units
Instructor VARCHAR(100) Name of the course
instructor
DepartmentID INT (FK) References
Departments(DepartmentID)

Table 3: Departments
This table holds department-level details including department name and head of
department.
Column Name Data Type Description
DepartmentID INT (PK) Unique ID for each
department
DepartmentName VARCHAR(100) Name of the department
HeadOfDept VARCHAR(100) Name of the head of
department
*/


/*Beginner Level (Basic SELECT, WHERE, ORDER BY)*/

-- Write a SQL query to list the full names of all students who are female.
SELECT CONCAT(first_name, ' ', last_name) AS full_name from Students;

-- Write a SQL query to find all students born after the year 2000.
SELECT * FROM Students WHERE birth_date > '2000-12-31';

-- Write a SQL query to retrieve the names of all students ordered by LastName alphabetically.
SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM Students ORDER BY last_name;

-- Write a SQL query to find students from the 'Computer Science' department
SELECT CONCAT(s.first_name, ' ', s.last_name) AS full_name FROM Students s JOIN Departments d ON s.department_id = d.department_id WHERE d.department_name = 'Computer Science';

-- Write a SQL query to select all columns from the Courses table.
SELECT * FROM Courses;

-- Write a SQL query to list all courses worth 3 credits
SELECT * FROM Courses WHERE credits = 3;

-- Write a SQL query to find all courses offered by the 'Science' department.
SELECT c.* FROM Courses c JOIN Departments d ON c.department_id = d.department_id WHERE d.department_name = 'Science';

-- Write a SQL query to retrieve all courses ordered by CourseName alphabetically.
SELECT * FROM Courses ORDER BY course_name;

-- Write a SQL query to list all instructors who teach courses in the 'Mathematics' department.
SELECT DISTINCT c.instructor FROM Courses c JOIN Departments d ON c.department_id = d.department_id WHERE d.department_name = 'Mathematics';

/* Intermediate Level (JOIN, GROUP BY, Aggregates)*/

-- Write a SQL query to list students along with their department names using a JOIN.
SELECT s.first_name, s.last_name, d.department_name FROM Students s JOIN Departments d ON s.department_id = d.department_id;

-- Write a SQL query to list all courses along with their department names using a JOIN.
SELECT c.course_name, d.department_name FROM Courses c JOIN Departments d ON c.department_id = d.department_id;

-- Write a SQL query to count the number of students in each department.
SELECT d.department_name, COUNT(s.student_id) AS student_count FROM Students s JOIN Departments d ON s.department_id = d.department_id GROUP BY d.department_name;

-- Write a SQL query to find the average age of students in the 'Mechanical Engineering' department.
SELECT d.department_name, AVG(DATEDIFF(CURDATE(), s.date_of_birth) / 365) AS average_age FROM Students s JOIN Departments d ON s.department_id = d.department_id WHERE d.department_name = 'Mechanical Engineering' GROUP BY d.department_name;

-- Write a SQL query to find departments with more than 10 students.
SELECT d.department_name, COUNT(s.student_id) AS student_count FROM Students s JOIN Departments d ON s.department_id = d.department_id GROUP BY d.department_name HAVING COUNT(s.student_id) > 10;

-- Write a SQL query to find the youngest student in the 'Electrical Engineering' department
SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM Students WHERE date_of_birth = (SELECT MIN(date_of_birth) FROM Students s JOIN Departments d ON s.department_id = d.department_id WHERE d.department_name = 'Electrical Engineering');

-- Write a SQL query to count the number of courses in each department.
SELECT d.department_name, COUNT(c.course_id) AS course_count FROM Courses c JOIN Departments d ON c.department_id = d.department_id GROUP BY d.department_name;

-- Write a SQL query to find the average number of credits per department
SELECT d.department_name, AVG(c.credits) AS average_credits FROM Courses c JOIN Departments d ON c.department_id = d.department_id GROUP BY d.department_name;

-- Write a SQL query to list departments offering more than 5 courses
SELECT d.department_name, COUNT(c.course_id) AS course_count FROM Courses c JOIN Departments d ON c.department_id = d.department_id GROUP BY d.department_name HAVING COUNT(c.course_id) > 5;

-- Write a SQL query to find the course with the highest number of credits in the 'Engineering' department.
SELECT c.course_name FROM Courses c JOIN Departments d ON c.department_id = d.department_id WHERE d.department_name = 'Engineering' ORDER BY c.credits DESC LIMIT 1;

/*Advanced Level (Subqueries, HAVING, CASE, Window Functions)*/

-- Write a query to find departments that have no students assigned.
SELECT d.department_name FROM Departments d LEFT JOIN Students s ON d.department_id = s.department_id WHERE s.student_id IS NULL;

-- Write a SQL query to return student names along with a label: 'Minor' if age < 18, else 'Adult'.
SELECT CONCAT(first_name, ' ', last_name) AS full_name, CASE WHEN DATEDIFF(CURDATE(), date_of_birth) / 365 < 18 THEN 'Minor' ELSE 'Adult' END AS age_group FROM Students;

-- Write a SQL query to return each course along with a label: 'Short' if Credits <= 2, 'Regular' otherwise.
SELECT course_name, CASE WHEN credits <= 2 THEN 'Short' ELSE 'Regular' END AS Duration FROM Courses;

-- Write a SQL query to find students who belong to the department with the highest number of students
SELECT * FROM Students WHERE DepartmentID = ( SELECT DepartmentID FROM Students GROUP BY DepartmentID ORDER BY COUNT(*) DESC LIMIT 1 );

-- Write a query to rank students by age within each department.
SELECT s.first_name, s.last_name, d.department_name, DATEDIFF(CURDATE(), s.date_of_birth) / 365 AS age, RANK() OVER (PARTITION BY d.department_id ORDER BY s.date_of_birth) AS age_rank FROM Students s JOIN Departments d ON s.department_id = d.department_id ORDER BY d.department_name, age_rank;

-- Write a query to find the department where the head’s name starts and ends with the same letter.
SELECT * FROM Departments WHERE LEFT(head_of_dept, 1) = RIGHT(head_of_dept, 1);

-- Write a query to find departments that offer no courses
SELECT d.department_name FROM Departments d LEFT JOIN Courses c ON d.department_id = c.department_id WHERE c.course_id IS NULL;

-- Write a SQL query to find courses offered by the department that offers the most courses overall.
SELECT * FROM Courses WHERE DepartmentID = ( SELECT DepartmentID FROM Courses GROUP BY DepartmentID ORDER BY COUNT(*) DESC LIMIT 1 );
