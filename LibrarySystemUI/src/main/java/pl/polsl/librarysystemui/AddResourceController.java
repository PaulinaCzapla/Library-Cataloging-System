/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.librarysystemui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.polsl.librarysystemui.model.Book;
import pl.polsl.librarysystemui.model.Date;
import pl.polsl.librarysystemui.model.Validator;

/**
 * FXML Controller class for AddResource view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class AddResourceController implements Initializable
{
    
    
    /**
     * TextField for author name
     */
    @FXML
    private TextField authorField;

    /**
     * TextField for title
     */
    @FXML
    private TextField titleFiled;

    /**
     * TextField for date of release
     */
    @FXML
    private TextField  dateOfRelease;
    
    /**
     * TextField for publishing house
     */
    @FXML
    private TextField publishingHouseField;
    
    /**
     * Label for information
     */
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        label.setText("");
    }

    
    /**
     * Switches to main menu view.
     * @throws IOException
     */
    @FXML
    private void switchMainMenu() throws IOException 
    {
        App.setRoot("mainmenu");
    }
    
    /**
     * Add new resource to Library.
     * @throws IOException
     */
    @FXML
    private void addResource() throws IOException 
    {
        setDefaultBorders();
        
        boolean isAuthorValid = false, isTitleValid = false, isPublishingHouseValid = false, isDateValid = false;
        String title = null, author= null, ph= null, date= null;
        
        if(Validator.validateText(authorField.getText()))
        {
            isAuthorValid = true;
            author = authorField.getText();
        } else 
        {
            authorField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        }
        if(Validator.validateText(titleFiled.getText()))
        {
            isTitleValid = true;
            title = titleFiled.getText();
        } else 
        {
            titleFiled.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        }
        if(Validator.validateText(publishingHouseField.getText()))
        {
            isPublishingHouseValid = true;
            ph = publishingHouseField.getText();
            
        } else 
        {
            publishingHouseField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        }
  
        if(Validator.validateDate(dateOfRelease.getText()))
        {
            isDateValid = true;
            date = dateOfRelease.getText();
        } else 
        {
            dateOfRelease.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
        }
        
        if(isAuthorValid && isTitleValid && isPublishingHouseValid && isDateValid)
        {
            Book newBook = new Book(title, author, ph, date);
            App.getLibrary().addNewBook(newBook);
            
            label.setStyle("-fx-text-fill: green ; -fx-font-size: 24;");
            label.setText("Book added.");
            authorField.clear();
            titleFiled.clear();
            publishingHouseField.clear();
            dateOfRelease.clear();
        } else
        {
            label.setStyle("-fx-text-fill: red ; -fx-font-size: 24;");
            label.setText("Wrong data entered. ");
        }
    }    

    /**
     * Set default button borders
     */
    private void setDefaultBorders()
    {
        authorField.setStyle("-fx-border-color: white ; -fx-border-width: 2px ;");
        titleFiled.setStyle("-fx-border-color: white ; -fx-border-width: 2px ;");
        publishingHouseField.setStyle("-fx-border-color: white ; -fx-border-width: 1px ;");
        dateOfRelease.setStyle("-fx-border-color: white ; -fx-border-width: 1px ;");
    }
    
}
