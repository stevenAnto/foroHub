# Proyecto ForoHub

## Índice
1. [Descripción del proyecto](#descripción-del-proyecto)
2. [Estado del proyecto](#estado-del-proyecto)
3. [Funcionalidades de la aplicación y demostración](#funcionalidades-de-la-aplicación-y-demostración)
4. [Acceso al proyecto](#acceso-al-proyecto)
5. [Tecnologías utilizadas](#tecnologías-utilizadas)
6. [Desarrollador del proyecto](#desarrollador-del-proyecto)
7. [Licencia](#licencia)

## Descripción del proyecto
En este proyecto, desarrollamos ForoHub, una API REST que replica el funcionamiento de un foro básico. Permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los tópicos del foro. Los usuarios pueden crear nuevos tópicos, ver todos los tópicos existentes, ver un tópico específico, actualizar un tópico y eliminar un tópico. Además, se implementa autenticación y autorización utilizando JWT para restringir el acceso a las operaciones según el rol del usuario.

## Estado del proyecto
Concluido

## Funcionalidades de la aplicación y demostración
### Crear un nuevo tópico en el foro
```http
POST /topicos
```
### Crear un nuevo tópico en el foro
```http
POST /topicos
```
Crea un nuevo tópico en el foro.

### Mostrar todos los tópicos
```http
GET /topicos
```
Devuelve una lista de todos los tópicos existentes en el foro.

### Mostrar un tópico específico
```http
GET /topicos/{id}
```
Devuelve los detalles de un tópico específico según su ID.

### Actualizar un tópico
```http
PUT /topicos/{id}
```
Actualiza un tópico existente según su ID.

### Eliminar un tópico
```http
DELETE /topicos/{id}
```
Elimina un tópico existente según su ID.

### Autenticación y autorización
Se implementa autenticación y autorización utilizando JWT (JSON Web Token) para proteger los endpoints de la API y restringir el acceso según el rol del usuario.

### Acceso al proyecto
El código fuente está disponible en el repositorio de GitHub:
[Repositorio ForoHub](https://github.com/tu-usuario/forohub)

Para clonar el repositorio, ejecuta el siguiente comando:
```bash
git clone https://github.com/tu-usuario/forohub.git
```

Para configurar el entorno de desarrollo, sigue las instrucciones detalladas en el archivo README.md del repositorio.

### Tecnologías utilizadas
- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Token) para autenticación
- Maven

### Desarrollador del proyecto
Esteven Antonio Calcina Puma

### Licencia
Este proyecto está licenciado bajo los términos de la Licencia MIT.
```
