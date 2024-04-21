package N;

import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessString2 {

    private final HashTableWithNSpace<String> hashTable = new HashTableWithNSpace<>();
    private final String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test2_batchInsert.txt");

    @BeforeEach
    public void batchInsertAll() {
        hashTable.batchInsert(keys);
    }
    @Test
    public void batchInsert() {
        HashTableWithNSpace<String> hashTable = new HashTableWithNSpace<>();
        int res = hashTable.batchInsert(keys);
        assert(res == 5);
    }





    @Test
    public void testSearch1() {
        String key = "#)R(FJ#";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch2() {
        String key = "#)R(FJ";
        boolean res = hashTable.search(key);
        assert(!res);
    }
    @Test
    public void testSearch3() {
        String key = "@@";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch4() {
        String key = "@";
        boolean res = hashTable.search(key);
        assert(!res);
    }




    @Test
    public void insert1() {
        String key = "@";
        assert(hashTable.insert(key));
    }
    @Test
    public void insert2() {
        String key = ")(";
        assert(hashTable.insert(key));
    }
    @Test
    public void insert3() {
        String key = "@@";
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert4() {
        String key = "094fr@)$@";
        assert(hashTable.insert(key));
    }


    @Test
    public void delete1() {
        String key = "@@";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        String key = "@@";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        String key = "#)R(FJ#";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete4() {
        String key = "#))(#%$";
        boolean res = hashTable.delete(key);
        assert(!res);
    }

    @Test void batchDelete1() {
        String[] keys = new String[] {"@@", "#)R(FJ#","@"};
        int res = hashTable.batchDelete(keys);
        assert(res == 2);
    }

    @Test void batchDelete2() {
        String[] keys = new String[]{
                "#)R(FJ#",
                "@@",
                "#R(NFC(@$F",
                ")(RF)R(#"
        };

        int res = hashTable.batchDelete(keys);
        assert(res == 4);
    }

    @Test void batchDelete3() {
        String[] keys = new String[] {"@@", "@@", "@@", "@@"};
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }

    @Test void batchDelete4() {
        String[] keys = new String[] {"@","@", "@", "@"};
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }

    @Test void batchDelete5() {
        String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test2_batchDelete.txt");
        int res = hashTable.batchDelete(keys);
        assert(res == 3);
    }





    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }
}
