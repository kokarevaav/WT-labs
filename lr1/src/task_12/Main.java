package task_12;

import task_12.comparators.AuthorComparator;
import task_12.comparators.PriceComparator;
import task_12.comparators.TitleComparator;

import java.util.*;

public class Main {

    private static final Book book1 = new Book("Robinson Crusoe", "Daniel Defoe",22,2);
    private static final Book book2 = new Book("Clarissa", "Samuel Richardson",44,3);
    private static final Book book3 = new Book("Emma", "Jane Austen",33,1);

    private static List<Book> bookList = new ArrayList<>();

    private static final Comparator<Book> titleComparator = new TitleComparator();
    private static final Comparator<Book> titleAuthorComparator = new TitleComparator().thenComparing(new AuthorComparator());
    private static final Comparator<Book> authorTitleComparator = new AuthorComparator().thenComparing(new TitleComparator());
    private static final Comparator<Book> authorTitlePriceComparator = new AuthorComparator()
            .thenComparing(new TitleComparator())
            .thenComparing(new PriceComparator());

    public static void main(String[] args) {
        updateList();

        //title sort
        bookList.sort(titleComparator);
        System.out.println("Title sort");
        bookList.forEach(System.out::println);

        updateList();

        //title-author sort
        bookList.sort(titleAuthorComparator);
        System.out.println("title-author sort");
        bookList.forEach(System.out::println);

        updateList();

        //author-title sort
        bookList.sort(authorTitleComparator);
        System.out.println("author-title sort");
        bookList.forEach(System.out::println);

        updateList();

        //author-title-price sort
        bookList.sort(authorTitlePriceComparator);
        System.out.println("author-title-price sort");
        bookList.forEach(System.out::println);
    }

    private static void updateList(){
        bookList.clear();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
    }
}
