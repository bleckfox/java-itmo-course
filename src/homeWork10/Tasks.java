package homeWork10;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Tasks {
    public static void main(String[] args) {

        // Задача 1
        System.out.println("Задача 1");

        // Устанавливаем временные зоны
        //ZoneId sydneyZone = ZoneId.of("Australia/Sydney");
        //ZoneId houstonZone = ZoneId.of("America/Chicago");
        //ZoneId washingtonZone = ZoneId.of("America/New_York");
        //ZoneId ottawaZone = ZoneId.of("America/Toronto");

        // Устанавливаем дату и время вылета из Сиднея
        LocalDateTime departureSydney = LocalDateTime.of(2023, 5, 16, 19, 0);

        // Вычисляем время прибытия в Хьюстон
        LocalDateTime arrivalHouston = departureSydney.plusHours(15).plusMinutes(35);
        //ZonedDateTime arrivalHoustonZone = ZonedDateTime.of(arrivalHouston, sydneyZone).withZoneSameInstant(houstonZone);
        ZonedDateTime arrivalHoustonZone = ZonedDateTime.of(arrivalHouston, ZoneId.of(TimeZone.SYDNEY.label)).withZoneSameInstant(ZoneId.of(TimeZone.HOUSTON.label));

        // Вычисляем время вылета из Хьюстона
        LocalDateTime departureHouston = arrivalHoustonZone.plusHours(1).toLocalDateTime();

        // Вычисляем время прибытия в Вашингтон
        LocalDateTime arrivalWashington = departureHouston.plusHours(2).plusMinutes(49);
        //ZonedDateTime arrivalWashingtonZone = ZonedDateTime.of(arrivalWashington, houstonZone).withZoneSameInstant(washingtonZone);
        ZonedDateTime arrivalWashingtonZone = ZonedDateTime.of(arrivalWashington, ZoneId.of(TimeZone.HOUSTON.label)).withZoneSameInstant(ZoneId.of(TimeZone.WASHINGTON.label));

        // Вычисляем время вылета из Вашингтона
        LocalDateTime departureWashington = arrivalWashingtonZone.plusHours(1).plusMinutes(10).toLocalDateTime();

        // Вычисляем время прибытия в Оттаву
        LocalDateTime arrivalOttawa = departureWashington.plusHours(1).plusMinutes(40);
        //ZonedDateTime arrivalOttawaZone = ZonedDateTime.of(arrivalOttawa, washingtonZone).withZoneSameInstant(ottawaZone);
        ZonedDateTime arrivalOttawaZone = ZonedDateTime.of(arrivalOttawa, ZoneId.of(TimeZone.WASHINGTON.label)).withZoneSameInstant(ZoneId.of(TimeZone.OTTAWA.label));

        // Выводим результаты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm");

        System.out.println("1. Время прибытия в аэропорт Оттавы: " + arrivalOttawaZone.format(formatter));
        System.out.println("2. Время вылета из аэропорта Хьюстона: " + departureHouston.format(formatter));
        System.out.println("3. Время вылета из аэропорта Вашингтона: " + departureWashington.format(formatter));


        // Задача 2 ----------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Задача 2");

        LocalTime currentTime = LocalTime.now();

        LocalTime firstShiftStart = LocalTime.of(7, 0);
        LocalTime secondShiftStart = LocalTime.of(15, 0);
        LocalTime thirdShiftStart = LocalTime.of(23, 0);

        if (currentTime.isAfter(firstShiftStart) && currentTime.isBefore(secondShiftStart)) {
            System.out.println("Сейчас первая смена");
        } else if (currentTime.isAfter(secondShiftStart) && currentTime.isBefore(thirdShiftStart)) {
            System.out.println("Сейчас вторая смена");
        } else {
            System.out.println("Сейчас третья смена");
        }


        // Задача 3 ----------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Задача 3");

        LocalDate today = LocalDate.now();
        LocalDate courseEndDate = LocalDate.of(2023, 6, 16);

        DayOfWeek[] scheduleDays = {
                DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY
        };

        int remainingLessons = 0;

        while (today.isBefore(courseEndDate)){
            for (DayOfWeek day : scheduleDays){
                if (today.getDayOfWeek() == day){
                    remainingLessons++;
                }
            }
            today = today.plusDays(1);
        }

        System.out.println("Осталось занятий: " + remainingLessons);
    }
}
