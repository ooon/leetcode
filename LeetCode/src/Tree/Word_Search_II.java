package Tree;

import java.util.Arrays;

public class Word_Search_II {
	public static void main(String[] args) {
		String[] s ={"aan","ac","abc","bd"};
		new Word_Search_II().buildTree(s);
	}
	 class TireNode{
	        char val;
	        TireNode[] next = new TireNode[26];
	        TireNode(char val){
	            this.val = val;
	        }
	        String toStirng(){
	        	return val+"";
	        }
	    }
	 public TireNode buildTree(String[] words){
	        TireNode root = new TireNode(' ');
	        for(String word :words)
	            insert(root, word, 0);
	        return root;
	    }
	    public void insert(TireNode root, String word,int idx){
	           if(idx == word.length()) return ;
	           if(root.next[word.charAt(idx) - 'a'] == null)
	             root.next[word.charAt(idx) - 'a'] = new TireNode(word.charAt(idx));
	           insert(root.next[word.charAt(idx) - 'a'],word,idx+1);
	    }
	
}
