package lt.gzeska.traverse;

import lt.gzeska.NodesTraversal;
import lt.gzeska.Printer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lt.gzeska on 21/04/2017.
 */
public class OrderedIterableNodeTraversal implements NodesTraversal {

    private final Printer printer;
    private Stack<Node> stack = new Stack<>();

    public OrderedIterableNodeTraversal(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void accept(Node parent) {
        stack.push(parent);
        while (!stack.isEmpty()) {
            int childSize = parent.getChildren().size();
            int traversedChildCount = 0;
            for (int i=0; i < childSize; i++) {
                Node child = parent.getChildren().get(i);
                getPrinter().print(child);
                if (!child.isLeaf()) {
                    addNextNodesToStack(child);
                    parent = child;
                    break;
                }
                traversedChildCount++;
            }
            if (traversedChildCount == childSize) {
                parent = stack.pop();
                getPrinter().print(parent);
            }
        }
    }

    @Override
    public Printer getPrinter() {
        return this.printer;
    }

    private void addNextNodesToStack(Node node) {
        //Use list to put nodes in reversed order to stack.
        LinkedList<Node> nodes = new LinkedList<>();
        while (node.hasNext()) {
            nodes.addFirst(node.getNext());
            node = node.getNext();
        }
        nodes.forEach(stack::push);
    }
}
