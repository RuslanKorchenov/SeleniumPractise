package data;

public class DiaryData {
    String tag;
    String text;

    public DiaryData(){}
    public DiaryData(String tag, String text) {
        this.tag = tag;
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
