package com.pwr.awt.librarysystem;

import com.pwr.awt.librarysystem.entity.*;
import com.pwr.awt.librarysystem.enumeration.RentalStatus;
import com.pwr.awt.librarysystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;
    private final RentalRepository rentalRepository;

    @Autowired
    public DataLoader(AuthorRepository authorRepository, CategoryRepository categoryRepository, BookRepository bookRepository, CopyRepository copyRepository, RentalRepository rentalRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
        this.rentalRepository = rentalRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Author jkRowling = new Author()
                .setFirstName("Joanne")
                .setLastName("Rowling")
                .setDescription("Harry Potter mom");
        Author gombrowicz = new Author()
                .setFirstName("Witold")
                .setLastName("Gombrowicz")
                .setDescription("Moder paradox, absurd and psychology polish writer");
        Author king = new Author()
                .setFirstName("Stephen")
                .setLastName("King");
        Author hlasko = new Author()
                .setFirstName("Marek")
                .setLastName("Hłasko");
        Author mrozek = new Author()
                .setFirstName("Sławomir")
                .setLastName("Mrożek");
        Author sienkiewicz = new Author()
                .setFirstName("Henryk")
                .setLastName("Sienkiewicz");
        Category fantasy = new Category()
                .setName("fantasy")
                .setDescription("Let's get into fantastic world");
        Category psychology = new Category()
                .setName("psychology")
                .setDescription("Psychology books");
        Category adventure = new Category()
                .setName("adventure")
                .setDescription("Here you can find adventures of a a lifetime");
        Category history = new Category()
                .setName("history");
        Book harryPotterCoS = new Book()
                .addAuthor(jkRowling)
                .addCategory(fantasy)
                .setTitle("Harry Potter and the chamber of secrets")
                .setDescription("One of the coolest book ever");
        Book harryPotterPS = new Book()
                .addAuthor(jkRowling)
                .addCategory(fantasy)
                .setTitle("Harry Potter and the Philosopher Stone")
                .setDescription("First part of cool saga");
        Book harryPotterPA = new Book()
                .addAuthor(jkRowling)
                .addCategory(fantasy)
                .setTitle("Harry Potter and the Prisoner of Azkaban")
                .setDescription("Third part of the coolest saga");
        Book harryPotterOP = new Book()
                .addAuthor(jkRowling)
                .addCategory(fantasy)
                .setTitle("Harry Potter and the Order of Phoenix")
                .setDescription("Fourth part of cool saga");
        Book harryPotterHB = new Book()
                .addAuthor(jkRowling)
                .addCategory(fantasy)
                .setTitle("Harry Potter and the Half Blood Prince")
                .setDescription("Fifth part of cool saga");
        Book tango = new Book()
                .addAuthor(mrozek)
                .addCategory(fantasy)
                .setTitle("Tango")
                .setDescription("Polish cool drama");
        Book naczworaka = new Book()
                .addAuthor(mrozek)
                .addCategory(fantasy)
                .setTitle("Na czworaka");
        Book ostatnidoraju = new Book()
                .addAuthor(hlasko)
                .addCategory(adventure)
                .setTitle("Ostatni do raju");
        Book pieknidwudziestoletni = new Book()
                .addAuthor(hlasko)
                .addCategory(adventure)
                .setTitle("Piękni dwudziestolenti");

        Book potop= new Book()
                .addAuthor(sienkiewicz)
                .addCategory(history)
                .setTitle("Potop");

        Book krzyzacy= new Book()
                .addAuthor(sienkiewicz)
                .addCategory(history)
                .setTitle("Krzyżacy");

        Book ferdydurke = new Book()
                .addAuthor(gombrowicz)
                .addCategory(fantasy)
                .setTitle("Ferdydurke")
                .setDescription("Cult polish novel");
        Copy hpcos = new Copy()
                .setBook(harryPotterCoS)
                .setPublicationYear(LocalDate.of(2019, 1, 1))
                .setRented(true)
                .setIsbn("978-3-16-148410-0");
        Copy hpcos1 = new Copy()
                .setBook(harryPotterCoS)
                .setPublicationYear(LocalDate.of(2019, 1, 1))
                .setRented(true)
                .setIsbn("978-3-16-148410-0");
        Copy hpcos2 = new Copy()
                .setBook(harryPotterCoS)
                .setPublicationYear(LocalDate.of(2019, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148410-0");
        Copy hpcps = new Copy()
                .setBook(harryPotterPS)
                .setPublicationYear(LocalDate.of(2011, 1, 1))
                .setRented(true)
                .setIsbn("978-3-16-148410-7");
        Copy hpcpa = new Copy()
                .setBook(harryPotterPA)
                .setPublicationYear(LocalDate.of(2005, 1, 1))
                .setRented(true)
                .setIsbn("978-3-16-148410-6");
        Copy hpcpa2 = new Copy()
                .setBook(harryPotterPA)
                .setPublicationYear(LocalDate.of(2015, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");
        Copy hpcpa3 = new Copy()
                .setBook(harryPotterPA)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");
        Copy tango_copy = new Copy()
                .setBook(tango)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");

        Copy czwor_copy = new Copy()
                .setBook(naczworaka)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");

        Copy ost_copy = new Copy()
                .setBook(ostatnidoraju)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");

        Copy piekni_cpoy = new Copy()
                .setBook(pieknidwudziestoletni)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");

        Copy potop_copy = new Copy()
                .setBook(potop)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");

        Copy krzyz_copy = new Copy()
                .setBook(krzyzacy)
                .setPublicationYear(LocalDate.of(2016, 1, 1))
                .setRented(false)
                .setIsbn("978-3-16-148414-9");

        Rental r1 = new Rental()
                .setLibraryUser(new LibraryUser().setUserId(1L))
                .setCopy(new Copy().setCopyId(3L))
                .setRentalDate(LocalDate.now().minusDays(60))
                .setDueDate(LocalDate.now().minusDays(30))
                .setReturnDate(LocalDate.now().minusDays(40))
                .setStatus(RentalStatus.RETURNED);

        Rental r2 = new Rental()
                .setLibraryUser(new LibraryUser().setUserId(1L))
                .setCopy(new Copy().setCopyId(4L))
                .setRentalDate(LocalDate.now().minusDays(40))
                .setDueDate(LocalDate.now().minusDays(10))
                .setStatus(RentalStatus.PENALTY);
        Rental r3 = new Rental()
                .setLibraryUser(new LibraryUser().setUserId(1L))
                .setCopy(new Copy().setCopyId(5L))
                .setRentalDate(LocalDate.now().minusDays(20))
                .setDueDate(LocalDate.now().plusDays(10))
                .setStatus(RentalStatus.RENTED);
        Rental r4 = new Rental()
                .setLibraryUser(new LibraryUser().setUserId(1L))
                .setCopy(new Copy().setCopyId(1L))
                .setRentalDate(LocalDate.now())
                .setDueDate(LocalDate.now().plusDays(30))
                .setStatus(RentalStatus.RESERVED);
        Rental r5 = new Rental()
                .setLibraryUser(new LibraryUser().setUserId(2L))
                .setCopy(new Copy().setCopyId(2L))
                .setRentalDate(LocalDate.now())
                .setDueDate(LocalDate.now().plusDays(30))
                .setStatus(RentalStatus.RESERVED);



        authorRepository.save(jkRowling);
        authorRepository.save(gombrowicz);
        authorRepository.save(mrozek);
        authorRepository.save(hlasko);
        authorRepository.save(king);
        authorRepository.save(sienkiewicz);
        categoryRepository.save(fantasy);
        categoryRepository.save(adventure);
        categoryRepository.save(psychology);
        categoryRepository.save(history);
        bookRepository.save(harryPotterOP);
        bookRepository.save(harryPotterCoS);
        bookRepository.save(harryPotterHB);
        bookRepository.save(harryPotterPA);
        bookRepository.save(harryPotterPS);
        bookRepository.save(ferdydurke);
        bookRepository.save(tango);
        bookRepository.save(naczworaka);
        bookRepository.save(potop);
        bookRepository.save(krzyzacy);
        bookRepository.save(ostatnidoraju);
        bookRepository.save(pieknidwudziestoletni);
        copyRepository.save(hpcos);
        copyRepository.save(hpcos1);
        copyRepository.save(hpcos2);
        copyRepository.save(hpcps);
        copyRepository.save(hpcpa);
        copyRepository.save(hpcpa2);
        copyRepository.save(hpcpa3);
        copyRepository.save(potop_copy);
        copyRepository.save(krzyz_copy);
        copyRepository.save(ost_copy);
        copyRepository.save(piekni_cpoy);
        copyRepository.save(czwor_copy);
        copyRepository.save(tango_copy);
        copyRepository.save(copyRepository.findById(1L).get().setRented(true));
        copyRepository.save(copyRepository.findById(2L).get().setRented(true));
        copyRepository.save(copyRepository.findById(4L).get().setRented(true));
        copyRepository.save(copyRepository.findById(5L).get().setRented(true));
        rentalRepository.save(r1);
        rentalRepository.save(r2);
        rentalRepository.save(r3);
        rentalRepository.save(r4);
        rentalRepository.save(r5);



    }
}
