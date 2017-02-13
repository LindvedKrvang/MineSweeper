/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bll;

import java.util.ArrayList;
import java.util.Random;
import minesweeper.be.Tile;

/**
 *
 * @author Rasmus
 */
public class FileManager {
    
    private static FileManager instance;
    
    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }
    
    /**
     * Creates all Tiles with the giving parameters.
     * @param totalTiles Total amount of tiles to be in the game.
     * @param mines The amount of bombs in the game.
     * @return 
     */
    public ArrayList<Tile> createTiles(int totalTiles, int mines){
        Random rand = new Random();
        ArrayList<Tile> listOfTiles = new ArrayList<>();
        int mineCounter = 0;
        int tilesPlaced = 0;
        for(int i = 0; i < totalTiles; i++){
            if(rand.nextInt(2) == 0 && mineCounter != mines){
                listOfTiles.add(new Tile(true));
                mineCounter++;
                tilesPlaced++;
            }else if(totalTiles - tilesPlaced == mines - mineCounter){
                listOfTiles.add(new Tile(true));
                mineCounter++;
                tilesPlaced++;
            }else{
                listOfTiles.add(new Tile(false));
                tilesPlaced++;
            }
        }
        return listOfTiles;
    }
}
