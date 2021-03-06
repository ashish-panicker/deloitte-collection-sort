package deloitte.day2;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student(1,"Ashish", 
				"ashish@gmail.com", 1);
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("rahul");
		s2.setEmail("rahul@mail.com");
		
		Student s3 = new Student(1,"Ashish", 
				"ashish@gmail.com", 1);
		
		Student [] studentsArray = new Student[3];
		
		studentsArray[0] = s1;
		studentsArray[1] = s2;
		studentsArray[2] = s3;
		
		try {
			checkStudent(s1);
		} catch (InvalidAgeException e) {
			System.err.println("An error occurred.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
//		System.out.println(s1);
	
	}
	
	public static void checkStudent(Student s) throws InvalidAgeException{
		if(s.getAge() <18) {
			throw new InvalidAgeException("Student age cannot be less than 18.");
		}
	}
	
	public static void add(int... arr) {
		int sum = 0;
		System.out.println("Length = " + arr.length);
		for(int a  : arr) {
			sum += a;
		}
		System.out.println("Sum = "  + sum);
	}

}
