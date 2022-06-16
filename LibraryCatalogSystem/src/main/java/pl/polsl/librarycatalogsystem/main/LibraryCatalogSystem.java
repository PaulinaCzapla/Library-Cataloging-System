/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl.polsl.librarycatalogsystem.main;

import pl.polsl.librarycatalogsystem.controller.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.polsl.librarycatalogsystem.controller.ArgumentsParser;
import pl.polsl.librarycatalogsystem.controller.UIController;
import pl.polsl.librarycatalogsystem.exceptions.ArgsWrongInput;
import pl.polsl.librarycatalogsystem.exceptions.NotSupportedFileFormat;
import pl.polsl.librarycatalogsystem.model.Book;
import pl.polsl.librarycatalogsystem.model.Library;

/**
 * Main class of the cataloging library resources system.
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class LibraryCatalogSystem extends Application 
{
        private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("calculation"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryCatalogSystem.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main method of program. To execute the program user have to enter two
     * arguments, where: first one is a "-fp" switch and second one is a patch
     * to the json file for example: -fp filepath.json
     *
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        launch();
        ArgumentsParser argsParser = new ArgumentsParser(args);

        // Try to parse "args" agruments
        try
        {
            argsParser.parse();
        } catch (ArgsWrongInput argsException)
        {
            Logger.getLogger(ArgumentsParser.class.getName()).log(Level.INFO, null, argsException);
            
            String[] arguments = {"-fp", "libraryresources.json"};
            argsParser = new ArgumentsParser(arguments);
            argsParser.parse();
        }

        FileManager fileManager = new FileManager(argsParser.getFilePath());

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

        Library library = new Library(books);

        UIController menuController = new UIController(library);
        menuController.controlMainMenu();

        //try write data to file
        try
        {
            fileManager.saveJsonFile(books);;
        } catch (NotSupportedFileFormat e)
        {
            Logger.getLogger(FileManager.class.getName()).log(Level.INFO, null, e);
            System.exit(0);
        }
    }

}
