package a_search;
import java.util.List;
public class insertSort {
    public insertSort() {
    }
    public void insertionSort(List<Node> list, Node addNode) {
        int addNodeCost = addNode.getfCost();
        if (list.size() == 0) {
            list.add(list.size(), addNode);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (addNodeCost < list.get(i).getfCost()) {
                    list.add(i, addNode);
                    return;
                }
            }
            list.add(list.size(), addNode);
        }
    }
}