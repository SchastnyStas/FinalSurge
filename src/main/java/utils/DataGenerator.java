package utils;

import com.github.javafaker.Faker;

public class DataGenerator {

    public static String generateRandomName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateRandomSentence() {
        Faker faker = new Faker();
        return faker.lorem().sentence();
    }
}