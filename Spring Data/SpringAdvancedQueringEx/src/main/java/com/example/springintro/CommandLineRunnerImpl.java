package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
        //printAllBooksAfterYear(2000);
//          printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Select ex:");
        int exNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exNumber){
            case 1->ex1();
            case 2->ex2();
            case 3->ex3();
            case 4->ex4();
            case 5->ex5();
            case 6->ex6();
            case 7->ex7();
            case 8->ex8();
            case 9->ex9();
            case 10->ex10();
            case 11->ex11();
           case 12->ex12();
            case 13->ex13();
            case 14->ex14();

        }

    }

    private void ex14() throws IOException {
        System.out.println("The procedure code is in ex14() method");

//        CREATE PROCEDURE `get_amount_of_books_by_name` (IN first_name VARCHAR(100),IN last_name VARCHAR(100),OUT total INT)
//        BEGIN
//
//        SELECT COUNT(*)
//        INTO total
//        FROM books JOIN authors a on a.id = books.author_id
//        WHERE a.first_name = first_name AND a.last_name = last_name;
//        END
        System.out.println("Enter author name");
        String [] names = bufferedReader.readLine().split("\\s+");
        System.out.println(this.bookService.amountOfBooksByAuthorName(names[0], names[1]));
    }

    private void ex13() throws IOException {
        System.out.println("Enter number of copies");
        int numberOfCopies = Integer.parseInt(bufferedReader.readLine());
        System.out.println(this.bookService.removeBooksWithCopiesLowerThanGivenNumber(numberOfCopies));
    }

    private void ex12() throws IOException {
        System.out.println("Enter date in format");
        String date = bufferedReader.readLine().trim();
        LocalDate localDate  = LocalDate.parse(
                date ,
                new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern( "dd MMM yyyy" )
                        .toFormatter( Locale.US )
        );
        System.out.println("Enter copies");
        int copies = Integer.parseInt(bufferedReader.readLine());
        System.out.println(bookService.increaseCopiesByDate(localDate, copies));

    }

    private void ex11() throws IOException {
        System.out.println("Enter book's title");
        String title = bufferedReader.readLine().trim();
        System.out.println(bookService.getBookReducedInfo(title));
    }

    private void ex10() {
        authorService.findAllAuthorsAndTheirTotalCopies().forEach(System.out::println);
    }

    private void ex9() throws IOException {
        System.out.println("Enter title length");
        int length = Integer.parseInt(bufferedReader.readLine());

        int countOfBooksWithTitleLengthLongerThan = bookService.findCountOfBooksWithTitleLengthLongerThan(length);

        System.out.printf("There are %d books with longer title than 12 symbols",countOfBooksWithTitleLengthLongerThan);
    }

    private void ex8() throws IOException {
        System.out.println("Enter a fragment the last name of the author to start with");
        String str = bufferedReader.readLine();

        bookService.findAllTitlesWithAuthorWithLastNameStartingWith(str).forEach(System.out::println);
    }

    private void ex7() throws IOException {
        System.out.println("Enter a fragment that has to be contained in the title");
        String str = bufferedReader.readLine();

       bookService.findAllBookTitlesWhereTitleContainsStr(str).forEach(System.out::println);
    }

    private void ex6() throws IOException {
        System.out.println("Enter what the author name ends with");

        String endsWith = bufferedReader.readLine();

        authorService.findAuthorFirstNameEndsWith(endsWith).forEach(System.out::println);
    }

    private void ex5() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

bookService.findAllBooksBeforeDate(localDate).forEach(System.out::println);


    }

    private void ex4() throws IOException {
        System.out.println("Enter year:");

        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findNotReleasedBookTitlesInYear(year).forEach(System.out::println);
    }

    private void ex3() {
    bookService.findAllBookTitlesWithPriceLessThat5MoreThan40().forEach(System.out::println);

    }

    private void ex2() {
        bookService.findAllGoldBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void ex1() throws IOException {
        System.out.println("Enter age restriction:");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

                this.bookService.findAllBookTitlesWithAgeRestriction(ageRestriction).forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
