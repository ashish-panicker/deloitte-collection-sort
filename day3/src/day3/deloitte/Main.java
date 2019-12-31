package day3.deloitte;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		/*
		 * DataManager manager = new DataManager();
		 * 
		 * manager.add(new Teacher(2, "Prem", "prem@gmail.com")); manager.add(new
		 * Teacher(4, "Anjali", "anjali@gmail.com")); manager.add(new Teacher(3,
		 * "Ratna", "ratna@gmail.com")); manager.add(new Teacher(1, "Ashish",
		 * "ashish@gmail.com"));
		 * 
		 * System.out.println("Before sorting..."); manager.print();
		 * 
		 * System.out.println("After email sort..."); manager.emailSort();
		 * manager.print();
		 * 
		 * System.out.println("After default sort..."); manager.defaultSort();
		 * manager.print();
		 * 
		 * System.out.println("After name sort..."); manager.nameSort();
		 * manager.print();
		 */

		/*
		 * // List<String> artists = new ArrayList<>(); // List<String> goldenArtists =
		 * new ArrayList<>(); // // goldenArtists.add("R D Burman"); //
		 * goldenArtists.add("Lakshmikant Pyarelal"); //
		 * goldenArtists.add("Bappi Lahri"); // // artists.add("A R Rahman"); //
		 * artists.add("Pritam"); // artists.add(0, "Vishal Shekhar"); // // for(String
		 * artist : artists) { // System.out.println(artist.toUpperCase()); // } // //
		 * Iterator<String> itr = artists.iterator(); // while(itr.hasNext()) { //
		 * String artist = itr.next(); // System.out.println(artist.toLowerCase()); // }
		 */

		/*
		 * Deque<String> d = new LinkedList<String>(); d.add("5"); d.addFirst("1");
		 * d.addLast("9"); d.push("7"); d.offer("8"); d.offerFirst("6");
		 * d.offerLast("2"); System.out.println("The deque is: " + d);
		 * System.out.print("\nDequeue using standard Iterator: "); Iterator i =
		 * d.iterator(); while (i.hasNext()) { System.out.print(i.next() + " "); }
		 * System.out.println("\n\nUsing peek, the element at head of the deque is: " +
		 * d.peek()); System.out.println("The deque after peek: " + d); System.out.
		 * println("\nUsing pop, the element removed from the head of the deque is: " +
		 * d.pop()); System.out.println("The deque after pop: " + d);
		 * System.out.println("\nDoes the deque contain element 8: " + d.contains("8"));
		 * d.removeFirst(); d.removeLast();
		 * System.out.println("\nDeque after removing the first and last elements is: "
		 * + d);
		 */
		
		Shape s = new Circle();
		s.info();

	}

}
