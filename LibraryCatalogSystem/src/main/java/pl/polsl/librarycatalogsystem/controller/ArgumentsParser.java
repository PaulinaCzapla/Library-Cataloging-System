/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import pl.polsl.librarycatalogsystem.exceptions.ArgsWrongInput;

/**
 * Arguments parsing class that prevents wrong program execution by client and
 * sets file path
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class ArgumentsParser
{

    /**
     * Parameters from command line
     */
    ArrayList<String> cmdParams = new ArrayList<>();

    /**
     * Path to the reading/writing file
     */
    private String filePath = new String();

    /**
     * Constructor
     *
     * @param args from the command line
     */
    public ArgumentsParser(String[] args)
    {
        this.cmdParams = new ArrayList<>(Arrays.asList(args));
    }

    /**
     * Method that parses command line parameters
     *
     * @throws ArgsWrongInput when program was exectued with wrong params
     */
    public void parse() throws ArgsWrongInput
    {
        checkEmptyArgs();
        checkTooManyParameters();
        checkForFpSwitch();
        checkForOtherSwitches();
        checkForFilePathAfterSwitch();
        filePath = cmdParams.get(cmdParams.indexOf("-fp") + 1);
    }

    /**
     * Checks if user entered too many params in the cmd
     *
     * @throws ArgsWrongInput if user entered wrong args
     */
    private void checkTooManyParameters() throws ArgsWrongInput
    {
        if (cmdParams.size() > 2)
        {
            throw new ArgsWrongInput("Too many params entered.");
        }
    }

    /**
     * Checks if user entered a filePath string after a "-fp" switch in the
     * command line
     *
     * @throws ArgsWrongInput if user entered wrong args
     */
    private void checkForFilePathAfterSwitch() throws ArgsWrongInput
    {
        int indexOfFilePath = cmdParams.indexOf("-fp") + 1;

        if (indexOfFilePath >= cmdParams.size())
        {
            throw new ArgsWrongInput("No file path specified after -fp.");
        }
    }

    /**
     * Checks if user entered different type of switches from "-fp"
     *
     * @throws ArgsWrongInput if args were inputed wrong by user
     */
    private void checkForOtherSwitches() throws ArgsWrongInput
    {
        boolean wrongSwitchOccuerd = false;

        for (String param : cmdParams)
        {
            if (param.contains("-") && !param.equals("-fp"))
            {
                wrongSwitchOccuerd = true;
            }
        }

        if (wrongSwitchOccuerd)
        {
            throw new ArgsWrongInput("Wrong switch entered.");
        }
    }

    /**
     * Checks if user entered "-fp" switch in the command line
     *
     * @throws ArgsWrongInput if args were inputed wrong by user
     */
    private void checkForFpSwitch() throws ArgsWrongInput
    {
        if (!cmdParams.contains("-fp"))
        {
            throw new ArgsWrongInput("-fp switch not entered. ");
        }
    }

    /**
     * Checks if user didn't eneter anything in the command line
     */
    private void checkEmptyArgs()
    {
        if (cmdParams.isEmpty())
        {
            askForFilePath();
            parse();
        }
    }

    /**
     * Returns file path that was entered by user in the command line
     *
     * @return file path
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * Gets file path from user and saves it in cmdPatams list
     *
     */
    private void askForFilePath()
    {
        OutputController.ArgumentsInformation();
        InputController ic = new InputController();
        String data = ic.enterData();

        if (!data.isEmpty())
        {
            String trimmed = data.trim();
            String[] splitted = trimmed.split(" ");
            cmdParams = new ArrayList<>(Arrays.asList(splitted));
        }
    }
}
