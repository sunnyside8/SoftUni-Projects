package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal up);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findAllByTitleContains(String str);

    List<Book> findAllByAuthor_LastNameStartsWith(String startStr);

    @Query("SELECT count(b) from Book b Where length(b.title) >:param ")
    int countBooksWithTitleLengthMoreThan(int param);

    Book getBookByTitle(String title);

    @Procedure("change_book_price_by_id")
    void changeBookPriceById(Long book_id);

    @Modifying
    @Query("UPDATE Book b SET b.copies = b.copies + :copies WHERE b.releaseDate > :localDate")
    int updateCopiesByReleaseDate(int copies,LocalDate localDate);

    @Modifying
    int removeByCopiesLessThan(Integer copies);

    @Procedure("get_amount_of_books_by_name")
   int amountOfBooksByAuthorName(String first_name, String last_name);
}
