import java.util.*;

class FileSystem {

    private FileNode root;

    public FileSystem() {
        root = new FileNode();
    }
    
    public boolean createPath(String path, int value) {
        
        if(path.equals("/") || path.equals("")) {
            return false;
        }

        var sections = path.substring(1).split("/");
        var currentNode = root;
        for(int i = 0; i < sections.length - 1; ++i) {
            if(!currentNode.Nodes.containsKey(sections[i]))
                return false;
            currentNode = currentNode.Nodes.get(sections[i]);
        }

        if(currentNode.Nodes.containsKey(sections[sections.length - 1])) {
            return false;
        }
        
        var fileNode = new FileNode();
        fileNode.IsFile = true;
        fileNode.Content = value;
        currentNode.Nodes.put(sections[sections.length - 1], fileNode);

        return true;
    }
    
    public int get(String path) {
        var sections = path.substring(1).split("/");
        var currentNode = root;
        for(int i = 0; i < sections.length; ++i) {
            if(!currentNode.Nodes.containsKey(sections[i]))
                return -1;
            currentNode = currentNode.Nodes.get(sections[i]);
        }

        return currentNode.IsFile ? currentNode.Content : -1;
    }
}

class FileNode {
    public boolean IsFile = false;
    public HashMap<String, FileNode> Nodes = new HashMap<>(); 
    public int Content = 0;
}