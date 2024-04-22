package utils;


import java.util.ArrayList;
import java.util.List;

public class DataCollector {

    public static List<String> Search = new ArrayList<>();

    public static  List<String> Insert = new ArrayList<>();

    public static List<String> Delete = new ArrayList<>();

    public static List<String> BatchInsert = new ArrayList<>();

    public static List<String> BatchDelete = new ArrayList<>();
    public static int searchCount = 0;
    public static int insertCount = 0;
    public static int deleteCount = 0;
    public static int batchInsertCount = 0;
    public static int batchDeleteCount = 0;



    static {
        int count = 260;
        searchCount = count * 4;
        insertCount = count * 4;
        deleteCount = count * 4;

        batchInsertCount = count * 2;
        batchDeleteCount = count * 2;


    }


    public static void addSearch(String search) {
        Search.add(search);
        searchCount--;
        if(searchCount == 0) {
            AnalysisLogger.writeToCsv(Search, "search.csv");
        }
    }

    public static void addInsert(String insert) {
        Insert.add(insert);
        insertCount--;
        if(insertCount == 0) {
            AnalysisLogger.writeToCsv(Insert, "insert.csv");
        }
    }

    public static void addDelete(String delete) {
        Delete.add(delete);
        deleteCount--;
        if(deleteCount == 0) {
            AnalysisLogger.writeToCsv(Delete, "delete.csv");
        }

    }

    public static void addBatchInsert(String batchInsert) {
        BatchInsert.add(batchInsert);
        batchInsertCount--;
        if(batchInsertCount == 0) {
            AnalysisLogger.writeToCsv(BatchInsert, "batchInsert.csv");
        }

    }

    public static void addBatchDelete(String batchDelete) {
        BatchDelete.add(batchDelete);
        batchDeleteCount--;
        if(batchDeleteCount == 0) {
            AnalysisLogger.writeToCsv(BatchDelete, "batchDelete.csv");
        }
    }



}
