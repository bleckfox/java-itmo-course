package courseWorks.courseWork2.newVersion_08062023.Commands;

import courseWorks.courseWork2.newVersion_08062023.Paragraph;

public class DisplayCommand implements ICommand{
    private Paragraph paragraph;

    public DisplayCommand setParagraph(Paragraph paragraph){
        this.paragraph = paragraph;
        return this;
    }

    @Override
    public void execute() {
        paragraph.display();
    }
}
