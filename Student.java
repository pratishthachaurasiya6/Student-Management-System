	package StudentManagement;

	public class Student {

	    private int id;
	    private String name;
	    private String course;
	    private String city;
	    private int totalMarks;
	    private String phone;

	    // Constructors
	    public Student() {}

	    public Student(String name, String course, String city, int totalMarks, String phone) {
	        this.name = name;
	        this.course = course;
	        this.city = city;
	        this.totalMarks = totalMarks;
	        this.phone = phone;
	    }

	    // Getters & Setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getName() { return name; }
	    public String getCourse() { return course; }
	    public String getCity() { return city; }
	    public int getTotalMarks() { return totalMarks; }
	    public String getPhone() { return phone; }
	}
