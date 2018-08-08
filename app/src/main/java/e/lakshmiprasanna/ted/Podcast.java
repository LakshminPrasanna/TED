package e.lakshmiprasanna.ted;

public class Podcast {
    private int image;
    private String textView;
    private String textView2;

    public int getImage() {
        return image;
    }

    public String getTextView() {
        return textView;
    }

    public String getTextView2() {
        return textView2;
    }

    public Podcast(int image, String textView, String textView2)
{
    this.image = image;
    this.textView = textView;
    this.textView2 = textView2;
}
}
