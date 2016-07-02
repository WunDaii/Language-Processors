/**
 * Main class.
 */
class TreeTest {

    public static void main(String[] args) {
        System.out.println(((new Test()).init()).test());
    }
}
/**
 * Ordered binary trees of integers with no duplicates.
 * The empty tree is considered to be ordered.
 * A non-empty tree is ordered if all values in the left sub-tree are less than
 * the value at the top, all values in the right-sub-tree are greater than
 * the value at the top, and both sub-trees are also ordered.
 */
class OrderedTree {

    // the data for this tree, or null if this tree is empty
    Node node;

    /**
     * Initialise a newly created tree to be empty.
     * @return this tree after initialisation
     */
    public OrderedTree init() {
        return this;
    }

    /**
     * Is this tree empty?
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        return node == null;
    }
    
    /**
     * Insert a value in order into the tree.
     * If the tree already contains the given value, the tree is not modified (so
     * trees will never contain duplicate values).
     * @param v the value to insert
     * @return true if the tree was modified
     */
    public boolean insert(int v) {
        if (isEmpty()) {
            this.node = new Node().init(v);
            return true;
        } else if (v < node.getValue()) {
            this.node.left.insert(v);
        } else if (v > node.getValue()) {
            this.node.right.insert(v);
        }
        
        return false;
    }
    
    /**
     * The number of values in this tree.
     * @return the number of values in this tree
     */
    public int size() {
        return size(this);
    }
    
    private int size(OrderedTree tree) {
        if (tree.isEmpty()) {
            return 0;
        } else {
            return (size(tree.node.getLeft()) + size(tree.node.getRight()) + 1);
        }
    }
    
    /**
     * An array containing the values in this tree in ascending order.
     * @return the values in this tree in ascending order
     */
    public int[] toArray() {
        
        int size = size();
        int[] array = new int[size];
        
        if (size > 0){
            addToArray(this, array, 0);
        }
        
        return array;
    }
    
    int addToArray(OrderedTree tree, int [] array, int pos) {
        if (!tree.node.getLeft().isEmpty()) {
            pos = addToArray(tree.node.getLeft(), array, pos);
        }
        array[pos++] = tree.node.getValue();
        if (!tree.node.getRight().isEmpty()) {
            pos = addToArray(tree.node.getRight(), array, pos);
        }
        return pos;
    }
    
    /**
     * Build a new ordered tree containing all the values from an array, minus
     * any duplicates.
     * Note: this method does not use or modify the target tree, so it could
     * be a static method (but MiniJava does not support static methods).
     * @param array the array of values
     * @return a new ordered tree containing all the values, minus any
     * duplicates
     */
    public OrderedTree fromArray(int[] array) {
        
        OrderedTree tree = new OrderedTree().init();
        
        for (int v : array) {
            tree.insert(v);
        }
        
        return tree;
    }
}

/**
 * Data and methods to test the OrderedTree class.
 */
class Test {

    int[] testArray;

    /**
     * Initialise the test data.
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
 * Nodes in an ordered tree of integers.
 * DO NOT MODIFY THIS CLASS.
 */
class Node {

    // the value stored in this node
    int value;
    
    // the left and right sub-trees
    OrderedTree left;
    OrderedTree right;

    /**
     * Initialise a newly created node with a specified value and
     * empty sub-trees.
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
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * The left sub-tree of this node.
     * @return the left sub-tree
     */
    public OrderedTree getLeft() {
        return left;
    }

    /**
     * The right sub-tree of this node.
     * @return the right sub-tree
     */
    public OrderedTree getRight() {
        return right;
    }

}
