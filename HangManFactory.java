import java.util.*;
public class HangManFactory {
	
	public static void main(String[] args) {
		Hangman hang = new Hangman();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 'Hangman' to start game");
		String scx = sc.next();
		if(scx.equalsIgnoreCase("Hangman")) {
		   hang.game();
		}
		else {
			  //retrying the game if input is wrong
		System.out.println("Invalid input");
		System.out.println("Enter 'retry' to start game again");
		String sk = sc.next();
		if(sk.equalsIgnoreCase("retry")) {
		    System.out.println("Enter 'Hangman' to start game");
	    	String scg = sc.next();
		if(scg.equalsIgnoreCase("Hangman")) {
		   hang.game();
		}
		}
		}
	}
}