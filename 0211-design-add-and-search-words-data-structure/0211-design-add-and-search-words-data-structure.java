class Node {
    int wordsStartingWith;
    boolean isWord;
    Node[] children;

    Node(int wordsStartingWith, boolean isWord) {
        this.wordsStartingWith = wordsStartingWith;
        this.isWord = isWord;
        children = new Node[26];
    }
}

class WordDictionary {
    
    Node root;

    public WordDictionary() {
        root = new Node(0, false);    
    }

    private void addWordUtil(String word, int pos, Node curr) {
        if(curr == null) {
            return;
        }
        if(pos == word.length()) {
            curr.isWord = true;
            return;
        }
        curr.wordsStartingWith++;
        if(curr.children[word.charAt(pos)-'a'] == null) {
            curr.children[word.charAt(pos)-'a'] = new Node(0, false);
        }
        addWordUtil(word, pos+1, curr.children[word.charAt(pos)-'a']);
    }
    
    public void addWord(String word) {
        addWordUtil(word, 0, root);
    }
    
    private boolean searchUtil(String word, int pos, Node curr) {
        if(curr == null) {
            return false;
        }
        if(pos == word.length()) {
            return curr.isWord;
        }

        if(word.charAt(pos) != '.') {
            return searchUtil(word, pos+1, curr.children[word.charAt(pos)-'a']);
        } else {
            boolean res = false;
            for(int i = 0; i < 26; i++) {
                res = (res || searchUtil(word, pos+1, curr.children[i]));
            }
            return res;
        }
    }

    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */