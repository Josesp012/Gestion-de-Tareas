# Gestion-de-Tareas
Aplicación de “Gestión de Tareas” (To-Do list) que permita a un usuario:  Crear, Leer, Actualizar y Eliminar tareas.

APi Rest (Back-End):
- Lenguaje: Java EE.
- Frameworks: SpringBoot, Maven: Dependencias (Spring Data JPA, Spring Starter Web, Spring Starter Validation, Spring Devtools, Oracle Driver)
Pagina Web (Front-End):
- Lenguajes: TypeScript, HTML, CSS.
- Frameworks: Angular, Node.js 

Instalacion: 
Base de datos: Oracle 19c, SQL Developer 

Back-End: Eclipse Version 2023, Apache Maven, Postman

Front-End: Visual Studio Code: Extensiones (Angular Language Service, Angular Snippets, Auto Rename Tag, autoclose, Error Lens, Live Server, Material Icon Theme, Monokai Vibrant
Node.js, Npm, Angular_Cli)

Variables del entorno:
-C:\Program Files\Java\jdk-17.0.2
-C:\Program Files\Maven\apache-maven-3.9.9
-C:\Oracle\WINDOWS.X64_193000_db_home\bin

Comandos terminal:
Oracle:
- /as sysdba
- alter session set *_oracle_script*=true
- create user db_curso identified by curso123
- grant all privileges to db_curso
Angular:
-  npm install
-  npm install -g @angular/cli

Comando clonacion del repositorio: git clone https://github.com/Josesp012/Gestion-de-Tareas.git

Procedimiento de ejecucion:
Base de datos
1. Ejecucion de manera ascendente los comandos del archivo tareas.sql en el programa SQL Developer
Api REst
2. Ejecucion en el editor de codigo Eclipse: Run As-> SringBootApp
3. Probar los metodos de la APi mediante Postman con la url: localhost:8080/api/tasks
Pagina Web
4. Abrir la terminal desde Visual Studio Code
5. Ejecutar el comando: ng serve --open
