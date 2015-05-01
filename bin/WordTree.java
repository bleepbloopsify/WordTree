import java.util.*;
import java.io.*;

public class WordTree{

    private WordTreeNode root;

    public WordTree(){
	root = new WordTreeNode();
    }

    public void add(String word){
	root = add(word, root);
    }

    public WordTreeNode add(String word, WordTreeNode curr){
	char c = 0;

	if (word.length() == 0){
	    curr.setWord(true);
	    return curr;
	}
	else{
	    c = word.charAt(0);
	
	    if (curr.getLetter(c) == null)
		curr.setLetter(c, new WordTreeNode(c));
	    curr.setLetter(c, add(word.substring(1,word.length()), curr.getLetter(c)));
	    return curr;
	}
    }
    public String getWord(){
	return getWord(root);
    }
    
    public String getWord(WordTreeNode curr){
	if (curr.isLast() || Math.random() * 100 > 90 && curr.isWord())
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
	WordTree wt = new WordTree();
	try{
	    BufferedReader br = new BufferedReader(new FileReader("../file/words_test.txt"));
	    String init = br.readLine();
	    while(init != null){ 
		wt.add(init);
		init = br.readLine();
		System.out.println(init);
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
