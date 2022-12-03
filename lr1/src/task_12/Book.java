package task_12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book implements Cloneable, Comparable<Book>{
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    @Override
    public int compareTo(Book book) {
        return this.isbn - book.isbn;
    }

    @Override
    public int hashCode() {
        return (int) (Math.pow(price, 4) + Math.sin(edition) * 150);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                price == book.price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", edition=" + edition +
                '}';
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

}


