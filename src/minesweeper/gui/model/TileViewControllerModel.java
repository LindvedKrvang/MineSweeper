/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.model;

import java.util.ArrayList;
import minesweeper.gui.controller.TileViewController;

/**
 *
 * @author Rasmus
 */
public class TileViewControllerModel {
    
    private static TileViewControllerModel instance;
    
    private ArrayList<TileViewController> mListOfControllers;
    
    /**
     * Gets the instance of this model.
     * @return 
     */
    public static TileViewControllerModel getInstance(){
        if(instance == null){
            instance = new TileViewControllerModel();
        }
        return instance;
    }
    
    public TileViewControllerModel(){
        mListOfControllers = new ArrayList<>();
    }
    
    /**
     * Add a controller to mListOfControllers.
     * @param controller 
     */
    public void addController(TileViewController controller){
        mListOfControllers.add(controller);
    }
    
    /**
     * Gets the list of controllers.
     * @return 
     */
    public ArrayList<TileViewController> getControllers(){
        return mListOfControllers;
    }
}
