package com.buffo.gp;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScheduleValidatorApp {

    private static final String INTERVAL_START_PROMPT =
            "Enter a start date/time for your interval in the format HH:mm:ss (e.g. 13:30:00)";
    private static final String INTERVAL_END_PROMPT =
            "Enter an end date/time for your interval in the format HH:mm:ss (e.g. 17:45:00)";
    private static final String TIME_TO_VALIDATE_PROMPT =
            "Enter the date/time you'd like to validate in the format HH:mm:ss (e.g. 16:30:00)";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("***** Welcome to the Schedule Validator *****");
        System.out.println("Close the application at any time by pressing Ctrl + C\n");

        Scanner scanner = new Scanner(System.in);

        LocalTime intervalStart = getLocalTime(scanner, INTERVAL_START_PROMPT);
        LocalTime intervalEnd = getLocalTime(scanner, INTERVAL_END_PROMPT);
        LocalTime timeToValidate = getLocalTime(scanner, TIME_TO_VALIDATE_PROMPT);

        boolean isTimeWithinInterval = isTimeWithinInterval(intervalStart, intervalEnd, timeToValidate);

        System.out.println(getOutputMessage(isTimeWithinInterval));
    }

    private static LocalTime getLocalTime(
            Scanner scanner,
            String prompt
    ) {
        LocalTime time = null;

        while (time == null) {
            System.out.println(prompt);
            try {
                time = LocalTime.parse(scanner.next(), DATE_TIME_FORMATTER);
            } catch (DateTimeParseException exception) {
                System.out.println("Incorrect format specified");
            }
        }

        return time;
    }

    private static boolean isTimeWithinInterval(
            LocalTime intervalStart,
            LocalTime intervalEnd,
            LocalTime timeToValidate
    ) {
        return timeToValidate.compareTo(intervalStart) >= 0 && timeToValidate.compareTo(intervalEnd) <= 0;
    }

    private static String getOutputMessage(boolean isTimeWithinInterval) {
        return isTimeWithinInterval ? "Time is within the specified interval" : "Time is not within the specified interval";
    }
}
