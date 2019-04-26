
public class Node {
	
	    String word;
	    public String wordClass, desc;
	    Node left, right, parent;

	    public void setLeft(Node target) {
	        if (target != null) target.parent = this;
	        left = target;
	    }

	    public void setRight(Node target) {
	        if (target != null) target.parent = this;
	        right = target;
	    }

	    public Node(String word, String wordClass, String desc) {
	        this.word = word;
	        this.wordClass = wordClass;
	        this.desc = desc;
	    }

	    @Override
	    public String toString() {
	        return word +" ("+ wordClass + ")" + desc;
	    }

	    public Node getMaxLeft() {
	        return left != null ? left.getRightRecursive() : null;
	    }

	    public Node getMinRight() {
	        return right != null ? right.getLeftRecursive() : null;
	    }

	    public Node getLeftRecursive() {
	        if (left != null) {
	            return left.getLeftRecursive();
	        } else {
	            return this;
	        }
	    }

	    public Node getRightRecursive() {
	        if (right != null)
	            return right.getRightRecursive();
	        else {
	            return this;
	        }
	    }

	    public void replace(Node target) {
	        word = target.word;
	        wordClass = target.wordClass;
	        desc = target.desc;
	    }
	}


