import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class StringTree {

	
	Node root;

	
	StringTree() {
		root = null;
	}

	
	Node addNode(Node root, String value) {


		if (root == null) {
			root = new Node(value);
			return root;
		}


		if (value.compareToIgnoreCase(root.value) < 0) {
			root.left = addNode(root.left, value);

		}

		else if (value.compareToIgnoreCase(root.value) > 0) {
			root.right = addNode(root.right, value);
		}
		
		return root;
	}

	void insert(String value) {
		root = addNode(root, value);
	}

	
	public static void printTree(Node root) {
		System.out.println(root.value + " ");
	}

	
	void orderValue(Node root) {

		if (root != null) {
			orderValue(root.left);
			printTree(root);
			orderValue(root.right);
		}
	}

	void treeins(String[] arr) {

		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}

	}

	// Test Program
	public static void main(String[] args) throws FileNotFoundException {

		StringTree tree = new StringTree();
		File file = new File("C:\\Users\\corey\\SchoolRepositories\\week8StringTree\\src\\input.txt");
		Scanner scn = new Scanner(System.in);
		int size = 0;

		System.out.println("Press 1 if you would like to enter strings into the program manually or 2 to scan the input file automatically");

		int select = scn.nextInt();

		switch (select) {
		case 1:
			
			System.out.println("How many values would you like to manually add and sort?");
			size = scn.nextInt();
			String[] arr = new String[size];
			System.out.println("Enter the string values you wish to store and sort, pressing enter between values.");
			for (int i = 0; i < size; i++)
			{
				arr[i] = scn.next();
				System.out.println(Arrays.toString(arr));
			}
			
			tree.treeins(arr);
			tree.orderValue(tree.root);
			
			
			break;
			
		case 2:
			String[] arr1 = new String[81];
			Scanner scanman = new Scanner(file);

			while (scanman.hasNextLine() != false) {
				for (int i = 0; i < arr1.length; i++) {
					arr1[i] = scanman.nextLine();
					
				}
			}
				System.out.println(Arrays.toString(arr1));

				tree.treeins(arr1);

				tree.orderValue(tree.root);
				
				printTree(tree.root);
			break;
		}
		

	}
}
