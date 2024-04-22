package utils.randomGenerators;

import java.io.FileWriter;
import java.io.IOException;

public class InputAndTestCodeGeneratorScript {

    static int[] sizes = {10, 100, 300, 500, 700, 1000};
    static int[] moreSizesForN = {10000, 100000, 1000000};
    static int[] orders = {1, 2, 3, 4, 5};
    static String[] types = {"N", "N2"};
    public static void main(String[] args) {

//        generateInput();
        generateTests();
    }
    public static void generateInput() {

        for (int size : sizes) {
            for (int order : orders) {
                RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/" + size + "s" + order + ".txt", size, -size * 10, size * 10);
            }
        }
        for(int size: moreSizesForN) {
            for (int order : orders) {
                RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/" + size + "s" + order + ".txt", size, -size * 10, size * 10);
            }
        }

    }

    public static void generateTests() {
        for (int size : sizes) {
            for (int order : orders) {
                for (String type : types) {
                    EfficiencyTestCodeGenerator.generateTest_Java(size, order, type);
                }
            }
        }

        for(int size: moreSizesForN) {
            for (int order : orders) {
                EfficiencyTestCodeGenerator.generateTest_Java(size, order, "N");
            }
        }
    }



}
