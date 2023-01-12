import java.util.*;
import java.util.Scanner;
public class Hangman implements HangmanMethod{

	static Scanner sc;
  static char input;
	static String words = "";
  static String replacedWords;
	static int max;
	static int count;
	static String name = "";
	static String get;
	static String newVariable = "";
	static boolean guessinword;
	static char[] gameEnds;
	 
	@Override
public void game() {
	     
		    //intializing and adding secretwords to the string array
		String[] guess = {
		   "rain","pure","wet","batman","drainage",
		   "toyota","rolls","assert","volatile",
		   "client","security","rock","clothes","samsung",
		   "transient","game","hangman","java","driver","manager",
		   "guesses","trials","pasta","serialized","brown","white",
		   "bag","thermopile","platinum","resistance","hostage",
		   "puzzle","rubix","cube","electroscope"};

		 gameEnds = new char[]{
		 'G','A','M','E',' ',' ',
			'E','N','D','S'
		 };
		
		 Random r = new Random();

		
	    words = guess[r.nextInt(35)];
		    //Our Guessed Word
		  words = words.toUpperCase();

		
	    System.out.println();
	    System.out.println("     WELCOME TO HANGMAN GAME     \n");
		  System.out.println("       let's play the game         \n");
	    System.out.println();
	    System.out.println("You Are Required To Enter Your Guess In UpperCase");
		
		
		System.out.println("NB: If A Duplicate Charcater is found the computer will input the character itself,\n       if you enter the duplicate character.");
		System.out.println("HINT: Does Word Has Duplicate: "+isDuplicate());
		System.out.println("Make Sure You Enter The Duplicate Character In Your Guesses");
		int min = 0;
		//since.there is no word with length of a million so we set the maximum value to a million.
		max =Math.max(1_000_000 ,min);
		
		
		//gameBoard(*****)
		replacedWords = new String(new char[words.length()]).replace("\0","*");

		 
		
		   System.out.println();
		   sc = new Scanner(System.in);
		   System.out.println("To Play Game. \nEnter Your Name Player:");
		   name = sc.next();
		   if(!name.equals(null)) {
		   System.out.println("Welcome Player "+name);
		   System.out.println("Make Sure You Read The Game Rules Above");
			 
			     //loop iterates maximum amount of trial)
 		  for(count = 0; count < max; count++) {
		   System.out.println(replacedWords);
		   System.out.println("Enter Your Guess:");
		   input = sc.next().charAt(0);
			 
				
				//calling methods
			   gameBoard();
		     Present();
		     checkWins();
			   hangmanImage(count);	
								
		 }
	}
}
	
		 //this checks and prints if a player win or lose
  @Override
public void checkWins() {
   if(words.equals(replacedWords)) {
	  System.out.println("Correct!,You Win, Well Played You Did It. \n      The Secretword was "+words);
			addEmoji();	
			//we set the maximum value to zero in order to end the loop.
			  max = 0;
		    end();
			    }
		   }  
	 //prints hangman image if input is wrong
  @Override
public void hangmanImage(int track) {
	if (track == 0 && !active()) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("_|_");
			   
		    }
	if (track == 1 && !active()) {
			System.out.println("Wrong guess, try again");   	
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("_|_");
		}
		if (track == 2 && !active()) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("_|_");
		}
		if (track == 3 && !active()) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____");
			System.out.println("   |          |");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("_|_");
		}
		 if (track == 4 && !active()) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____");
			System.out.println("   |          |");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
	   
		 }if (track == 5 && !active()) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____");
			System.out.println("   |          |");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("_|_      /   \\");
		}
		if (track == 6 && !active() && !words.equals(replacedWords)) {
			System.out.println("GAME OVER!");
			System.out.println("   ____");
			System.out.println("   |          |");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          |");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("_|_      /   \\");
			System.out.println("GAME OVER! The word was " + words);
			System.out.println(
				"YOU LOST!, maximum limit of incorrect guesses reached!");
			  
			//we set the maximum value to zero in order to end the loop.
			
			   max = 0;
			   end();
			    
		  }
		}
	  /*code here make sure our input
	  is at the right position of our gameBoard("*****")*/
 @Override
