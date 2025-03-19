# 🏆 UEFA Champions League Team Management System 🏆
Bienvenido al UEFA Champions League Team Management System, una aplicación Java diseñada para gestionar y analizar datos de equipos de fútbol que participan en la UEFA Champions League. Este proyecto utiliza programación funcional, Streams API y manipulación de datos en JSON para ofrecer una experiencia interactiva y eficiente.

### 📋 Tabla de Contenidos
- Descripción del Proyecto

- Estructura del Proyecto

- Funcionalidades Principales

- Cómo Ejecutar el Proyecto

- Dependencias

### 🚀 Descripción del Proyecto
Este proyecto es un sistema de gestión de equipos de fútbol que participan en la UEFA Champions League. Permite a los usuarios cargar datos de equipos, jugadores y estadísticas desde un archivo JSON, y realizar diversas operaciones como filtrado, ordenación y análisis de datos utilizando la API de Streams de Java.

- 🗂 Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes:

- com.manejoequipos.domain: Contiene las clases de dominio como equipos, jugador, estadisticas y Liga.

- com.manejoequipos.filtros: Implementa los retos y operaciones de filtrado, mapeo y reducción utilizando Streams API.

- com.manejoequipos.repository: Se encarga de la lectura y carga de datos desde un archivo JSON.

- com.manejoequipos.ui: Contiene la interfaz de usuario en consola para interactuar con el sistema.

- com.manejoequipos.usecase: Implementa casos de uso específicos como el cálculo de promedios, filtrado de equipos.

### 🛠 Funcionalidades Principales
- 🔍 Filtrado y Búsqueda
- Filtrar equipos fundados después del año 2000.

- Buscar jugadores por nacionalidad.

- Filtrar equipos con más de 20 victorias.

### 📊 Análisis de Datos
- Calcular el promedio de edad de los jugadores.

- Obtener el promedio de goles a favor por equipo.

- Contar la cantidad de delanteros en la liga.

### 🏅 Comparaciones y Ordenación
- Encontrar el equipo con más victorias.

- Identificar al jugador más alto.

- Ordenar equipos por goles a favor.

### 📝 Reportes
- Generar un mapa de equipos y sus goles a favor.

- Listar entrenadores de equipos con al menos un empate.

### 🖥 Cómo Ejecutar el Proyecto
Clona el repositorio:

````bash

git clone https://github.com/tu-usuario/uefa-champions-league-management.git
````
- Abre el proyecto en tu IDE favorito.

- Asegúrate de tener Java 8 o superior instalado.

- Carga el archivo JSON (uefa.json) en la raíz del proyecto.

- Ejecuta la clase Main para iniciar la aplicación.

- Sigue las instrucciones en la consola para interactuar con el sistema.

### 📦 Dependencias
- Jackson Databind: Para la manipulación de archivos JSON.

````xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
</dependency>
````
