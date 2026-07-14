# Subscription Manager

Subscription Manager es una aplicación desarrollada con Spring Boot siguiendo los principios de la Arquitectura Hexagonal (Ports & Adapters) y Domain-Driven Design (DDD).

## Objetivo

El objetivo del proyecto es gestionar suscripciones personales (Netflix, Spotify, gimnasio, software, etc.) aplicando buenas prácticas de arquitectura y diseño de software.

## Tecnologías

- Java 21
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- H2 Database
- JUnit 5

## Arquitectura

El proyecto sigue una arquitectura hexagonal con la siguiente estructura:

```
src/main/java/com/antonio/subscription_manager
├── domain
├── application
└── infrastructure
```

- **domain**: entidades, value objects y reglas de negocio.
- **application**: casos de uso y puertos.
- **infrastructure**: adaptadores de entrada y salida.
