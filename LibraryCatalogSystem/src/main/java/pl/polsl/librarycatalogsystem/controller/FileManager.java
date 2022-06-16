/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.controller;

import java.util.ArrayList;
import pl.polsl.librarycatalogsystem.exceptions.NotSupportedFileFormat;
import pl.polsl.librarycatalogsystem.model.Book;

/**
 * Class to manage file
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class FileManager
{

    /**
     * Path to the file that will be read/written
     */
    final private String filePath;
    /**
     * Reference to InputController object, that allows user to input data
     */
    final private InputController inputController;
    /**
     * Reference to OutputController object for priting informations to the
     * console
     */
    final private OutputController outputController;

    /**
     * Contstructor
     *
     * @param filePath a path to the file that will be read/written
     */
    public FileManager(String filePath)
    {
        this.filePath = filePath;
        this.inputController = new InputController();
        this.outputController = new OutputController();
    }

    /**
     * Read data from file using InputController object
     *
     * @return ArrayList list with read data
     * @throws NotSupportedFileFormat
     */
    public ArrayList<Book> readJsonFile() throws NotSupportedFileFormat
    {
        checkFileFormat();
        return inputController.readDataFromJsonFile(filePath);
    }

    /**
     * Write data to file using OutputController object
     *
     * @param list an ArrayList with data to write
     * @throws NotSupportedFileFormat throws and exception if file format is
     * wrong
     */
    public void saveJsonFile(ArrayList<Book> list) throws NotSupportedFileFormat
    {
        checkFileFormat();
        outputController.saveJsonFile(list, filePath);
    }

    /**
     * Checks if file format is correct
     *
     * @throws NotSupportedFileFormat throws and exception if file format is
     * wrong
     */
    private void checkFileFormat() throws NotSupportedFileFormat
    {
        int length = filePath.length();
        String format = "";
        if (length > 5)
        {
            format = filePath.substring(length - 5, length);
        }

        if (format.isEmpty())
        {
            throw new NotSupportedFileFormat("No file format entered.");
        }
        if (!format.equals(".json"))
        {
            throw new NotSupportedFileFormat();
        }
    }
}
