package lt.gzeska;

import lt.gzeska.traverse.Node;

/**
 * Created by lt.gzeska on 20/04/2017.
 */
public interface NodesTraversal {
    void accept(Node node);
    public Printer getPrinter();
}
