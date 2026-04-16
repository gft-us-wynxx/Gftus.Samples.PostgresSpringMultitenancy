# Design: Translate Repository to English

**Date:** 2026-04-15  
**Status:** Approved

## Overview

This project is a Spring Boot + PostgreSQL multitenancy sample. All human-readable Portuguese content across the repository will be translated to English. The goal is to make the repository accessible to an English-speaking audience.

## Scope

### Files to Modify

| File | What Changes |
|---|---|
| `README.md` | Full rewrite in English |
| `src/main/java/.../services/AuthorService.java` | Translate error string |
| `src/main/java/.../services/PostService.java` | Translate error string |
| `src/main/java/.../resources/exceptions/ResourceExceptionHandler.java` | Translate error label string |
| `src/main/java/.../config/Instantiation.java` | Translate seed data strings |
| `src/main/resources/db/migration/V01__Estrutura_inicial.sql` | Rename file only (content already in English) |

### Translations

#### Java error messages
| Location | Current | Translated |
|---|---|---|
| `AuthorService.java:25` | `"Objeto não encontrado"` | `"Object not found"` |
| `PostService.java:21` | `"Objeto não encontrado"` | `"Object not found"` |
| `ResourceExceptionHandler.java:19` | `"Não encontrado"` | `"Not found"` |

#### Seed data (`Instantiation.java`)
| Current | Translated |
|---|---|
| `"Partiu viagem"` | `"Off on a trip"` |
| `"Vou viajar para São Paulo. Abraços!"` | `"I'm traveling to São Paulo. Cheers!"` |
| `"Bom dia"` | `"Good morning"` |
| `"Acordei feliz hoje!"` | `"I woke up happy today!"` |

#### SQL migration filename
| Current | New |
|---|---|
| `V01__Estrutura_inicial.sql` | `V01__Initial_structure.sql` |

> **Note:** Flyway is currently disabled (`spring.flyway.enabled=false`), so renaming this file is safe. If Flyway is re-enabled against a database that already tracked the old filename, the migration will need to be re-run or the `flyway_schema_history` table updated manually.

### Files NOT Changing
- `application.properties` — already in English
- Package names (`br.com.fullcustom...`) — domain identifiers, not language
- SQL file content — already in English SQL syntax

## README Structure (English)

The new README will preserve the same sections:
- Project description (what it is and why)
- Characteristics (dedicated schema strategy, X-TENANT header, application.properties tenant config, Flyway versioned migrations)
- Technologies used (Java 11, Spring Boot 2.3.2, Postgres 12)

## Approach

Option B — single pass, all files changed in one commit. No branching, no splitting by area. The project is a sample/demo with no production users.
