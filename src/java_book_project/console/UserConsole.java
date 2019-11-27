package java_book_project.console;

import java_book_project.user.UserFunction;

import java.util.Scanner;

public class UserConsole {

    public UserConsole() {
        Scanner sc = new Scanner(System.in);
        var userName = "";

        System.out.println("-----------WELCOME Mr.USER------------");
        System.out.print("Who are you? ");
        userName = sc.nextLine();
        new UserFunction(userName);
   }

}
