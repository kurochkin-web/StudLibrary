import Services.Book;
import Services.DataGenerator;
import Services.MyArrayList;
import Services.MyHashSet;

import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Book> result = DataGenerator.generateStudents().stream()
                .peek(System.out::println) // вывести каждого студента
                .flatMap(student -> student.getBooks().stream()) // все книги
                .sorted(Comparator.comparingInt(Book::getPages)) // по страницам
                .distinct() // только уникальные книги
                .filter(book -> book.getYear() > 2000) // после 2000
                .limit(3) // только 3
                .peek(book -> System.out.println("Книга: " + book))
                .map(book -> {
                    System.out.println("Год выпуска: " + book.getYear());
                    return book;
                })
                .findFirst(); // короткое замыкание — находим первую книгу

        // Работа с Optional
        System.out.println(result
                .map(book -> "Найденная книга: " + book.getYear())
                .orElse("Книга не найдена"));
    }
}