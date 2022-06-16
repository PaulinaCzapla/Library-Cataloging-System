/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.controller;

/**
 * Class representing a warning that needs confirmation from user.
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public class ConfirmActionWarning extends Warning
{

    /**
     * Constructor
     *
     * @param statement which is an information to communicate
     */
    ConfirmActionWarning(String statement)
    {
        super(statement);
    }

    /**
     * Displays a statement to user
     */
    @Override
    public void display()
    {
        System.out.println(this.getStatement());
        System.out.println("[1] Yes");
        System.out.println("[2] No");
    }

    /**
     * Gets information from user about confirmation
     *
     * @return boolean value that signifies user choice
     */
    public boolean confirmAction()
    {
        boolean loop = true;
        boolean choice = false;

        InputController controller = new InputController();
        while (loop)
        {
            String option = controller.enterData();

            if (option.equals("1"))
            {
                loop = false;
                choice = true;
            } else if (option.equals("2"))
            {
                loop = false;
                choice = false;
            }
        }
        return choice;
    }
}
