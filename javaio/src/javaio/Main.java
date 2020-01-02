package javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamTokenizer;

class User implements Serializable {

	private static final long serialVersionUID = 777680457965754246L;

	private String name;
	private String email;
	private int id;

	User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}

}

public class Main {

	public static void main(String[] args) {

		Main m = new Main();
		try {
			m.deSerialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

	void serialize() throws IOException {
		String fileName = "user.dat";
		User u = new User(1, "ashish", "ashish@gmail.com");
		try (FileOutputStream fOut = new FileOutputStream(fileName)) {
			ObjectOutputStream objOut = new ObjectOutputStream(fOut);
			objOut.writeObject(u);
		}
	}

	void deSerialize() throws IOException, ClassNotFoundException {
		String fileName = "user.dat";
		User u = null;
		try (FileInputStream fIn = new FileInputStream(fileName)) {
			ObjectInputStream objIn = new ObjectInputStream(fIn);
			u = (User) objIn.readObject();
			System.out.println(u);
		}
	}

	boolean checkForWord(String word) throws IOException {

		String fileName = "D:\\lorem.txt";

		StreamTokenizer st = new StreamTokenizer(new FileReader(fileName));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			if (st.ttype == StreamTokenizer.TT_WORD) {
				if (st.sval.trim().toLowerCase().equals(word.trim().toLowerCase())) {
					return true;
				}
			}
		}
		return false;

	}

	void writeDataAsChar() throws IOException {

		String fileName = "D:\\javaiochar.txt";

		try (FileWriter writer = new FileWriter(fileName, true)) {
			writer.write("Writing from char file streams".toCharArray());
		}
	}

	void readDataAsChar() throws IOException {
		String fileName = "D:\\javaiochar.txt";
		String data = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			data = reader.readLine();
			while (data != null) {
				System.out.println(data);
				data = reader.readLine();
			}
		}
	}

	void writeDataAsBytes() throws IOException {

		String fileName = "D:\\javaio.txt";

		try (FileOutputStream outStream = new FileOutputStream(fileName, true)) {
			outStream.write("One more line of data.".getBytes());
		}

	}

	void readDataAsBytes() throws IOException {

		String fileName = "D:\\javaio.txt";

		try (FileInputStream inStream = new FileInputStream(fileName)) {
			int data = inStream.read();
			while (data != -1) {
				System.out.print((char) data);
				data = inStream.read();
			}
		}

	}

}
