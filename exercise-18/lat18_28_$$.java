/*
(Nonrecursive directory size) Rewrite Listing 18.7, DirectorySize.java, without
using recursion.

This program works by using linked list like data structure
Every File is considered a new node that need to be analyzed before removed.
When new FIle is found it is added to the end of list.
*/

import java.io.File;
import java.util.Scanner;

public class lat18_28_$$ {
	public static void main(String[] args) {
		// Prompt the user to enter a directory or a file
		System.out.print("Enter a directory or a file: ");
		Scanner in = new Scanner(System.in);
		String directory = in.nextLine();
		in.close();

		// Display the size
		System.out.println(getSize(new File(directory)) + " bytes");
	}

	public static long getSize(File file) {
		long size = 0; // Store the total size of all files

		// creating a head of the list
		LinkedListFile currentNode = new LinkedListFile(null);

		// linking the head
		currentNode = currentNode.link(new LinkedListFile(file));

		// keep checking current node if there is a previous node (this node is not the
		// head)
		while (currentNode.prev != null) {
			if (currentNode.value.isDirectory()) {
				// get all files and subdirectories in current directory
				File[] files = currentNode.value.listFiles();

				// go to parent node because this node is checked
				currentNode = currentNode.prev;

				// link files that was found to the list
				for (int i = 0; files != null && i < files.length; i++) {
					currentNode = currentNode.link(new LinkedListFile(files[i]));
				}
			} else {
				System.out.println(currentNode.value.getName());
				size += currentNode.value.length();

				// point to the previous node
				currentNode = currentNode.prev;
			}
		}

		return size;
	}
}

/**
 * Linked list node that stores File object as a value
 */
class LinkedListFile {
	File value;
	LinkedListFile prev; // track previous node

	LinkedListFile(File value) {
		this.value = value;
	}

	// link this node to a target node and return target node that linked to this
	// node
	LinkedListFile link(LinkedListFile node) {
		node.prev = this;
		return node;
	}
}