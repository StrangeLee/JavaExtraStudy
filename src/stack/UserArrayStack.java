package stack;

/**
 * 배열로 구현하는 Stack
 * 편의를 위해 각 함수들을 void 타입으로 선언했음.
 */
public class UserArrayStack {

    int top;
    int [] stack;
    int size;

    public UserArrayStack(int size) {
        this.size = size; //
        stack = new int[size];
        top = -1; // top 의 값 초기화
    }

    private void push(int item) {
        stack[++top] = item;
        System.out.println(stack[top] + " push!");
    }

    private void peek() {
        System.out.println(stack[top] + " peek!");
    }

    private void pop() {
        System.out.println(stack[top] + " pop!");
        stack[top--] = 0;
    }

    private int search(int item) {
        for (int i = 0; i <= top; i++) { // for 문은 top 만큼
            if (stack[i] == item)
                return (top - i) + 1; // top - 탐색한 배열의 인덱스, 배열 이므로 +1 추가
        }
        return -1;
    }

    private boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        UserArrayStack stack = new UserArrayStack(10);

        for (int i = 0; i < 5; i++) {
            stack.push(i + 1); // stack 에 데이터 삽입
        }
        stack.pop(); // 최근에 추가한 데이터 삭제
        stack.peek();
        System.out.println(stack.search(4));
        System.out.println(stack.empty()); // false 면 값이 있음, true 면 없음.
    }
}
