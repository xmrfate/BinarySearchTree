public class BinarySearchTree {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();

        tree.insert_node(5);
        tree.insert_node(10);
        tree.insert_node(2);
        tree.insert_node(-2);
        tree.insert_node(3);
        tree.insert_node(7);
        tree.insert_node(12);

        tree.print();

        //node to hold the result
        Tree res;

        try {
            res = tree.search(0);
            System.out.println("\n\n" + res.data);
        } catch(NullPointerException e){
            System.out.println("\n\nElement was not found.");
        }


        //tree.remove(2);

        tree.remove(10);
        tree.remove(2);
        tree.remove(5);
        tree.print();

        tree.insert_node(19);
        tree.insert_node(25);
        tree.insert_node(-23);
        tree.insert_node(-45);
        tree.print();

    }

}
