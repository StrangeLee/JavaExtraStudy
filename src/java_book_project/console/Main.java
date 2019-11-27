package java_book_project.console;

import java_book_project.book.BookFunction;
import java_book_project.user.UserFunction;

import java.util.Scanner;

public class Main {

    public Main() {
        Scanner sc = new Scanner(System.in);
        int inputNum; // Scanner 의 값을 받을 변수

        // 시작
        System.out.println("---------WELCOME TO JAVA LIBRARY---------");
        System.out.print("(1) 관리자 \n(2) 유저 \n(3) 종료\n");
        System.out.print("What are you doing? : ");
        inputNum = sc.nextInt();
        if (inputNum == 1) {
            new AdminConsole();
        } else if (inputNum == 2){
            new UserConsole();
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        new UserFunction().setUser();
        new BookFunction().setBooks();
        new Main();
    }
}
