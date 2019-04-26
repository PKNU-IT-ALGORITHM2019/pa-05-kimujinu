import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	    public BinarySearch BST = new BinarySearch();
	    public String[] words = new String[3];

	    public static void main(String[] args) {
	        Main main = new Main();
	        main.addAll("shuffled_dict.txt");
	        while (true) {
	        	Scanner scan = new Scanner(System.in);
	        	System.out.print("$: ");
	        	String reply = scan.next();
	            if(reply.equals("add")) {
	                    scan.nextLine();
	                    System.out.print("word : ");
	                    main.words[0] = scan.nextLine();
	                    System.out.print("class : ");
	                    main.words[1] = scan.nextLine();
	                    System.out.print("meaning : ");
	                    main.words[2] = scan.nextLine();
	                    main.BST.add(new Node(main.words[0], main.words[1], main.words[2]));
	            }else if(reply.equals("delete")) {
	            	main.BST.delete(scan.next(), false);
	            }else if(reply.equals("find")) {
	                    ArrayList<Node> tT = main.BST.find(scan.next());
	                    if (tT.size() <= 0)
	                        System.out.println("Not found");
	                    else for (Node t : tT)
	                        System.out.println(t);
	            }else if(reply.equals("deleteall")) {
	            	main.deleteAll(scan.next());
	            }else if(reply.equals("size")) {
	                    System.out.printf("", main.BST.size);
	            }else if(reply.equals("exit")) {
	            	System.exit(0);
	            }
	            }
	    }
	    public Node read(Scanner scanner) {
	        String t = scanner.nextLine();
	        words[0] = t.substring(0, t.indexOf('(') - 1);
	        words[1] = t.substring(t.indexOf('(') + 1, t.lastIndexOf(')'));
	        words[2] = t.substring(t.lastIndexOf(')') + 1);
	        return new Node(words[0], words[1], words[2]);
	    }

	    public void addAll(String path) {
	        Scanner fScanner;
	        try {
	            fScanner = new Scanner(new File(path));

	            int count = 0;
	            while (fScanner.hasNext()) {
	                BST.add(read(fScanner));
	                count++;
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Not found");
	        }
	    }

	    public void deleteAll(String path) {
	        Scanner fScanner;
	        try {
	            fScanner = new Scanner(new File(path));

	            int count = 0;
	            while (fScanner.hasNext()) {
	                BST.delete(fScanner.nextLine(), true);
	                count++;
	            }
	            System.out.println(count + "Deleted Successfully.");
	        } catch (FileNotFoundException e) {
	            System.out.println("Not found");
	        }
	    }
	}
