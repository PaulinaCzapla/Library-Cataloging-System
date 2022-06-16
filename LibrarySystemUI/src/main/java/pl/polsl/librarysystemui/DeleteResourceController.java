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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.polsl.librarysystemui.model.Book;

/**
 * FXML Controller class for DeleteResource view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class DeleteResourceController implements Initializable
{

    /**
     * Button for deleting resource
     */
    @FXML 
    private Button deleteResourceButton;
    
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
     * Observable list to display
     */
    private ObservableList<Book> list;
    
    /**
     * Book to delete
     */
    private Book bookToDelete = null;

    /**
     * Tectfield for book's id
     */
    @FXML
    private TextField textField;
    
    /**
     * Initializes view
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        publishingHouse.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        releaseDateText.setCellValueFactory(new PropertyValueFactory<Book, String>("releaseDateText"));
        
        list = null;
        deleteResourceButton.setDisable(true);
        table.setItems(null);
        table.setPlaceholder(new Label("No results found"));
    }   

    
    /**
     * Searches library resources and displays it
     */
    @FXML
    void search(ActionEvent event) 
    {
            list = null;
      
            String text = textField.getText();
            
            if(text != null && !text.equals("") && text.matches("[1-9]+"))
            {
                 Book book = App.getLibrary().searchByID(Integer.parseInt(text));
                 if(book!=null)
                 {
                    list = FXCollections.observableArrayList(book);
                 }
            }
            if(list != null)
            {
                table.setItems(list);
                deleteResourceButton.setDisable(false);
                bookToDelete = list.get(0);
            } 
            else
            {
                deleteResourceButton.setDisable(true);
                table.setItems(null);
                table.setPlaceholder(new Label("No results found"));
            }  
   }

    /**
     * Switches to main menu view
     * @throws IOException
     */
    @FXML
    void switchToMainMenu() throws IOException 
    {
        App.setRoot("mainmenu");
    }

    
    /**
     * Deletes chosen resource
     * @throws IOException
     */
    @FXML
    void deleteResource() throws IOException 
    {
        if(bookToDelete!= null)
        {
            App.getLibrary().deleteBook(bookToDelete);
            table.setItems(null);
            table.setPlaceholder(new Label("No results found"));
        }
    }
}
