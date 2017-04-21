package lt.gzeska.traverse;

import lt.gzeska.NodesTraversal;
import lt.gzeska.Printer;

/**
 * Created by lt.gzeska on 20/04/2017.
 */
public class RecursiveNodesTraversal implements NodesTraversal {

    private final Printer printer;

    public RecursiveNodesTraversal(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void accept(Node node) {
        getPrinter().print(node);
        for (Node child : node.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public Printer getPrinter() {
        return this.printer;
    }
}
