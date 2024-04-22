package utils.randomGenerators;

public class InputGenerationScript {
    public static void main(String[] args) {
        RandomInputGenerator.generateRandomIntegers("test_files/efficiency/1000s1", 1000, -10000, 10000);
        RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/1000s2", 1000, -10000, 10000);

        RandomInputGenerator.generateRandomIntegers("test_files/efficiency/10000s1", 10000, -100000, 100000);
        RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/10000s2", 10000, -100000, 100000);

        RandomInputGenerator.generateRandomIntegers("test_files/efficiency/100000s1", 100000, -1000000, 1000000);
        RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/100000s2", 100000, -1000000, 1000000);

        RandomInputGenerator.generateRandomIntegers("test_files/efficiency/1000000s1", 1000000, -10000000, 10000000);
        RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/1000000s2", 1000000, -10000000, 10000000);


//        RandomInputGenerator.generateRandomIntegers("test_files/efficiency/10000000s1", 10000000, -1000000000, 1000000000);
//        RandomInputGenerator.generateRandomIntegersUnique("test_files/efficiency/10000000s2", 10000000, -1000000000, 1000000000);
//

//        RandomInputGenerator.generateRandomIntegers("test_files/efficiency/100000000s1", 100000000, -1000000000, 1000000000);

    }
}
