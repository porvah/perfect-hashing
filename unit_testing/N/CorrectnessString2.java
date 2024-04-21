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
        System.out.println(res);
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





    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }
}
