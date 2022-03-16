package com.example.springdataintroex.service.impl;

import com.example.springdataintroex.model.entity.*;
import com.example.springdataintroex.repository.BookRepository;
import com.example.springdataintroex.service.AuthorService;
import com.example.springdataintroex.service.BookService;
import com.example.springdataintroex.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

   public static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";
    private final BookRepository bookRepository;
    private  final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorServiceImpl authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if(bookRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row->{
                    String [] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });

    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year,12,31));
    }

    @Override
    public List<String> findAllAuthorsBooksWithReleaseDateBefore(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year,1,1))
                .stream()
                .map(book -> String.format("%s %s",book.getAuthor().getFirstName()
                ,book.getAuthor().getLastName()))
                .distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName,String lastname) {
        return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName,lastname)
                .stream()
                .map(book -> String.format("%s %s %d",book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());


    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();
        System.out.println();
        return new Book(editionType,releaseDate,copies,price,ageRestriction,title,author,categories);

    }
}
