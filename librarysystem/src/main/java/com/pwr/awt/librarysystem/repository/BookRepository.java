package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthors_FirstName(String firstName);

    List<Book> findByAuthors_LastName(String firstName);

    List<Book> findByCategories_Name(String firstName);

    List<Book> findByTitleAndAuthors_FirstName(String title,   String firstName);

    List<Book> findByTitleAndAuthors_LastName(  String title,   String lastName);

    List<Book> findByTitleAndCategories_Name(  String title,   String category);

    List<Book> findByAuthors_FirstNameAndAuthors_LastName(  String firstName,   String lastName);

    List<Book> findByAuthors_FirstNameAndCategories_Name(  String firstName,   String lastCategory);

    List<Book> findByAuthors_LastNameAndCategories_Name(  String firstName,   String category);

    List<Book> findByTitleAndAuthors_FirstNameAndAuthors_LastName(  String title,   String firstName,   String lastName);

    List<Book> findByTitleAndAuthors_FirstNameAndCategories_Name(  String title,   String firstName,   String category);

    List<Book> findByTitleAndAuthors_LastNameAndCategories_Name(  String title,   String lastName,   String category);

    List<Book> findByAuthors_FirstNameAndAuthors_LastNameAndCategories_Name(  String firstName,   String lastName,   String category);

    List<Book> findByTitleAndAuthors_FirstNameAndAuthors_LastNameAndCategories_Name(  String title,   String firstName,   String lastName,   String category);


    default List<Book> findByAuthors_FirstNameAndAuthors_LastNameAndCategories_NameAndTitle(  Optional<String> firstName,   Optional<String> lastName,  Optional<String> category,   Optional<String> title) {
        if (firstName.isEmpty()) {
            if (lastName.isEmpty()) {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findAll();
                    } else {
                        return findByTitle(title.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByCategories_Name(category.get());
                    } else {
                        return findByTitleAndCategories_Name(title.get(), category.get());
                    }
                }
            } else {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findByAuthors_LastName(lastName.get());
                    } else {
                        return findByTitleAndAuthors_LastName(title.get(), lastName.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByAuthors_LastNameAndCategories_Name(lastName.get(), category.get());
                    } else {
                        return findByTitleAndAuthors_LastNameAndCategories_Name(title.get(), lastName.get(), category.get());
                    }
                }
            }
        } else {
            if (lastName.isEmpty()) {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstName(firstName.get());
                    } else {
                        return findByTitleAndAuthors_FirstName(title.get(), firstName.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameAndCategories_Name(firstName.get(), category.get());
                    } else {
                        return findByTitleAndAuthors_FirstNameAndCategories_Name(title.get(), firstName.get(), category.get());
                    }
                }
            } else {
                if (category.isEmpty()) {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameAndAuthors_LastName(firstName.get(), lastName.get());
                    } else {
                        return findByTitleAndAuthors_FirstNameAndAuthors_LastName(title.get(), firstName.get(), lastName.get());
                    }
                } else {
                    if (title.isEmpty()) {
                        return findByAuthors_FirstNameAndAuthors_LastNameAndCategories_Name(firstName.get(), lastName.get(), category.get());
                    } else {
                        return findByTitleAndAuthors_FirstNameAndAuthors_LastNameAndCategories_Name(title.get(), firstName.get(), lastName.get(), category.get());
                    }
                }
            }
        }
    }
}
