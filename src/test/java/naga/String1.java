package naga;

public class String1 {

	public static void main(java.lang.String[] args) {
		String a = "java,selenium,automation";
		
		
		String[] b =a.split(",");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
