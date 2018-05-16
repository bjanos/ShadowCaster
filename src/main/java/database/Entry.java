package database;

/**
 * Entity class for the obscure table
 *
 * @author Janos Benyovszki
 */
public class Entry {

    //id is read-only as its a primary key and auto-incremented
    private int id;
    private String type;
    private String inputText;
    private String outputText;
    private String Date;

    public Entry(String type, String inputText, String outputText, String date) {
        this.type = type;
        this.inputText = inputText;
        this.outputText = outputText;
        Date = date;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    String getInputText() {
        return inputText;
    }

    String getDate() {
        return Date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    public void setDate(String date) {
        Date = date;
    }
}
