package efficiency.N;

import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Efficiency10000s2{
    HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
    Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/10000s2.txt");
    Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/10000s3.txt");


    private long time;

    private final String type = "N";
    private final int size = 10000;
    private String currentOperation;
    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys1);
        time = System.nanoTime();
    }


    @Test
    public void batchInsert() {

        currentOperation = "batchInsert";
        HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys1);

        assert(res == 10000);
    }

    @Test
    public void testSearch1() {
        currentOperation = "search";
        Integer key = 16038;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch2() {
        currentOperation = "search";
        Integer key = -66084;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch3() {
        currentOperation = "search";
        Integer key = 35792;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch4() {
        currentOperation = "search";
        Integer key = -67180;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void insert1() {
        currentOperation = "insert";
        int key = 16038;
        boolean res = hashTable.insert(key);
        assert (!res);
    }

    @Test
    public void insert2() {
        currentOperation = "insert";
        int key = -66084;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert3() {
        currentOperation = "insert";
        int key = 35792;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert4() {
        currentOperation = "insert";
        int key = -67180;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void batchInsert2() {
       currentOperation = "batchInsert";
        int res = hashTable.batchInsert(keys2);

        assert(res == 9466);
    }

    @Test
    public void delete1() {
        currentOperation = "delete";
        int key = 16038;
        boolean res = hashTable.delete(key);
        assert (res);
    }

    @Test
    public void delete2() {
        currentOperation = "delete";
        int key = -66084;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete3() {
        currentOperation = "delete";
        int key = 35792;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete4() {
        currentOperation = "delete";
        int key = -67180;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void batchDeleteAll() {
        currentOperation = "batchDelete";
        int res = hashTable.batchDelete(keys1);

        assert(res == 10000);
    }

    @Test
    public void batchDelete2() {
        currentOperation = "batchDelete";
        int res = hashTable.batchDelete(keys2);

        assert(res == 534);
    }

    @AfterEach
    public void printAnalysis() {
        time = System.nanoTime() - time;
        AnalysisLogger.addAnalysis(currentOperation, size,  type, hashTable.getAllSpace(), time);
        AnalysisLogger.printAnalysis(hashTable);
    }


}
