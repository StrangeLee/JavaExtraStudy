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

    // 배열로 했을 때 stack 클래스 와 같이 몇번째 위치인지를 반환 할 수 없음. 
    private int search(int item) {
        for (int i = 0; i < this.size; i++) {
            if (stack[i] == item)
                return (i + 1);
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
        System.out.println(stack.search(7));
        System.out.println(stack.empty()); // false 면 값이 있음, true 면 없음.
    }
}
