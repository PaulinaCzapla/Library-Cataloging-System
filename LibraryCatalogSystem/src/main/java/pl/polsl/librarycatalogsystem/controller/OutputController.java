/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.controller;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.librarycatalogsystem.model.Book;

/**
 * Class to output information.
 *
 * @author PaulinaCzapla
 * @version 1.0
 */
public class OutputController
{

    /**
     * Displays list on the screen
     *
     * @param list ArrayList to be displayed
     */
    public void displayList(List<Book> list)
    {
        if (list != null)
        {
            for (Book book : list)
            {
                System.out.println(book);
            }
        }
    }

    /**
     * Saves data to the .json file
     *
     * @param list list to be written
     * @param filePath path to the file
     */
    void saveJsonFile(ArrayList<Book> list, String filePath)
    {
        FileWriter writer;
        try
        {
            writer = new FileWriter(filePath);
            Gson gson = new Gson();
            gson.toJson(list.toArray(), writer);

            writer.flush();
            writer.close();
        } catch (IOException e)
        {
            System.err.println("File opening error.");
            Logger.getLogger(OutputController.class.getName()).log(Level.SEVERE, null, e);
            System.exit(0);
        }
    }

    /**
     * Displays information about arguments and switches
     */
    public static void ArgumentsInformation()
    {
        System.out.println("To execute the program you have to enter path to the file with library resources using -fp switch. \n"
                + "example: \n-fp filepath.json");
    }
}
