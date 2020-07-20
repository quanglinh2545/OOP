/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br;
package sequential;
import java.util.List;

public class Node {                                           
    private Integer x, y;
    private Integer nodetype = 0;
    private Integer value;
   
    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void removeNode(List<Node> list, Node tempCell) {
        int x = tempCell.getX();
        int y = tempCell.getY();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getX() == x && list.get(i).getY() == y) {
                list.remove(i);
            }
        }
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getNodetype() {
		return nodetype;
	}

	public void setNodetype(Integer nodetype) {
		this.nodetype = nodetype;
	}
}