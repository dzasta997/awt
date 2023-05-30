package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthors_FirstNameContainingIgnoreCase(String firstName);

    List<Book> findByAuthors_LastNameContainingIgnoreCase(String firstName);

    List<Book> findByCategories_NameIgnoreCase(String firstName);

    List<Book> findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCase(String title,   String firstName);

    List<Book> findByTitleContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCase(  String title,   String lastName);

    List<Book> findByTitleContainingIgnoreCaseAndCategories_NameIgnoreCase(  String title,   String category);

    List<Book> findByAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCase(  String firstName,   String lastName);

    List<Book> findByAuthors_FirstNameContainingIgnoreCaseAndCategories_NameIgnoreCase(  String firstName,   String lastCategory);

    List<Book> findByAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(  String firstName,   String category);

    List<Book> findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCase(  String title,   String firstName,   String lastName);

    List<Book> findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCaseAndCategories_NameIgnoreCase(  String title,   String firstName,   String category);

    List<Book> findByTitleContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(  String title,   String lastName,   String category);

    List<Book> findByAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(  String firstName,   String lastName,   String category);

    List<Book> findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(  String title,   String firstName,   String lastName,   String category);


    default List<Book> findByAuthors_FirstNameAndAuthors_LastNameAndCategories_NameAndTitle(  Optional<String> firstName,   Optional<String> lastName,  Optional<String> category,   Optional<String> title) {
        if (firstName.isEmpty()) {
            if (lastName.isEmpty()) {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findAll();
                    } else {
                        return findByTitleContainingIgnoreCase(title.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByCategories_NameIgnoreCase(category.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndCategories_NameIgnoreCase(title.get(), category.get());
                    }
                }
            } else {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findByAuthors_LastNameContainingIgnoreCase(lastName.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCase(title.get(), lastName.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(lastName.get(), category.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(title.get(), lastName.get(), category.get());
                    }
                }
            }
        } else {
            if (lastName.isEmpty()) {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameContainingIgnoreCase(firstName.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCase(title.get(), firstName.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameContainingIgnoreCaseAndCategories_NameIgnoreCase(firstName.get(), category.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCaseAndCategories_NameIgnoreCase(title.get(), firstName.get(), category.get());
                    }
                }
            } else {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCase(firstName.get(), lastName.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCase(title.get(), firstName.get(), lastName.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(firstName.get(), lastName.get(), category.get());
                    } else {
                        return findByTitleContainingIgnoreCaseAndAuthors_FirstNameContainingIgnoreCaseAndAuthors_LastNameContainingIgnoreCaseAndCategories_NameIgnoreCase(title.get(), firstName.get(), lastName.get(), category.get());
                    }
                }
            }
        }
    }
}
