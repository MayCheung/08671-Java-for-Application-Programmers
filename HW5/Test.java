
public class Test {
	public static void main(String[] args) {
		Directory d = new Directory();

    	Student s1 = new Student("terrylee");
    	s1.setFirstName("terry");
    	s1.setLastName("lee");
    	s1.setPhoneNumber("412-268-1078");
    	Student s2 = new Student("jle");
    	s2.setFirstName("jeff");
    	s2.setLastName("eppinger");
    	s2.setPhoneNumber("412-268-1474");
    	Student s3 = new Student("jerryhong");
    	s3.setFirstName("terry");
    	s3.setLastName("hong");
    	s3.setPhoneNumber("412-464-4756");
    	Student s4 = new Student("jeffhong");
    	s4.setFirstName("jeff");
    	s4.setLastName("hong");
    	s4.setPhoneNumber("412-456-7182");
    	Student s5 = new Student("jesslee");
    	s5.setFirstName("jessica");
    	s5.setLastName("lee");
    	s5.setPhoneNumber("412-465-7183");

    	System.out.println(s1);
    	System.out.println(s2);
    	System.out.println(s3);
    	System.out.println(s4);
    	System.out.println(s5);

    	d.addStudent(s1);
    	d.addStudent(s2);
    	d.addStudent(s3);
    	d.addStudent(s4);
    	d.addStudent(s5);
    	System.out.println(d.size());

    	// System.out.println(d.mapId);
    	// System.out.println(d.mapFirstName);
    	// System.out.println(d.mapLastName);

    	// System.out.println(d.searchByAndrewId(null));
    	// System.out.println(d.searchByAndrewId("terrylee"));
    	// System.out.println(d.searchByFirstName(null));
    	// System.out.println(d.searchByFirstName("tom"));
    	System.out.println(d.searchByFirstName("terry"));
    }
}