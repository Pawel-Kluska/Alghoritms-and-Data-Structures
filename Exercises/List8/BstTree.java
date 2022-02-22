package glowny;

import java.util.NoSuchElementException;

public class BstTree<T>{

    private class Node {

        int key;
        Node left;
        Node right;
        Node parent;
        T value;

        public Node(int key, Node left, Node right, Node parent, T value) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    Node root=null;

    public void add(T value){

        boolean added = false;
        Node actNode;

        if(root == null){
            actNode = new Node(value.hashCode(), null, null, null, value);
            root = actNode;
            added=true;
        }
        else{
            actNode = root;

          while(!added){

                if(value.hashCode() < actNode.key){

                    if(actNode.left == null) {
                        Node newNode = new Node(value.hashCode(), null, null, actNode, value);
                        actNode.left = newNode;
                        added=true;
                    }
                    else
                        actNode = actNode.left;

                    }


                else if(value.hashCode() > actNode.key){
                    if(actNode.right == null){
                        Node newNode = new Node(value.hashCode(), null, null, actNode, value);
                        actNode.right = newNode;
                        added=true;
                    }
                    else
                        actNode = actNode.right;

                }
                else{

                    break;
                }
            }
        }
    }

    public void InOrderWalk(){
        InOrderWalk2(root);
    }

    private void InOrderWalk2(Node node){

        if(node!=null){
            InOrderWalk2(node.left);
            System.out.println(node.value);
            InOrderWalk2(node.right);
        }

    }

    private Node findValue(T value){

        Node actNode= root;

            while(actNode!=null){

                if(actNode.key == value.hashCode()) {
                    return actNode;
                }

                else if(value.hashCode() < actNode.key){
                        actNode = actNode.left;
                }

                else if(value.hashCode() > actNode.key){
                        actNode = actNode.right;
                }

            }
            return null;
    }

    private Node findMin(Node actNode){


        while(actNode.left!=null){
            actNode=actNode.left;
        }
        return actNode;
    }

    private Node findMax(Node actNode){

        while(actNode.right!=null){
            actNode=actNode.right;
        }
        return actNode;
    }

    public T showMin(){
        Node min = findMin(root);

        if(min!=null)
        return min.value;

        throw new NoSuchElementException();
    }

    public T showMax(){
        Node max = findMax(root);
        if(max!=null)
        return max.value;

        throw new NoSuchElementException();
    }

    public T showNext(T value){

        Node node = findValue(value);
        node = findNext(node);
        if(node != null)
        return node.value;
        throw new NoSuchElementException();
    }

    private Node findNext(Node node){

        if(node.right!=null){
            return findMin(node.right);
        }

        Node par = node.parent;

        while(par != null && node == par.right){
            node = par;
            par = par.parent;
        }
        return par;
    }

    private void remove1(Node remNode){

        Node del;
        Node child;

        if(remNode.left == null || remNode.right == null)
            del = remNode;
        else
            del = findNext(remNode);

        if(del.left != null)
            child = del.left;
        else
            child = del.right;

        if (child != null)
            child.parent = del.parent;

        if(del.parent == null)
            root = child;
        else if(del == del.parent.left)
            del.parent.left = child;
        else
            del.parent.right = child;

        if(del != remNode)
            swap(del,remNode);
    }

    private void swap(Node node1, Node node2){

        int key = node1.key;
        T value = node1.value;

        node1.key=node2.key;
        node1.value=node2.value;

        node2.key=key;
        node2.value=value;
    }

    public void remove(T value){
        Node rem = findValue(value);
        if(rem!=null)
            remove1(rem);
        else throw new NoSuchElementException();
    }

    public boolean contains(T value){

        Node actNode= root;

        while(actNode!=null){

            if(actNode.key == value.hashCode()) {
                return true;
            }

            else if(value.hashCode() < actNode.key){
                actNode = actNode.left;
            }

            else if(value.hashCode() > actNode.key){
                actNode = actNode.right;
            }

        }
        return false;

    }
}