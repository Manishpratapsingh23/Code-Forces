interface A{
	void show();
	void config();
	String place = "Mathura";
}

interface B{
	int age = 44;
	void run();
}

interface C extends B{
	void run();
}

class abc implements A,C{
	public void show(){ System.out.println("IN SHOW"); }
	public void config(){ System.out.println("IN CONFIG"); }
	public void run(){ System.out.println("IN RUN"); }
}

class x{
	public void showData(){
		System.out.println("int x");
	}
}

class y extends x{
	@Override
	public void showData(){
		System.out.println("int y");
	}
}

public class Demo{
	public static void main(String[] args) {
		// A obj = new abc();
		// obj.show();
		// obj.config();
		// System.out.println(obj.place);
		// B obj1 = new abc();
		// C obj2 = new abc();
		// System.out.println(obj1.age);
		// System.out.println(obj2.age);
		// obj2.run();
		y obj =  new y();
		obj.showData();

	}
}