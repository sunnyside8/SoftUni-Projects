package com.example.springdataintroex;

import com.example.springdataintroex.model.entity.Book;
import com.example.springdataintroex.service.AuthorService;
import com.example.springdataintroex.service.BookService;
import com.example.springdataintroex.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        boolean firstRun = true;
        boolean end = false;
        while (true) {
            if (firstRun) {
                seedData();
                firstRun = false;
                System.out.println("The database was created based on the files from the .zip");
            }
            System.out.println("Select ex number ot type \"End\" to exit:");
            try {
                int exNumber = Integer.parseInt(bufferedReader.readLine());
                switch (exNumber) {
                    case 1 -> printAllBooksAfterYear(2000);
                    case 2 -> authorsOfBooksWithReleaseDateBeforeYear(1990);
                    case 3 -> printAllAuthorsAndNumberOfTheirBooks();
                    case 4 -> printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
                    default -> end = true;
                }
            } catch (IOException e) {
                System.out.println("Invalid task number");
            }
            if(end){
                return;
            }
        }

    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void authorsOfBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsBooksWithReleaseDateBefore(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle).forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
