package correctness.N;

import hash_tables.HashTableWithNSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnalysisLogger;
import utils.KeysReader;

public class CorrectnessString3 {

    private final HashTableWithNSpace<String> hashTable = new HashTableWithNSpace<>();
    private final String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test3_batchInsert_multipleWords.txt");

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
        String key = "Vex joy orb";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch2() {
        String key = "Vex joy orj";
        boolean res = hashTable.search(key);
        assert(!res);
    }
    @Test
    public void testSearch3() {
        String key = "Zap fib zen mix";
        boolean res = hashTable.search(key);
        assert(res);
    }
    @Test
    public void testSearch4() {
        String key = "Zap";
        boolean res = hashTable.search(key);
        assert(!res);
    }





    @Test
    public void delete1() {
        String key = "Cog sun elf";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete2() {
        String key = "Zip dew fox";
        boolean res = hashTable.delete(key);
        assert(res);
    }
    @Test
    public void delete3() {
        String key = "Vow pin dif";
        boolean res = hashTable.delete(key);
        assert(!res);
    }
    @Test
    public void delete4() {
        String key = "Vow pin";
        boolean res = hashTable.delete(key);
        assert(!res);
    }




    @Test
    public void insert1() {
        String key = "Zap";
        assert(hashTable.insert(key));
    }
    @Test
    public void insert2() {
        String key = "Vow pin dig";
        assert(!hashTable.insert(key));
    }
    @Test
    public void insert3() {
        String key = "Vow pin dig ";
        assert(hashTable.insert(key));
    }
    @Test
    public void insert4() {
        String key = "Vow pin digg";
        assert(hashTable.insert(key));
    }





    @Test
    public void batchDeleteAll() {
        int res = hashTable.batchDelete(keys);
        assert(res == 10);
    }
    @Test
    public void batchDelete1() {
        String[] keys = new String[]{
                "Wok joy elf",
                "Zap fib zen mix",
                "Vex joy orb",
                "Jab cop fix",
                "Vow pin dig"
        };

        int res = hashTable.batchDelete(keys);
        assert(res == 5);
    }

    @Test
    public void batchDelete2() {
        String[] keys = new String[]{"Wok joy elf",
                "Wok joy elf",
                "Vex joy orb ",
                "Jab cop fi",
                "Vow pin dg"
        };
        int res = hashTable.batchDelete(keys);
        assert(res == 1);
    }

    @Test
    public void batchDelete3() {
        String[] keys = new String[]{
                "Not in the table",
                "Not in the table",
                "Not in the table"
        };
        int res = hashTable.batchDelete(keys);
        assert(res == 0);
    }

    @Test
    public void batchDelete4() {
        String[] keys = KeysReader.getStringsFromFile("test_files/correctness/strings/test3_batchDelete_multipleWords.txt");
        int res = hashTable.batchDelete(keys);
        assert(res == 9);
    }






    @AfterEach
    public void printAnalysis() {
        AnalysisLogger.printAnalysis(hashTable);
    }
}