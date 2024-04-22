package correctness.N;

import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessInteger1 {

    HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
    Integer[] keys = KeysReader.getIntegersFromFile("test_files/correctness/integers/test1_batchInsert_withDuplicates.txt");

    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys);
    }

    @Test
    public void batchInsert() {
        HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys);
        assert(res == 13);
    }

    @Test
    public void testSearch1() {
        Integer key = 1;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch2() {
        Integer key = 2;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch3() {
        Integer key = 14;
        boolean res = hashTable.search(key);
        assert(!res);
    }

    @Test
    public void testSearch4() {
        Integer key = -2;
        boolean res = hashTable.search(key);
    }


    @Test
    public void delete1() {
        int key = 1;
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        int key = 13;
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        int key = 14;
        boolean res = hashTable.delete(key);
        assert(!res);
    }
    @Test
    public void delete4() {
        int key = -2;
        boolean res = hashTable.delete(key);
        assert(!res);
    }




    @Test
    public void insert1() {
        int key = 1;
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert2() {
        int key = 14;
        assert(hashTable.insert(key));
    }
    @Test
    public void insert3() {
        int key = 13;
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert4() {
        int key = -2;
        assert(hashTable.insert(key));
    }





    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys);
        assert(res == 13);
    }

    @Test
    public void batchDelete1() {
        Integer[] keys = new Integer[]{1, 5, 3, 7, -4, -122};
        int res = hashTable.batchDelete(keys);
        assert(res == 4);
    }

    @Test
    public void batchDelete2() {
        Integer[] keys = new Integer[]{1, 1, 1, 1};
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }

    @Test
    public void batchDelete3() {
        Integer[] keys = new Integer[]{4, 4, 4, 5};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test
    public void batchDelete4() {
        Integer[] keys = new Integer[]{-1, -5, 1000};
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }

    @Test void batchDelete5() {
        Integer[] keys = KeysReader.getIntegersFromFile("test_files/correctness/integers/test1_batchDelete_withDuplicates.txt");
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }





    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }

}
