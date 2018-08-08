package e.lakshmiprasanna.ted;

public class Product {
    private int id;
    private int image;
    private String textView;
    private String textView2;

    public String getTextView3() {
        return textView3;
    }

    private String textView3;

    public String getTextView() {
        return textView;
    }

    public String getTextView2() {
        return textView2;
    }

    public int getImage() {
        return image;
    }



    public Product(int id, int image,String textView,String textView2,String textView3)
    {
        this.id = id;
        this.image = image;
        this.textView = textView;
        this.textView2 = textView2;
        this.textView3 = textView3;
    }
}
