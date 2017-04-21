package lt.gzeska;

import lt.gzeska.traverse.Node;

/**
 * Created by lt.gzeska on 20/04/2017.
 */
public interface Printer {

    default void print(Node node) {
        if (!node.isRoot()) {
            write(node);
        }
    }

    public default void write(Node node) {
        System.out.println(node.getData());
    }
}
