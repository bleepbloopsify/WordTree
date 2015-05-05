import java.util.*;

public class WordTreeNode{

    private WordTreeNode[] letters;
    private char data;
    private boolean isWord;

    public WordTreeNode(){
	letters = new WordTreeNode[26];
	isWord = false;
    }

    public WordTreeNode(char c){
	letters = new WordTreeNode[26];
	isWord = false;
	data = c;
    }

    public void setData(char c){
	data = c;
    }

    public String toString(){
	return data + "";
    }

    public ArrayList<WordTreeNode> getAll(){
	ArrayList<WordTreeNode> filled = new ArrayList<WordTreeNode>();
	for(int i = 0; i < letters.length; i++)
	    if(letters[i] != null)
		filled.add(letters[i]);
	return filled;
    }

    public WordTreeNode getOneLetter(){
	ArrayList<WordTreeNode> filled = new ArrayList<WordTreeNode>();
	for(int i = 0; i < letters.length; i++)
	    if(letters[i] != null)
		filled.add(letters[i]);
	return filled.get( (int)(Math.random() * filled.size()));
    }

    public boolean isLast(){
	ArrayList<WordTreeNode> filled = new ArrayList<WordTreeNode>();
	for(int i = 0; i < letters.length; i++)
	    if(letters[i] != null)
		filled.add(letters[i]);
	return filled.size() == 0;
    }

    public boolean isWord(){
	return isWord;
    }

    public boolean hasLetter(char c){
	return letters[(int)c - 97] == null;
    }

    public void setWord(boolean b){
	isWord = b;
    }

    public char getData(){
	return data;
    }

    public void setLetter(char c){
	letters[ (int) c - 97 ] = new WordTreeNode(c);
    }
  
    public void setLetter(char c, WordTreeNode w){
	letters[ (int) c - 97 ] = w;
    }
  
    public WordTreeNode getLetter(char c){
	return letters[ (int)c - 97 ];
    }
}
