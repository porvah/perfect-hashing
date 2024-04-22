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

public class Efficiency2 {
    HashTableWithN2Space<Integer> hashTable = new HashTableWithN2Space<>();
    Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/10000s1");
    Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/10000s2");


    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys1);
    }


    @Test
    public void batchInsert() {
        HashTableWithN2Space<Integer> hashTable = new HashTableWithN2Space<>();
        int res = hashTable.batchInsert(keys1);
        System.out.println(res);
        assert(res == 9790);
    }

    @Test
    public void testSearch1() {
        Integer key = 1;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch2() {
        Integer key = 2;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch3() {
        Integer key = 3;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void testSearch4() {
        Integer key = 1034230;
        boolean res = hashTable.search(key);
        assert (!res);
    }

    @Test
    public void batchInsert2() {
        int res = hashTable.batchInsert(keys2);

        assert(res == 9515);
    }

    @Test
    public void insert1() {
        int key = -14252;
        boolean res = hashTable.insert(key);

        assert(res);
    }

    @Test
    public void insert2() {
        int key = 1423700;
        boolean res = hashTable.insert(key);

        assert(res);
    }

    @Test
    public void insert3() {
        int key = 624322;
        boolean res = hashTable.insert(key);

        assert(res);
    }

    @Test
    public void insert4() {
        int key = 1004;
        boolean res = hashTable.insert(key);

        assert(res);
    }

    @Test
    public void delete1() {
        int key = 1024140;
        boolean res = hashTable.delete(key);

        assert(!res);
    }

    @Test
    public void delete2() {
        int key = -13123424;
        boolean res = hashTable.delete(key);

        assert(!res);
    }

    @Test
    public void delete3() {
        int key = 3;
        boolean res = hashTable.delete(key);

        assert(!res);
    }

    @Test
    public void delete4() {
        int key = 2;
        boolean res = hashTable.delete(key);

        assert(!res);
    }

    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys1);

        assert(res == 9790);
    }

    @Test
    public void batchDelete2() {
        int res = hashTable.batchDelete(keys2);

        assert(res == 485);
    }

    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }


}
