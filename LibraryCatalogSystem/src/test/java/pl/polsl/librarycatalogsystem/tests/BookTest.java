package pl.polsl.librarycatalogsystem.tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.librarycatalogsystem.exceptions.WrongDateFormat;
import pl.polsl.librarycatalogsystem.exceptions.WrongTextFormat;
import pl.polsl.librarycatalogsystem.model.Book;

/**
 * Test class that checks if public methods in Book class work correctly
 * @author Paulina Czapla
 * @version 1.0
 */
public class BookTest
{
    /**
     * Private field with Book object
     */
    private Book book;

    /**
     * Set up unit test
     */
    @BeforeEach
    public void setUp()
    {
        book = new Book(1,"Title", "Author", "Publishing House", "01.01.2000");
    }
    
    /**
     * A parametrized test that checks if setTitle() method works correctly with correct and incorrect parameters
     * @param text title to set
     * @param isCorrect information if exception should be thrown
     */
    @ParameterizedTest
    @CsvSource({"Title1, true", "Title2, true", "Long Title Long Title,true" , "@#$, false", "a, false", ", false"})
    public void testSetTitle(String text, boolean isCorrect)
    {
        try
        {
            book.setTitle(text);
            if(!isCorrect)
            {
                fail("Method didn't throw an exepction while given wrong text format");
            }
        }
        catch(WrongTextFormat e)
        {
            if(isCorrect)
            {
                fail("Method throw an exepction while given correct text format");
            }            
        }
    }
    
    /**
     * A test that checks if setTitle() method works correctly with null param
     */
    @Test
    public void testSetTitleWithNull()
    {
        try
        {
            book.setTitle(null);
            fail("Method didn't throw an exepction while given wrong text format");
            
        }
        catch(WrongTextFormat e)
        {}
    }
    
    
    /**
     * A test that checks if setAuthor() method works correctly with correct and incorrect parameters
     * @param text author to set
     * @param isCorrect information if exception should be thrown
     */
    @ParameterizedTest
    @CsvSource({"Author1, true", "Author2, true", "Long Author Long Author,true" , "@#$, false", "a, false",", false"})
    public void testSetAuthor(String text, boolean isCorrect)
    {
         try
        {
            book.setAuthor(text);
            if(!isCorrect)
            {
                fail("Method didn't throw an exepction while given wrong text format");
            }
        }
        catch(WrongTextFormat e)
        {
            if(isCorrect)
            {
                fail("Method throw an exepction while given correct text format");
            }            
        }       
    }
    
     /**
     * A test that checks if setAuthor() method works correctly with null
     */
    @Test
    public void testSetAuthorWithNull()
    {
         try
        {
            book.setAuthor(null);
            fail("Method didn't throw an exepction while given wrong text format");
        }
        catch(WrongTextFormat e){}       
    }
    
    /**
     * A parametrized test that checks if setPublishingHouse() method works correctly with correct and incorrect parameters
     * @param text publishing house to set
     * @param isCorrect information if exception should be thrown
     */
    @ParameterizedTest
    @CsvSource({"PublishingHouse1, true", "PublishingHouse2, true", "Long PublishingHouse abcdeg ,true" , "\\@\\#\\$, false", "a, false", ", false"})
    public void testSetPublishingHouse( String text, boolean isCorrect)
    {
        try
        {
            book.setPublishingHouse(text);
            if(!isCorrect)
            {
                fail("Method didn't throw an exepction while given wrong text format");
            }
        }
        catch(WrongTextFormat e)
        {
            if(isCorrect)
            {
                fail("Method throw an exepction while given correct text format");
            }            
        }        
    }
    
       /**
     * A test that checks if setPublishingHouse() method works correctly with null param
     */
    @Test
    @CsvSource({"PublishingHouse1, true", "PublishingHouse2, true", "Long PublishingHouse abcdeg ,true" , "\\@\\#\\$, false", "a, false", ", false"})
    public void testSetPublishingHouseWithNull()
    {
        try
        {
            book.setPublishingHouse(null);
            fail("Method didn't throw an exepction while given wrong text format");
        }
        catch(WrongTextFormat e) {}        
    } 
    
    /**
     * A parametrized test that checks if setReleaseDate() method works correctly with correct and incorrect parameters
     * @param text date in string to set
     * @param isCorrect information if exception should be thrown
     */
    @ParameterizedTest
    @CsvSource({"10.10.2000, true", "10-10-2000, true", "01.01.1987 ,true" , "1.1.2000, false", 
        "10.10.20, false", "@#$, false", "a, false", ", false", ".0.2000, false", "10.13.2000, false", "34.12.2000, false"})
    public void testSetReleaseDate(String text, boolean isCorrect)
    {
        try
        {
            book.setDate(text);
            if(!isCorrect)
            {
                fail("Method didn't throw an exepction while given wrong date format");
            }
        }
        catch(WrongDateFormat e)
        {
            if(isCorrect)
            {
                fail("Method throw an exepction while given correct date format");
            }            
        }        
    }
    
     /**
     * A test that checks if setReleaseDate() method works correctly with null
     */
    @Test
    public void testSetReleaseDateWIthNull()
    {
        try
        {
            book.setDate(null);
            fail("Method didn't throw an exepction while given wrong date format");
        }
        catch(WrongDateFormat e) {}        
    }
}
