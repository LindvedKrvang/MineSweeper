/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bll;

import java.util.ArrayList;
import java.util.Random;
import static minesweeper.MineSweeper.TILES_PER_ROW;
import minesweeper.be.SingleListOfTiles;
import minesweeper.be.Tile;

/**
 *
 * @author Rasmus
 */
public class TileManager {
    
    private static TileManager instance;
    
    public static TileManager getInstance(){
        if(instance == null){
            instance = new TileManager();
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
            if(rand.nextInt(3) == 0 && mineCounter != mines){
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
    
    /**
     * Checks all adjacent tiles if it is a bomb or not and return the amount of bombs.
     * @param tilePosition
     * @param primaryList
     * @param aboveList
     * @param belowList
     * @return 
     */
    public int checkForBombs(int tilePosition, SingleListOfTiles primaryList, SingleListOfTiles aboveList, SingleListOfTiles belowList){
        int amountOfBombs = 0;
        amountOfBombs += checkTile(tilePosition, aboveList, -1);
        amountOfBombs += checkTile(tilePosition, aboveList, 0);
        amountOfBombs += checkTile(tilePosition, aboveList, 1);
        
        amountOfBombs += checkTile(tilePosition, primaryList, -1);
        amountOfBombs += checkTile(tilePosition, primaryList, 1);
        
        amountOfBombs += checkTile(tilePosition, belowList, -1);
        amountOfBombs += checkTile(tilePosition, belowList, 0);
        amountOfBombs += checkTile(tilePosition, belowList, 1);
        
        return amountOfBombs;
    }
    
    /**
     * Checks the specified tile if it exits and if it is a bomb.
     * Return 1 if it is a bomb. 0 if it is not.
     * @param tilePosition
     * @param list
     * @param difference
     * @return 
     */
    private int checkTile(int tilePosition, SingleListOfTiles list, int difference) {
        if(tilePosition + difference >= 0 && tilePosition + difference <= TILES_PER_ROW - 1 && list != null){
            if(list.get(tilePosition + difference).isBomb()){
                return 1;
            }        
        }
        return 0;
    }
}
