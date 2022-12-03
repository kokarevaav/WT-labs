package task_12;

public class ProgrammerBook extends Book{

    private String language;
    private int level;

    public ProgrammerBook(String title, String author, int price, int isbn, String language, int level) {
        super(title, author, price, isbn);
        this.language = language;
        this.level = level;
    }

    @Override
    public int hashCode() {
        return (int) (super.hashCode() + Math.pow(level, 5));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        ProgrammerBook book = (ProgrammerBook) obj;
        return language.equals(book.language) &&
                level == book.level;
    }

    @Override
    public String toString() {
        return "ProgrammersBook{" +
                "title='" + super.getTitle() + '\'' +
                ", author='" + super.getAuthor() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", language="  + this.language + '\'' +
                ", level="  + this.level + '\'' +
                '}';
    }
}
