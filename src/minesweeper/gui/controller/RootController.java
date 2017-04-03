/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class RootController implements Initializable {

    @FXML
    private BorderPane borderPane;

    private Node mMenu;

    public RootController() {
        try {
            mMenu = createMenuNode();
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borderPane.setCenter(mMenu);
    }

    /**
     * Creates the node for the menu.
     *
     * @return
     * @throws IOException
     */
    private Node createMenuNode() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minesweeper/gui/view/Menu.fxml"));
        Node node = loader.load();
        MenuController controller = loader.getController();
        controller.setController(this);
        return node;
    }

    /**
     * Creates the node for the gameboard.
     *
     * @return
     * @throws IOException
     */
    private Node createGameBoardNode() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minesweeper/gui/view/GameBoardView.fxml"));
        Node node = loader.load();
        GameBoardViewController controller = loader.getController();
        controller.setController(this);
        return node;
    }

    public void startGame() {
        try {
            borderPane.setCenter(createGameBoardNode());
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
