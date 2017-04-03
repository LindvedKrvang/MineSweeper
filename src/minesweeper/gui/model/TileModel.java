/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.model;

import java.util.ArrayList;
import static minesweeper.MineSweeper.TILES_PER_ROW;
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
    private final TileViewControllerModel mTileViewControllerModel;

    public static TileModel getInstance() {
        if (instance == null) {
            instance = new TileModel();
        }
        return instance;
    }

    public TileModel() {
        mTileManager = TileManager.getInstance();
        mTileViewControllerModel = TileViewControllerModel.getInstance();
        createBoard();
    }

    /**
     * Gets the firstListOfTiles.
     *
     * @return
     */
    public ArrayList<SingleListOfTiles> getListOfTiles() {
        return mAllTileList;
    }

    /**
     * Creates all the tiles and puts them in seperated lists.
     */
    private void createTiles() {
        mListOfTiles = mTileManager.createTiles(99, 30);
        for (int i = 0; i < mListOfTiles.size(); i++) {
            ArrayList<Tile> placeholder = new ArrayList();
            for (int j = 0; j < TILES_PER_ROW; j++) {
                Tile tile = mListOfTiles.remove(0);
                tile.setPositionInList(j);
                placeholder.add(tile);
            }
            fillSingleList(i, placeholder);
        }
    }

    /**
     * Fills the list with the parsed list.
     *
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

    private void giveListReferences() {
        for (Tile tile : mListOne.getList()) {
            tile.setLists(mListOne, null, mListTwo);
        }
        for (Tile tile : mListTwo.getList()) {
            tile.setLists(mListTwo, mListOne, mListThree);
        }
        for (Tile tile : mListThree.getList()) {
            tile.setLists(mListThree, mListTwo, mListFour);
        }
        for (Tile tile : mListFour.getList()) {
            tile.setLists(mListFour, mListThree, mListFive);
        }
        for (Tile tile : mListFive.getList()) {
            tile.setLists(mListFive, mListFour, mListSix);
        }
        for (Tile tile : mListSix.getList()) {
            tile.setLists(mListSix, mListFive, mListSeven);
        }
        for (Tile tile : mListSeven.getList()) {
            tile.setLists(mListSeven, mListSix, mListEight);
        }
        for (Tile tile : mListEight.getList()) {
            tile.setLists(mListEight, mListSeven, mListNine);
        }
        for (Tile tile : mListNine.getList()) {
            tile.setLists(mListNine, mListEight, null);
        }
    }

    /**
     * Gives all tiles the amount of bombs next to them.
     */
    private void giveBombAmountOfAdjacentBombs() {
        for (SingleListOfTiles listOfAllList : mAllTileList) {
            for (Tile tile : listOfAllList.getList()) {
                tile.setAdjacentBombs(mTileManager.checkForBombs(tile.getPositionInList(), tile.getPrimaryList(), tile.getAboveList(), tile.getBelowList()));
            }
        }
    }

    /**
     * For each tile around the parsed tile, checks if it has any adjacent
     * bombs.
     *
     * @param positionInList
     * @param primaryList
     * @param aboveList
     * @param belowList
     */
    public void checkSurroundingTiles(int positionInList, SingleListOfTiles primaryList, SingleListOfTiles aboveList, SingleListOfTiles belowList) {
        checkTile(positionInList - 1, primaryList);
        checkTile(positionInList + 1, primaryList);

        checkTile(positionInList - 1, aboveList);
        checkTile(positionInList, aboveList);
        checkTile(positionInList + 1, aboveList);

        checkTile(positionInList - 1, belowList);
        checkTile(positionInList, belowList);
        checkTile(positionInList + 1, belowList);
    }

    /**
     * Call the controller of the specified tile and call checkTile.
     *
     * @param position
     * @param list
     */
    private void checkTile(int position, SingleListOfTiles list) {
        if (position >= 0 && position <= TILES_PER_ROW - 1 && list != null) {
            list.get(position).getController().checkTile();
        }
    }

    /**
     * Creates all the tiles and gives them all their references.
     */
    public void createBoard() {
        mAllTileList = new ArrayList<>();
        createTiles();
        giveListReferences();
        giveBombAmountOfAdjacentBombs();
    }
}
