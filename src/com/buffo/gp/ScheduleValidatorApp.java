package com.buffo.gp;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScheduleValidatorApp {

    public static void main(String[] args) {
        System.out.println("***** Welcome to the Schedule Validator *****");
        System.out.println("Close the application at any time by pressing Ctrl + C\n");

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime intervalStart = null;
        LocalTime intervalEnd = null;
        LocalTime dateTimeToValidate = null;

        while (intervalStart == null) {
            System.out.println("Enter a start date/time for your interval in the format HH:mm:ss (e.g. 13:30:00)");
            try {
                intervalStart = LocalTime.parse(scanner.next(), dateTimeFormatter);
            } catch (DateTimeParseException exception) {
                System.out.println("Incorrect format specified");
            }
        }

        while (intervalEnd == null) {
            System.out.println("Enter an end date/time for your interval in the format HH:mm:ss (e.g. 17:45:00)");
            try {
                intervalEnd = LocalTime.parse(scanner.next(), dateTimeFormatter);
            } catch (DateTimeParseException exception) {
                System.out.println("Incorrect format specified");
            }
        }

        while (dateTimeToValidate == null) {
            System.out.println("Enter the date/time you'd like to validate in the format HH:mm:ss (e.g. 17:45:00)");
            try {
                dateTimeToValidate = LocalTime.parse(scanner.next(), dateTimeFormatter);
            } catch (DateTimeParseException exception) {
                System.out.println("Incorrect format specified");
            }
        }

        boolean isDateTimeWithinInterval = dateTimeToValidate.compareTo(intervalStart) >= 0 && dateTimeToValidate.compareTo(intervalEnd) <= 0;
        System.out.println(isDateTimeWithinInterval ? "true" : "false");
    }
}
