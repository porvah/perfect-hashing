package utils.randomGenerators;

import utils.KeysReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EfficiencyTestCodeGenerator {


    public static void generateTest_Java(int size, int order, String type, int[] params) {
        Integer[] keys1 = KeysReader.getIntegersFromFile("test_files/efficiency/"+size+"s"+order+".txt");
        Integer[] keys2 = KeysReader.getIntegersFromFile("test_files/efficiency/"+size+"s"+((order)%InputAndTestCodeGeneratorScript.numberOfTestsPerSize+1) + ".txt");

        Set<Integer> st1 = new HashSet<>(), st2 = new HashSet<>();
        for(Integer integer : keys1)st1.add(integer);
        for(Integer integer : keys2)st2.add(integer);


        int sol1 = 0;
        for(Integer key: st2) {
            if(st1.contains(key)) {
                sol1++;
            }
        }
        int sol2 = 0;
        for(Integer key: st2) {
            if(!st1.contains(key)) {
                sol2++;
            }
        }



        String toBeWritten = "package efficiency." + type + ";\n" +
                "\n" +
                "import hash_tables.HashTableWith" + type + "Space;\n" +
                "import org.junit.jupiter.api.AfterAll;\n" +
                "import org.junit.jupiter.api.AfterEach;\n" +
                "import org.junit.jupiter.api.BeforeEach;\n" +
                "import org.junit.jupiter.api.Test;\n" +
                "import utils.AnalysisLogger;\n" +
                "import utils.KeysReader;\n" +
                "\n" +
                "import java.util.Collections;\n" +
                "import java.util.HashSet;\n" +
                "import java.util.Set;\n" +
                "\n" +
                "public class Efficiency"+size+"s"+order+ "{\n" +
                "    HashTableWith"+type+"Space<Integer> hashTable = new HashTableWith"+type+"Space<>();\n" +
                "    Integer[] keys1 = KeysReader.getIntegersFromFile(\"test_files/efficiency/"+size+"s"+order+".txt"+"\");\n" +
                "    Integer[] keys2 = KeysReader.getIntegersFromFile(\"test_files/efficiency/"+size+"s"+((order)%InputAndTestCodeGeneratorScript.numberOfTestsPerSize+1)+".txt"+"\");\n" +
                "\n" + "\n" +
                "    private long time;\n" +
                "\n" +
                "    private final String type = \""+type +"\";\n" +
                "    private final int size = "+size+";\n" +
                "    private String currentOperation;\n" +
                "    @BeforeEach\n" +
                "    public void batchInsertAll() {\n" +
                "        hashTable.batchInsert(keys1);\n" +
                "        time = System.nanoTime();\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    @Test\n" +
                "    public void batchInsert() {\n" +
                "" + "\n" +
                "        currentOperation = \"batchInsert\";\n"+
                "        HashTableWith"+type+"Space<Integer> hashTable = new HashTableWith"+type+"Space<>();\n" +
                "        int res = hashTable.batchInsert(keys1);\n" +
                "\n" +
                "        assert(res == "+keys1.length+");\n" +
                "    }\n" +
                "\n";
        for(int i = 0; i < 4; i++) {
            toBeWritten += "    @Test\n" +
                    "    public void testSearch"+(i+1)+"() {\n" +
                    "        currentOperation = \"search\";\n"+
                    "        Integer key = "+params[i]+";\n" +
                    "        boolean res = hashTable.search(key);\n" +
                    "        assert ("+(st1.contains(params[i]) ? "res" : "!res")+");\n" +
                    "    }\n" +
                    "\n";
        }
        for(int i = 0; i < 4; i++) {
            toBeWritten += "    @Test\n" +
                    "    public void insert"+(i+1)+"() {\n" +
                    "        currentOperation = \"insert\";\n"+
                    "        int key = "+params[i]+";\n" +
                    "        boolean res = hashTable.insert(key);\n" +
                    "        assert ("+(st1.contains(params[i]) ? "!res" : "res")+");\n" +
                    "    }\n" +
                    "\n";

        }
        toBeWritten +=

                "    @Test\n" +
                "    public void batchInsert2() {\n" +
                        "       currentOperation = \"batchInsert\";\n"+
                "        int res = hashTable.batchInsert(keys2);\n" +
                "\n" +
                "        assert(res == "+sol2+");\n" +
                "    }\n" +
                "\n";
        for(int i = 0; i < 4; i++) {
            toBeWritten += "    @Test\n" +
                    "    public void delete"+(i+1)+"() {\n" +
                    "        currentOperation = \"delete\";\n"+
                    "        int key = "+params[i]+";\n" +
                    "        boolean res = hashTable.delete(key);\n" +
                    "        assert ("+(st1.contains(params[i]) ? "res" : "!res")+");\n" +
                    "    }\n" +
                    "\n";
        }

        toBeWritten +=
                "    @Test\n" +
                "    public void batchDeleteAll() {\n" +
                        "        currentOperation = \"batchDelete\";\n"+
                "        int res = hashTable.batchDelete(keys1);\n" +
                "\n" +
                "        assert(res == "+st1.size()+");\n" +
                "    }\n" +
                "\n" +
                "    @Test\n" +
                "    public void batchDelete2() {\n" +
                        "        currentOperation = \"batchDelete\";\n"+
                "        int res = hashTable.batchDelete(keys2);\n" +
                "\n" +
                "        assert(res == "+sol1+");\n" +
                "    }\n" +
                "\n";
        toBeWritten +=
                """
                            @AfterEach
                            public void printAnalysis() {
                                time = System.nanoTime() - time;
                                
                                AnalysisLogger.addAnalysis(currentOperation, size,  type, hashTable.getAllSpace(), time, hashTable.getHashCount());
                                AnalysisLogger.printAnalysis(hashTable);
                            }


                        }
                        """;
        try {
            FileWriter fileWriter = new FileWriter("unit_testing/efficiency/"+type+"/Efficiency"+size + "s"+order+".java");
            fileWriter.write(toBeWritten);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateTest_Java(int size, int order, String type) {
        int[] params = new int[4];
        Random random = new Random();
        for(int i = 0; i < 4; i++) {
            params[i] = -10*size +2*random.nextInt(10*size);
        }
        generateTest_Java(size, order, type, params);
    }
}
