# GeoIp
Simple geoIp restful service.

createTable.sql script may be used to create the database table. It also creates a geoip_user user and grants it all priveleges on the table being created. This user is used by the application.

The application expects either zero or one argument when being started. If the argument is present it should contain a full path to a .csv file containing data to be loaded into the database.

How to run: open project in IDE and run the GeoipApplication class or use maven spring-boot:run goal