public void gameBoard() { 
     
     int position = words.indexOf(input);
	  int lastIndex = words.length()-1;
	  for(int i = 0; i < words.length();i++) {
		
	  if(replacedWords.contains("*") && i == position) {
		 StringBuilder buildgame = new StringBuilder(replacedWords);
		  buildgame.setCharAt(i, input);
  
		 String value = buildgame.toString();

		 newVariable = value;
		 replacedWords = newVariable;

		 String output = value;
		 
	     System.out.println(output);
		 
 
		     /*this code here make sure duplicate characters are
			   in the right position of our gameBoard(******)*/
		  if(replacedWords.contains("*") && (count == lastIndex) && isDuplicate()) {
			 
			  
			  char[] player = words.toCharArray();
			  for(int k = 0; k < player.length; k++) {
				  for(int j = k+1; j < player.length; j++) {
					  if(player[k] == player[j]) {
						  boolean vIn = replacedWords.contains("*");
						  if(true) {
						  char vOut = (char)(vIn?1:0); 
                           vOut = player[j];
						   buildgame.setCharAt(j,vOut);
						   
						   String sk = buildgame.toString();
						   
						   newVariable = sk;
						   replacedWords = newVariable;
						   
						   get = sk;
						   System.out.println("Duplicate Character is added to the guessed word.\n"+get);
						   break;
						   }
						   break;
					  }
				  }
			  }
		  }
	  }
   }
}	
    // check if the input is active
  @Override
public boolean active() {
		guessinword = words.indexOf(input) != -1;
		if(guessinword == true) {
			return true;
		}
		else {
		 return false;
	}
}

   //check if input is present in the guessed words
  @Override
public void Present() {
		if(active() == true) {
			System.out.println(input+" is present in word"); 
		} else {
			System.out.println(input+" is not present in word");
	}
}

    //Prints out an emoji if a player wins
 @Override
public void addEmoji() {
	
	String a =  ".--..--..--..--..--..--.";
  String b =  ".'  \"+ (`._   (_)     _   \"";
	String c =  ".'    |  '._)         (_)  |";
	String d = "\')\"+      .----..---.   /";
	String f =  "|(_.'  |    /    .-\"/.  \"+  |";
	String g =  "\"0|    |   ( O| O) | o|";
	String h =  "|  _  |    .--.____.'._.-.  |";
	String i =  "\" | o         -` .-`  |";
  String j =  "|    \"+   |`-._ _ _ _ _\"+/";
  String k =  "\"+   |   |  `. |_||_|   |";
  String l =  "| o  |    \"+      \"+    |     -.   .-. HURRAY YOU WON!!!";
  String m =  "|.-.  \"+    `--..-'   O |     `.`-' .'";
  String n = 	"_.'  .' |     `-.-'      /-.__   ' .-'";
	String o =  ".' `-.` '.|='=.='=.='=.='=|._/_ `-'.'";
	String p =  "`-._  `.  |________/\"+____|    `-.'";
	String q =  ".'   ).| '=' '='\"+ '=' |";
	String r =  "`._.`  '---------------'";
	String s=   "//___\"+  //___\"";
	String t=   "||       ||";
  String u =  "LGB  ||_.-.   ||_.-.";
	String v =  "(_.--__) (_.--__) ";
	
	System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n"+f+"\n"+g+"\n"+h+"\n"+i+"\n"+j+"\n"+k+"\n"+l+"\n"+m+"\n"+n+"\n"+o+"\n"+p+"\n"+q+"\n"+r+"\n"+s+"\n"+t+"\n"+u+"\n"+v);
}

// check if there is a duplicate in guessed words
  @Override
public boolean isDuplicate() {
	char[] player = words.toCharArray();
	for(int i = 0; i < player.length; i++) {
		for(int j = i+1; j < player.length; j++) {
			if(player[i] == player[j]) {
			     return true;
				}
				else {
					}
				}
			}
				return false;
			 	  }
				  
	//Prints Out Duplicate Character in guessed words
   @Override
public char Duplicate() {
	char[] player = words.toCharArray();
 for(int i = 0; i < player.length; i++) {
		for(int j = i+1; j < player.length; j++) {
			if(player[i] == player[j]) {
			return player[j];
		} else {
			}
		}
	}
			return '*';
		}
	//printing out the gameend array
  @Override
public void end() {
 for(char c : gameEnds) {
		 System.out.print(c);
			try{
			  Thread.sleep(700);
			}
			catch(Exception e) {
			}
			}
			System.out.println();
	    System.out.println("Thanks For Playing our game,Enjoy Playing!");
	    }
   }
