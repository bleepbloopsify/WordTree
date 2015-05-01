import java.util.*;
import java.io.*;

public class WordTree{

  private WordTreeNode root;

  public WordTree(){
    root = new WordTreeNode();
  }

  public void add(String word){
    root = add(word, root.getLetter(word.charAt(0)));
  }

  public WordTreeNode add(String word, WordTreeNode curr){
    char c = word.charAt(0);
    if (c == '\u0000'){
      curr.setWord(true);
      return curr;
    }
    else
      if (curr.getLetter(c) == null)
	curr.setLetter(c, new WordTreeNode(c));
    curr.setLetter(c, add(word.substring(1,word.length()), curr.getLetter(c)));
    return curr;
  }

  public String getWord(){
    return getWord(root);
  }

  public String getWord(WordTreeNode curr){
    if (curr.isWord())
	return curr.getData() + " ";
    return "";
  }

  private static void setFile(String file){
      try{
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  String init = br.readLine();
	  while(init != null){ 
	      
	      return;
	      
	  }
      }
      catch(IOException e){{}
      }
  }
    public static void main(String[] args){
	
    }
    


  }
