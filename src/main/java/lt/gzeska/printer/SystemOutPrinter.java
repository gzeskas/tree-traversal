package lt.gzeska.printer;

import lt.gzeska.Printer;
import lt.gzeska.traverse.Node;

/**
 * Created by lt.gzeska on 21/04/2017.
 */
public class SystemOutPrinter implements Printer {
    @Override
    public void write(Node node) {
        System.out.println(node.getData());
    }
}
