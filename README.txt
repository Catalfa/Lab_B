Per eseguire i comandi Maven entrare nella directory src.

compila progetto e crea javadoc:
    mvn clean install

avvia server:
    mvn exec:java -Dexec.mainClass="ServerCV.server.ServerStart.java"

avvia client:
    mvn exec:java -Dexec.mainClass="ClientCV.CentriVaccinali.CentriVaccinali.java"t

