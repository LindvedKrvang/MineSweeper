/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.be;

import java.util.ArrayList;

/**
 *
 * @author Rasmus
 */
public class SingleListOfTiles {
    
    private ArrayList<Tile> mListOfTiles;
    
    private int mListNumber;

    public SingleListOfTiles(int listNumber, ArrayList<Tile> list) {
        mListNumber = listNumber;
        mListOfTiles = list;
    }
    
    /**
     * Returns the Tile at the specified position.
     * @param position
     * @return 
     */
    public Tile getTile(int position){
        return mListOfTiles.get(position);
    }
    
    /**
     * Returns the listOfTiles.
     * @return 
     */
    public ArrayList<Tile> getList() {
        return mListOfTiles;
    }
    
    /**
     * Returns the number of the list.
     * @return 
     */
    public int getListNumber() {
        return mListNumber;
    }    
    
    /**
     * Returns the length of the list.
     * @return 
     */
    public int size(){
        return mListOfTiles.size();
    }
    
    /**
     * Returns the Tile at the specified position.
     * @param position
     * @return 
     */
    public Tile get(int position){
        return mListOfTiles.get(position);
    }
}
