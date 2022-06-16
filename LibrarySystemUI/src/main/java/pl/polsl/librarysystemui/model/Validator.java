/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarysystemui.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clas that represents a validator. Mathods in this class are used for data
 * validation.
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class Validator
{

    /**
     * Validates a string by using a privided pattern
     *
     * @param pattern
     * @param text text to validate
     * @return result of validation as a boolean value
     */
    private static boolean validate(String pattern, String text)
    {
        return text.matches(pattern); 
    }

    /**
     * Validates a string.
     *
     * @param text text to validate
     * @return result of validation as a boolean value
     */
    public static boolean validateText(String text)
    {
        boolean result = false;
        
        if(text != null)
        {
            result = validate("[a-zA-Z -.,0-9]{3,50}", text);
        }
        
        return result;
    }

    /**
     * Validates a string date representation
     *
     * @param date text(date) to validate
     * @return result of validation as a boolean value
     */
    public static boolean validateDate(String date)
    {
        ArrayList<Integer> monthDays = new ArrayList();      
        Collections.addAll(monthDays, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
        
        boolean result = false;
        
        

        if(date!= null && date.length() == 10 )
        {
            if(date.substring(0, 2).matches("[1-9]+") && date.substring(3, 5).matches("[1-9]+"))
            if(date!="")
            {
                int day = Integer.parseInt(date.substring(0, 2));
                int month = Integer.parseInt(date.substring(3, 5));

                if (month > 0 && month < 13)
                {
                    if (day <= monthDays.get(month - 1) && day > 0)
                    {
                        result = validate("([0-9]{2}[-.]{1}[0-9]{2}[-.]{1}[1-2]{1}[0-9]{3})", date);
                    }
                }
            }
        }
        return result;
    }
}
