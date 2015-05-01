import java.util.*;

public class WordTree{

  private WordTreeNode root;

  public WordTree(){
    root = new WordTreeNode();
  }

  public void add(String word){
    root = add(word, root.get(word.charAt(0)));
  }

  public WordTreeNode add(String word, WordTreeNode curr){
    char c = word.charAt(0);
    if (c == null){
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
      return curr.getData()
  }

  private static void setFile(String file){

    BufferedReader br = new BufferedReader(new FileReader(file));
    String init = br.readline();
    while(init != 



	  }

    public static void main(String[] args){

    }



  }
