/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.librarycatalogsystem.view;

import java.util.HashMap;
import java.util.Map;
import pl.polsl.librarycatalogsystem.controller.DataType;

/**
 * Abstract class representing menu
 *
 * @author Paulina Czapla
 * @version 1.0
 */
public abstract class Menu
{

    /**
     * Map that stores the appropriate text depending on DataType key
     */
    private Map<DataType, String> data;

    /**
     * Non-parameter constructor
     */
    public Menu()
    {
        data = new HashMap<DataType, String>();
        data.put(DataType.id, "Enter id: ");
        data.put(DataType.title, "Enter title: ");
        data.put(DataType.author, "Enter author's name: ");
        data.put(DataType.publishingHouse, "Enter publishing house: ");
        data.put(DataType.dateOfRelease, "Enter date of release: ");
    }

    /**
     * Displays text from map depending on the parameter value
     *
     * @param dataType parameter used as map key
     */
    public void display(DataType dataType)
    {
        System.out.println(data.get(dataType));
    }
}
