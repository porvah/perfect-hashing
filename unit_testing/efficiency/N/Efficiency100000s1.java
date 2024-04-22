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

public class Efficiency100000s1{
    HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
    Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/100000s1.txt");
    Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/100000s2.txt");


    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys1);
    }


    @Test
    public void batchInsert() {
        HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys1);

        assert(res == 100000);
    }

    @Test
    public void testSearch1() {
        Integer key = -537390;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch2() {
        Integer key = -660852;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch3() {
        Integer key = -403654;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch4() {
        Integer key = -308522;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void insert1() {
        int key = -537390;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert2() {
        int key = -660852;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert3() {
        int key = -403654;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void insert4() {
        int key = -308522;
        boolean res = hashTable.insert(key);
        assert (res);
    }

    @Test
    public void batchInsert2() {
        int res = hashTable.batchInsert(keys2);

        assert(res == 95012);
    }

    @Test
    public void delete1() {
        int key = -537390;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete2() {
        int key = -660852;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete3() {
        int key = -403654;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void delete4() {
        int key = -308522;
        boolean res = hashTable.delete(key);
        assert (!res);
    }

    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys1);

        assert(res == 100000);
    }

    @Test
    public void batchDelete2() {
        int res = hashTable.batchDelete(keys2);

        assert(res == 4988);
    }

    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }


}
