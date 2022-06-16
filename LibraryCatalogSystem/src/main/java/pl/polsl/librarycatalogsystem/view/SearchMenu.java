/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.view;

/**
 * Class representing menu for searching resources
 * 
 * @author Paulina Czapla
 * @version 1.0
 */
public class SearchMenu extends Menu implements IUserInterface
{

    /**
     * Displays search menu
     */
    public void display()
    {
        System.out.println("Library search ");
        System.out.println("");
        System.out.println("");
        System.out.println("[1] Search by ID");
        System.out.println("[2] Search by author's name");
        System.out.println("[3] Seatch by title");
        System.out.println("[B] Return to main menu");
    }

}
