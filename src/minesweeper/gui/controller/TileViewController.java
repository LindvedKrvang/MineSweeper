/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import minesweeper.be.Tile;
import minesweeper.bll.TileManager;
import minesweeper.gui.model.TileModel;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class TileViewController implements Initializable {

    @FXML
    private Button btnTile;
    
    private Tile mTile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Sets the Tile of the button.
     * @param tile 
     */
    public void setTile(Tile tile){
        mTile = tile;
    }

    @FXML
    private void handleButtonTile(MouseEvent event) {
        if(event.getButton() == MouseButton.SECONDARY && mTile.getIsClicked() == false){
            mTile.setFlagged();
            if(mTile.getIsFlagged() == true){
                btnTile.setText("F");
            }else{
                btnTile.setText("");
            }
        }else if(mTile.getIsFlagged() == false){
            btnTile.setText(mTile.getName());
            mTile.setClickedTrue();
            if(mTile.isBomb() == true){
            //TODO RKL: Make GameOver.
            }else if(mTile.getAdjacentBombs() == 0){
                TileModel.getInstance().checkSurroundingTiles(mTile.getPositionInList(), 
                    mTile.getPrimaryList(), 
                    mTile.getAboveList(), 
                    mTile.getBelowList());
            }
        }
    }   
    
    /**
     * Display the name of the tile and if it has zero adjacent bombs. Checks the tiles around it.
     */
    public void checkTile(){
        if(mTile.getIsClicked() == false && mTile.getIsFlagged() == false){
            mTile.setClickedTrue();
            btnTile.setText(mTile.getName());
            if(mTile.getAdjacentBombs() == 0){
                TileModel.getInstance().checkSurroundingTiles(mTile.getPositionInList(), mTile.getPrimaryList(), mTile.getAboveList(), mTile.getBelowList());
            }
        }        
    }
}
