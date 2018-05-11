package gui.layout;

import app.SCFunctionTypes;
import app.ShadowCaster;
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
    private TextArea outputTxtField;

    @FXML
    private TextArea inputTxtArea;

    public void initialize() {
        shadowCaster = new ShadowCaster();
    }

    @FXML
    private void keyHandle(KeyEvent event) {

        System.out.println("Pressed " + event.getText());
    }

    @FXML
    private void obscure() {
        outputTxtField.setText(shadowCaster.execute(inputTxtArea.getText(), SCFunctionTypes.OBSCURE));
    }

    @FXML
    private void reveal() {
        outputTxtField.setText(shadowCaster.execute(inputTxtArea.getText(), SCFunctionTypes.REVEAL));
    }

}
