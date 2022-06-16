/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.polsl.librarycatalogsystem.view;

/**
 * Interface that allows to display and clear console
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public interface IUserInterface
{

    /**
     * Displays menu
     */
    void display();

    /**
     * Clears console
     */
    default void clearConsole()
    {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }
    
    /**
     * Displays information for return
     */
    default void displayReturnInfo()
    {
        System.out.println("press [B] to return ");
    }
}
