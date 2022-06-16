/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.librarycatalogsystem.exceptions.WrongDateFormat;
import pl.polsl.librarycatalogsystem.model.*;
import pl.polsl.librarycatalogsystem.view.*;

/** Class representing controller for user interface
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class UIController 
{
    /**
     * Reference to MainMenu object for printing main menu to user
     */
    private final MainMenu mainMenu;
    /**
     * Reference to SearchMenu object for printing menu for searching resources to user
     */    
    private final SearchMenu searchLibraryMenu;
    /**
     * Reference to AddNewMenu object for printing menu for adding new book to the library
     */    
    private final AddNewBookMenu addNewBookMenu;
    /**
     * Reference to DeleteBookMenu object for printing menu for deleting a book from library
     */    
    private final DeleteBookMenu deleteBookMenu;
    /**
     * Reference to InputController object, that allows user to input data
     */    
    private final InputController inputController;
    /**
     * Reference to OutputController object for priting informations to the console
     */    
    private final OutputController outputController;
    /**
     * Reference to Library object that contains and manages all resources (books)
     */    
    private final Library library;
    /**
     * Reference to Warning object that prints warning about incorrect input to user
     */    
    private final Warning wrongInput;
    /**
     * Constructor
     * @param library Library object that contains resources (books) 
     */ 
    public UIController(Library library)
    {
        this.mainMenu = new MainMenu();
        this.searchLibraryMenu = new SearchMenu();
        this.addNewBookMenu = new AddNewBookMenu();
        this.deleteBookMenu = new DeleteBookMenu();
        this.inputController = new InputController();
        this.outputController = new OutputController();
        this.library = library;
        this.wrongInput = new Warning("Incorrect input data.");
    }

    /**
     * Constructor
     */    
    public void controlMainMenu()
    {
        boolean loop = true;
        boolean changed = true;
        
        while(loop)
        {
        if(changed)
        {
            mainMenu.clearConsole();
            mainMenu.display();
        }
        String input = inputController.enterData();
            
            switch(input)
            {
                case "1":
                
                    mainMenu.clearConsole();
                    outputController.displayList(library.getBooksListReadOnly());
                    returnToMenu();
                    changed = true;
                    break;
                
                case "2":
                
                    manageSearchMenu();
                    changed = true;
                    break;
                   
                case "3":
                    addNewBookMenu.clearConsole();
                    addNewBookMenu.display();
                    manageAddNewBook();
                    changed = true;
                    break;
                    
                case "4":
                    deleteBookMenu.clearConsole();
                    deleteBookMenu.display();
                    manageDeleteBook();
                    break;
               case "b": {}
               case "B":
               {
                   loop = false;
                   changed = true;
               }   break;    
                default:
                {
                   wrongInput.display();
                   changed = false;
                }      
            }
        }
    }
    
    /**
     * Adding new book to the library by getting input from user
     */
    private void manageAddNewBook()
    {        
        addNewBookMenu.display(DataType.title);
        String title = inputController.enterTextAndValidate(); 
        addNewBookMenu.display(DataType.author);
        String author = inputController.enterTextAndValidate();    
        addNewBookMenu.display(DataType.publishingHouse);
        String publishingHouse = inputController.enterTextAndValidate();   
        addNewBookMenu.display(DataType.dateOfRelease);
        String dateOfRelease = inputController.enterDateAndValidate();
        
        Book newBook = null;
        try
        {
            newBook = new Book(title, author, publishingHouse,dateOfRelease);
        } catch (WrongDateFormat e)
        {
            Logger.getLogger(Date.class.getName()).log(Level.INFO, null, e);
           
        }
        System.out.println("\n\n" + newBook+"\n\n");
        
        ConfirmActionWarning confirmWarning = new ConfirmActionWarning("Do you confirm adding a new book?");
        confirmWarning.display();
        
        if(confirmWarning.confirmAction())
        {
            library.addNewBook(newBook);
            Warning warning = new Warning("New book added. ");
            warning.display();
        }
    }
    /**
     * Managing search library options by getting input from user. 
     */     
    private void manageSearchMenu()
    {
       boolean loop = true, changed = true;
       while(loop)
        {
            if(changed)
            {
                searchLibraryMenu.clearConsole();
                searchLibraryMenu.display();
            }
        
            String input = inputController.enterData();
        
            switch(input)
            {
                case "1":
                {
                    mainMenu.clearConsole();
                    searchByID();
                    returnToMenu();
                    changed = true;
                    
                }  break;
                case "2":
                {
                    mainMenu.clearConsole();
                    searchByAuthorsName();
                    returnToMenu();
                    changed = true;
                    
                } break;
               case "3":
               {
                    mainMenu.clearConsole();
                    searchByTitle();
                    returnToMenu();
                    changed = true;
                    
               }   break;
               case "b": {}
               case "B":
               {
                   loop = false;
                   changed = true;
               }   break;
                   
                default:
                {
                    wrongInput.display();
                    changed = false;
                }                
            }
        }
    }
    /**
     * Deleting book from the library by asking user which book should be deleted.
     */
    private void manageDeleteBook()
    {
        Book book = searchByID();
        
        ConfirmActionWarning confirmWarning = new ConfirmActionWarning("\n\nDo you want to delete the book?");
        confirmWarning.display();
        
        if(confirmWarning.confirmAction())
        {
            library.deleteBook(book);
            
            Warning warning = new Warning("Deleted. ");
            warning.display();
        }
        
        returnToMenu();
    }
     /**
     * Seatrching book in the library by it's ID number and displaying result
     */
     private Book searchByID()
     {
       searchLibraryMenu.display(DataType.id);          
       String id = inputController.enterData();
       Book book = library.searchByID(Integer.parseInt(id));
       
       if(book!=null)
       {
            System.out.println(book);   
       }
       else
       {
           System.out.println("No such resources.");
       }
       return book;
     }
     /**
     * Seatrching book in the library by it's title and displaying results
     */
     private void searchByTitle()
     {
      searchLibraryMenu.display(DataType.title);            
      String title = inputController.enterData();
      ArrayList<Book> books = library.searchByTitle(title);
                    
      if(!books.isEmpty())
        {
          outputController.displayList(books);
        }
      else
       {
           System.out.println("No such resources.");
       }
     }
     /**
     * Seatrching book in the library by it's author's name and displaying results
     */     
     private void searchByAuthorsName()
     {
           searchLibraryMenu.display(DataType.author);
           String author = inputController.enterData();

           ArrayList<Book> books = library.searchByAuthor(author);
                    
            if(!books.isEmpty())
             {
                outputController.displayList(books);
             }
            else
            {
                System.out.println("No such resources.");
             }
     }
     /**
     * Displaying information about returning to main menu and waiting for input
     */
     private void returnToMenu()
     {
         mainMenu.displayReturnInfo(); 
         inputController.waitForReturnInput();
     }
}
