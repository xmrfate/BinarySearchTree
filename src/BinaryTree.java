public class BinaryTree {

    private Tree root;

    public void remove(int target){
        Tree c = new Tree();
        Tree res = new Tree();
        c = root;

        res = delete_node(c, target);
    }

    private Tree delete_node(Tree c, int target) {
        if(c==null){
            return c;
        }

        if(target < c.data){
            c.lchild = delete_node(c.lchild, target);
        } else if(target > c.data) {
            c.rchild = delete_node(c.rchild, target);
        } else{ //node is found

            //no child
            if(c.lchild==null && c.rchild==null){
                c = null;
            } else if(c.lchild==null) {
                c = c.rchild;
            } else if(c.rchild==null) {
                c = c.lchild;
            }
            else{ //two children
                System.out.println("Two children case");
                Tree temp;

                temp = min_value_left(c.rchild);

                c.data = temp.data;

                //delete min value node
                c.rchild = delete_node(c.rchild, temp.data);
            }
        }

        return c;
    }

    public Tree min_value_left(Tree t) {
        if(t.lchild==null){
            return t;
        } else{
            return min_value_left(t.lchild);
        }
    }

    public void insert_node(int target){
        Tree current = new Tree();
        Tree prev = new Tree();
        Tree temp = new Tree();

        temp.lchild = null;
        temp.rchild = null;
        temp.data = target;

        //if tree is empty
        if(root==null){
            root = temp;
            temp = null;
        } else{
            current = root;

            while(current!=null){
                prev = current;

                if(target < current.data){
                    current = current.lchild;
                } else{
                    current = current.rchild;
                }
            }

            //insertion point is found
            if(target < prev.data){
                prev.lchild = temp;
            } else {
                prev.rchild = temp;
            }
        }
    }

    public Tree search(int target) {
        Tree res;

        res = search_tree(target);

        return res;
    }

    private Tree search_tree(int target) {
        Tree current = new Tree();

        current = root;

        while(current!=null && current.data!=target){
            if(target < current.data){
                current = current.lchild;
            } else{
                current = current.rchild;
            }
        }

        return current;
    }

    public void print() {
        Tree c = new Tree();
        c = root;

        System.out.println("Pre-order print: ");
        preorder_print(c);

        System.out.println("\n\nInorder print: ");
        inorder_print(c);

        System.out.println("\n\nPost-order print: ");
        postorder_print(c);
    }

    private void preorder_print(Tree t) {
        if(t==null){
            return;
        }

        System.out.print(t.data + " ");
        preorder_print(t.lchild);
        preorder_print(t.rchild);
    }

    private void inorder_print(Tree t){
        if(t==null){
            return;
        }

        inorder_print(t.lchild);
        System.out.print(t.data + " ");
        inorder_print(t.rchild);
    }

    private void postorder_print(Tree t){
        if(t==null){
            return;
        }

        postorder_print(t.lchild);
        postorder_print(t.rchild);
        System.out.print(t.data + " ");
    }

}
