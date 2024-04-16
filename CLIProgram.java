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
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case "insert" -> dictionary.insert(commandParts[1]);
                case "delete" -> dictionary.delete(commandParts[1]);
                case "search" -> System.out.println(dictionary.search(commandParts[1]));
                case "batchInsert" -> {
                    String[] keys = commandParts[1].split(",");
                    dictionary.batchInsert(keys);
                }
                case "batchDelete" -> {
                    String[] keys = commandParts[1].split(",");
                    dictionary.batchDelete(keys);
                }
            }
        }
    }
}
