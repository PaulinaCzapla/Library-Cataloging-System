package pl.polsl.librarycatalogsystem.tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.aggregator.*;
import pl.polsl.librarycatalogsystem.model.Book;
import pl.polsl.librarycatalogsystem.model.Library;
/**
 * Test class that checks if every public method in Library class is working correctly.
 * @author Paulina Czapla
 * @version 1.0
 */
public class LibraryTest
{
    /**
     * Private field with Library object to test.
     */
    private Library library;
    
    /**
     * Set up unit test
     */
    @BeforeEach
    public void setUp()
    {
        Library.resetLastID();
        ArrayList<Book> lib = new ArrayList();
        lib.add(new Book("Title1", "Author Name1", "PublishingHouse1", "21.03.2011"));
        lib.add(new Book("Title2", "Author Name2", "PublishingHouse2", "21.03.2011"));
        lib.add(new Book("Title3", "Author Name3", "PublishingHouse3", "21.03.2011"));
        
        library  = new Library(lib);
    }
    
    
    /**
     * Parametrized test method that checks if addNewBook() method works correctly
     * @param argumentsAccessor accessor for the arguments
     */
    @ParameterizedTest
    @CsvSource({"Title1, Author Name, PublishingHouse, 21.03.2011", 
        " Much Longer Title, Author Name Second, Publishing House 321, 01.01.1999", 
        "Title, Name and Surname, Publishing House, 29.02.2000"})
    public void testAddNewBook(ArgumentsAccessor argumentsAccessor)
    {
        Book book = new Book (argumentsAccessor.getString(0), argumentsAccessor.getString(1), argumentsAccessor.getString(2), argumentsAccessor.getString(3));
        library.addNewBook(book);
        ArrayList<Book> list = library.getBooksList();

        assertTrue(book.equals(list.get(list.size()-1)), "The book wasn't added to the list");
        
    }
    
    
    /**
     * Test method that checks if addNewBook() method works correctly for null param
     */
    @Test
    public void testAddNewNullBook()
    {
        int num = library.getBooksList().size();
        library.addNewBook(null);
        ArrayList<Book> list = library.getBooksList();
        int num2 = library.getBooksList().size();
        assertTrue(num == num2, "The null added to the list");
        
    }
    
