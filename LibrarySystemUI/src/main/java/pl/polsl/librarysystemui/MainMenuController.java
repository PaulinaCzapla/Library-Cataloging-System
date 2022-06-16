/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.librarysystemui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class for MainMenu view
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class MainMenuController implements Initializable
{

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
    /**
     * Switches to display all resources view
     * @throws IOException
     */
    @FXML
    private void switchDisplayAllResources() throws IOException 
    {
        App.setRoot("displayallresources");
    }
    
    /**
     * Switches to search view
     * @throws IOException
     */
    @FXML
    private void switchSearchLibraryResources() throws IOException 
    {
        App.setRoot("searchresources");
    }
    
    /**
     * Switches to add new resource view
     * @throws IOException
     */
    @FXML
    private void switchAddNewResource() throws IOException 
    {
        App.setRoot("addresource");
    }
    
    /**
     * Switches to delete book view
     * @throws IOException
     */
    @FXML
    private void switchDeleteResource() throws IOException 
    {
        App.setRoot("deleteresource");
    }
    
    /**
     * Exit program
     * @throws IOException
     */
    @FXML
    private void exit() throws IOException 
    {
       System.exit(0);
    }
}
