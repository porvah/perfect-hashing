package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringsReader {
    public static String[] getStringsFromFile(String fileName) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings.toArray(new String[0]);
    }
}
