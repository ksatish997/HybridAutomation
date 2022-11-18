package examples;

public class VargsDemo {

	public static void main(String[] args) {
	
		fun(1,1,1,1,1);

	}
	
	public static void fun(int ... a) 
	{
	  
		for(int i=0;i<a.length;i++)
		{
			System.out.println("let's have fun...");
		}
	}

}
