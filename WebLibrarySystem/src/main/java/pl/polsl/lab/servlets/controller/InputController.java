/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.servlets.controller;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import pl.polsl.lab.excepctions.WrongDateFormat;
import pl.polsl.lab.model.Book;
import pl.polsl.lab.model.Library;
import pl.polsl.lab.model.Validator;

/** Class for getting input data from user or file
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class InputController 
{
    /**
     * Scanner object to get input from user
     */
    private final Scanner scanner;
    
    /**
     * Non-parameter constructor
     */
    public InputController()
    {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Get input from user
     * @return String object with entered data
     */
    public String enterData()
    {
        return scanner.nextLine();
        
    }
    /**
     * Read data from json file using gson
     * @param filePath a path to a file to be read
     * @return ArrayList<Book> list with read data
     */
    ArrayList<Book> readDataFromJsonFile(InputStream input) throws WrongDateFormat, IOException
    {        
        ArrayList<Book> list = null;
        try (JsonReader reader = new JsonReader(new InputStreamReader(input)))
        {
             Gson gson = new Gson();
             Book[] books = gson.fromJson(reader, Book[].class);
             
             list = new ArrayList<Book>(Arrays.asList(books));    
             
             Library.setLastID(Library.findLastID(list));
             reader.close();

        } catch (FileNotFoundException ex) 
        {
            System.err.println("File not found.");
            
            Logger.getLogger(InputController.class.getName()).log(Level.SEVERE, null, ex);
           // System.exit(0);
        }
            catch (IOException ex) 
        {
            Logger.getLogger(InputController.class.getName()).log(Level.SEVERE, null, ex);
           // System.exit(0);
        }
         return list;  
    }
    /**
     * Wait to for return input from user
     */
    public void waitForReturnInput()
    {
            String back;
            do
              {
                 back = enterData();  
              } while (!back.equals("b") && !back.equals("B"));
    }
    
    /**
     * Waits for input from user as long as he enter correct data (String)
     * @return text data from user
     */
    public String enterTextAndValidate()
    {
        String data;  
        boolean first = true;
        do
        {
            if(!first)
            {
                System.out.println("Wrong input.");
            }
            first = false;
            data = enterData();
        } while(!Validator.validateText(data));
        
        return data;
    }
    /**
     * Waits for input from user as long as he enter correct date (String)
     * @return text data representing date from user
     */
    public String enterDateAndValidate()
    {
        String data;
        boolean first = true;
        do
        {
            if(!first)
            {
                System.out.println("Wrong input.");
            }
            first = false;
            data = enterData();
        } while(!Validator.validateDate(data));
        return data;
    }
    
}