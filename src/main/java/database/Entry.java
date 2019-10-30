package database;

import javafx.beans.property.SimpleStringProperty;

/**
 * Entity class for the obscure table
 *
 * @author Janos Benyovszki
 */
public class Entry {

    //id is read-only as its a primary key and auto-incremented
    private SimpleStringProperty type;
    private SimpleStringProperty inputText;
    private SimpleStringProperty date;

    public Entry(String type, String inputText, String date) {
        this.type = new SimpleStringProperty(type);
        this.inputText = new SimpleStringProperty(inputText);
        this.date = new SimpleStringProperty(date);
    }

    public String getType() {
        return type.get();
    }

    public String getInputText() {
        return inputText.get();
    }

    public String getDate() {
        return date.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setInputText(String inputText) {
        this.inputText.set(inputText);
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
