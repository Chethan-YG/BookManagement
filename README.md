# 📚 Book Management System

A full-stack Book Management System developed using **Spring Boot** for the backend and a simple **HTML/CSS** frontend. This project allows users to manage books and authors, performing CRUD (Create, Read, Update, Delete) operations.

## 🚀 Features

- **Add, update, delete, and view books** and their authors.
- **One-to-One relationship** between books and authors.
- **RESTful API** built with **Spring Boot** to handle backend operations.
- **MySQL** used for persistent storage of books and authors.
- Simple **HTML/CSS frontend** for interacting with the API.

## 🛠️ Tech Stack

### Backend
- **Java 17**: Programming language.
- **Spring Boot**: Backend framework.
- **Spring Data JPA**: For database interaction.
- **MySQL**: Database management system.
- **Hibernate**: ORM (Object-Relational Mapping).
- **RESTful API**: For handling requests and responses.

### Frontend
- **HTML/CSS**: Basic frontend interface for interacting with the backend.

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.api.book
│   │       ├── controller
│   │       │   └── BookController.java
│   │       ├── dao
│   │       │   └── BookRepository.java
│   │       ├── entities
│   │       │   ├── Book.java
│   │       │   └── Author.java
│   │       └── services
│   │           └── BookService.java
│   └── resources
│       ├── application.properties
│       └── templates (for frontend views)
└── test
    └── java (for unit tests)
```

## 🗄️ Database Schema

### Book Table

| Column    | Type   | Description               |
|-----------|--------|---------------------------|
| book_id   | int    | Primary key               |
| title     | String | Title of the book         |
| author_id | int    | Foreign key linking to Author |

### Author Table

| Column     | Type   | Description                |
|------------|--------|----------------------------|
| author_id  | int    | Primary key                |
| first_name | String | Author's first name        |
| last_name  | String | Author's last name         |
| language   | String | Language the author writes in |

## ⚙️ Setup Instructions

### Prerequisites

- **Java 17** installed.
- **MySQL** installed and running.

### Steps to Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/book-management-system.git
    cd book-management-system
    ```

2. **Configure the database**:
   - Open the `application.properties` file in the `src/main/resources` folder.
   - Modify the following lines with your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bookdb
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Build and run the project**:
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Access the application**:
    - The backend APIs will be accessible at `http://localhost:8080/books`.
    - Frontend views (for book management) can be accessed at `http://localhost:8080/{endpoint}`.

### API Endpoints

- `GET /books` - Retrieve all books.
- `GET /books/{id}` - Retrieve a specific book by ID.
- `POST /books` - Add a new book.
- `PUT /books/{id}` - Update an existing book.
- `DELETE /books/{id}` - Delete a book by ID.

## 📋 Future Improvements

- Add more robust frontend design using React or Angular.
- Implement authentication for secure API access.
- Extend functionality to manage book categories and genres.

## 🤝 Contributing

Feel free to fork this project, submit pull requests, or open issues if you find any bugs or have feature suggestions!
