package efficiency.N2;

import hash_tables.HashTableWithN2Space;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Efficiency600s8{
    HashTableWithN2Space<Integer> hashTable = new HashTableWithN2Space<>();
    Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/600s8.txt");
    Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/600s9.txt");


    private long time;

    private final String type = "N2";
    private final int size = 600;
    private String currentOperation;
    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys1);
        time = System.nanoTime();
    }


    @Test
    public void batchInsert() {

        currentOperation = "batchInsert";
        HashTableWithN2Space<Integer> hashTable = new HashTableWithN2Space<>();
        int res = hashTable.batchInsert(keys1);

        assert(res == 600);
    }

    @Test
    public void testSearch1() {
        currentOperation = "search";
        Integer key = 2944;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch2() {
        currentOperation = "search";
        Integer key = 698;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch3() {
        currentOperation = "search";
        Integer key = 2352;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch4() {
        currentOperation = "search";
        Integer key = 3786;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void insert1() {
        currentOperation = "insert";
        int key = 2944;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert2() {
        currentOperation = "insert";
        int key = 698;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert3() {
        currentOperation = "insert";
        int key = 2352;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert4() {
        currentOperation = "insert";
        int key = 3786;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void batchInsert2() {
       currentOperation = "batchInsert";
        int res = hashTable.batchInsert(keys2);

        assert(res == 570);
    }

    @Test
    public void delete1() {
        currentOperation = "delete";
        int key = 2944;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete2() {
        currentOperation = "delete";
        int key = 698;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete3() {
        currentOperation = "delete";
        int key = 2352;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete4() {
        currentOperation = "delete";
        int key = 3786;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void batchDeleteAll() {
        currentOperation = "batchDelete";
        int res = hashTable.batchDelete(keys1);

        assert(res == 600);
    }

    @Test
    public void batchDelete2() {
        currentOperation = "batchDelete";
        int res = hashTable.batchDelete(keys2);

        assert(res == 30);
    }

    @AfterEach
    public void printAnalysis() {
        time = System.nanoTime() - time;

        AnalysisLogger.addAnalysis(currentOperation, size,  type, hashTable.getAllSpace(), time, hashTable.getHashCount());
        AnalysisLogger.printAnalysis(hashTable);
    }


}
