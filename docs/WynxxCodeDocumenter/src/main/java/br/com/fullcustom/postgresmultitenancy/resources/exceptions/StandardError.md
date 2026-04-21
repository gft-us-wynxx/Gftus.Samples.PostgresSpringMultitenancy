# StandardError - Data Structure Documentation

## Overview

The `StandardError` data structure represents a standardized error response format used across the application. It encapsulates all relevant details about an error that occurs during API request processing, providing a consistent and predictable error payload to API consumers.

This class belongs to the exception handling layer of a **PostgreSQL Multi-Tenancy** application.

---

## Package

`br.com.fullcustom.postgresmultitenancy.resources.exceptions`

---

## Structure Details

The `StandardError` data structure implements `Serializable`, enabling it to be transmitted over the network or persisted when needed.

### Fields

| Field       | Type      | Description                                                                 |
|-------------|-----------|-----------------------------------------------------------------------------|
| `timestamp` | `Long`    | The moment (in milliseconds since epoch) when the error occurred            |
| `status`    | `Integer` | The HTTP status code associated with the error (e.g., 404, 500)            |
| `error`     | `String`  | A brief label describing the error category (e.g., "Not Found")            |
| `message`   | `String`  | A descriptive message providing additional context about the error          |
| `path`      | `String`  | The API endpoint path that was being accessed when the error was triggered  |

---

## Construction

The data structure supports two modes of instantiation:

| Constructor         | Description                                              |
|---------------------|----------------------------------------------------------|
| Default (no-args)   | Creates an empty instance with no fields initialized     |
| Parameterized       | Creates a fully populated instance with all five fields  |

---

## Insights

- **Standardized API Error Responses**: This structure ensures that every error returned by the application follows a uniform format, making it easier for client applications and integration partners to parse and handle errors consistently.
- **Multi-Tenancy Context**: Being part of a multi-tenancy system, this error structure likely serves multiple tenants. The consistent format helps tenant-specific error handling and monitoring across the platform.
- **Serialization Support**: The implementation of `Serializable` with an explicit `serialVersionUID` ensures safe serialization across different JVM versions, which is important in distributed or microservice architectures.
- **RESTful Convention Alignment**: The combination of `status`, `error`, `message`, and `path` closely mirrors standard REST API error response conventions, facilitating straightforward debugging and logging.
