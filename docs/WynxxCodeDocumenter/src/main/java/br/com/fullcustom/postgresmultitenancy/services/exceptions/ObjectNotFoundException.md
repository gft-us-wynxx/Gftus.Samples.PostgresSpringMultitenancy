# ObjectNotFoundException

## Overview

This document describes a custom exception data structure used within the multi-tenancy PostgreSQL application. It defines a specialized runtime exception that is raised when a requested object cannot be found in the system. This exception is part of the service layer's error-handling strategy, enabling the application to communicate clearly when a lookup operation fails to locate the expected resource.

## Data Structure Details

| Attribute / Element       | Type                | Description                                                                 |
|---------------------------|---------------------|-----------------------------------------------------------------------------|
| `serialVersionUID`        | `long` (constant)   | Version identifier for serialization compatibility, set to `1L`.            |
| `ObjectNotFoundException` | Constructor         | Accepts a message string describing the reason the object was not found.    |

## Inheritance

| Level          | Class                        | Description                                                        |
|----------------|------------------------------|--------------------------------------------------------------------|
| Parent         | `RuntimeException`           | Standard Java unchecked exception, does not require explicit handling. |
| Grandparent    | `Exception` → `Throwable`   | Part of the core Java exception hierarchy.                         |

## Package

`br.com.fullcustom.postgresmultitenancy.services.exceptions`

This places the exception within the **services exceptions** package, indicating it is intended to be thrown by service-layer components when a data retrieval operation does not find the target entity.

## Insights

- As an **unchecked exception** (extending `RuntimeException`), it does not force calling code to handle it explicitly with try-catch blocks. This is a common pattern for exceptions that represent programming or data-integrity issues rather than recoverable conditions.
- The exception carries a descriptive message, allowing consuming layers (such as REST controllers or global exception handlers) to relay meaningful feedback to the end user or API consumer — for example, returning an HTTP **404 Not Found** response.
- This structure supports a **clean separation of concerns**: the service layer signals the absence of a resource, and upper layers decide how to present that information (e.g., error response body, status code).
- In a **multi-tenancy** context, this exception may surface when a requested resource does not exist within the scope of the current tenant's data partition.
