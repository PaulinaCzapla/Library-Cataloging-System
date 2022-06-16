/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.model;

import pl.polsl.librarycatalogsystem.exceptions.WrongDateFormat;
import pl.polsl.librarycatalogsystem.exceptions.WrongTextFormat;

/**
 * Class that represents a book
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class Book
{

    /**
     * Uniqie book id
     */
    private int id;
    /**
     * Book's title
     */
    private String title;
    /**
     * Author's name
     */
    private String author;
    /**
     * Publishing house name
     */
    private String publishingHouse;
    /**
     * Reference to the object representing date of release
     */
    private Date releaseDate;

    /**
     * Constructor
     *
     * @param title title od the book
     * @param author author's name
     * @param publishingHouse a name of the publishing house
     * @param date String representation of the date
     * @throws WrongDateFormat
     */
    public Book(String title, String author, String publishingHouse, String date) throws WrongDateFormat
    {
        this.id = Library.getLastID() + 1;
        Library.incrementLastID();
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.releaseDate = new Date(date);
    }
    
    public Book(int id , String title, String author, String publishingHouse, String date) throws WrongDateFormat
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.releaseDate = new Date(date);
    }

    /**
     * Converts object's state to the text form
     *
     * @return textual representation of the object
     */
    public String toString()
    {
        return ("\nID: " + id + "\nauthor: " + author + "\ntitle: " + title
                + "\npublishing house: " + publishingHouse + "\nrelease date: " + releaseDate);

    }

    /**
     * Getter for id
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Getter for title
     *
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getter for author's name
     *
     * @return author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Getter for publishing house
     *
     * @return publishingHouse
     */
    public String getPublishingHouse()
    {
        return publishingHouse;
    }

    /**
     * Getter for date of release
     *
     * @return releaseDate
     */
    public Date getDate( )
    {
        return releaseDate;
    }
        
    public void setDate(String date) throws WrongDateFormat
    {
        if(Validator.validateDate(date))
        {
            releaseDate = new Date(date);
        }
        else
        {
            throw new WrongDateFormat();
        }
    }
    
    public void setTitle(String title) throws WrongTextFormat
    {
        if(Validator.validateText(title))
        {
            this.title = title;
        } 
        else
        {
            throw new WrongTextFormat();
        }
    }

    /**
     * Getter for author's name
     *
     */
    public void setAuthor(String author) throws WrongTextFormat
    {
        if(Validator.validateText(author))
        {
            this.author = author;
        }
        else
        {
            throw new WrongTextFormat();
        }
    }

    /**
     * Setter for publishing house
     *
     */
    public void setPublishingHouse(String ph) throws WrongTextFormat
    {
        if(Validator.validateText(ph))
        {
            this.publishingHouse = ph;
        }
        else
        {
            throw new WrongTextFormat();
        }        
    }




}
