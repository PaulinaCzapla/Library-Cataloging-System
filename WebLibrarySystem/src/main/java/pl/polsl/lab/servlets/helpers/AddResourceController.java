/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.lab.servlets.helpers;

import java.io.IOException;
import pl.polsl.lab.excepctions.WrongDateFormat;
import pl.polsl.lab.servlets.controller.Database;
import pl.polsl.lab.model.Book;
import pl.polsl.lab.model.Date;
import pl.polsl.lab.model.Validator;

/**
 * Controller class for AddResource view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class AddResourceController
{
    /**
     * Add new resource to Library.
     *
     * @throws IOException
     */
    public String addResource(String title, String author, String publisher, String date) throws IOException
    {
        var isAuthorValid = Validator.validateText(author);
        var isTitleValid = Validator.validateText(title);
        var isPublishingHouseValid = Validator.validateText(publisher);
        boolean isDateValid = false;
        boolean result = false;
        
        String message = "";
        
        try
        {
            Date.checkDate(date);
        }
        catch( WrongDateFormat e)
        {
           message += e.getMessage();
            isDateValid = false;
        }
        
        
       if(!isTitleValid)
        {
            message += "<br>Invalid title. ";
        }
       
        if(!isAuthorValid)
        {
            message += "<br>Invalid author's name. ";
        }
       
        if(!isPublishingHouseValid)
        {
            message += "<br>Invalid publishing house's name. ";
        }
        

        if (isAuthorValid && isTitleValid && isPublishingHouseValid && isDateValid)
        {
            Book newBook = new Book(title, author, publisher, date);
            
            var library = Database.getLibrary();
            
            if(library == null)
            {
                message += "\nDatabase is not loaded. ";
                result = false;
            }
            else
            {
                library.addNewBook(newBook);
                result = true;               
            }                
        }
        
        return message;
    }
}
