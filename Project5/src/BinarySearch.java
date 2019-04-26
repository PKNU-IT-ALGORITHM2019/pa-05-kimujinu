import java.util.ArrayList;

public class BinarySearch {
	
	    int size = 0;
	    public Node root = null;

	    public void add(Node adder) {
	        Node t = root, preT = null;
	        boolean flag = false;
	        int diff;
	        if (t == null) {
	            root = adder;
	            size++;
	            return;
	        }
	        while (true) {
	            if (t == null) {
	                if (flag) preT.setLeft(adder);
	                else preT.setRight(adder);
	                size++;
	                return;
	            }
	            diff = adder.word.compareToIgnoreCase(t.word);
	            if (diff < 0) {
	                preT = t;
	                t = t.left;
	                flag = true;
	            } else {
	                preT = t;
	                t = t.right;
	                flag = false;
	            }

	        }
	    }

	    public ArrayList<Node> find(String keyword) {
	        ArrayList<Node> ret = new ArrayList<>();
	        Node t = root;
	        int diff;
	        while (true) {
	            if (t == null) return ret;
	            diff = keyword.compareToIgnoreCase(t.word);
	            if (diff < 0) t = t.left;
	            else if (diff > 0) t = t.right;
	            else {
	                ret.add(t);
	                t = t.right;
	            }
	        }
	    }

	    public void delete(String keyword, boolean mute) {
	        ArrayList<Node> dels = find(keyword);
	        boolean flag = false;
	        if (dels.size() == 0) {
	            if (!mute) System.out.println("Not found");
	            return;
	        }
	        while (dels.size() > 0) {
	            Node del = dels.get(0);
	            Node change = del.getMinRight();
	            if (change == null) change = del.getMaxLeft();
	            if (change == null) change = del;
	            else flag = true;
	            if (!del.equals(change)) del.replace(change);
	            if (flag && change.right != null) {
	                if (change.equals(change.parent.right)) {
	                    change.parent.setRight(change.right);
	                } else if (change.equals(change.parent.left)) {
	                    change.parent.setLeft(change.right);
	                }
	            } else if (!flag && change.left != null) {
	                if (change.equals(change.parent.right)) {
	                    change.parent.setRight(change.left);
	                } else if (change.equals(change.parent.left)) {
	                    change.parent.setLeft(change.left);
	                }
	            } else {
	                if (change.equals(change.parent.right)) {
	                    change.parent.setRight(null);
	                } else if (change.equals(change.parent.left)) {
	                    change.parent.setLeft(null);
	                }
	            }
	            dels = find(keyword);
	        }
	        if (!mute) System.out.println("Deleted Successfully.");
	    }
	}

