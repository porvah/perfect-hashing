package utils;

import hash_tables.IHashTable;

public class AnalysisLogger {

    public static void printAnalysis(IHashTable table) {
        System.out.println("Size: " + table.getAllSpace());
        System.out.println("Hash Count: " + table.getHashCount());
    }
}
