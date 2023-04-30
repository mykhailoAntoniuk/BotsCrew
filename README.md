# **BotsCrew test task**
Application for tracking employees of university departments. Checking average salary values by departments, searching for lectors by template. Collection of statistics and number of employees 

**Tech stack:**
  - JDK 17
  - Maven 
  - Spring Boot 3.0.6
  - Lombok for generation common code
  
**App suports next commands:**
1. Who is head of department {department_name}
2. Show {department_name} statistics.
3. Show the average salary for the department {department_name}.
4. Show count of employee for {department_name}.
5. Global search by {template}.

**The following departments are present by default:**
1. Computer Science
2. Physics
3. Mathematics
4. English
5. History
# **How to start:**
  1) Setup JDK 17 and make sure your PATH variable for JAVA_HOME is correctness
  2) Clone this repository to your local enviroment
  3) Open root folder of cloned project in your console EXAMPLE: ```$path\to\root\BotsCrew```
  4) Execute ```mvnw spring-boot:run``` Windows CMD (adapt it for your OS) Linux\MacOS ```./mvnw spring-boot:run``` in some cases, you need to change permissions use ```chmod +rwx mvnw``` for Linux\MacOS
  5) Enjoy
