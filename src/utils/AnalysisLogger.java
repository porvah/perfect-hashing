package utils;

import hash_tables.IHashTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AnalysisLogger {

    public static void printAnalysis(IHashTable table) {
        System.out.println("Size: " + table.getAllSpace());
        System.out.println("Hash Count: " + table.getHashCount());


    }

    public synchronized static void writeToCsv(List<String> data, String fileName) {

        try {
            File file = new File(fileName);
            FileWriter csvWriter = new FileWriter(new File("test_files/dataCollected/" + fileName), true);
            for (String row : data) {
                csvWriter.append(row);
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static synchronized void addAnalysis(String operation, int size, String type, int space, long time) {
        String content = type + "," + space + "," + time + "\n";
        switch (operation) {
            case "search" -> {
                DataCollector.addSearch(content);
            }
            case "insert" -> {
                DataCollector.addInsert(content);
            }
            case "delete" -> {
                DataCollector.addDelete(content);
            }
            case "batchInsert" -> {
                DataCollector.addBatchInsert(content);
            }
            case "batchDelete" -> {
                DataCollector.addBatchDelete(content);
            }

        }
    }
}
