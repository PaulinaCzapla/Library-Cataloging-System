/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.lab.servlets.helpers;

import java.util.ArrayList;
import pl.polsl.lab.servlets.controller.Database;
import pl.polsl.lab.model.Book;
import pl.polsl.lab.model.Validator;

/**
 * Controller class for SearchResources view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class SearchResourcesController
{    
    /**
     * Searches library resources and displays it.
     * @param type to be searched
     * @param input book data
     */
    public ArrayList<Book> search(String type, String input) 
    {
        ArrayList<Book> list = new ArrayList<Book>();

        var library = Database.getLibrary();
        if (library == null)
        {
            return list;
        } else
        {
            if (type != null)
            {
                String text = input;

                if (text != null && !text.equals(""))
                {
                    if (type.equals("ID"))
                    {
                        if (Validator.isANumber(text))
                        {
                            Book book = library.searchByID(Integer.parseInt(text));
                            if (book != null)
                            {
                                list.add(book);
                            }
                        }
                    } else if (type.equals("Author"))
                    {
                        list = library.searchByAuthor(text);
                    } else if (type.equals("Title"))
                    {
                        list = library.searchByTitle(text);
                    }
                }
            }
            return list;
        }
    }
}
