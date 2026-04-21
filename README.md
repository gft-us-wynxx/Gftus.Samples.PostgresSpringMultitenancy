# Postgres Multitenancy

Project developed to create a test environment using the multi-tenant feature.

### Features

- Uses the dedicated schema strategy, meaning Postgres has a single database where tenants are schemas, created separately to fully isolate one tenant from another.
- Every request is intercepted and the header named X-TENANT is read, where the user must pass the name of the desired tenant (schema). The tenant identifier is then stored in a ThreadLocal so it can be accessed by the database layer.
- Tenants are configured in the application.properties file and will be created/updated whenever the application restarts.
- Flyway is used to create each tenant's schema in a versioned manner — when a new Flyway version file is created, it will be executed for every tenant defined in application.properties.

### Technologies

- Java 11
- Spring Boot 2.3.2
- Postgres 12
