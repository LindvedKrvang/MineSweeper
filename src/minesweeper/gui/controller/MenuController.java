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

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class MenuController implements Initializable {

    private RootController mController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlePlayButton(ActionEvent event) {
        mController.startGame();
    }

    @FXML
    private void handleExitButton(ActionEvent event) {
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
