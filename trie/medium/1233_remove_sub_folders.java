class Solution {
  class Trie {
    private boolean subFolder;
    private Map<String, Trie> children;

    public Trie(boolean subFolder) {
      this.subFolder = subFolder;
      this.children = new HashMap<String, Trie>();
    }

    public boolean insert(String path) {
      Trie root = this;
      String[] folders = path.split("/");
      for(int i=0; i<folders.length; i++) {
        String folder = folders[i];
        Trie child = root.children.getOrDefault(folder, new Trie(false));
        if(child.subFolder) return false;
        if(i == folders.length-1) child.subFolder = true;
        root.children.put(folder, child);
        root = child;
      }
      return true;
    }

  }
  public List<String> removeSubFolders(String[] folder) {
    Arrays.sort(folder, (a,b) -> Integer.compare(a.length(), b.length()));
    Trie root = new Trie(false);
    List<String> ans = new ArrayList<>();
    for(String f : folder) {
      if(root.insert(f)) {
        ans.add(f);
      }
    }
    return ans;
  }
}
