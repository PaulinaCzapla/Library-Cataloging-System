/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.exceptions;

/**
 * Exception class for checking wrong file format inputed in the command line by
 * the user
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class NotSupportedFileFormat extends RuntimeException
{

    /**
     * Non-parameter constructor set default exception message
     */
    public NotSupportedFileFormat()
    {
        super("File format not supported");
    }

    /**
     * Constructor sets exception message
     *
     * @param message display message
     */
    public NotSupportedFileFormat(String message)
    {
        super(message);
    }
}
