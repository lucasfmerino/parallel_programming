package buscaTextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskTextSearch implements Runnable {
    private String fileName;
    private String name;

    public TaskTextSearch(String fileName, String name) {
        this.fileName = fileName;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(fileName));

            int lineNumber = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(
                            String.format("File: [%s] - Line number: [%d] - %s", fileName, lineNumber, line));
                }

                lineNumber++;

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
