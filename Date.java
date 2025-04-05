import java.util.Collections;
import java.util.ArrayList;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Проверка валидности даты
    public boolean isValidDate() {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int maxDay;
        switch (month) {
            case 4: case 6: case 9: case 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = isLeapYear(year) ? 29 : 28;
                break;
            default:
                maxDay = 31;
        }
        return day <= maxDay;
    }

    // Проверка високосного года
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Обновление даты
    public boolean updateDate(int day, int month, int year) {
        Date temp = new Date(day, month, year);
        if (temp.isValidDate()) {
            this.day = day;
            this.month = month;
            this.year = year;
            return true;
        }
        return false;
    }

    // Определение дня недели (алгоритм Зеллера)
    public String getDayOfWeek() {
        int q = day;
        int m = month < 3 ? month + 12 : month;
        int y = month < 3 ? year - 1 : year;

        int K = y % 100;
        int J = y / 100;
        int h = (q + 13 * (m + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;

        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }

    // Разница в днях между датами
    public int calculateDifference(Date other) {
        return Math.abs(this.toDays() - other.toDays());
    }

    // Преобразование даты в количество дней
    private int toDays() {
        int total = 0;
        for (int y = 1; y < year; y++) {
            total += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            total += getDaysInMonth(m, year);
        }
        return total + day;
    }

    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11: return 30;
            case 2: return isLeapYear(year) ? 29 : 28;
            default: return 31;
        }
    }

    // Вывод даты в формате "January 1, 2023"
    public void printDate() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.printf("%s %d, %d\n", months[month - 1], day, year);
    }

    // Реализация Comparable для сортировки
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }
}