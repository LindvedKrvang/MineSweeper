/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.be;

/**
 *
 * @author Rasmus
 */
public class Tile {
    
    private boolean mIsBomb;
    private String mName;
    
    public Tile(boolean isBomb){
        mIsBomb = isBomb;
        if(mIsBomb == true){
            mName = "B";
        }else{
            mName = "S";
        }
    }
    
    /**
     * Gets the name of the tile.
     * @return 
     */
    public String getName(){
        return mName;
    }
}
