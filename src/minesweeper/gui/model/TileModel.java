/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.model;

import java.util.ArrayList;
import minesweeper.be.SingleListOfTiles;
import minesweeper.be.Tile;
import minesweeper.bll.TileManager;

/**
 *
 * @author Rasmus
 */
public class TileModel {
    
    private static TileModel instance;
    
    private ArrayList<Tile> mListOfTiles;
    private SingleListOfTiles mListOne;
    private SingleListOfTiles mListTwo;
    private SingleListOfTiles mListThree;
    private SingleListOfTiles mListFour;
    private SingleListOfTiles mListFive;
    private SingleListOfTiles mListSix;
    private SingleListOfTiles mListSeven;
    private SingleListOfTiles mListEight;
    private SingleListOfTiles mListNine;
    
    private ArrayList<SingleListOfTiles> mAllTileList;
    
    private final TileManager mTileManager;
    
    public static TileModel getInstance(){
        if(instance == null){
            instance = new TileModel();
        }
        return instance;
    }
    
    public TileModel(){
        mTileManager  = TileManager.getInstance();
        mAllTileList = new ArrayList<>();
        createTiles();
        giveBombReferences();
    }
    
    /**
     * Gets the firstListOfTiles.
     * @return 
     */
    public ArrayList<SingleListOfTiles> getListOfTiles(){
        return mAllTileList;
    }
    
    /**
     * Creates all the tiles and puts them in seperated lists. 
     */
    private void createTiles() {
        mListOfTiles = mTileManager.createTiles(99, 30);
        for(int i = 0; i < mListOfTiles.size(); i++){
            ArrayList<Tile> placeholder = new ArrayList();
            for(int j = 0; j < 11; j++){
                Tile tile = mListOfTiles.remove(0);
                tile.setPositionInList(j);
                placeholder.add(tile);
            }
            fillSingleList(i, placeholder);
        }
    }
    
    /**
     * Fills the list with the parsed list.
     * @param i
     * @param placeholder 
     */
    private void fillSingleList(int i, ArrayList<Tile> placeholder) {
        switch (i) {
            case 0:
                mListOne = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListOne);
                break;
            case 1:
                mListTwo = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListTwo);
                break;
            case 2:
                mListThree = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListThree);
                break;
            case 3:
                mListFour = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListFour);
                break;
            case 4:
                mListFive = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListFive);
                break;
            case 5:
                mListSix = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListSix);
                break;
            case 6:
                mListSeven = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListSeven);
                break;
            case 7:
                mListEight = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListEight);
                break;
            case 8:
                mListNine = new SingleListOfTiles(i, placeholder);
                mAllTileList.add(mListNine);
                break;
            default:
                break;
        }
    }

    private void giveBombReferences() {
        for(Tile tile : mListOne.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListOne, null, mListTwo));
        }
        for(Tile tile : mListTwo.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListTwo, mListOne, mListThree));
        }
        for(Tile tile : mListThree.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListThree, mListTwo, mListFour));
        }
        for(Tile tile : mListFour.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListFour, mListThree, mListFive));
        }
        for(Tile tile : mListFive.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListFive, mListFour, mListSix));
        }
        for(Tile tile : mListSix.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListSix, mListFive, mListSeven));
        }
        for(Tile tile : mListSeven.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListSeven, mListSix, mListEight));
        }
        for(Tile tile : mListEight.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListEight, mListSeven, mListNine));
        }
        for(Tile tile : mListNine.getList()){
            tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), mListNine, mListEight, null));
        }
    }
}
