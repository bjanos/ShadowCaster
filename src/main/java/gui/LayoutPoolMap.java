package gui;

/**
 * Mapping for the panes in the pane pool generated by the
 * LayoutManager.
 *
 * @author Janos Benyovszki
 * @see LayoutManager
 */
public interface LayoutPoolMap {

    int FRAME = 0;
    int START = 1;
    int TRANSACTIONS = 2;
    int DATA = 3;

    //TODO enum class instead of Strings - multiple strings can be mixed now

    /*
    * Resource bundles can be in format text/[name], as the ResourceBundle
    * class looks for the in the resources folder. For fxml this does not
    * work as the LayoutManager uses getClass(), it only goes up to gui.
    *
    * Using classloader sets the relative path to target/classes/, then
    * getResources returns the fxml if the path is fxml/[name]
    * */
    String FRAME_LOCATION = "fxml/Frame.fxml";
    String FRAME_RESOURCE_LOCATION = "text/Frame_en";
    String TRANSACTION_LOCATION = "fxml/Transactions.fxml";
    String TRANSACTION_RESOURCE_LOCATION = "text/Transactions_en";
    String DATA_LOCATION = "fxml/Data.fxml";
    String DATA_RESOURCE_LOCATION = "text/Data_en";

}
