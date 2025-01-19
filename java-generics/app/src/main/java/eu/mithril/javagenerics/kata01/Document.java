package eu.mithril.javagenerics.kata01;


public class Document {

    private String title;
    private String content;
    private boolean isConfidential;

    public Document(String title, String content, boolean isConfidential) {
        this.title = title;
        this.content = content;
        this.isConfidential = isConfidential;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isConfidential() {
        return isConfidential;
    }

}