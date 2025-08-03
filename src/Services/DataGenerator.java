package Services;

import java.util.List;
import java.util.Arrays;

public class DataGenerator {
    public static List<Student> generateStudents() {
        return List.of(
                new Student("Аня", List.of(
                        new Book("Книга A1", 120, 2001),
                        new Book("Книга A2", 200, 1998),
                        new Book("Книга A3", 180, 2005),
                        new Book("Книга A4", 150, 2010),
                        new Book("Книга A5", 90, 1995)
                )),
                new Student("Борис", List.of(
                        new Book("Книга B1", 120, 2001),
                        new Book("Книга B2", 250, 2015),
                        new Book("Книга A3", 180, 2005), // повтор
                        new Book("Книга B4", 300, 2020),
                        new Book("Книга B5", 100, 2018)
                ))
        );
    }
}
