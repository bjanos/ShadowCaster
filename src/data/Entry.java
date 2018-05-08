package data;

/**
 * Entity class for the obscure table
 */
class Entry {

    //id is read-only as its a primary key and auto-incremented
    private int id;
    private String type;
    private String inputText;
    private String outputText;
    private String Date;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getInputText() {
        return inputText;
    }

    public String getOutputText() {
        return outputText;
    }

    public String getDate() {
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
