package tests;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.librarysystemui.model.Validator;
/**
 * Test class that checks if public methods in Book class work correctly
 * @author Paulina Czapla
 * @version 1.0
 */
public class ValidatorTest
{
    
     /**
     * A parametrized test that checks if validateText() method works correctly
     * @param text text to validate
     * @param expected value that method should return
     */
    @ParameterizedTest
    @CsvSource({"Abc abcdefg, true", "Text2 with Nums567 8, true", "Text.- , true", "TextSpecial@#$ ,false" , "a, false", ", false"})
    public void testValidateText(String text, boolean expected)
    {
        assertTrue(Validator.validateText(text) == expected, " Validator doesn't work correctly for text data ");
    }
    
    
     /**
     * A  test that checks if validateText() method works correctly for null param
     */
    @Test
    public void testValidateNullText()
    {
        assertTrue(Validator.validateText(null) == false, " Validator doesn't work correctly for null text data ");
    }
    
    /**
     * A parametrized test that checks if validateDate() method works correctly
     * @param text text to validate
     * @param expected value that method should return
     */
    @ParameterizedTest
    @CsvSource({"10.10.2000, true", "10-10-2000, true", "01.01.1879, true", "01.01.20,false" , "1.1.2000,false" , "Text,false" , "a, false", ", false"})
    public void testValidateDate(String text, boolean expected)
    {
       assertTrue(Validator.validateDate(text) == expected, " Validator doesn't work correctly for date ");
    }
    
      /**
     * A test that checks if validateDate() method works correctly for null data
     */
    @Test
    public void testValidateNullDate()
    {
       assertTrue(Validator.validateDate(null) == false, " Validator doesn't work correctly for date ");
    }
}
