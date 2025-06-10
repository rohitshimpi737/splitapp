# SplitApp

SplitApp is a Spring Boot-based expense splitting application that allows users to create groups, add expenses, split bills, and settle balances easily.

## Features

- User authentication (JWT-based)
- Group and expense management
- Equal expense splitting among group members
- Settlement calculation and tracking
- RESTful API endpoints
- PostgreSQL database integration

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/splitapp.git
   cd splitapp
   ```
2. Configure the Database:
    - Create a PostgreSQL database (locally or using a cloud provider like Railway, Render, or AWS).
    - Update `src/main/resources/application-dev.properties` with your database credentials.
    - **Important:** Do not commit sensitive files. Add `application-dev.properties` to your `.gitignore`.
3. Build the Project:
   ```bash
   mvn clean install
   ```
4. Configure the database connection in `src/main/resources/application.properties`.
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```
6. Access the application at `http://localhost:8080`.