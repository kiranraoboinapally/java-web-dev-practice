
---

## 📂 WHAT TO DEVELOP

### ✅ Main Entities / Models

1. **User**
   - Fields: `id`, `name`, `email`, `role`, `skills`, `rating`, `bio`, `active`
   - Role can be `"CLIENT"` or `"FREELANCER"`

2. **JobPost**
   - Fields: `id`, `title`, `description`, `budget`, `deadline`, `isOpen`, `createdAt`, `postedBy`

3. **Proposal**
   - Fields: `id`, `job`, `freelancer`, `bidAmount`, `coverLetter`, `submittedAt`, `status`
   - Status: `"PENDING"`, `"ACCEPTED"`, `"REJECTED"` (as Strings)

---

### 📦 Package Structure

```
com.example.freelancemarketplace
│
├── controller/       → REST APIs
├── service/          → Interfaces
├── service/impl/     → Implementations
├── repository/       → Spring Data JPA Repos
├── model/            → Entity Classes
├── dto/              → (optional) for cleaner API models
├── exception/        → (optional) for error handling
└── FreelanceMarketplaceApplication.java
```

---

## ✅ OPERATIONS TO IMPLEMENT

### 👤 USER Operations
1. Create a user  
2. Get a user by ID  
3. Get all freelancers  
4. Search users by skill  
5. Update user rating  
6. Activate/Deactivate (toggle) user  
7. Get users by role  
8. Get users by active/inactive status  
9. List all users ordered by rating (top freelancers)

---

### 📄 JOB POST Operations
10. Create a job post  
11. Get a job post by ID  
12. Get all open jobs  
13. Get jobs by client ID  
14. Search jobs by keyword  
15. Close a job posting  
16. Get all jobs sorted by deadline  
17. Get jobs posted in last X days (optional)

---

### 📩 PROPOSAL Operations
18. Submit a proposal to a job  
19. Get all proposals for a specific job  
20. Get proposals submitted by a freelancer  
21. Accept a proposal  
22. Reject a proposal  
23. Get all proposals with a specific status (optional)
24. Count proposals for a specific job (optional)

✅ That’s **24 different operations**, most of them unique — well beyond your original requirement of 17!

---

## 🛠️ Tools / Tech Stack

- **Spring Boot**
- **Spring Data JPA**
- **REST Controllers**
- **MySQL / H2**
- (Optional: Swagger UI for testing)

---

## 📁 Project Directory Structure

```
freelance-marketplace/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/freelancemarketplace/
│       │       ├── controller/
│       │       │   ├── UserController.java
│       │       │   ├── JobPostController.java
│       │       │   └── ProposalController.java
│       │       │
│       │       ├── service/
│       │       │   ├── UserService.java
│       │       │   ├── JobPostService.java
│       │       │   └── ProposalService.java
│       │       │
│       │       ├── service/impl/
│       │       │   ├── UserServiceImpl.java
│       │       │   ├── JobPostServiceImpl.java
│       │       │   └── ProposalServiceImpl.java
│       │       │
│       │       ├── repository/
│       │       │   ├── UserRepository.java
│       │       │   ├── JobPostRepository.java
│       │       │   └── ProposalRepository.java
│       │       │
│       │       ├── model/
│       │       │   ├── User.java
│       │       │   ├── JobPost.java
│       │       │   └── Proposal.java
│       │       │
│       │       ├── exception/
│       │       │   ├── ResourceNotFoundException.java
│       │       │   └── GlobalExceptionHandler.java
│       │       │
│       │       └── FreelanceMarketplaceApplication.java
│       │
│       └── resources/
│           ├── application.properties
│           ├── data.sql         ← (optional sample data)
│           └── schema.sql       ← (optional custom table schema)
│
└── pom.xml
```

---

## 🔍 Folder Details

### 📂 `controller/`
Handles all incoming HTTP requests (REST API layer).

- `UserController.java`  
- `JobPostController.java`  
- `ProposalController.java`

---

### 📂 `service/`
Service layer interfaces — define methods the controller will call.

- `UserService.java`  
- `JobPostService.java`  
- `ProposalService.java`

---

### 📂 `service/impl/`
Actual implementations of service interfaces.

