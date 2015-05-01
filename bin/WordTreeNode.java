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

    public boolean isWord(){
	return isWord;
    }

  public void setWord(boolean b){
    isWord = b;
  }

  public char getData(){
    return data;
  }
  
  public void setLetter(char c, WordTreeNode w){
    letters[ (int) c - 97 ] = w;
  }
  
  public WordTreeNode getLetter(char c){
    return letters[ (int)c - 97 ];
  }
}
