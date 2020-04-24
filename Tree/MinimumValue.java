package Tree;

public class MinimumValue {
    public int minimumValue(Node node){
        int min = -1;
        if(node.getLeftNode() != null){
            min = minimumValue(node.getLeftNode());
        }
        return min;
    }
}
