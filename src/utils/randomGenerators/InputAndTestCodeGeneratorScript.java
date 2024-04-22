package utils.randomGenerators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InputAndTestCodeGeneratorScript {

    static int[] sizes = {10, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    static int[] moreSizesForN = {5000, 10000, 50000, 100000};
    static int numberOfTestsPerSize = 10;
    static String[] types = {"N", "N2"};
    public static void main(String[] args) {

//        generateInput();
        generateTests();
    }
    public static void generateInput() {

        for (int size : sizes) {
            for (int order = 1; order <= numberOfTestsPerSize; order++) {
                RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/" + size + "s" + order + ".txt", size, -size * 10, size * 10);
            }
        }
        for(int size: moreSizesForN) {
            for (int order = 1; order <= numberOfTestsPerSize; order++) {
                RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/" + size + "s" + order + ".txt", size, -size * 10, size * 10);
            }
        }

    }

    public static void generateTests() {


        for (int size : sizes) {
            int[] params = new int[4];
            Random random = new Random();
            for(int i = 0; i < 4; i++) {
                params[i] = -10*size +2*random.nextInt(10*size);
            }
            for (int order = 1; order <= numberOfTestsPerSize; order++) {
                for (String type : types) {
                    EfficiencyTestCodeGenerator.generateTest_Java(size, order, type, params);
                }
            }
        }

        for(int size: moreSizesForN) {
            for (int order = 1; order <= numberOfTestsPerSize; order++) {
                EfficiencyTestCodeGenerator.generateTest_Java(size, order, "N");
            }
        }
    }



}
