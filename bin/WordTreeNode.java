public class WordTreeNode{

    private WordTreeNode[] letters;
    private char data;
    private boolean isWord;

    public WordTreeNode(){
	letters = new WordTreeNode[26];
	isWord = false;
    }

    public void setData(char c){
	data = c;
    }

    public void setWord(boolean b){
	isWord = b;
    }

    public WordTreeNode getLetter(char c){
	return letters[ (int)c - 97 ];
    }
}
