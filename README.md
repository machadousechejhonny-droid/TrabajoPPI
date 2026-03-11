# TrabajoPPI

Proyecto Java EE (NetBeans) con JPA y JSF.

## Base de datos (Derby)

El proyecto se conecta a una base de datos Apache Derby en modo servidor (Network Server) con:

- URL: `jdbc:derby://localhost:1527/RopaMax`
- Recurso JDBC (GlassFish): `jdbc/miPPI` (ver `web/WEB-INF/glassfish-resources.xml`)
- Persistence Unit: `TrabajoPPIPU` usando `java:app/jdbc/miPPI` (ver `src/conf/persistence.xml`)

### Por que se sube la carpeta `db/RopaMax`

Normalmente no se versiona una base de datos "viva" en Git, pero en este proyecto se incluye `db/RopaMax` para
entregar la BD exactamente como se uso/desarrollo (incluyendo datos), por requerimiento de entrega y para que el
proyecto pueda ejecutarse sin tener que recrear y poblar manualmente.

De todas formas, tambien se incluye el script `db/create_tables.sql` para que se pueda reconstruir el esquema
si alguien prefiere crear la base desde cero.

### Como usar la BD incluida

Para que Derby encuentre la carpeta `db/RopaMax`, el Network Server debe iniciarse con el "system home" apuntando a
la carpeta `db/` de este proyecto (de forma que exista `db/RopaMax`).

Una forma sencilla es configurar en NetBeans la ubicacion de Java DB/Derby a la carpeta `db/` del proyecto y luego
iniciar el servidor Derby desde NetBeans. Despues, al levantar GlassFish, la conexion a `RopaMax` deberia funcionar.
