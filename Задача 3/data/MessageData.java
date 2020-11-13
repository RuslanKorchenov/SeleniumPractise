package data;

public class MessageData {
    String pageName;
    String text;

    public MessageData(String pageName, String text) {
        this.pageName = pageName;
        this.text = text;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
