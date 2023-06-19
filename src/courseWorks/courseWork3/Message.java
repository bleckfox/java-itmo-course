package courseWorks.courseWork3;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private final String text;
    private LocalDateTime sent;

    public Message(String text) { this.text = text; }

    public void setSent(LocalDateTime sent) { this.sent = sent; }

    public LocalDateTime getSent() {
        return sent;
    }

    public String getText() {
        return text;
    }

}
