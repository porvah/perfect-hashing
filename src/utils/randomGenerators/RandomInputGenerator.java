package utils.randomGenerators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomInputGenerator {

    static public void generateRandomIntegers(String fileName, int count, int min, int max) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            Random random = new Random();
            for(int i = 0; i < count; i++) {
                int ranNum = min + random.nextInt(max - min + 1);
                fileWriter.write(ranNum + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void generateRandomIntegers(String fileName, int count, int max) {
        generateRandomIntegers(fileName, count, 0, max);
    }


    public static void generateRandomIntegersUnique(String fileName, int count, int min, int max) {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < count) {
            int ranNum = min + random.nextInt(max - min + 1);
            set.add(ranNum);
        }

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Integer integer : set) {
                fileWriter.write(integer + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateRandomIntegersUnique(String fileName, int count, int max) {
        generateRandomIntegersUnique(fileName, count, 0, max);
    }
}
