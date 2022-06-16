/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.view;

/**
 * Class representing main menu
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class MainMenu implements IUserInterface
{

    /**
     * Displays main menu
     */
    public void display()
    {
        System.out.println("Welcome to library system! ");
        System.out.println("");
        System.out.println("");
        System.out.println("[1] Display all library resources");
        System.out.println("[2] Search library resources");
        System.out.println("[3] Add new resources ");
        System.out.println("[4] Delete resources");
        System.out.println("[B] Exit");
    }
}
