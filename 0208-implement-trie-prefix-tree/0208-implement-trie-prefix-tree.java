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

class Trie {
    Node root;
    public Trie() {
        root = new Node(0, false);
    }

    private void insertUtil(String word, int pos, Node curr) {
        if(curr == null) {
            return;
        }
        if(pos == word.length()) {
            curr.isWord = true;
            return;
        }
        curr.wordsStartingWith++;

        if(curr.children[word.charAt(pos)-'a'] == null) {
            curr.children[word.charAt(pos)-'a'] = new Node(1, false);
        }

        insertUtil(word, pos+1, curr.children[word.charAt(pos)-'a']);
    }
    
    public void insert(String word) {
        insertUtil(word, 0, root);
    }

    private boolean searchUtil(String word, int pos, Node curr) {
        if(curr == null) {
            return false;
        }
        if(pos == word.length()) {
            return curr.isWord;
        }

        return searchUtil(word, pos+1, curr.children[word.charAt(pos)-'a']);
    }
    
    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }
    
    private boolean startsWithUtil(String prefix, int pos, Node curr) {
        if(curr == null) {
            return false;
        }
        if(pos == prefix.length()) {
            return (curr.wordsStartingWith > 0);
        }

        return startsWithUtil(prefix, pos+1, curr.children[prefix.charAt(pos)-'a']);
    }

    public boolean startsWith(String prefix) {
        return startsWithUtil(prefix, 0, root);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */