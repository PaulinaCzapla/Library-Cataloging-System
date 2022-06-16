/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarysystemui.excepctions;

/**
 * Exception class for checking any wrong type of inputed params in the command
 * line by the user
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class ArgsWrongInput extends RuntimeException
{

    /**
     * Non-parameter constructor set default exception message
     */
    public ArgsWrongInput()
    {
        super("Wrong parameters entered in the command line.");
    }

    /**
     * Constructor that sets exception message
     *
     * @param message display message
     */
    public ArgsWrongInput(String message)
    {
        super(message);
    }
}

