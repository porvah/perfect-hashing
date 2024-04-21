package N;

import hash_tables.HashTableWithN2Space;
import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessString1 {

    private final HashTableWithNSpace<String> hashTable = new HashTableWithNSpace<>();
    private final String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test1_batchInsert.txt");

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
    public void batchInsert1() {
        int res = hashTable.batchInsert(keys);
        assert(res == 0);
    }




    @Test
    public void testSearch1() {
        String key = "Fast";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch2() {
        String key = "Cat";
        boolean res = hashTable.search(key);
        assert(!res);
    }
    @Test
    public void testSearch3() {
        String key = "Fun";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch4() {
        String key = "Alphabet";
        boolean res = hashTable.search(key);
        assert(!res);
    }





    @Test
    public void delete1() {
        String key = "Slow";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        String key = "Fast";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        String key = "Rat";
        boolean res = hashTable.delete(key);
        assert(!res);
    }
    @Test
    public void delete4() {
        String key = "Hat";
        boolean res = hashTable.delete(key);
        assert(!res);
    }




    @Test
    public void insert1() {
        String key = "Dog";
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
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys);
        assert(res == 10);
    }
    @Test
    public void batchDelete1() {
        String[] keys = new String[]{"Fast", "Cat", "Fun", "Alphabet"};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test
    public void batchDelete2() {
        String[] keys = new String[]{"Slow", "Fast", "Rat", "Hat"};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test
    public void batchDelete3() {
        String[] keys = new String[]{"Dog", "Fast", "Fast", "Sat"};
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }

    @Test
    public void batchDelete4() {
        String[] keys = new String[]{"Dog", "Dog", "Dog", "Dog"};
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }






    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }
}