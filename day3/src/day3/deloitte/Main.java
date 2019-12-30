package day3.deloitte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		DataManager manager = new DataManager();
		
		manager.add(new Teacher(1, "Ashish", "ashish@gmail.com"));
		manager.add(new Teacher(2, "Prem", "prem@gmail.com"));
		manager.add(new Teacher(4, "Anjali", "anjali@gmail.com"));
		manager.add(new Teacher(3, "Ratna", "ratna@gmail.com"));
				
		System.out.println("Before sorting...");
		manager.print();
		
		System.out.println("After default sort...");
		manager.defaultSort();
		manager.print();
		
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
		
	}

}
