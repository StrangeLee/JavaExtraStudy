package java_book_project.console;

import java_book_project.book.BookFunction;

import java.util.Scanner;

public class AdminConsole {

    public AdminConsole() {
        Scanner sc = new Scanner(System.in);
        int inputNum;

        System.out.println("--------------WELCOME Mr.ADMIN---------------");
        System.out.print("(1) 책 추가\n(2) 책 조회 \n(3) 메인으로\n(4) 종료\n");
        System.out.print("What are you doing? ");
        inputNum = sc.nextInt();
        new BookFunction(inputNum);
    }
}
