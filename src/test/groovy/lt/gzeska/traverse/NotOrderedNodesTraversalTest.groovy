package lt.gzeska.traverse

import lt.gzeska.Printer
import spock.lang.Specification

/**
 * Created by gzegoz.jurgo@ruptela.com on 17.4.21.
 */
class NotOrderedNodesTraversalTest extends Specification {
    def "shouldPrintAllRootNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new NotOrderedNodesTraversal(print)
            def tree = new Node()
            tree.add("Lorem")
            tree.add("Vitea")
        when:
            printer.accept(tree)
        then:
            2 * print.print(_)
    }

    def "shouldPrintAllChildNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new NotOrderedNodesTraversal(print)
            def tree = new Node()
            def lorem = tree.add("Lorem")
            lorem.add("first")
            lorem.add("second")
            when:
            printer.accept(tree)
        then:
            3 * print.print(_)
    }

    def "shouldPrintAllChildOfChildNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new NotOrderedNodesTraversal(print)
            def tree = new Node()
            def lorem = tree.add("Lorem")
            def first = lorem.add("first")
            first.add("first-1")
            first.add("first-2")
            def second = lorem.add("second")
        when:
            printer.accept(tree)
        then:
            5 * print.print(_)
    }

    def "shouldPrintAllTestNodes"() {
        given:
            def print = Mock(Printer)
            def printer = new NotOrderedNodesTraversal(print)
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
            11 * print.print(_)
    }
}
