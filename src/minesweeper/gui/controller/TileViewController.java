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
import minesweeper.be.Tile;

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

    @FXML
    private void handleButtonTile(ActionEvent event) {
        btnTile.setText(mTile.getName());
    }
    
    /**
     * Sets the Tile of the button.
     * @param tile 
     */
    public void setTile(Tile tile){
        mTile = tile;
    }
}
