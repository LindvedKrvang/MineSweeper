/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.be;

import minesweeper.gui.controller.TileViewController;

/**
 *
 * @author Rasmus
 */
public class Tile {
    
    private boolean mIsBomb;
    private String mName;
    private int mBombsAdjacent;
    private int mPositionInList;
    private boolean mIsClicked;
    private boolean mIsFlagged;
    
    private SingleListOfTiles mPrimaryList;
    private SingleListOfTiles mAboveList;
    private SingleListOfTiles mBelowList;
    
    private TileViewController mController;
    
    public Tile(boolean isBomb){
        mIsBomb = isBomb;
        mIsClicked = false;
        mIsFlagged = false;
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
     * Sets the lists of the tile.
     * @param primary
     * @param above
     * @param below 
     */
    public void setLists(SingleListOfTiles primary, SingleListOfTiles above, SingleListOfTiles below){
        mPrimaryList = primary;
        mAboveList = above;
        mBelowList = below;
    }
    
    /**
     * Get the primaryList.
     * @return 
     */
    public SingleListOfTiles getPrimaryList() {
        return mPrimaryList;
    }
    
    /**
     * Get the aboveList.
     * @return 
     */
    public SingleListOfTiles getAboveList() {
        return mAboveList;
    }
    
    /**
     * Get the belowList.
     * @return 
     */
    public SingleListOfTiles getBelowList() {
        return mBelowList;
    }    
    
    /**
     * Sets the controller for the tile.
     * @param controller 
     */
    public void setController(TileViewController controller){
        mController = controller;
    }
    
    /**
     * Gets the controller of the tile.
     * @return 
     */
    public TileViewController getController(){
        return mController;
    }
    
    /**
     * Sets mIsClicked equal to true.
     */
    public void setClickedTrue(){
        mIsClicked = true;
    }
    
    /**
     * Returns mIsClicked.
     * @return 
     */
    public boolean getIsClicked(){
        return mIsClicked;
    }
    
    /**
     * Sets mIsFlagged to the opposite.
     */
    public void setFlagged(){
        mIsFlagged = !mIsFlagged;
    }
    
    /**
     * Returns mIsFlagged.
     * @return 
     */
    public boolean getIsFlagged(){
        return mIsFlagged;
    }
}
