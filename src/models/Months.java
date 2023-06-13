package models;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Months {



    Январь(1),
    Февраль(2),
    Март(3),
    Апрель(4),
    Май(5),
    Июнь(6),
    Июль(7),
    Август(8),
    Сентябрь(9),
    Октябрь(10),
    Ноябрь(11),
    Декабрь(12);
    private final int number;

    Months(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    private static final Map<Integer, String> MONTH_BY_NUMBER = Arrays.stream(values()).collect(
            Collectors.toMap(Months::getNumber, Months::name)
    );

    public static String getMonthName(int number) {
        return MONTH_BY_NUMBER.get(number);
    }
}
