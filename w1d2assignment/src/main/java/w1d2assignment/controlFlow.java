package w1d2assignment;

public class controlFlow {

	public static void main(String[] args) {
	
		controlFlow cF = new controlFlow();
		System.out.println(cF.printNumberInWord(-2));
		System.out.println(cF.reverse("testing"));

	}

	public String printNumberInWord(int num) {

		switch (num) {
		case 0:
			return "ZERO";
		case 1:
			return "ONE";
		case 2:
			return "TWO";
		case 3:
			return "THREE";
		case 4:
			return "FOUR";
		case 5:
			return "FIVE";
		case 6:
			return "SIX";
		case 7:
			return "SEVEN";
		case 8:
			return "EIGHT";
		case 9:
			return "NINE";
		default:
			return "OTHER";

		}
	}

	
	public String reverse(String string) {
		char[] array = string.toCharArray();
		char[] rever = new char[array.length];
		int point = array.length-1;
		for(int i = 0; i < array.length;i++) {
			rever[i] = array[point-i];
		}
		String result = new String(rever);
		return result;
	}
}
//Write a method called printNumberInWord. The method has one parameter number
//which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
//... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
//for any other number including negative numbers. You can use if-else
//statement or switch statement whatever is easier for you.
//
//Signature:
//public String printNumberInWord(int number) {
//		// TODO Write an implementation for this method declaration
//		
//		return ;
//	}
//
//Reverse String
//
//Without using the StringBuilder or StringBuffer class, write a method that
//reverses a String. Example: reverse("example"); -> "elpmaxe"
//
//Signature:
//public String reverse(String string) {
//		// TODO Write an implementation for this method declaration
//		
//		return;
//	}
