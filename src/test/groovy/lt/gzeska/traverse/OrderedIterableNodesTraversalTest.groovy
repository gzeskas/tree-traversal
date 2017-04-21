package lt.gzeska.traverse

import lt.gzeska.Printer
import spock.lang.Specification

/**
 * Created by lt.gzeska on 20/04/2017.
 */
class OrderedIterableNodesTraversalTest extends Specification {

    def "shouldPrintAllRootNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new OrderedIterableNodeTraversal(print)
            def tree = new Node()
            tree.add("Lorem")
            tree.add("Vitea")
        when:
            printer.accept(tree)
        then:
            3 * print.print(_)
    }

    def "shouldPrintAllChildNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new OrderedIterableNodeTraversal(print)
            def tree = new Node()
            def lorem = tree.add("Lorem")
            lorem.add("first")
            lorem.add("second")
        when:
            printer.accept(tree)
        then:
            4 * print.print(_)
    }

    def "shouldPrintAllChildOfChildNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new OrderedIterableNodeTraversal(print)
            def tree = new Node()
            def lorem = tree.add("Lorem")
            def first = lorem.add("first")
            first.add("first-1")
            first.add("first-2")
            def second = lorem.add("second")
        when:
            printer.accept(tree)
        then:
            6 * print.print(_)
    }

    def "shouldPrintAllTestNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new OrderedIterableNodeTraversal(print)
            def tree = new Node()
            def lorem = tree.add("Lorem")
            lorem.add("Ipsum")
            def dolor = lorem.add("Dolor")
            dolor.add("Orci")
            def sit = tree.add("Sit")
            sit.add("Amet")
            def con = sit.add("Consectetur")
            con.add("Adipiscing")
            con.add("Elit")
            sit.add("Vestibulum")
            tree.add("Vitea")
        when:
            printer.accept(tree)
        then:
            12 * print.print(_)
    }
}
