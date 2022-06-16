/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.excepctions;

/**
 * Exception class for checking wrong text format
 * @author Paulina Czapla
 * @version 1.0
 */
public class WrongTextFormat extends RuntimeException
{
     /**
     * Non-parameter constructor set default exception message
     */
    public WrongTextFormat()
    {
        super("Wrong text format");
    }

    /**
     * Constructor that sets exception message
     *
     * @param message display message
     */
    public WrongTextFormat(String message)
    {
        super(message);
    }
}

