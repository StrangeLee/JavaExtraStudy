package stack;

public class Node {

    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    protected void linkNode(Node node) {
        this.nextNode = node;
    }

    protected int getData() {
        return this.data;
    }

    protected Node getNextNode() {
        return this.nextNode;
    }
}
