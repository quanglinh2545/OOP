package binary;
import java.util.ArrayList;
public class insertSort {
    public void insertionSort(ArrayList<Node> list, Node addNode) {
        int addNodeValue = addNode.getValue();
        if (list.size() == 0) {
            list.add(list.size(), addNode);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (addNodeValue < list.get(i).getValue()) {
                    list.add(i, addNode);
                    return;
                }
            }
            list.add(list.size(), addNode);
        }
    }
}//end class