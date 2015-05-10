import java.util.*;
import java.io.*;

public class WordTree{

	private WordTreeNode root;

	public WordTree(){
		root = new WordTreeNode();
	}

	public void add(String word){
		if(word.length() == 1){
			if(!root.hasLetter(word.charAt(0)))
				root.setLetter(word.charAt(0));
			return;
		}
		char car = word.charAt(0);
		String cdr = word.substring(1,word.length());
		if (root.getLetter(car) == null)
			root.setLetter(car);
		root.setLetter(car, add(cdr,root.getLetter(car)));
	}



	public WordTreeNode add(String word, WordTreeNode curr){
		if (word.length() == 0){
			curr.setWord(true);
		}
		else{
			char car = word.charAt(0);
			String cdr = word.substring(1,word.length());
			if (curr.getLetter(car) == null)
				curr.setLetter(car);
			curr.setLetter(car, add(cdr, curr.getLetter(car)));
		}
		return curr;
	}

	public String getWord(){
		return getWord(root);
	}

	public String getWord(WordTreeNode curr){
		if (curr.isLast() || Math.random() * 100 > 97 && curr.isWord())
			return curr.getData() + " ";
		return curr.getData() + getWord(curr.getOneLetter());
	}
	public void inOrder(){
		inOrder(root);
		System.out.println();
	}
	public void inOrder(WordTreeNode curr){
		if (curr == null ) return;
		System.out.print(curr.getData() + " ");
		if( curr.isLast()) return;
		inOrder(curr.getOneLetter());
	}

	public String Long(){
		return Long(root);
	}

	public String Long(WordTreeNode curr){
		if(curr.isLast())
			return curr.getData() + "";
		ArrayList<WordTreeNode> filled = curr.getAll();
		String longest = "";
		for(int i = 0; i < filled.size(); i++){
			String temp = Long(filled.get(i));
			if(longest.length() < (curr.getData() + temp).length())
				longest = curr.getData() + temp;
		}
		return longest;
	}

	public ArrayList<String> prefix(String p){
		ArrayList<String> ans = new ArrayList<String>();
		prefix(p.substring(0,p.length() - 1),root.get(p),ans);
		return ans;
	}

	public void prefix(String p, WordTreeNode e, ArrayList<String> al){
		p += e.getData();
		if(e.isWord())
			al.add(p);
		if(e.isLast())
			return;
		ArrayList<WordTreeNode> filled = e.getAll();
		for(int i = 0; i < filled.size(); i++)
			prefix(p, filled.get(i), al);
	}

	private void userInput() {
		System.out.println("List of Commands: ");
		System.out.println("(1) Random Word");
		System.out.println("(2) Longest Word");
		System.out.println("(3) Common Prefix");
		System.out.println("(4) Add Word");
		System.out.println("(5) Project Requirements");
		System.out.println("(6) Exit");
		System.out.println();
		System.out.println("Please enter either the number or the command!");
		System.out.println();

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		if(input.equals("1") || input.equals("Random Word")) {
			System.out.println("Random Word: " + getWord());
		}
		else if(input.equals("2") || input.equals("Longest Word")) {
			System.out.println("Longest Word: " + Long());
		}
		else if(input.equals("3") || input.equals("Common Prefix")) {
			System.out.println("Please enter a prefix: ");
			String prefixString = scan.nextLine();
			ArrayList<String> prefixArray = prefix(prefixString);
			for (int i = 0; i < prefixArray.size(); i++) {
				System.out.println(prefixArray.get(i));
			}
			System.out.println("All words with prefix \"" + prefixString +"\" ");
			System.out.println(prefixArray.size() + " words with this prefix");
		}
		else if(input.equals("4") || input.equals("Add Word")) {
			System.out.println("Please enter a word: ");
			String word = scan.nextLine();
			add(word);
			System.out.println("\"" + word + "\" has been added");
		}
		else if(input.equals("5") || input.equals("Project Requirements")) {
			String prefixString = "str";
			ArrayList<String> prefixArray = prefix(prefixString);
			for (int i = 0; i < prefixArray.size(); i++) {
				System.out.println(prefixArray.get(i));
			}
			System.out.println("All words with prefix \"" + prefixString +"\" ");
			System.out.println(prefixArray.size() + " words with this prefix");
			System.out.println("Random Word: " + getWord());
			System.out.println("Longest Word: " + Long());
		}
		else if(input.equals("6") || input.equals("Exit")) {
			return;
		}
		else {
			System.out.println("Invalid Command");
		}
		System.out.println();
		userInput();
	}

	public static void main(String[] args){
		WordTree wt = new WordTree();
		try{
			BufferedReader br = new BufferedReader(new FileReader("../file/words_full.txt"));
			String init = br.readLine();
			while(init != null){ 
				wt.add(init);
				init = br.readLine();
			}
		}
		catch(IOException e){}
		for(int i = 0; i < 12; i++) {
			System.out.println();
		}
		System.out.println("Roy Xu and Leon Chou");
		System.out.println("WordTree");
		System.out.println();
		wt.userInput();
	}
}
