import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;



public class Program {
	public static void main(String[] args){
		System.out.println(stringValidator(read()));
	}
	
	public static String read(){
		System.out.println("reading");
		StringBuilder builder = new StringBuilder();
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			builder.append(scanner.nextLine());
		}
		System.out.println("the lines are read.");
		return builder.toString();
	}
	
	public static Map<Character,Character> braces;
	
	static {
		braces=new HashMap<Character,Character>();
		braces.put(')','(');
		braces.put('}','{');
		braces.put(']','[');
		braces.put('>','<');
		
	}
	
	public static boolean stringValidator(String s){
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			Character c=s.charAt(i);
			System.out.println("the char is "+c);
			if (braces.values().contains(c)){
				System.out.println("pushed");
				stack.push(c);
			}
			if(braces.keySet().contains(c)){
				System.out.println("poppp");
				if(stack.isEmpty()){
					System.out.println("I got no more braces! ((");
					return false;
				}
				Character lastBrace=stack.pop();
				if(!lastBrace.equals(braces.get(c))){
					System.out.println("Aaaand its not equal");
					return false;
				}
				System.out.println("Aaaaaand its equal");
			}	
		}
		if(!stack.isEmpty()){
			System.out.println("Oh god! Need more braces!");
			return false;
		}
		return true;
	}
}
