# Challenge: LiterAlura

Este proyecto es una biblioteca en línea desarrollada en Java como parte del desafío del curso Java Spring Boot G7 - One de Oracle + Alura Latam. El sistema consume el API de [Gutendex](https://gutendex.com/) para obtener títulos, autores e idiomas de libros, los cuales se almacenan en una base de datos para permitir consultas sobre los títulos registrados.

## Estructura del Proyecto
``` PlaniText
├── backend/         # Código fuente del backend (API REST)
├── frontend/        # Código fuente del frontend (Aplicación de consola)
└── README.md        # Documentación del proyecto
```
## Tecnologías Utilizadas

### Backend
- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Base de Datos**: PostgreSQL, o el de tu preferencia.
- **Control de Dependencias**: Maven

### Frontend
- **Tipo de Aplicación**: Aplicación de consola que interactúa con el backend
- **Lenguajes**: Java 
- **Control de Dependencias**: Maven

## Requisitos Previos

Para ejecutar el proyecto en tu entorno local, asegúrate de tener instalados:
- **Java** (versión 11 o superior)
- **Maven**
- **Base de datos especificada** (si es necesario, configura la base de datos antes de ejecutar el backend)

## Conclusión

Esta biblioteca en línea es una herramienta educativa diseñada para facilitar el consumo de APIs externas y la manipulación y almacenamiento de datos en un motor de base de datos. Al implementar buenas prácticas, como el manejo seguro de claves a través de variables de entorno, el proyecto ofrece una estructura sólida y escalable. Todo lo construido se ajusta a los contenidos y objetivos del curso, proporcionando una base práctica para el aprendizaje y la aplicación de conceptos fundamentales en desarrollo de software.


## Cómo Contribuir

¡Contribuciones son bienvenidas! Si deseas mejorar este proyecto, sigue estos pasos para contribuir a través de GitHub:

1. **Fork el repositorio**:
   Haz clic en el botón "Fork" en la parte superior de la página del repositorio.

2. **Clona tu fork localmente**:

   ```bash
   git clone https://github.com/odriverar/LiterAlura.git
   ```
3. **Crea una nueva rama para tu cambio**
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
4. **Realiza tus cambios y haz commits descriptivos:**
   ```bash
   git commit -m "Descripción detallada de lo que has cambiado"
   ```
5. **Sube tu rama al repositorio remoto:**
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
6. **Abre un Pull Request:**
   - Ve a la pestaña "Pull requests" en el repositorio original.
   - Haz clic en "New pull request" y selecciona la rama que has subido. 
   - Proporciona una descripción clara de los cambios que has hecho.
7. **Espera la revisión:** Tu Pull Request será revisado y, si todo está en orden, será fusionado con la rama principal del proyecto.



### Contacto

Si tienes alguna pregunta o sugerencia, no dudes en abrir un issue en el repositorio o contactarnos a través de odriverar@gmail.com.

---

>Gracias por utilizar este proyecto. Esperamos que esta herramienta te sea útil.
