package pl.polsl.librarysystemui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.librarysystemui.controller.FileManager;
import pl.polsl.librarysystemui.excepctions.NotSupportedFileFormat;
import pl.polsl.librarysystemui.model.Book;
import pl.polsl.librarysystemui.model.Library;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     * Scene for views
     */
    private static Scene scene;
    
    /**
     * Library representation
     */
    private static Library library;
    
    /**
     * FileManager representation
     */
    private static FileManager  fileManager = new FileManager("libraryresources.json");
    
    /**
     * Library getter
     * @return Library library object
     */
    public static Library getLibrary()
    {
        return library;
    }

    /**
     * Initializes scene
     */
    @Override
    public void start(Stage stage) throws IOException 
    {
        scene = new Scene(loadFXML("mainmenu"), 1200, 700);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Set root view
     */
    static void setRoot(String fxml) throws IOException 
    {
        if(fxml.equals("mainmenu"))
        {
            saveFile();
        }
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads .fxml files
     */
    private static Parent loadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main function
     */
    public static void main(String[] args) 
    {
            
        Library.resetLastID();
        ArrayList<Book> books = new ArrayList<>();

        //try to read data from file
        try
        {
            books = fileManager.readJsonFile();
        } catch (NotSupportedFileFormat e)
        {
            Logger.getLogger(FileManager.class.getName()).log(Level.INFO, null, e);   
        }

        library = new Library(books);

        launch();

    }
    
    /**
     * Save library data to the file.
     */
    private static void saveFile()
    {
        if(library!=null)
        {
        try
        {
            fileManager.saveJsonFile(library.getBooksList());
        } catch (NotSupportedFileFormat e)
        {
            Logger.getLogger(FileManager.class.getName()).log(Level.INFO, null, e);
        }
        }
    }

}