# Online Quiz Application

## Project Description

An Online Quiz Application built in Java that allows users to take quizzes on various topics. The application supports multiple-choice questions, tracks user progress, and provides feedback on quiz performance.

## Features

- **User Authentication**
  - Users can create an account and log in to take quizzes.
  - Passwords are securely stored using hashing and salting.

- **Quiz Management**
  - Admins can create, edit, and delete quizzes.
  - Each quiz contains multiple-choice questions with answers and options.

- **Quiz Taking**
  - Users can select a quiz from the available list.
  - Each quiz displays one question at a time with options for users to select the correct answer.
  - Feedback on the answer is provided immediately after submission.

- **Scoring and Progress Tracking**
  - The user's score is displayed at the end of each quiz.
  - Users can view their past quiz attempts and scores.

- **Leaderboard** (Optional)
  - A leaderboard displays the top scorers for each quiz.

- **Data Persistence**
  - Uses **MySQL** for storing user data, quiz details, and quiz results.
  - CRUD operations are implemented using JDBC.

- **Security Considerations**
  - Passwords are hashed and salted using strong encryption algorithms.

## Technologies Used

- **Java 23.0.1**
- **Spring Boot** (for building the application)
- **JDBC** (for database interaction)
- **MySQL** (for data storage)
- **Maven** (for project dependency management)

## Database Schema

The following are the main tables used in the application:

### Users Table

| Column        | Type          | Description                    |
|---------------|---------------|--------------------------------|
| `id`          | INT           | Unique user ID (Primary Key)   |
| `username`    | VARCHAR(100)   | User's username                |
| `password`    | VARCHAR(100)   | User's hashed password         |
| `email`       | VARCHAR(100)   | User's email address           |

### Quizzes Table

| Column        | Type          | Description                    |
|---------------|---------------|--------------------------------|
| `id`          | INT           | Unique quiz ID (Primary Key)   |
| `title`       | VARCHAR(100)   | Quiz title                     |
| `description` | TEXT          | Quiz description               |

### Questions Table

| Column        | Type          | Description                    |
|---------------|---------------|--------------------------------|
| `id`          | INT           | Unique question ID (Primary Key)|
| `quiz_id`     | INT           | Foreign key linking to quizzes |
| `question`    | TEXT          | The question text              |
| `option_1`    | VARCHAR(100)   | Option 1                        |
| `option_2`    | VARCHAR(100)   | Option 2                        |
| `option_3`    | VARCHAR(100)   | Option 3                        |
| `option_4`    | VARCHAR(100)   | Option 4                        |
| `correct_ans` | INT           | Correct answer (1-4)           |

### Quiz Results Table

| Column        | Type          | Description                    |
|---------------|---------------|--------------------------------|
| `id`          | INT           | Unique result ID (Primary Key) |
| `user_id`     | INT           | Foreign key linking to users   |
| `quiz_id`     | INT           | Foreign key linking to quizzes |
| `score`       | INT           | User's score                   |
| `date_taken`  | DATETIME      | Date and time of quiz attempt  |

## Setup Instructions

### Prerequisites

- **Java 23.0.1** or higher
- **Maven** for dependency management
- **MySQL** for database storage

### Clone the Repository

```bash
- git clone https://github.com/your-username/quiz-app.git

Configure Database
Open MySQL and create the database:

sql
Copy
Edit
CREATE DATABASE quiz_db;
Import the table schema or create tables based on the schema section above.

Update the application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
⚙️ Run the Application
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
Access the app at: http://localhost:8080

🧪 How to Use
Register or log in as a user.

Choose any available quiz and start answering.

View real-time feedback for each answer.

Check your final score and review past attempts.

If admin, manage quizzes via the admin interface.

🚀 Future Enhancements
Timer-based quizzes

Randomized question sets

Question difficulty levels

Email notifications

UI redesign with JavaFX or modern styling



🙌 Author
Anirudh Gaddey
Java Backend Developer | Spring Boot | MySQL | JDBC | GitHub: @anirudhrebel

