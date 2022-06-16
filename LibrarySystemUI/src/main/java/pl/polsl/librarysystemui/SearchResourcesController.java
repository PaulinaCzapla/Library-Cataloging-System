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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.polsl.librarysystemui.model.Book;

/**
 * FXML Controller class for SearchResources view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class SearchResourcesController implements Initializable
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
    private TableColumn<Book, String> releaseDate;

    /**
     * Table column for author
     */
    @FXML
    private TableColumn<Book,String> author;

    /**
     * Combobox with search options
     */
    @FXML
    private ComboBox<String> comboboxSearch;

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
     * Text field for information from user
     */
    @FXML
    private TextField textField;
    

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        publishingHouse.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        releaseDate.setCellValueFactory(new PropertyValueFactory<Book, String>("releaseDateText"));
        
        comboboxSearch.getItems().addAll("ID", "Author's name", "Title");
        table.setItems(null);
        table.setPlaceholder(new Label("No results found"));     
    } 
    
    /**
     * Switches main menu
     * @throws IOException
     */
    @FXML
    private void switchMainMenu() throws IOException 
    {
        App.setRoot("mainmenu");
    }
    
    /**
     * Search element in library
     * @throws IOException
     */
    @FXML
    private void search() throws IOException 
    {
        ObservableList<Book> list = null;
        
        if(comboboxSearch.getValue() != null)
        {
            String text = textField.getText();
            
            if(text != null && !text.equals(""))
            {
                if(comboboxSearch.getValue().equals("ID"))
            {
                if(isANumber(text))
                {
                 Book book = App.getLibrary().searchByID(Integer.parseInt(text));
                 
                 if(book!=null)
                 list = FXCollections.observableArrayList(book);
                }
          
            } else if(comboboxSearch.getValue().equals("Author's name"))
            {
                list = FXCollections.observableArrayList(App.getLibrary().searchByAuthor(text));
          
             } else if(comboboxSearch.getValue().equals("Title"))
            {
                list = FXCollections.observableArrayList(App.getLibrary().searchByTitle(text));
            }
            }
             if(list != null)
             {
                  table.setItems(list);
             } 
            else
             {
                table.setItems(null);
                table.setPlaceholder(new Label("No results found"));
             }
      
        }
    }
    
    /**
     * Checks if param is a number
     * @param text that should be check
     * @return true if param is a number, false if isn't
     */
    private boolean isANumber(String text)
    {
        return text.matches("[1-9]+");
    }
    
}
