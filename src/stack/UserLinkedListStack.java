package stack;

public class UserLinkedListStack {

    Node top;

    public UserLinkedListStack() {
        this.top = null;
    }

    private void push(int data) {
        Node node = new Node(data);
        node.linkNode(top);
        top = node;
    }

    public int peek() {
        return top.getData();
    }

    private void pop() {
        if (empty())
            throw new ArrayIndexOutOfBoundsException();
        else {
            top = top.getNextNode();
        }
    }

    private int search(int item) {
        Node searchNode = top;
        int index = 1;
        while(true) {
            if (searchNode.getData() == item) {
                return index;
            } else {
                searchNode = searchNode.getNextNode();
                index ++;
                if (searchNode == null)
                    break;
            }
        }

        return -1;
    }

    private boolean empty() {
        return top == null;
    }

    public static void main(String[] args) {
        UserLinkedListStack stack = new UserLinkedListStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
        System.out.println(stack.peek() + " peek!");
        stack.pop();
        System.out.println(stack.peek() + " peek!");
        System.out.println(stack.search(6));
        System.out.println(stack.empty());
    }
}
