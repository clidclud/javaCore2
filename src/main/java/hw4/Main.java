package hw4;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public enum Holiday {
        NONE,
        NEW_YEAR,
        MARCH_8,
        FEB_23
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Томара Григорьевна", Customer.Gender.FEMALE);
        Employee employee1 = new Employee("Анастасия Александровна", Customer.Gender.FEMALE);
        Employee employee2 = new Employee("Елизавета Тихоновна", Customer.Gender.FEMALE);
        Employee employee3 = new Employee("Денис Станиславович", Customer.Gender.MALE);
        Employee employee4 = new Employee("Андрей Николаевич", Customer.Gender.MALE);
        Employee employee5 = new Employee("Антон Степанович", Customer.Gender.MALE);

        Employee[] employees = {employee, employee1, employee2, employee3, employee4, employee5};

        congratulateEmployees(employees);

    }

    public static void congratulateEmployees(Employee[] employees) {
        Holiday todayHoliday = getTodayHoliday();

        for (Employee employee : employees) {
            switch (todayHoliday) {
                case NEW_YEAR:
                    System.out.println("С Новым Годом, " + employee.getName() + "!");
                    break;
                case MARCH_8:
                    if (employee.getGender() == Customer.Gender.FEMALE) {
                        System.out.println("С 8 марта, " + employee.getName() + "!");
                    }
                    break;
                case FEB_23:
                    if (employee.getGender() == Customer.Gender.MALE) {
                        System.out.println("С 23 февраля, " + employee.getName() + "!");
                    }
                    break;
                default:
                    System.out.println("Нет праздника сегодня для " + employee.getName() + ".");
                    break;
            }
        }
    }

    public static Holiday getTodayHoliday() {
        LocalDate today = LocalDate.now();
        if (today.getMonth() == Month.JANUARY && today.getDayOfMonth() == 1) {
            return Holiday.NEW_YEAR;
        } else if (today.getMonth() == Month.MARCH && today.getDayOfMonth() == 8) {
            return Holiday.MARCH_8;
        } else if (today.getMonth() == Month.FEBRUARY && today.getDayOfMonth() == 23) {
            return Holiday.FEB_23;
        } else {
            return Holiday.NONE;
        }
    }
}
