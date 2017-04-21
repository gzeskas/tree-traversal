package lt.gzeska.traverse

import spock.lang.Specification

/**
 * Created by lt.gzeska on 20/04/2017.
 */
class NodeTest extends Specification {

    def "shouldCheckIfNodeWithoutParentIsRoot"() {
        given:
            def node = new Node()
        when:
            boolean isRoot = node.isRoot()
        then:
            isRoot
    }

    def "shouldCheckIfNodeIsALeaf"() {
        given:
            def node = new Node()
        when:
            boolean isLeaf = node.isLeaf()
        then:
            isLeaf
    }

    def "shouldAddNewNodeAsLeafToParent"(){
        given:
            def root = new Node()
        when:
            def ipsum = root.add("Ipsum")
        then:
            ipsum.isLeaf()
            !root.isLeaf()
            root.isRoot()
    }

    def "shouldCreateNextRelationBetweenChildNodes"(){
        given:
            def root = new Node()
        when:
            def ipsum = root.add("Ipsum")
            def dolor = root.add("Dolor")
        then:
            ipsum.hasNext()
            !dolor.hasNext()
    }

}