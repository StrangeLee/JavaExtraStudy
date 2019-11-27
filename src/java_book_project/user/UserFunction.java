package java_book_project.user;

import java_book_project.book.Book;
import java_book_project.book.BookFunction;
import java_book_project.console.Main;
import java_book_project.console.UserConsole;

import java.util.Scanner;

public class UserFunction {

    public static User [] user = new User[10];
    public static User selectedUser;

    public UserFunction() {

    }

    public UserFunction(String userName) {
        if (selectedUser == null) {
            for (User user:
                    user) {
                if (user.getName().equals(userName)) {
                    System.out.println("you are " + userName +"!!!!");
                    selectedUser = user;
                    userDoing();
                    break;
                } else {
                    continue;
                }
            }
            System.out.println("You are not user!!");
            new Main();
        } else {
            userDoing();
        }
    }

    public void userDoing() {
        Scanner sc = new Scanner(System.in);
        var inputData = 0;
        var inputString = "";
        System.out.println("hello " + selectedUser.getName());
        System.out.print("(1) 책 대출\n(2) 빌린 책 조회\n(3) 전체 책 조회\n(4) 메인\n");
        System.out.print("What are you doing? ");
        inputData = sc.nextInt();

        Scanner sc2 = new Scanner(System.in);
        switch (inputData) {
            case 1 :
                System.out.print("대출할 책의 번호를 검색하세요.(000형식): ");
                inputString = sc2.nextLine();
                BookFunction.borrowBook(inputString, selectedUser);
                userDoing();
                break;
            case 2:
                System.out.println(selectedUser.getName() + "님이 빌린 책은...");
                if (selectedUser.borrowCount != 0) {
                    for (int i = 0; i < selectedUser.borrowCount; i++) {
                        System.out.println(selectedUser.borrowBooks[i].getName());
                    }
                    System.out.println("입니다.");
                } else {
                    System.out.println("없습니다.");
                }
                userDoing();
                break;
            case 3:
                System.out.println("준비중입니다....");
                new UserConsole();
                break;
            case 4:
                new Main();
                break;
            default:
                System.out.println("옳지 않은 인식 입니다.");
                userDoing();
                break;
        }
    }

    public static void setUser() {
        var users = "james irving donovan jenny thompson curry harden westbrook durant jordan".split(" ");
        for (int i = 0; i < 10; i++) {
            user[i] = new User(users[i], i + 1, "address", "call");
        }
    }

}
