package lt.gzeska.traverse;

import lt.gzeska.NodesTraversal;
import lt.gzeska.Printer;

import java.util.Stack;

/**
 * Created by lt.gzeska on 21/04/2017.
 */
public class NotOrderedNodesTraversal implements NodesTraversal {

    private final Printer printer;

    private Stack<Node> stack = new Stack<>();

    public NotOrderedNodesTraversal(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void accept(Node node) {
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            for (Node child : current.getChildren()) {
                getPrinter().print(child);
                if (!child.isLeaf()) {
                    stack.push(child);
                }
            }
        }
    }

    @Override
    public Printer getPrinter() {
        return this.printer;
    }
}
