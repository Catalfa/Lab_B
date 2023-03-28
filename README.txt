Per eseguire i comandi Maven entrare nella directory src.

creazione tabelle: (dbURL ha un formato simile a "jdbc:postgresql://localhost:5432/lab-b")
    ant -DURL="dbURL" -Dusername="YourUsername" -Dpassword="YourPassword" db_setup

compila progetto e crea javadoc:
    mvn clean install

avvia server:
    mvn exec:java -Dexec.mainClass="ServerCV.server.ServerStart.java"

avvia client:
    mvn exec:java -Dexec.mainClass="ClientCV.CentriVaccinali.CentriVaccinali.java"t

