package tests;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.librarysystemui.excepctions.WrongDateFormat;
import pl.polsl.librarysystemui.model.Date;


/**
 * Test class that checks if public methods in Date class work correctly
 * @author Paulina Czapla
 * @version 1.0
 */
public class DateTest
{

    /**
     * A parametrized test that checks if checkDate() method works correctly for proper parameters
     * @param text textual date representation
     */
    @ParameterizedTest
    @ValueSource(strings = { "10.10.2000", "10-10-2000", "01.01.1879", "12.12.2020", "12-12-2020" }) 
    public void testCheckDate(String text)
    {
        try
        {
            Date.checkDate(text);
        }
        catch(WrongDateFormat e)
        {
            fail("Method throw an exepction while given correct date format");         
        }        
    }
    
    
    /**
     * A parametrized test that checks if checkDate() method works correctly for incorrect params
     * @param text incorrect textual date representation
     */
    @ParameterizedTest
    @ValueSource(strings = { "01.01.20" , "1.1.2000" , "Text" , "a", "", "01.", "1", "11.11.11", "32.12.2000", "01.13.2000" }) 
    public void testCheckWrongDate(String text)
    {
        try
        {
            Date.checkDate(text);
            fail("Method didn't throw an exepction while given incorrect date format");     
        }
        catch(WrongDateFormat e)
        {}   
    }
    
     /**
     * A test that checks if checkDate() method works correctly for null param
     */
    @Test
    public void testCheckDateWithNull()
    {
        try
        {
            Date.checkDate(null);
            fail("Method didn't throw an exepction while given incorrect date format");     
        }
        catch(WrongDateFormat e)
        {}   
    }
}
