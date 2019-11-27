package java_book_project.user;

import java_book_project.book.Book;

import javax.xml.namespace.QName;

public class User {
    private String name;
    private int userNo;
    private String address;
    private String callNumber;

    public Book [] borrowBooks = new Book[3];
    public int borrowCount = 0;

    public User(String name, int userNo, String address, String callNumber) {
        this.name = name;
        this.userNo = userNo;
        this.address = address;
        this.callNumber = callNumber;
    }

    public void addBorrowBook(Book book) {
        if (borrowCount == 3) {
            System.out.println("책을 더 빌릴 수 없습니다.");
            return;
        } else {
            borrowBooks[borrowCount] = book;
            borrowCount++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
}
