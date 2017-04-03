/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import static minesweeper.MineSweeper.LENGTH_OF_TILE;
import static minesweeper.MineSweeper.TILES_PER_ROW;
import minesweeper.be.SingleListOfTiles;
import minesweeper.be.Tile;
import minesweeper.gui.model.TileModel;
import minesweeper.gui.model.TileViewControllerModel;

/**
 *
 * @author Rasmus
 */
public class GameBoardViewController implements Initializable, ListChangeListener<Tile> {

    @FXML
    private FlowPane flowPane;

    private final TileModel mTileModel;
    private final TileViewControllerModel mTileViewControllerModel;

    private RootController mController;

    public GameBoardViewController() {
        mTileModel = TileModel.getInstance();
        mTileViewControllerModel = TileViewControllerModel.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setFlowPaneWidth();
        addTilesToFlowPane();
    }

    @Override
    public void onChanged(Change<? extends Tile> c) {

    }

    /**
     * Creates all the tiles and adds them to the flowPane.
     */
    public void addTilesToFlowPane() {
        flowPane.getChildren().clear();
        ArrayList<SingleListOfTiles> listOfTiles = mTileModel.getListOfTiles();
        for (int i = 0; i < listOfTiles.size(); i++) {
            for (int j = 0; j < listOfTiles.get(i).size(); j++) {
                try {
                    flowPane.getChildren().add(createTileNode(listOfTiles.get(i).get(j)));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    /**
     * Creates a node of a TileView.
     *
     * @return
     * @throws IOException
     */
    private Node createTileNode(Tile tile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minesweeper/gui/view/TileView.fxml"));
        Node node = loader.load();
        TileViewController controller = loader.getController();
        controller.setTile(tile);
        mTileViewControllerModel.addController(controller);
        tile.setController(controller);
        controller.setController(this);
        return node;
    }

    /**
     * Set the width of the flowPane.
     */
    private void setFlowPaneWidth() {
        flowPane.setMaxWidth(LENGTH_OF_TILE * TILES_PER_ROW);
        flowPane.setPrefWidth(LENGTH_OF_TILE * TILES_PER_ROW);
        flowPane.setMinWidth(LENGTH_OF_TILE * TILES_PER_ROW);
    }

    /**
     * Sets the controller.
     *
     * @param controller
     */
    public void setController(RootController controller) {
        mController = controller;
    }
}
