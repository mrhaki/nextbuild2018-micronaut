package nextbuild;

public class Message {
    private String text;

    public Message() {
        
    }

    public Message(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
