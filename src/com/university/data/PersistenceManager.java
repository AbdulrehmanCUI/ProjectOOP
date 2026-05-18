package com.university.data;

import java.io.*;
import java.nio.file.*;

public class PersistenceManager {

    private static final String DATA_FILE = "src/com/university/data/university.dat";

    private static final String BACKUP_FILE = "src/com/university/data/backup.dat";

    public static synchronized void save(Object data) {

        try(ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(DATA_FILE))) {

            out.writeObject(data);

            createBackup();

            System.out.println("System saved successfully.");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Object load() {

        File file = new File(DATA_FILE);

        if(!file.exists() || file.length() == 0) {
            return null;
        }

        try(ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(file))) {

            return in.readObject();

        } catch(IOException |
                ClassNotFoundException e) {

            System.out.println(
                    "Primary file corrupted. Recovering backup..."
            );

            return loadBackup();
        }
    }

    private static void createBackup() throws IOException {

        Files.copy(
                Paths.get(DATA_FILE),
                Paths.get(BACKUP_FILE),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    private static Object loadBackup() {

        try(ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(BACKUP_FILE))) {

            return in.readObject();

        } catch(Exception e) {
            return null;
        }
    }
}
