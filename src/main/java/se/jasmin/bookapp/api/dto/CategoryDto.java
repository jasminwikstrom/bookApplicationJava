package se.jasmin.bookapp.api.dto;

public class CategoryDto {




        private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "text='" + text + '\'' +
                '}';
    }
}
