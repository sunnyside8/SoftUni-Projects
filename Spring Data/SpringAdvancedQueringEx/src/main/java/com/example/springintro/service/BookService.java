package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldBookTitlesWithCopiesLessThan5000();

    List<String> findAllBookTitlesWithPriceLessThat5MoreThan40();

    List<String> findNotReleasedBookTitlesInYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBookTitlesWhereTitleContainsStr(String str);

    List<String> findAllTitlesWithAuthorWithLastNameStartingWith(String str);

    int findCountOfBooksWithTitleLengthLongerThan(int length);

    String getBookReducedInfo(String title);

    int increaseCopiesByDate(LocalDate localDate,int copies);

    int removeBooksWithCopiesLowerThanGivenNumber(int numberOfCopies);

    int amountOfBooksByAuthorName(String first_name,String last_name);
}
