package pl.polsl.lab.servlets.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.lab.excepctions.NotSupportedFileFormat;
import pl.polsl.lab.model.Book;
import pl.polsl.lab.model.Library;


public class Database {

    /**
     * Library representation
     */
    private static Library library;
    
    /**
     * FileManager representation
     */
    private static FileManager fileManager = new FileManager();
    
    /**
     * Library getter
     * @return Library library object
     */
    public static Library getLibrary()
    {
        return library;
    }

    private static boolean updateLibrary(String fileName, InputStream stream)
    {    
        Library.resetLastID();
        ArrayList<Book> books = new ArrayList<>();

        //try to read data from file
        try
        {
            books = fileManager.readJsonFile(fileName, stream);
        } 
        catch (NotSupportedFileFormat e)
        {
            Logger.getLogger(FileManager.class.getName()).log(Level.INFO, null, e);
            return false;
        }
        catch (IOException e)
        {
            Logger.getLogger(FileManager.class.getName()).log(Level.INFO, null, e);
            return false;
        }
        
        library = new Library(books);
        return true;
    }
    
    /**
     * Save library data to the file.
     */
    public static boolean saveFile(OutputStream outputStream)
    {
        if(library!=null)
        {
            try
            {
                fileManager.saveJsonFile(library.getBooksList(), outputStream);
            } catch (NotSupportedFileFormat e)
            {
                Logger.getLogger(FileManager.class.getName()).log(Level.INFO, null, e);
                return false;
            }
            return true;
        }
        else{
            return false; 
        }       
    }

    public static boolean set(String fileName, InputStream stream)
    {
        return updateLibrary(fileName, stream);
    }
}