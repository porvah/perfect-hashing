package N;

import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessInteger3 {

    HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
    Integer[] keys = KeysReader.getIntegersFromFile("test_files/correctness/integers/test3_batchInsert_withNegatives.txt");

    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys);
    }

    @Test
    public void batchInsert() {
        HashTableWithNSpace<Integer> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys);
        assert(res == 7);
    }

    @Test
    public void testSearch1() {
        Integer key = -2;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch2() {
        Integer key = -3;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch3() {
        Integer key = -7;
        boolean res = hashTable.search(key);
        assert(!res);
    }

    @Test
    public void testSearch4() {
        Integer key = 5;
        boolean res = hashTable.search(key);
        assert(!res);
    }


    @Test
    public void delete1() {
        int key = -2;
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        int key = -3;
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        int key = -7;
        boolean res = hashTable.delete(key);
        assert(!res);
    }
    @Test
    public void delete4() {
        int key = 6;
        boolean res = hashTable.delete(key);
        assert(!res);
    }




    @Test
    public void insert1() {
        int key = -342;
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert2() {
        int key = -345;
        assert(hashTable.insert(key));
    }
    @Test
    public void insert3() {
        int key = -8;
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert4() {
        int key = 0;
        assert(hashTable.insert(key));
    }





    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys);
        assert(res == 7);
    }
    @Test
    public void batchDelete1() {
        Integer[] keys = new Integer[]{-2, -3, -7, 5};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test
    public void batchDelete2() {
        Integer[] keys = new Integer[]{
                -2,
                -3,
                -8
        };
        int res = hashTable.batchDelete(keys);
        assert(res == 3);
    }

    @Test
    public void batchDelete3() {
        Integer[] keys = new Integer[]{
                -2,
                -2
        };
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }

    @Test
    public void batchDelete4() {
        Integer[] keys = new Integer[]{1, 2, 3, 4};
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }

    @Test
    public void batchDelete5() {
        Integer[] keys = KeysReader.getIntegersFromFile("test_files/correctness/integers/test3_batchDelete_withNegatives.txt");
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }





    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }

}
