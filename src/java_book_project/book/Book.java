package java_book_project.book;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 책의 Data class
 * 생성자를 통해 기본적인 Book 의 정보들을 임시 저장하고
 * BookFunction 의 배열을 통해 각 카테고리 별로 책의 정보들을 저장한다.
 */
public class Book {

    public static final int NOVEL_NO = 0;
    public static final int POEM_NO = 1;
    public static final int SPORTS_NO = 2;
    public static final int OTHER_NO = 3;
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private int bookValue;
    private String bookNumber;
    private String name;
    public boolean isBorrow = false;
    public Calendar cal;

    public Book() {

    }

    public Book(int bookValue, String bookNumber, String name) {
        this.bookValue = bookValue;
        this.bookNumber = bookNumber;
        this.name = name;
    }

    public void borrowBook() {
        isBorrow = true;
        cal = Calendar.getInstance();
        System.out.println("책을 빌렸습니다.");
    }

    public int getBookValue() {
        return bookValue;
    }

    public void setBookValue(int bookValue) {
        this.bookValue = bookValue;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
