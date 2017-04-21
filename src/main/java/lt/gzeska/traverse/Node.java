package lt.gzeska.traverse;

import lt.gzeska.NodesTraversal;
import lt.gzeska.PrintableNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lt.gzeska on 20/04/2017.
 */
public class Node implements PrintableNode {
    private Node parent;
    private String data;
    private Node next;
    private List<Node> children;

    public Node() {
        this.data = null;
        this.parent = null;
        this.next = null;
        this.children = new ArrayList<>();
    }

    private Node(String data, Node parent) {
        this.data = data;
        this.parent = parent;
        this.next = next;
        this.children = new ArrayList<>();
    }

    boolean hasNext() {
        return this.next != null;
    }

    Node getNext() {
        return this.next;
    }

    private void setNext(Node next) {
        this.next = next;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public Node add(String data) {
        Node child = new Node(data, this);
        //Additional property for non recursive traversal.
        if (this.children.size() > 0 ) {
            this.children.get(this.children.size() -1).setNext(child);
        }
        this.children.add(child);
        return child;
    }

    public String getData() {
        return data;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void accept(NodesTraversal traversal) {
        traversal.accept(this);
    }
}
