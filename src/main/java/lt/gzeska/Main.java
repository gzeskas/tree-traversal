package lt.gzeska;

import lt.gzeska.printer.SystemOutPrinter;
import lt.gzeska.traverse.Node;
import lt.gzeska.traverse.NotOrderedNodesTraversal;
import lt.gzeska.traverse.OrderedIterableNodeTraversal;
import lt.gzeska.traverse.RecursiveNodesTraversal;

/**
 * Created by lt.gzeska on 20/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        Printer print = new SystemOutPrinter();
        NodesTraversal recursiveTraversal=  new RecursiveNodesTraversal(print);
        NodesTraversal orderedIterableTraversal=  new OrderedIterableNodeTraversal(print);
        NodesTraversal notOrderedIterableTraversal=  new NotOrderedNodesTraversal(print);

        Node tree = new Node();
        Node lorem = tree.add("Lorem");
        lorem.add("Ipsum");
        Node dolor = lorem.add("Dolor");
        dolor.add("Orci");
        Node sit = tree.add("Sit");
        sit.add("Amet");
        Node con = sit.add("Consectetur");
        con.add("Adipiscing");
        con.add("Elit");
        sit.add("Vestibulum");
        tree.add("Vitea");

        System.out.println("-----RECURSIVE----");
        recursiveTraversal.accept(tree);
        System.out.println("-----ITERATIVE ORDERED----");
        orderedIterableTraversal.accept(tree);
        System.out.println("-----ITERATIVE NOTORDERED----");
        notOrderedIterableTraversal.accept(tree);
    }
}
