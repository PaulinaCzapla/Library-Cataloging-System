/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.librarysystemui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.polsl.librarysystemui.model.Book;

/**
 * FXML Controller class for DisplayAllResources view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class DisplayAllResourcesController implements Initializable
{
     /**
     * TableView with books list.
     */
    @FXML
    private TableView<Book> table;

    /**
     * Table column for release date
     */
    @FXML
    private TableColumn<Book, String> releaseDateText;

    /**
     * Table column for author
     */
    @FXML
    private TableColumn<Book,String> author;

    /**
     * Table column for publishing house
     */
    @FXML
    private TableColumn<Book, String> publishingHouse;

    /**
     * Table column for id
     */
    @FXML
    private TableColumn<Book, Integer> id;

    /**
     * Table column for title
     */
    @FXML
    private TableColumn<Book, String> title;

    /**
     * List for search results
     */
    private ObservableList<Book> list;
    
    /**
     * Initializes the controller class.
     * @param  url
     * @param  rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        publishingHouse.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        releaseDateText.setCellValueFactory(new PropertyValueFactory<Book, String>("releaseDateText"));
        
        list = FXCollections.observableArrayList(App.getLibrary().getBooksListReadOnly());
        
        if(list!=null)
        {
             table.setItems(list);
        }
    }    
    
    /**
     * Switches to main menu view
     * @throws IOException
     */
    @FXML
    private void switchMainMenu() throws IOException 
    {
        App.setRoot("mainmenu");
    }
}
