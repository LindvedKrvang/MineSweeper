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
    private int mBombsAdjacent;
    private int mPositionInList;
    
    private SingleListOfTiles mPrimaryList;
    private SingleListOfTiles mAboveList;
    private SingleListOfTiles mBelowList;
    
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
    
    /**
     * Gets if the tile is a bomb or not.
     * @return 
     */
    public boolean isBomb(){
        return mIsBomb;
    }
    
    /**
     * Sets the amount of bombs around the tile.
     * @param amountOfBombs 
     */
    public void setAdjacentBombs(int amountOfBombs){
        mBombsAdjacent = amountOfBombs;
        if(mIsBomb == false){
            mName = mBombsAdjacent + "";
        }
    }
    
    /**
     * Return the amount of bombs adjacent to the tile.
     * @return 
     */
    public int getAdjacentBombs(){
        return mBombsAdjacent;
    }
    
    /**
     * Sets the position of the tile in its list.
     * @param position 
     */
    public void setPositionInList(int position){
        mPositionInList = position;
    }
    
    /**
     * Gets the positon of the tile in its list.
     * @return 
     */
    public int getPositionInList(){
        return mPositionInList;
    }
    
    /**
     * Sets the primary, above and belows list of the tile.
     * @param primary
     * @param above
     * @param below 
     */
    public void setList(SingleListOfTiles primary, SingleListOfTiles above, SingleListOfTiles below){
        mPrimaryList = primary;
        mAboveList = above;
        mBelowList = below;
    }
    
    /**
     * Returns the primaryList.
     * @return 
     */
    public SingleListOfTiles getPrimaryList() {
        return mPrimaryList;
    }
    
    /**
     * Retuns the aboveList.
     * @return 
     */
    public SingleListOfTiles getAboveList() {
        return mAboveList;
    }
    
    /**
     * Returns the belowList.
     * @return 
     */
    public SingleListOfTiles getBelowList() {
        return mBelowList;
    }
    
    
}
