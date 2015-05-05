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
	catch(IOException e){{}
	}
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());
	System.out.println(wt.getWord());

	System.out.println(wt.Long());
	System.out.println(wt.prefix("pre"));
    }
    
}
