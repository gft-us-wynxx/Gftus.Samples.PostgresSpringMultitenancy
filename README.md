# Postgres Multitenancy

Sample project demonstrating multi-tenant capabilities using Spring Boot and PostgreSQL.

### Features

- Uses the dedicated schema strategy: in Postgres there is a single database where tenants are separate schemas, ensuring complete data isolation between tenants.
- Every request is intercepted to extract the `X-TENANT` header, where the user must pass the desired tenant name (schema). The tenant identifier is stored in ThreadLocal to make it accessible to the database layer.
- Tenants are configured in `application.properties` and their schemas are created or updated when the application starts.
- Flyway manages schema versioning across all tenants — new migration files are automatically executed for each tenant defined in `application.properties`.

### Technologies

- Java 11
- Spring Boot 2.3.2
- Postgres 12
