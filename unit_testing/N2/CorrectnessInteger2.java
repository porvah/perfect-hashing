package N2;

import hash_tables.HashTableWithN2Space;
import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessInteger2 {
    HashTableWithN2Space<Integer> hashTable = new HashTableWithN2Space<>();
    Integer[] keys = KeysReader.getIntegersFromFile("test_files/correctness/integers/test2_batchInsert_withBigNumbers.txt");

    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys);
    }

    @Test
    public void batchInsert() {
        HashTableWithN2Space<Integer> hashTable = new HashTableWithN2Space<>();
        int res = hashTable.batchInsert(keys);
        assert(res == 9);
    }
    @Test
    public void testSearch1() {
        Integer key = 34545654;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch2() {
        Integer key = 1;
        boolean res = hashTable.search(key);
        assert (res);
    }

    @Test
    public void testSearch3() {
        Integer key = 13424;
        boolean res = hashTable.search(key);
        assert(!res);
    }

    @Test
    public void testSearch4() {
        Integer key = 2526364;
        boolean res = hashTable.search(key);
        assert(!res);
    }


    @Test
    public void delete1() {
        int key = 34545654;
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        int key = 1;
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        int key = 34545655;
        boolean res = hashTable.delete(key);
        assert(!res);
    }
    @Test
    public void delete4() {
        int key = 372532;
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
        int key = 2425;
        assert(hashTable.insert(key));
    }
    @Test
    public void insert3() {
        int key = 34545654;
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert4() {
        int key = 3;
        assert(hashTable.insert(key));
    }





    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys);
        assert(res == 9);
    }
    @Test
    public void batchDelete1() {
        Integer[] keys = new Integer[]{1, 34545654, 266392, 24642352};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test
    public void batchDelete2() {
        Integer[] keys = new Integer[]{
                1,
                34545654,
                75476545,
                43557465
        };
        int res = hashTable.batchDelete(keys);
        assert(res == 4);
    }

    @Test
    public void batchDelete3() {
        Integer[] keys = new Integer[]{
                34545654,
                34545654
        };
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }

    @Test
    public void batchDelete4() {
        Integer[] keys = new Integer[]{-1, -5, 1000};
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }


    @Test
    public void batchDelete5() {
        Integer[] keys = KeysReader.getIntegersFromFile("test_files/correctness/integers/test2_batchDelete_withBigNumbers.txt");
        int res = hashTable.batchDelete(keys);
        assert(res == 4);
    }





    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }

}
