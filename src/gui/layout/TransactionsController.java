package gui.layout;

import app.SCFunctionTypes;
import app.ShadowCaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TransactionsController {

    private ShadowCaster shadowCaster;

    @FXML
    private Label footerMsgLabel;

    @FXML
    private TextArea outputTxtField;

    @FXML
    private TextArea inputTxtArea;

    @FXML
    private Button revBtn;

    @FXML
    private Label footerTimeLabel;

    @FXML
    private Button obscBtn;

    @FXML
    private Button transactionBtn;

    public void initialize() {
        shadowCaster = new ShadowCaster();
    }


    @FXML
    void showTransactions(ActionEvent event) {
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