    /**
     * Test method that checks if resetId() method works correctly.
     */
    @Test
    public void testResetId()
    {
        Library.resetLastID();
        
        assertTrue(Library.getLastID() == 0, "Last ID didn't reset. ");
    }
    
    
    /**
     * Parametrized test method that checks if findLastId() method works correctly by adding new Books to the library
     * and checking if "lastID" field chenged to the right value.
     * @param argumentsAccessor accessor for the arguments
     */
    @ParameterizedTest
    @CsvSource({"99,Title1, Author Name,  PublishingHouse, 21.03.2011", 
        "1000,Much Longer Title, Author Name Second, Publishing House 321, 01.01.1999", 
        "4, Title, Name and Surname, Publishing House, 29.02.2000"})
    public void testFindLastId(ArgumentsAccessor argumentsAccessor)
    {
        ArrayList<Book> list = library.getBooksList();
        list.add(new Book(5, "Title5", "Author Name5", "PublishingHouse5", "21.03.2011")); 
        list.add(new Book( argumentsAccessor.getInteger(0), argumentsAccessor.getString(1), argumentsAccessor.getString(2), argumentsAccessor.getString(3), argumentsAccessor.getString(4)));
        
        int lastID  = (5 > argumentsAccessor.getInteger(0) ? 5 : argumentsAccessor.getInteger(0));
        
        assertTrue(Library.findLastID(list) == lastID, "LastID is not calculated correctly.");
    }
    
    
    /**
     * Parametrized test method that checks if incrementLastID() method works correctly by calling the method
     * as many times as indicated by the parameter
     * @param loop how many times method should be called
     */
    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 11 }) 
    public void testIncrementLastID(int loop)
    {
        for(int i = 0; i<loop ; i++)
        {
            Library.incrementLastID();
        } 
        assertTrue(Library.getLastID() == (3 + loop), "LastID is not incremented. ");
    }
    
    /**
     * A test method that checks if getBooksListReadOnly() method works correctly by checking by checking for 
     * an exception when trying to modify the list returned by the method 
     */
    @Test
    public void testGetBooksListReadOnly()
    {
        List<Book> list = library.getBooksListReadOnly();
        
        try
        {
            list.add(new Book(5, "Title5", "Author Name5", "PublishingHouse5", "21.03.2011"));
            fail("An exception should be thrown when trying add new element to read-only list");
        }
        catch(UnsupportedOperationException e)
        {}
    }
    
    
    /**
     * A parametrized test method that checks if searchByID() method works correctly by searching IDs
     * given as a parameter both existing and non existing 
     * @param id to find
     * @param expected information if any book should be found
     */
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "10, false", "100, false"})
    public void testSearchByID(int id, boolean expected)
    {
        Book foundBook = library.searchByID(id);   
        assertTrue((foundBook==null? false : true) == expected, "The book not found by ID. ");
    }
    
    /**
     * A parametrized test method that checks if searchByAuthor() method works correctly by searching authors names
     * given as a parameter both existing and non existing 
     * @param name to find
     * @param expected information how many books should be found
     */
    @ParameterizedTest
    @CsvSource({"Author Name1, 1", "Author Name2, 1", "Author Name3, 1", "Qwerty abc, 0", 
        "Author Name4, 0", "Author Name, 3", "Author, 3", "Name, 3", "Abcdefg Name3, 0", ", 0"})
    public void testSearchByAuthor(String name, int expected)
    {
        ArrayList<Book> foundBooks = library.searchByAuthor(name);
        assertTrue(foundBooks.size() == expected, "Books not found by author. ");
    }
    
    
    /**
     * A parametrized test method that checks if searchByTitle() method works correctly by searching titles
     * given as a parameter both existing and non existing 
     * @param title to find
     * @param expected information how many books should be found
     */
    @ParameterizedTest
    @CsvSource({"Title1, 1", "Title2, 1", "Title3, 1", "Qwerty abc, 0", 
        "Title4, 0", "Title, 3", "Abcdefg Name3, 0"})
    public void testSearchByTitle(String title, int expected)
    {
        ArrayList<Book> foundBooks = library.searchByTitle(title);
        assertTrue(foundBooks.size() == expected, "Books not found by title. ");
    }
    
    /**
     * A parametrized test method that checks if deleteBook() method works correctly by deleting books
     * and checing if they are still in the list
     * @param index which book should be deleted
     */
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2 }) 
    public void testDeleteBook(int index)
    {
        ArrayList<Book> list = library.getBooksList();
        Book bookToDelete = list.get(index);
        int size = list.size();
        
        library.deleteBook(bookToDelete);
        
        boolean result = false;
        
        for(int i = 0; i<list.size() ; i++)
        {
            result = list.get(i).equals(bookToDelete); 
        }
        result = result && !(-- size == list.size());
        
        assertFalse(result, "The book wasn't deleted. ");
    }
    
    /**
     * A parametrized test method that checks if deleteBook() method works correctly by trying to delete 
     * non-existing books given as a parameters
     * @param index which book should be deleted
     */
    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 100, 1000 }) 
    public void testDeleteNonExistingBook(int index)
    {
        ArrayList<Book> list = library.getBooksList();
        Book bookToDelete = new Book(index, "Title5","Author Name5",  "PublishingHouse5", "21.03.2011");
        
        int size = list.size();
        
        library.deleteBook(bookToDelete);
               
        assertTrue(size == list.size(), "The book was deleted even though it doesn't exist. ");
    }
    
     /**
     * A parametrized test method that checks if deleteBook() method works correctly by trying to delete 
     */
    @Test
    public void testDeleteNullBook()
    {
        ArrayList<Book> list = library.getBooksList();
      
        int size = list.size();
        
        library.deleteBook(null);
               
        assertTrue(size == list.size(), "The book was deleted even though it's null. ");
    }
    
}
