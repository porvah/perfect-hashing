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

public class Efficiency4 {
    HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
    Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/1000000s1");
    Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/1000000s2");


    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys1);
    }


    @Test
    public void batchInsert() {
        HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys1);

        assert(res == 97481);
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

        assert(res == 95068);
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



}
