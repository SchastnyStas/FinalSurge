package utils;

import com.github.javafaker.Faker;

public class DataGenerator {
    public static String generateRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generateRandomPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }
}