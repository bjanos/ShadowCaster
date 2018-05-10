package main.java.gui.layout;

import main.java.app.SCFunctionTypes;
import main.java.app.ShadowCaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

/**
 * @author Janos Benyovszki
 */
public class TransactionsController {

    private ShadowCaster shadowCaster;

    @FXML
    private Label footerMsgLabel;

    @FXML
    private TextArea outputTxtField;

    @FXML
    private TextArea inputTxtArea;

    public void initialize() {
        shadowCaster = new ShadowCaster();
    }

    @FXML
    void keyHandle(KeyEvent event) {

        System.out.println("Pressed " + event.getText());
    }

    @FXML
    void obscure() {
        outputTxtField.setText(shadowCaster.execute(inputTxtArea.getText(), SCFunctionTypes.OBSCURE));
    }

    @FXML
    void reveal() {
        outputTxtField.setText(shadowCaster.execute(inputTxtArea.getText(), SCFunctionTypes.REVEAL));
    }

}
