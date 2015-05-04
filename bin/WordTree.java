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
    
    public static void main(String[] args){
	System.out.println((int)'a' + " " + (int)'z');
	WordTree wt = new WordTree();
	try{
	    BufferedReader br = new BufferedReader(new FileReader("../file/words_full.txt"));
	    String init = br.readLine();
	    while(init != null){ 
		wt.add(init);
		init = br.readLine();
	    }
	}
	catch(IOException e){{}
	}
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	wt.inOrder();
    }
    
}
