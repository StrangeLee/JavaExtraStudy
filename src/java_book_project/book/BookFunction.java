package java_book_project.book;

import java_book_project.console.AdminConsole;
import java_book_project.console.Main;
import java_book_project.user.User;
import java_book_project.user.UserFunction;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BookFunction {

    static Book [] books = new Book[120];
    static NovelBook [] novelBooks = new NovelBook[30];
    static PoemBook [] poemBooks = new PoemBook[30];
    static SportsBook [] sportsBooks = new SportsBook[30];
    static OtherBook [] otherBooks = new OtherBook[30];

    public static int novelCount = 0;
    public static int poemCount = 0;
    public static int sportsCount = 0;
    public static int otherCount = 0;
    public static int bookCount = 0;

    public BookFunction() {}

    public BookFunction(int mode) {
        if (mode == 1) {
            Scanner sc = new Scanner(System.in);
            String inputString = "";

            System.out.println("책의 정보를 입력해 주세요.");
            System.out.print("책 카테고리 (poem, novel, history, other 중 입력): ");
            inputString = sc.nextLine();
            addBook(inputString);
        } else if (mode == 2) {
            Scanner sc = new Scanner(System.in);
            String inputString = "";

            System.out.print("원하는 책의 제목을 입력해주세요 : ");
            inputString = sc.nextLine();
            showBook(inputString);
        } else if (mode == 3) {
            new Main();
        } else if (mode == 4) {
            return;
        } else {
            System.out.println("입력값이 잘못 되었습니다.");
            new AdminConsole();
        }
    }

    // 책 빌리기
    public static void addBook(String category) {
        Scanner sc = new Scanner(System.in);
        var bookName = "";

        switch (category) {
            case "novel" :
                System.out.print("책 제목 : ");
                bookName = sc.nextLine();
                novelBooks[novelCount] = new NovelBook(new DecimalFormat("000").format(bookCount + 1), bookName);
                System.out.println("소설 카테고리의 " + novelBooks[novelCount].getBookNumber() + "번, "
                        + novelBooks[novelCount].getName());
                System.out.println("책이 추가되었습니다.");

                books[bookCount] = novelBooks[novelCount];
                bookCount++;
                novelCount++;
                break;
            case "poem" :
                System.out.print("책 제목 : ");
                bookName = sc.nextLine();
                poemBooks[poemCount] = new PoemBook(new DecimalFormat("000").format(bookCount + 1), bookName);
                System.out.println("시 카테고리의 " + poemBooks[poemCount].getBookNumber() + "번, "
                        + poemBooks[poemCount].getName());
                System.out.println("책이 추가되었습니다.");

                books[bookCount] = poemBooks[poemCount];
                bookCount++;
                novelCount++;
                break;
            case "sports" :
                System.out.print("책 제목 : ");
                bookName = sc.nextLine();
                sportsBooks[sportsCount] = new SportsBook(new DecimalFormat("000").format(bookCount + 1), bookName);
                System.out.println("스포츠 카테고리의 " + sportsBooks[sportsCount].getBookNumber() + "번, "
                        + sportsBooks[sportsCount].getName());
                System.out.println("책이 추가되었습니다.");

                books[bookCount] = sportsBooks[sportsCount];
                bookCount++;
                sportsCount++;
                break;
            case "other" :
                System.out.print("책 제목 : ");
                bookName = sc.nextLine();
                otherBooks[otherCount] = new OtherBook(new DecimalFormat("000").format(bookCount + 1), bookName);
                System.out.println("기타 카테고리의 " + otherBooks[otherCount].getBookNumber() + "번, "
                        + otherBooks[otherCount].getName());
                System.out.println("책이 추가되었습니다.");

                books[bookCount] = otherBooks[otherCount];
                bookCount++;
                otherCount++;
                break;
            default:
                System.out.print("입력 값이 잘못 되었습니다.");
                new BookFunction(1);
        }
        System.out.println("addBook 종료");
        new AdminConsole();
    }

    // 책 조회
    public static void showBook(String bookName) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getName().equals(bookName)) {
                System.out.println(bookName + " 책이 존재합니다.");

                if (books[i].isBorrow == true) {
                    System.out.println("이 책은 " + Book.sdf.format(books[i].cal) + "에 대여가 되었습니다.");
                } else {
                    System.out.println("이 책은 대여가 가능합니다.");
                }
                new AdminConsole();
                break;
            }
        }
        System.out.println("책이 존재하지 않습니다.");
        new BookFunction(2);
    }

    // 책 대출
    public static void borrowBook(String bookNum, User user) {
        Scanner sc = new Scanner(System.in);
        var inputString = "";
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookNumber().equals(bookNum)) {
                if (books[i].isBorrow == false) {
                    System.out.println("이 책은 빌릴 수 있습니다.");
                    System.out.print(books[i].getName() + " 책을 빌리겠습니까? (yes or no) ");
                    inputString = sc.nextLine();
                    if (inputString.equals("yes")) {
                        user.addBorrowBook(books[i]);
                        new UserFunction().userDoing();
                    } else {
                        break;
                    }
                } else {
                    System.out.println("이 책은 빌릴 수 없습니다.");
                }
            }
        }
    }

    // 기본 데이터 생성
    public static void setBooks() {
        var bookNames = "조던의 역사, 조선왕조실록, 세계사, 노인과 바다, 지킬앤 파이드".split(", ");
        for (int i = 0; i < 5; i++) {
            novelBooks[novelCount] = new NovelBook(new DecimalFormat("000").format(bookCount + 1), bookNames[i]);
            System.out.println("소설 카테고리의 " + novelBooks[novelCount].getBookNumber() + "번, "
                    + novelBooks[novelCount].getName());
            System.out.println("책이 추가되었습니다.");

            books[bookCount] = novelBooks[novelCount];
            bookCount++;
            novelCount++;
        }
    }

    // 대출된 책 현황
    public static void printCounts() {
        System.out.println("현재 빌릴 수 있는 책 수: " + bookCount);
        System.out.println("소설 책 수: " + novelCount);
        System.out.println("시 책 수: " + poemCount);
        System.out.println("스포츠 책 수: " + sportsCount);
        System.out.println("기타 책 수: " + otherCount);
    }

    public static void main(String[] args) {
        new AdminConsole();
    }
}
