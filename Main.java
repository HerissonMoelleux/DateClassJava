import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Создание валидных и невалидных дат
        Date dueDate = new Date(6, 4, 2025);  // Дата сдачи
        Date invalidDate = new Date(29, 2, 2025); // 2025 не високосный

        System.out.println("Дата сдачи (6/4/2025): " + dueDate.isValidDate());   // true
        System.out.println("Невалидная дата (29/2/2025): " + invalidDate.isValidDate()); // false

        // Обновление даты
        Date dateToUpdate = new Date(1, 1, 2025);
        System.out.println("Обновление на 28/2/2025: " + dateToUpdate.updateDate(28, 2, 2025)); // true
        System.out.println("Обновление на 31/4/2025: " + dateToUpdate.updateDate(31, 4, 2025)); // false

        // День недели для 6 апреля 2025
        System.out.println("День недели для 6/4/2025: " + dueDate.getDayOfWeek()); // Sunday

        // Разница между датами
        Date date1 = new Date(6, 4, 2025);
        Date date2 = new Date(1, 1, 2026);
        System.out.println("Разница между 6/4/2025 и 1/1/2026: " + date1.calculateDifference(date2) + " дней"); // 270 дней

        // Сортировка
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(15, 5, 2025));
        dates.add(dueDate);                // 6/4/2025
        dates.add(new Date(10, 3, 2025));
        Collections.sort(dates);

        System.out.println("\nОтсортированные даты:");
        for (Date d : dates) {
            d.printDate();
        }
    }
}