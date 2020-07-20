package binary;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.FontUIResource;

public class BinaryController {
	JFrame frame;
	private int valueX = -1;
	private int valueY = -1;
	private int WIDTH = 950;
	private final int HEIGHT = 800;
	private final int MSIZE = 900;
	private int CSIZE = 65;
	private boolean solving = false;
	private insertSort isSort = new insertSort();
	private Random r = new Random();
	private Node searchNode = new Node(20,30);
	private ArrayList<Node> arrNode = new ArrayList<Node>();
	private ArrayList<Integer> arrNodemid = new ArrayList<Integer>();
	Timer tmr,tmr2,tmr3 ;
	
	JTextField txtsearch = new JTextField();
	JTextField add = new JTextField();
	
	JButton buttsearch = new JButton("Search");
	JButton buttadd = new JButton("Add");
	JButton buttaddrd = new JButton("Add Random");
	JButton buttresetall = new JButton("Reset All");
	JButton buttreset = new JButton("Reset");
	JButton buttremove = new JButton("Remove");
	
	JPanel toolP = new JPanel();
	
	Map canvas;
	
	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public boolean addNodeplus(ArrayList<Node> arrNode1,int n) {
		Node node1 = new Node(valueX,valueY);
		node1.setValue(n);
		if(!checkList(arrNode1, node1)) {
		isSort.insertionSort(arrNode1, node1);
		setXYNode(arrNode1);
		add.setText("");
		delay();
		update();
		
		return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Is present");
			return false;
		}
	}
    public void removeNode(final MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for(Node node : arrNode ) {
        	if( x < node.getX() + CSIZE && x > node.getX() && y < node.getY() + CSIZE && y > node.getY()) {
        		if(SwingUtilities.isRightMouseButton(e)) {
        			arrNode.remove(node);
        			canvas.repaint();
        		}
        	}
        }
    }

