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
    
    private final TileManager tileManager;
    
    public static TileModel getInstance(){
        if(instance == null){
            instance = new TileModel();
        }
        return instance;
    }
    
    public TileModel(){
        tileManager  = TileManager.getInstance();
        mAllTileList = new ArrayList<>();
        createList();        
    }
    
    /**
     * Gets the firstListOfTiles.
     * @return 
     */
    public ArrayList<SingleListOfTiles> getListOfTiles(){
        return mAllTileList;
    }
    
    /**
     * Creates all the lists and puts them in seperated lists. 
     */
    private void createList() {
        mListOfTiles = tileManager.createTiles(99, 40);
        for(int i = 0; i < mListOfTiles.size(); i++){
            ArrayList<Tile> placeholder = new ArrayList();
            for(int j = 0; j < 11; j++){
                placeholder.add(mListOfTiles.remove(0));
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
}
