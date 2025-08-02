# 👨‍💼 Employee JPA Custom Query API

This is a Spring Boot RESTful API for managing employee data using **Spring Data JPA**, with focus on **JPQL**

## 📌 Features

- JPQL custom queries
- Query examples using:
  - `BETWEEN`, `IN`, `NOT IN`
  - `LIKE`, `AND`, `OR`
  - Date range filters

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Microsoft SQL Server
- Maven
- Lombok
- Swagger (OpenAPI)
- Postman (for testing)

---
## 🗂️ Project Structure

employee-jpa-custom-query/
├── src/
│ ├── main/
│ │ ├── java/com/example/custom-query/
│ │ │ ├── controller/
│ │ │ ├── service/
│ │ │ ├── repository/
│ │ │ ├── dto/
│ │ │ └── model/
│ │ └── resources/
│ │ ├── application.yml
└── pom.xml

---

## ✅ Sample Custom Queries
@Query("select e from Employee e where e.salary between :min and :max")
List<Employee> findBySalaryBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max );

@Query("select e from Employee e where e.role in :roles")
List<Employee> findBYRoleIn(@Param("roles") List<String> roles);

▶️ Running the Project
1.Clone the repo
git clone https://github.com/your-username/employee-jpa-custom-query.git
cd employee-jpa-custom-query

2.Update application.yml with your MS SQL credentials.

3.Run using:
mvn spring-boot:run

4.Swagger UI: http://localhost:8080/swagger-ui.html

📦 Sample API Endpoints
| Method | Endpoint                                    | Description            |
| ------ | ------------------------------------------- | ---------------------- |
| GET    | `/api/employees`                            | List all employees     |
| POST   | `/api/employees`                            | Create new employee    |
| GET    | `/api/employees/salary?min=10000&max=50000` | Filter by salary range |
| GET    | `/api/employees/department?name=IT`         | Filter by department   |

🧪 Testing
Use Postman Collection or Swagger UI