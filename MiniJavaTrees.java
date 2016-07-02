
/**
 * Main class.
 */
class TreeTest {

    public static void main(String[] args) {
        System.out.println(((new Test()).init()).test());
    }
}

/**
 * Ordered binary trees of integers with no duplicates. The empty tree is
 * considered to be ordered. A non-empty tree is ordered if all values in the
 * left sub-tree are less than the value at the top, all values in the
 * right-sub-tree are greater than the value at the top, and both sub-trees are
 * also ordered.
 */
class OrderedTree {

    // the data for this tree, or null if this tree is empty
    Node node;
    boolean full;
    OrderedTree leftTree;
    OrderedTree rightTree;
    int size;
    boolean hasLeft;
    boolean hasRight;

    /**
     * Initialise a newly created tree to be empty.
     *
     * @return this tree after initialisation
     */
    public OrderedTree init() {
        size = 0;
        return this;
    }

    /**
     * Is this tree empty?
     *
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        boolean isEmpty;
        if (full){
            isEmpty = false;
        }else{
        isEmpty = true;
    }
        return isEmpty;
    }

    public boolean left() {
        return hasLeft;
    }

    public boolean right() {
        return hasRight;
    }

    public Node getNode() {
        return node;
    }

    /**
     * Insert a value in order into the tree. If the tree already contains the
     * given value, the tree is not modified (so trees will never contain
     * duplicate values).
     *
     * @param v the value to insert
     * @return true if the tree was modified
     */
    public boolean insert(int v) {

        OrderedTree tree;
        boolean insert;
        int value;
        int valueOne;
        insert = false;
        
        if (this.isEmpty()) {
            node = new Node().init(v);
            insert = true;
            full = true;
        } else {
            value = node.getValue();
            valueOne = value + 1;
            if (v < value) {
                tree = node.getLeft();
                insert = tree.insert(v);
                if (insert) {
                    hasLeft = true;
                } else {

                }
            } else if (v < valueOne) {
                insert = false;
            } else {
                tree = node.getRight();
                insert = tree.insert(v);
                if (insert) {
                    hasRight = true;
                } else {

                }
            }
        }

        if (insert) {
            size = size + 1;
        } else {
        }

        return insert;
    }

    /**
     * The number of values in this tree.
     *
     * @return the number of values in this tree
     */
    public int size() {
        return size;
    }

    /**
     * An array containing the values in this tree in ascending order.
     *
     * @return the values in this tree in ascending order
     */
    public int addToArray(OrderedTree tree, int[] array, int pos) {
        
       OrderedTree tree_;
        Node node_;
        node_ = tree.getNode();
        if (tree.left()) {
            tree_ = node_.getLeft();
            pos = this.addToArray(tree_, array, pos);
        } else {

        }
        array[pos] = node_.getValue();
        pos = pos + 1;
        if (tree.right()) {
            tree_ = node_.getRight();
            pos = this.addToArray(tree_, array, pos);
        } else {

        }

        return pos;
    }

    public int[] toArray() {

        int[] array;
        int i;
        int sizeOne;
        int pos;
        OrderedTree tree;
        array = new int[size];
        i = 0;
        sizeOne = size + 1;
        tree = this;

        if (sizeOne < 2) {

        } else {
            pos = this.addToArray(tree, array, 0);
        }
        return array;
    }

    /**
     * Build a new ordered tree containing all the values from an array, minus
     * any duplicates. Note: this method does not use or modify the target tree,
     * so it could be a static method (but MiniJava does not support static
     * methods).
     *
     * @param array the array of values
     * @return a new ordered tree containing all the values, minus any
     * duplicates
     */
    public OrderedTree fromArray(int[] array) {

        OrderedTree newTree;
        int arrSize;
        int i;
        boolean insert;
        arrSize = array.length;
        i = 0;
        newTree = new OrderedTree().init();

        if ((arrSize + 1) < 2) {

        } else {
            while (i < arrSize) {
                insert = newTree.insert(array[i]);
                                i = i + 1;
            }
        }

        return newTree;
    }
}

/**
 * Data and methods to test the OrderedTree class.
 */
class Test {

    int[] testArray;

    /**
     * Initialise the test data.
     *
     * @return this Test object after initialisation
     */
    public Test init() {
        testArray = new int[5];
        testArray[0] = 23;
        testArray[1] = 0 - 7;
        testArray[2] = 1381;
        testArray[3] = 59;
        testArray[4] = 0 - 79;
        return this;
    }

    /**
     * Print all the values in an array in order from left to right, each value
     * on a separate line.
     *
     * @param a the array
     * @return 999
     */
    public int printArray(int[] a) {
        int i;
        i = 0;
        while (i < (a.length)) {
            System.out.println(a[i]);
            i = i + 1;
        }
        return 999;
    }

    /**
     * Carry out some tests.
     *
     * @return whatever is appropriate for the test
     */
    public int test() {
        int[] sorted;
        OrderedTree tree;
        tree = (new OrderedTree()).fromArray(testArray);
        sorted = tree.toArray();
        return this.printArray(sorted);
    }
}

/**
 * Nodes in an ordered tree of integers. DO NOT MODIFY THIS CLASS.
 */
class Node {

    // the value stored in this node
    int value;

    // the left and right sub-trees
    OrderedTree left;
    OrderedTree right;

    /**
     * Initialise a newly created node with a specified value and empty
     * sub-trees.
     *
     * @param v the value
     * @return this node after initialisation
     */
    public Node init(int v) {
        value = v;
        left = new OrderedTree();
        right = new OrderedTree();
        return this;
    }

    /**
     * The value stored in this node.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * The left sub-tree of this node.
     *
     * @return the left sub-tree
     */
    public OrderedTree getLeft() {
        return left;
    }

    /**
     * The right sub-tree of this node.
     *
     * @return the right sub-tree
     */
    public OrderedTree getRight() {
        return right;
    }

}
