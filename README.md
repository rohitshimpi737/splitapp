# SplitApp

SplitApp is a Spring Boot-based expense splitting application that allows users to create groups, add expenses, split bills, and settle balances easily.

## Database Information

- **Database:** PostgreSQL
- **Default Port:** 5432
- **Recommended Version:** 12 or above
- **Sample connection properties:**
  ```
  spring.datasource.url=jdbc:postgresql://<host>:5432/<database>
  spring.datasource.username=<your_db_username>
  spring.datasource.password=<your_db_password>
  spring.datasource.driver-class-name=org.postgresql.Driver
  spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
  ```
- You can use a local PostgreSQL instance or a managed service (Railway, Render, AWS RDS, etc.).
- **Important:** Never commit your real credentials to version control.

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
   git clone https://github.com/rohitshimpi737/splitapp.git
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

## API Usage

- Import the provided Postman collection for easy API testing.
- Use the `/api/v1/auth/login` endpoint to obtain a JWT token.
- Use the token in the `Authorization` header for all protected endpoints.

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](LICENSE)