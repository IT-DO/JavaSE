package Java_Core.Annotations.AnnotationsTest;

import lombok.Getter;
import lombok.Setter;


public class Book {
    private String name;
    private String author;
    @XmlElement(name = "book")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        AnnotationAnalizator analizator = new AnnotationAnalizator();
        analizator.analize(Book.class);

    }
}
