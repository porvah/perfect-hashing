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

public class Efficiency1000000s2{
    HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
    Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/1000000s2.txt");
    Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/1000000s3.txt");


    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys1);
    }


    @Test
    public void batchInsert() {
        HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys1);

        assert(res == 1000000);
    }

    @Test
    public void testSearch1() {
        Integer key = -3232930;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch2() {
        Integer key = -8207988;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch3() {
        Integer key = -4594864;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch4() {
        Integer key = 8714660;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void insert1() {
        int key = -3232930;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert2() {
        int key = -8207988;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert3() {
        int key = -4594864;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert4() {
        int key = 8714660;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void batchInsert2() {
        int res = hashTable.batchInsert(keys2);

        assert(res == 949823);
    }

    @Test
    public void delete1() {
        int key = -3232930;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete2() {
        int key = -8207988;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete3() {
        int key = -4594864;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete4() {
        int key = 8714660;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys1);

        assert(res == 1000000);
    }

    @Test
    public void batchDelete2() {
        int res = hashTable.batchDelete(keys2);

        assert(res == 50177);
    }

    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }


}
