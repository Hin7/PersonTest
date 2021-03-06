/**
* Решение задачи по второму занятию школы Java-программистов
*
* @version 1.1 04.03.2020
* @author Hin7
 */




public class PersonTest {
    public static void main(String[] args) {
        //тест класса Person
        String[] ManNames = {"Михаил", "Петр", "Владислав", "Александр", "Виктор"};
        String[] WomenNames = {"Наталья", "Ульяна", "Антонина", "Анна", "Светлана"};

        Person[] people = new Person[10];
        for (int i = 0; i < people.length / 2; i++) {
            people[i * 2] = new Person(true, ManNames[i]);
            people[i * 2 + 1] = new Person(false, WomenNames[i]);
        }
        System.out.println("Исходный массив:");
        for (Person human : people)
            System.out.println(human);
        System.out.println();

        System.out.println("Женим половину на половину");
        for (int i = 0; i < people.length / 2; i++) {
            people[i * 2].marry(people[i * 2 + 1]);
        }

        for (Person human : people)
            System.out.println(human);
        System.out.println();

        System.out.println("Попытка женить случайным образом. Если успех, то свадьба.");
        for (int i = 0; i < 10; i++) {
            int m = (int) (10 * Math.random());
            int w = (int) (10 * Math.random());
            if (people[m].marry(people[w]))
                System.out.println("Свадьба " + people[m].getName() + " " + people[w].getName());
        }
        System.out.println();

        for (Person human : people)
            System.out.println(human);
        System.out.println();
    }
}
