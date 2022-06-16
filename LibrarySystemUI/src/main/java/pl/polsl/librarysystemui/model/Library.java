/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarysystemui.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class representing library.
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class Library
{

    /**
     * Static field representing last book id number (it's used for giving a id
     * number to the new book)
     */
    private static int lastID;

    /**
     * List of the library resources
     */
    private ArrayList<Book> books;

    /**
     * Contructor
     *
     * @param books list of library resources
     */
    public Library(ArrayList<Book> books)
    {
        this.books = new ArrayList();
        if(books!=null)
        {
            this.books = books;
        }
    }
    
     /**
     * Non-parameter ontructor
     *
     */
    public Library()
    { 
        this.books = new ArrayList<>();
    }

    /**
     * Getter for lastID
     *
     * @return lastID
     */
    public static int getLastID()
    {
        return lastID;
    }

    /**
     * Resets value of the lastID
     */
    public static void resetLastID()
    {
        lastID = 0;
    }

    /**
     * Setter for lastID
     *
     * @param newLastID
     */
    public static void setLastID(int newLastID)
    {
        lastID = newLastID;
    }

    /**
     * Finds last (the biggest) id in the list
     *
     * @param list list of library resources
     * @return last ID
     */
    public static int findLastID(ArrayList<Book> list)
    {
        int max = 0;
        for (Book book : list)
        {
            if (max < book.getId())
            {
                max = book.getId();
            }
        }
        return max;
    }

    /**
     * Increments last ID by 1
     */
    public static void incrementLastID()
    {
        lastID = lastID + 1;
    }

    /**
     * Getter for books
     *
     * @return books
     */
    public ArrayList<Book> getBooksList()
    {
        return books;
    }
    
    
     /**
     * Getter for books read only list
     *
     * @return books
     */
    public List<Book> getBooksListReadOnly()
    {
        return Collections.unmodifiableList(books);
    }

    /**
     * Adds new book to the list
     *
     * @param book new book
     */
    public void addNewBook(Book book)
    {
        if(book!=null)
        {
            this.books.add(book);
        }
    }

    /**
     * Deletes book from the list
     *
     * @param book book to be deleted
     */
    public void deleteBook(Book book)
    {
        if(book!= null)
        books.remove(book);
    }

    /**
     * Searches list by book id
     *
     * @param id
     * @return result
     */
    public Book searchByID(int id)
    {
        for (Book book : books)
        {
            if (book.getId() == id)
            {
                return book;
            }
        }
        return null;
    }

    /**
     * Searches list by author. The best matching results are at the beginning
     * of the list.
     *
     * @param author
     * @return list with results
     */
    public ArrayList<Book> searchByAuthor(String author)
    {
        ArrayList<Book> foundBooks = new ArrayList<>();
        
        if(author != null && books != null)
        {
            Stream<Book> booksStream = books.stream();

            Stream<Book> sameBooksStream =  booksStream
                       .filter(g -> g.getAuthor().toLowerCase().equals(author.toLowerCase()));
               
            sameBooksStream.forEach(g -> foundBooks.add(0,g));
               
            Stream<Book> booksStream2 = books.stream();
               
               
            Stream<Book> filteredStream = booksStream2
                .filter(g -> g.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .filter(g -> !g.getAuthor().toLowerCase().equals(author.toLowerCase()));
            
            filteredStream.forEach(g -> foundBooks.add(g));

               filteredStream.close();
               booksStream.close();
               booksStream2.close(); 
               sameBooksStream.close();
            }
        return foundBooks;
    }

    /**
     * Searches list by title. The best matching results are at the beginning of
     * the list.
     *
     * @param title
     * @return list with results
     */
    public ArrayList<Book> searchByTitle(String title)
    {
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        
        if(title != null && books != null)
        {
            Stream<Book> booksStream = books.stream();

            Stream<Book> sameBooksStream =  booksStream
                       .filter(g -> g.getTitle().toLowerCase().equals(title.toLowerCase()));
               
            sameBooksStream.forEach(g -> foundBooks.add(0,g));
               
            Stream<Book> booksStream2 = books.stream();
         
            Stream<Book> filteredStream = booksStream2
                .filter(g -> g.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(g -> !g.getTitle().toLowerCase().equals(title.toLowerCase()));
            
            filteredStream.forEach(g -> foundBooks.add(g));

               filteredStream.close();
               booksStream.close();
               booksStream2.close(); 
               sameBooksStream.close();
            }        
       
        return foundBooks;
    }

}