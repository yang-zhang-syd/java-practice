import java.util.*;

class FileNode {
    public boolean IsFile = false;
    public HashMap<String, FileNode> Nodes = new HashMap<>(); 
    public String Content = "";
}

class FileSystem {

    private FileNode root;

    public FileSystem() {
        root = new FileNode();
    }
    
    public List<String> ls(String path) {
        var node = findFileNode(path);

        if(node == null)
            return new LinkedList<String>();

        if(node.IsFile) {
            var result = new LinkedList<String>();
            var lastSlashIndex = path.lastIndexOf("/");
            var fileName = path.substring(lastSlashIndex + 1);
            result.add(fileName);
            return result;
        }
        
        var result = node.Nodes.keySet().stream().sorted().toList();
        return result;
    }

    public void mkdir(String path) {
        mkdirInternal(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        var lastSlashIndex = filePath.lastIndexOf("/");
        var fileName = filePath.substring(lastSlashIndex + 1);
        var dirPath = filePath.substring(0, lastSlashIndex);
        var dirNode = mkdirInternal(dirPath);
        
        if(dirNode.Nodes.containsKey(fileName)) {
            var fileNode = dirNode.Nodes.get(fileName);
            if(!fileNode.IsFile) {
                // error!
            }
            fileNode.Content += content;
        }
        else {
            var fileNode = new FileNode();
            fileNode.IsFile = true;
            fileNode.Content = content;
            dirNode.Nodes.put(fileName, fileNode);
        }
    }
    
    public String readContentFromFile(String filePath) {
        var fileNode = findFileNode(filePath);
        if(fileNode != null && fileNode.IsFile) {
            return fileNode.Content;
        }

        return "";
    }

    private FileNode mkdirInternal(String path) {
        if(path.equals("/") || path.equals("")) {
            return root;
        }
        
        var dirs = path.substring(1).split("/");
        var currentNode = root;
        for(var dir : dirs) {
            if(!currentNode.Nodes.containsKey(dir)) {
                currentNode.Nodes.put(dir, new FileNode());
            }

            currentNode = currentNode.Nodes.get(dir);
        }

        return currentNode;
    }

    private FileNode findFileNode(String path) {
        if(path.equals("/")) {
            return root;
        }

        var sections = path.substring(1).split("/");
        var currentNode = root;
        
        for(var section : sections) {
            if(!currentNode.Nodes.containsKey(section)) {
                return null;
            }

            currentNode = currentNode.Nodes.get(section);
        }

        return currentNode;
    }
}
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

// ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
// [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

class Program {
    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        var result1 = obj.ls("/");
        obj.mkdir("/a/b/c");
        obj.mkdir("/d/b/c");
        obj.addContentToFile("/a/b/c/d", "hello");
        var result2 = obj.ls("/");
        var readResult = obj.readContentFromFile("/a/b/c/d");
    }
}