package N;

import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessString2 {

    private final HashTableWithNSpace<String> hashTable = new HashTableWithNSpace<>();
    private final String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test2_batchInsert_permuted.txt");

    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys);
    }
    @Test
    public void batchInsert() {
        HashTableWithNSpace<String> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys);
        assert(res == 10);
    }





    @Test
    public void testSearch1() {
        String key = "abc";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch2() {
        String key = "xyz";
        boolean res = hashTable.search(key);
        assert(!res);
    }
    @Test
    public void testSearch3() {
        String key = "cab";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch4() {
        String key = "abccab";
        boolean res = hashTable.search(key);
        assert(!res);
    }




    @Test
    public void insert1() {
        String key = "abc";
        assert(hashTable.insert(key));
    }
    @Test
    public void insert2() {
        String key = "Cat";
        assert(hashTable.insert(key));
    }
    @Test
    public void insert3() {
        String key = "Fast";
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert4() {
        String key = "Sat";
        assert(hashTable.insert(key));
    }


    @Test
    public void delete1() {
        String key = "abc";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        String key = "cab";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        String key = "xyz";
        boolean res = hashTable.delete(key);
        assert(!res);
    }
    @Test
    public void delete4() {
        String key = "acbacb";
        boolean res = hashTable.delete(key);
        assert(!res);
    }

    @Test void batchDelete1() {
        String[] keys = new String[] {"abc", "cab", "xyz", "acbacb"};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test void batchDelete2() {
        String[] keys = new String[] {"abc", "cab", "acb"};
        int res = hashTable.batchDelete(keys);
        assert(res == 3);
    }

    @Test void batchDelete3() {
        String[] keys = new String[] {"abc", "abc", "abc", "acb"};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test void batchDelete4() {
        String[] keys = new String[] {"aaa", "bbb", "ccc", "ddd"};
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }

    @Test void batchDelete5() {
        String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test2_batchDelete_permuted.txt");
        int res = hashTable.batchDelete(keys);
        assert(res == 10);
    }





    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }
}
