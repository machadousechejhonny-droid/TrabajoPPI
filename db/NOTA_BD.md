# Nota sobre la base de datos

En este repositorio se incluyen dos cosas relacionadas con la BD:

1. `db/RopaMax/`
   - Es la carpeta fisica de la base de datos Derby (Apache Derby).
   - Se incluye para conservar la BD tal cual se uso en el proyecto (incluyendo datos), lo cual facilita la entrega
     y la ejecucion inmediata del sistema.

2. `db/create_tables.sql`
   - Script con el DDL para crear las 2 tablas (`ROPA` y `CALZADO`).
   - Se incluye porque es una forma reproducible/estandar de reconstruir el esquema si no se quiere versionar la
     carpeta completa de la BD o si se necesita recrearla desde cero.

Nota: En proyectos reales normalmente se versionan solo migraciones/scripts (y no la carpeta completa de una BD),
pero aqui se incluye la carpeta por motivos de entrega y para que el proyecto funcione sin pasos extra.
