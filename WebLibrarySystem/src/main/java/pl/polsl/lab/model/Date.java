/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.model;

import java.time.LocalDate;
import java.util.Vector;
import pl.polsl.lab.excepctions.WrongDateFormat;

/**
 * Class representing a date
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class Date
{

    /**
     * Day in the month
     */
    private int day;
    /**
     * Month's number
     */
    private int month;
    /**
     * Full year
     */
    private int year;

    /**
     * Constructor
     *
     * @param date textual date representation
     * @throws WrongDateFormat
     */
    public Date(String date) throws WrongDateFormat
    {
        checkDate(date);
        Vector<Integer> dateInfo = readDateFromString(date);
        day = dateInfo.get(0);
        month = dateInfo.get(1);
        year = dateInfo.get(2);
    }

    /**
     * Converts object's state to the text form
     *
     * @return textual representation of the object
     */
    public String toString()
    {
        String dayText, monthText;

        if (day < 10)
        {
            dayText = "0" + Integer.toString(day);
        } else
        {
            dayText = Integer.toString(day);
        }

        if (month < 10)
        {
            monthText = "0" + Integer.toString(month);
        } else
        {
            monthText = Integer.toString(month);
        }

        return (dayText + "-" + monthText + "-" + Integer.toString(year));
    }

    /**
     * Converts string date representation to three integer values
     *
     * @param date string date representation
     * @return table of integer values
     */
    private Vector<Integer> readDateFromString(String date)
    {
        Vector<Integer> dateTable = new Vector<Integer>();

        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 9));
        
        dateTable.add(day);
        dateTable.add(month);
        dateTable.add(year);

        return dateTable;
    }

    /**
     * Checks if date format is correct using class Validator method
     *
     * @param date textual date representation
     * @throws WrongDateFormat
     */
    public static void checkDate(String date) throws WrongDateFormat
    {
        if (!Validator.validateDate(date))
        {
            throw new WrongDateFormat();
        }
        
    }
    
    /**
     * Convert LocalDate to String.
     * 
     * @param date LocalDate to be converted
     * @return textual date
     */
    public static String getDateString(LocalDate date)
    {
        String day, month;
        String dateText = "";
        
        if(date.getDayOfMonth()<10)
        {
            dateText += "0";
        }
        
        dateText += String.valueOf(date.getDayOfMonth())+".";
        
        if(date.getMonthValue() <10)
        {
            dateText += "0";
        }
        dateText += String.valueOf(date.getMonthValue())+"."+ String.valueOf(date.getYear());
        
        return dateText;
        
    }

}
