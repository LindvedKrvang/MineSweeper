/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import minesweeper.be.Tile;
import minesweeper.bll.FileManager;
import minesweeper.gui.model.TileModel;

/**
 *
 * @author Rasmus
 */
public class GameBoardViewController implements Initializable, ListChangeListener<Tile> {

    @FXML
    private FlowPane flowPane;
    
    private final TileModel tileModel;
    
    public GameBoardViewController(){
        tileModel = TileModel.getInstance();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addTilesToFlowPane();
    }

    @Override
    public void onChanged(Change<? extends Tile> c) {
        
    }
    
    private void addTilesToFlowPane(){
        ArrayList<Tile> listOfTiles = tileModel.getListOfTiles();
        for(int i = 0; i < listOfTiles.size(); i++){
            try{
                flowPane.getChildren().add(createTileNode(listOfTiles.get(i)));
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Creates a node of a TileView.
     * @return
     * @throws IOException 
     */
    private Node createTileNode(Tile tile) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minesweeper/gui/view/TileView.fxml"));
        Node node = loader.load();
        TileViewController controller = loader.getController();
        controller.setTile(tile);
        return node;
    }
}
