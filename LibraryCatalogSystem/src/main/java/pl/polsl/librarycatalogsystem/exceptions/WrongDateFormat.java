/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.exceptions;

/**
 * Exception class for checking wrong date format
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class WrongDateFormat extends RuntimeException
{

    /**
     * Non-parameter constructor set default exception message
     */
    public WrongDateFormat()
    {
        super("Wrong date format. ");
    }

    /**
     * Constructor that sets exception message
     *
     * @param message display message
     */
    public WrongDateFormat(String message)
    {
        super(message);
    }
}
