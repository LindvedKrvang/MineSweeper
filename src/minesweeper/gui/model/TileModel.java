/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import minesweeper.be.Tile;
import minesweeper.bll.FileManager;

/**
 *
 * @author Rasmus
 */
public class TileModel {
    
    private static TileModel instance;
    
    private ArrayList<Tile> listOfTiles;
    
    private final FileManager fileManager;
    
    public static TileModel getInstance(){
        if(instance == null){
            instance = new TileModel();
        }
        return instance;
    }
    
    public TileModel(){
        fileManager  = FileManager.getInstance();
        listOfTiles = fileManager.createTiles(480, 99);
    }
    
    /**
     * Gets the listOfTiles.
     * @return 
     */
    public ArrayList<Tile> getListOfTiles(){
        return listOfTiles;
    }
}
