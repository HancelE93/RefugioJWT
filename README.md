# 🔐 Taller JWT - Refugio de Mascotas "Patitas al Rescate"

Proyecto desarrollado con **Spring Boot**, **PostgreSQL**, **BCrypt** y **JWT** para implementar un sistema de autenticación progresivamente más seguro, pasando de contraseñas almacenadas en texto plano a una arquitectura basada en tokens.

---

## 🚀 Tecnologías Utilizadas

* ☕ Java
* 🌱 Spring Boot
* 🗄️ PostgreSQL
* 🔄 Spring Data JPA
* 🔒 BCrypt
* 🎟️ JWT (JSON Web Token)

---

## 📚 Hitos Implementados

### 🐾 Hito 1: Registro y Login Vulnerable

Se implementó el registro e inicio de sesión de usuarios almacenando las contraseñas en texto plano para demostrar los riesgos de seguridad asociados a esta práctica.

### 🔐 Hito 2: Protección de Contraseñas con BCrypt

Se incorporó BCrypt para almacenar contraseñas mediante hashing, evitando que sean visibles directamente en la base de datos.

### 🎟️ Hito 3: Generación de Tokens JWT

Después de una autenticación exitosa, el sistema genera un token JWT firmado digitalmente con una validez de 30 minutos.

### 🛡️ Hito 4: Protección de Endpoint

Se protegió el endpoint `/perfil`, validando manualmente el token JWT enviado en la cabecera `Authorization`.

---

## 📡 Endpoints Principales

| Método | Endpoint              | Descripción                    |
| ------ | --------------------- | ------------------------------ |
| POST   | `/api/auth/registrar` | Registrar un nuevo usuario     |
| POST   | `/api/auth/login`     | Iniciar sesión y obtener JWT   |
| GET    | `/api/auth/perfil`    | Acceder a un recurso protegido |

---

## 🧪 Pruebas Realizadas

✅ Registro de usuarios.

✅ Verificación de contraseñas almacenadas en texto plano.

✅ Implementación de BCrypt.

✅ Generación de tokens JWT.

✅ Validación de tokens en endpoints protegidos.

✅ Rechazo automático de tokens alterados o inválidos.

---

## 🎯 Objetivo del Proyecto

Comprender los fundamentos de la autenticación segura en aplicaciones backend mediante el uso de hashing de contraseñas, generación de tokens JWT y protección de recursos utilizando mecanismos de validación de identidad.

---

### 👨‍💻 Autor

**Hancel Espín**
