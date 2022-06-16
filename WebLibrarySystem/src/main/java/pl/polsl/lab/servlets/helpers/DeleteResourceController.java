/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.lab.servlets.helpers;

import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import pl.polsl.lab.servlets.controller.Database;
import pl.polsl.lab.model.Book;

/**
 * Controller class for DeleteResource view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class DeleteResourceController
{

    /**
     * Searches library resources and displays it.
     * @param id resource's id
     */
    public boolean delete(String id)
    {
        ArrayList<Book> list = new ArrayList<Book>();

        var library = Database.getLibrary();
        if (library == null)
        {
            return false;
        } 
        else
        {
            if (id != null && !id.equals("") && id.matches("[0-9]+"))
            {
                Book book = library.searchByID(Integer.parseInt(id));
                if (book != null)
                {
                    list.add(book);
                }
            }

            if (list.size() > 0)
            {
                for (int i = 0; i < list.size(); i++)
                {
                    var book = list.get(i);
                    try
                    {
                        deleteResource(book);
                    } catch (IOException e)
                    {
                        return false;
                    }
                }

                return true;
            } 
            else
            {
                return false;
            }
        }
    }

    /**
     * Deletes chosen resource
     *
     * @throws IOException
     */
    private void deleteResource(Book book) throws IOException
    {
        Database.getLibrary().deleteBook(book);
    }
}
