import dictionary.Dictionary;
import dictionary.HashTableFactory;

import java.util.Scanner;

public class CLIProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of HashTable you want to use (n2  or  n):");
        String HashTableType = scanner.nextLine();
        Dictionary dictionary = new Dictionary(
                HashTableFactory.createHashTable(HashTableType)
        );

        while(true) {
            System.out.println("Enter a command (insert, delete, search, batchInsert, batchDelete, exit) followed by args:");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }
            String[] commandParts = command.split(" ", 2);
            String commandName = commandParts[0];
            String commandArgs = commandParts[1];
            switch (commandName) {
                case "insert" -> {
                    boolean success = dictionary.insert(commandParts[1]);
                    System.out.println(success ? "Inserted successfully" : "Failed to insert. String already exists");
                }
                case "delete" -> {
                    boolean success = dictionary.delete(commandParts[1]);
                    System.out.println(success ? "Deleted successfully" : "Failed to delete. String does not exist");
                }
                case "search" -> {
                    boolean success = dictionary.search(commandParts[1]);
                    System.out.println(success ? "String found" : "String not found");
                }
                case "batchInsert" -> {
                    String fileName = commandParts[1];
                    int[] results = dictionary.batchInsert(fileName);
                    System.out.println("Inserted " + results[0] + " strings, " + results[1] + " strings already existed");

                }
                case "batchDelete" -> {
                    String fileName = commandParts[1];
                    int[] results = dictionary.batchDelete(fileName);
                    System.out.println("Deleted " + results[0] + " strings, " + results[1] + " strings did not exist");
                }
            }
        }
    }



}
