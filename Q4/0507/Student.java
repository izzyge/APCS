public abstract class Student{
	private String name;
	private int age;

	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String toString(){
		return name + " " + age + " " + getSchool();
	}

	public int getAge(){
		return age;
	}

	public abstract String getSchool();
}