	public boolean checkList(ArrayList<Node> arrNode1, Node node) {
		if(arrNode1.size()==0) return false;
		for(Node node1 : arrNode1) {
			if(node.getValue() == node1.getValue()) return true;
		}
		return false;
	}
	public boolean checkList(ArrayList<Node> arrNode1, int n) {
		if(arrNode1.size()==0) return false;
		for(Node node1 : arrNode1) {
			if(n == node1.getValue()) return true;
		}
		return false;
	}
	public void reset() {
		tmr2.stop();
		tmr.stop();
		for(Node node : arrNode) {
			node.setNodetype(0);
					}
		while(arrNodemid.size() > 0) {
			arrNodemid.remove(0);
		}
		solving = false;
		searchNode.setValue(null);
		searchNode.setX(20);
		searchNode.setY(30);
		canvas.repaint();
	}
	public void resetAll() {
		while(arrNode.size() > 0) {
			arrNode.remove(0);
		}
		reset();
	}
	public void Animation() {
		tmr2.start();
	}
    boolean binarySearch(ArrayList<Node> arrNode, int l, int r, int x) { 
    	while(r >= l) {
    		int mid = l + (r - l)/2;
    		arrNodemid.add(arrNode.indexOf(arrNode.get(mid)));
    		if(arrNode.get(mid).getValue() == x) {
    			solving = true;
    			return solving;
    		}
    		else if(arrNode.get(mid).getValue() > x) {
            	r = mid -1;
    		}
    		else  {
    			l = mid + 1;
    			}
    		}
    	return solving;
    }
	public void drawNode(Graphics g,Node node) {
		int x = node.getX();
		int y = node.getY();
		switch(node.getNodetype()) {
		case 0:
			g.setColor(Color.WHITE);
			break;
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.YELLOW);
			break;
		case 3:
			rainbowEffect(g);
			break;
	}
		g.fillRect(x,y,CSIZE,CSIZE);
		g.setColor(Color.BLACK);
		g.setFont(new FontUIResource(null, Font.ITALIC, 30));
		g.drawString(node.getValue()+"", x + 15, y + 40);
		g.setColor(Color.BLACK);
		g.drawRect(x,y,CSIZE,CSIZE);
		g.draw3DRect(x, y, CSIZE, CSIZE, true);

	}
	public void drawNode(Graphics g,ArrayList<Node> arrNode) {
		for(int i = 0; i < arrNode.size(); i++) {
			drawNode(g,arrNode.get(i));
		}
	}
	
	public void setXYNode(ArrayList<Node> arrNode) {
		if(arrNode.size()>0) {
			for(int i = 0; i < arrNode.size(); i++) {
				arrNode.get(i).setX( 20 + ((i)%9) * (CSIZE+10));
				arrNode.get(i).setY( 110 + (i/9)*(CSIZE+150));
			}
		}
	}
	public void update() {
		setXYNode(arrNode);
		canvas.repaint();
	}
	public void delay() {	//DELAY METHOD
		try {
			Thread.sleep(1);
		} catch(Exception e) {}
	}
	public void delay1() {	//DELAY METHOD
		try {
			Thread.sleep(500);
		} catch(Exception e) {}
	}
    public void rainbowEffect(final Graphics g) {
        final int red = (int) (Math.random() * 225);
        final int green = (int) (Math.random() * 225);
        final int blue = (int) (Math.random() * 225);
        g.setColor(new Color(red, green, blue, 195));
    }
	public void initialize() {	//INITIALIZE THE GUI ELEMENTS
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(WIDTH,HEIGHT);
		frame.setTitle("Binary Search");
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		toolP.setBorder(BorderFactory.createTitledBorder(loweredetched,"Controls"));
		int space = 25;
		int buff = 45;
		
		toolP.setLayout(null);
		toolP.setBounds(10,10,210,600);
		
		txtsearch.setBounds(40,space, 130, 25);
		toolP.add(txtsearch);
		space+=buff;
		

		
		buttsearch.setBounds(40, space, 130, 25);
		toolP.add(buttsearch);
		space+=buff;
		
		add.setBounds(40,space, 130, 25);
		toolP.add(add);
		space+=buff;
				
		buttadd.setBounds(40,space, 130, 25);
		toolP.add(buttadd);
		space+=buff;
		
		buttaddrd.setBounds(40,space,130,25);
		toolP.add(buttaddrd);
		space+=buff;
		
		buttreset.setBounds(40, space, 130, 25);
		toolP.add(buttreset);
		space+=buff;
		
		buttresetall.setBounds(40, space, 130, 25);
		toolP.add(buttresetall);
		space+=buff;
		
		buttremove.setBounds(40, space, 130, 25);
		toolP.add(buttremove);
		space+=buff;
		
		frame.getContentPane().add(toolP);
		
		canvas = new Map();
		canvas.setBounds(230, 10, MSIZE+1, MSIZE+1);
		frame.getContentPane().add(canvas);
		buttsearch.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtsearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input your value");
				}
				else {
					int n = Integer.parseInt(txtsearch.getText());
					searchNode.setValue(n);
					txtsearch.setText("");
					canvas.repaint();
					binarySearch(arrNode, 0, arrNode.size()-1, n);
					Animation();
				}
			}
		});

		buttadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(add.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input your value");
				}
				else if(arrNode.size() == 18) {
					add.setText("");
					JOptionPane.showMessageDialog(null, "MAX");
				} 
				else{
				int n = Integer.parseInt(add.getText());
				addNodeplus(arrNode,n);
				add.setText("");
				}
			}
		});
		
		buttaddrd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(arrNode.size() == 18) {
					JOptionPane.showMessageDialog(null, "MAX");
				}
				else {
					int n;
					do{n = r.nextInt(100);}while(checkList(arrNode, n));
					addNodeplus(arrNode, n);
			}
				}
		});
		buttreset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		buttresetall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		
		tmr = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.repaint();
			}
		});
		tmr2 = new Timer(1,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arrNodemid.size() < 3/2) {
					tmr2.stop();
				}
				else {
					int x1 = searchNode.getX(), y1 = searchNode.getY();
					int x2 = arrNode.get(arrNodemid.get(0)).getX(), y2 = arrNode.get(arrNodemid.get(0)).getY() + CSIZE + 50;
					arrNode.get(arrNodemid.get(0)).setNodetype(2);
				if(x1 < x2 - 1) {
					x1++;
					searchNode.setX(x1);
					y1 = (int)((y1 - y2)/(x1 - x2) + y1);
					searchNode.setY(y1);
					canvas.repaint();
				}
				else if(x1 - 1 > x2) {
					x1--;
					searchNode.setX(x1);
					y1 = (int)((y2 - y1)/(x1 - x2) + y1);
					searchNode.setY(y1);
					canvas.repaint();
				}
				else {
					x1 = x2;
					searchNode.setX(x1);
					y1 = y2;
					searchNode.setY(y1);
					if(arrNodemid.size() == 1 && solving ) {
						arrNode.get(arrNodemid.get(0)).setNodetype(3);
						tmr.start();
					}
					else if(arrNodemid.size() == 1 && !solving ) {
						for(Node node : arrNode) {
							node.setNodetype(1);
							canvas.repaint();
						}
					}
					else if(searchNode.getValue() > arrNode.get(arrNodemid.get(0)).getValue()) {
						for(int i = 0; i < arrNodemid.get(0); i++) {
							arrNode.get(i).setNodetype(1);
							canvas.repaint();
						}
					}
					else if(searchNode.getValue() < arrNode.get(arrNodemid.get(0)).getValue()) {
						for(int i = arrNodemid.get(0) + 1;i <= arrNode.size() - 1 ;i++) {
							arrNode.get(i).setNodetype(1);
							canvas.repaint();
						}
						}
					canvas.repaint();
					arrNodemid.remove(0);
					delay1();
			}
			}
			}
		});
		
		}
/*
	public static void main(String[] args) {
		BSMain main = new BSMain();
		main.initialize();
	}
	
	*/
	class Map extends JPanel implements MouseListener, MouseMotionListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Map() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(arrNode == null) {}
			else {
				drawNode(g,arrNode);
			}
			if(searchNode.getValue()!=null) {
			drawNode(g,searchNode);
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
	}
}
	}