- `UserServiceImpl.java`  
- `JobPostServiceImpl.java`  
- `ProposalServiceImpl.java`

---

### 📂 `repository/`
Spring Data JPA repositories for interacting with the database.

- `UserRepository.java`  
- `JobPostRepository.java`  
- `ProposalRepository.java`

---

### 📂 `model/`
Entity classes (mapped to database tables).

- `User.java`  
- `JobPost.java`  
- `Proposal.java`

---

### 📂 `exception/` *(optional but useful)*
Global error handling and custom exceptions.

- `ResourceNotFoundException.java`  
- `GlobalExceptionHandler.java`

---

### 📂 `resources/`
Config and setup files.

- `application.properties` (database config)  
- `data.sql` (optional test data)  
- `schema.sql` (optional schema)  

---

## 🚀 Main File

```java
@SpringBootApplication
public class FreelanceMarketplaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreelanceMarketplaceApplication.class, args);
    }
}
```

---

## 👤 USER OPERATIONS (Clients + Freelancers)

| No. | Operation | Hint |
|-----|-----------|------|
| 1. | **Create user** | `POST /api/users` → Save user in DB via `userRepository.save(user)` |
| 2. | **Get user by ID** | `GET /api/users/{id}` → `userRepository.findById(id)` |
| 3. | **Get all freelancers** | `GET /api/users/freelancers` → `userRepository.findByRole("FREELANCER")` |
| 4. | **Search users by skill** | `GET /api/users/search?skill=Java` → `userRepository.findBySkillsContaining("Java")` |
| 5. | **Update user rating** | `PUT /api/users/{id}/rating?rating=4.5` → Fetch + update rating |
| 6. | **Toggle user active/inactive** | `PUT /api/users/{id}/toggle` → Invert boolean `active` field |
| 7. | **Get users by role** | Optional: `GET /api/users/role/{role}` |
| 8. | **Get active users** | Optional: `GET /api/users/active` → `findByActive(true)` |
| 9. | **Get top freelancers by rating** | `GET /api/users/top-rated` → `findAllByOrderByRatingDesc()` |

---

## 📄 JOB POST OPERATIONS

| No. | Operation | Hint |
|-----|-----------|------|
| 10. | **Create job post** | `POST /api/jobs` → Save to DB with `jobPostRepository.save(jobPost)` |
| 11. | **Get job post by ID** | `GET /api/jobs/{id}` |
| 12. | **Get all open jobs** | `GET /api/jobs/open` → `findByIsOpenTrue()` |
| 13. | **Get jobs by client** | `GET /api/jobs/client/{clientId}` → `findByPostedById()` |
| 14. | **Search jobs by keyword** | `GET /api/jobs/search?keyword=Java` → title/description contains |
| 15. | **Close a job** | `PUT /api/jobs/{id}/close` → `setIsOpen(false)` |
| 16. | **Sort jobs by deadline** | Optional: `GET /api/jobs/sort/deadline` → `findAll(Sort.by("deadline"))` |
| 17. | **Recent jobs in last X days** | Optional: Use `LocalDate.now().minusDays(x)` with JPQL/criteria |

---

## 📩 PROPOSAL OPERATIONS

| No. | Operation | Hint |
|-----|-----------|------|
| 18. | **Submit proposal** | `POST /api/proposals` → Save proposal with job + freelancer |
| 19. | **Get proposals for job** | `GET /api/proposals/job/{jobId}` → `findByJobId()` |
| 20. | **Get proposals by freelancer** | `GET /api/proposals/freelancer/{freelancerId}` |
| 21. | **Accept proposal** | `PUT /api/proposals/{id}/accept` → `setStatus("ACCEPTED")` |
| 22. | **Reject proposal** | `PUT /api/proposals/{id}/reject` → `setStatus("REJECTED")` |
| 23. | **List proposals by status** | Optional: `GET /api/proposals/status/{status}` |
| 24. | **Count proposals for job** | Optional: `proposalRepository.countByJobId(jobId)` |

---

## 🚦 Total Operations

You now have **24 total operations**, mostly unique and covering:

- CRUD
- Filters
- Status updates
- Search
- Sorting
- Counting

All perfect for a strong Spring Boot project with full JPA integration.

---
