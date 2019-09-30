package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Program that implements binary tree
 * 
 * @author Karlo Lochert
 *
 */

public class UniqueNumbers {
	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right ;
		public TreeNode(int value) {
			this.value = value;
	    }
	}
	
	/**
	 * Adds given value into tree
	 * 
	 * @param glava
	 * @param value
	 * @return
	 */
	public static TreeNode addNode(TreeNode glava, int value) {
		if (glava == null) {
			return new TreeNode(value);
		}
		if (!containsValue(glava,value)) {
			if (value > glava.value) {
					glava.right =  addNode(glava.right,value);
			}else if (value < glava.value){
					glava.left =  addNode(glava.left,value);
			}
		}
		return glava;
	}
	/**
	 * Returns size of a tree
	 * 
	 * @param glava
	 * @return
	 */
	public static int treeSize(TreeNode glava) {
		if (glava == null) {
			return 0;
		}
		
		return 1 + treeSize(glava.left) + treeSize(glava.right);
	}
	/**
	 * Returns is given value in tree
	 * 
	 * @param glava
	 * @param value
	 * @return
	 */
	
	public static boolean containsValue(TreeNode glava, int value) {
		if (glava == null) {
			return false;
		}
		if (glava.value == value) {
			return true;
		}
		if (value < glava.value) {
			return containsValue(glava.left,value);
		}
		
		return containsValue (glava.right,value);
	}
	/**
	 * Returns sorted elements of tree depending on the condition
	 * 
	 * @param glava
	 * @param uvjet
	 */
	public static void SortiraniIspis(TreeNode glava,int uvjet){
		if (glava == null) {
			return;
		}
		if (uvjet == 1) {
			SortiraniIspis(glava.left,uvjet);
			System.out.print(glava.value + " ");
			SortiraniIspis(glava.right,uvjet);
		}
		else if (uvjet == 0) {
			SortiraniIspis(glava.right,uvjet);
			System.out.print(glava.value + " ");
			SortiraniIspis(glava.left,uvjet);
		}
	}
	/**
	 * Expects adding nodes in shape of integers until "kraj" is typed
	 * @param args
	 */
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode glava = null;
		String unos;
		do {
			System.out.println("Unesite broj > ");
			unos = sc.nextLine();
			try { 
				Integer.parseInt(unos);
			}catch (Exception e) {
				if (unos.equals("kraj")){
					break;
				}
				System.out.println("'" + unos + "'" + " nije cijeli broj.");
				continue;
			}
			if (containsValue(glava,Integer.parseInt(unos))) {
				System.out.println("Broj već postoji. Preskačem.");
				continue;
			}
			glava = addNode(glava,Integer.parseInt(unos));
			System.out.println("Dodano.");
		}while(!unos.equals("kraj"));
		System.out.println("Doviđenja.");
		sc.close();
		
		System.out.print("Ispis od najmanjeg: ");	
		SortiraniIspis(glava,1);
		System.out.println("");
		System.out.print("Ispis od najvećeg: ");
		SortiraniIspis(glava,0);
	}
	
}
