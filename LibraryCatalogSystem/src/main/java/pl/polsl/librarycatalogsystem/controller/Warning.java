/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.controller;

/**
 * Class representing a warning that just print statement and don't need
 * confirmation
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class Warning
{
    /**
     * Statement to be displayed
     */
    private final String statement;

    /**
     * Constructor
     *
     * @param statement statement to be displayed
     */
    public Warning(String statement)
    {
        this.statement = statement;
    }

    /**
     * Displays the statement
     */
    public void display()
    {
        System.out.println(statement);
    }

    /**
     * Getter for the statement
     *
     * @return statement
     */
    public String getStatement()
    {
        return statement;
    }
}
