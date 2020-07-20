package a_search;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ASearchController extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
    private Timer timer;
    private int index = 0;
    private final int DELAY = 10;
    private final int INITIAL_DELAY = 50;   
    private JTextField num1;
      Graphics g;
    JFrame frame;
    pathFinder pF;
    private Font arcadeFont;
    private boolean isReady;
    private boolean isStart;
    private boolean isFinish;
    private boolean isWall;
    private boolean isEraser;
 
    private List<Node> obstacles,parentL;

    private Node startCell, endCell;

    private Integer GRID_SIZE, FRAME_WIDTH, FRAME_LENGTH, NUM_OF_COL, NUM_OF_ROW;
    
    // public static void main(String[] args) {
    //     new main();
    // }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    public ASearchController() {
        
        JButton butSearch = new JButton("SEARCH");
        butSearch.setBounds(24,25,120,25);
        
		butSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent but1) {
                runPathFinder();
                initTimer();
            }
        });
        JButton butClear = new JButton("CLEAR");
        butClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent but2){
                clearBoard();
            }
        });
        butClear.setBounds(24,75, 120, 25);
        JButton butStart = new JButton ("START CELL");
        butStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent but3){
                isStart = true;
                isFinish = false;
                isReady = true;
                isWall = false;
                isEraser = false;
            }
        });
        butStart.setBounds(24,125,120,25);
        JButton butFinish = new JButton ("FINISH CELL");
        butFinish.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent but3){
                isFinish = true;
                isStart = false;
                isReady = true;
                isEraser = false;
                isWall = false;
            }
        });
        butFinish.setBounds(24,175,120,25);

        JButton butWall = new JButton("SET WALL");
        butWall.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent but4){
                isWall = true;
                isEraser = false;
                isStart = false;
                isFinish = false;
                isReady = false;
            }
        });
        butWall.setBounds(24,225,120,25);

        JButton butEraser = new JButton("ERASER");
        butEraser.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent but5){
                isWall = false;
                isEraser = true;
                isStart = false;
                isFinish = false;
                isReady = false;
            }
        });
        butEraser.setBounds(24,275,120,25);




        

        num1 = new JTextField();
		num1.setText("0");
		num1.setBounds(87, 375, 59, 25);
		//contentPane.add(num1);
		num1.setColumns(10);



       JLabel costLB = new JLabel("COST");
        costLB.setBounds(24, 375, 50, 25);
        JLabel found = new JLabel("PATH FOUND");
        JLabel notfound = new JLabel("PATH NOT FOUND");
        notfound.setBounds(24,425,120,25);
        GRID_SIZE = 15;
        NUM_OF_COL = 63;
        NUM_OF_ROW = 46;
        FRAME_WIDTH = 962;
        FRAME_LENGTH = 800;
        isReady = false;
        pF = new pathFinder();
        obstacles = pF.getObstaclesList();
        parentL = pF.getParentList();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        frame = new JFrame();
        frame.setContentPane(this);
        frame.setTitle("A* Algorithm");
        frame.setLayout(null);
        frame.add(num1);
        frame.add(butSearch);
        frame.add(butClear);
        frame.add(costLB);
        frame.add(butStart);
        frame.add(butFinish);
        frame.add(butWall);
        frame.add(butEraser);


        frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_LENGTH));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

    public int xInBorder(int X) {
        if (X<GRID_SIZE*NUM_OF_COL){
        if (X < 165) {
            X = 165;
        } else {
            X = X + GRID_SIZE - X % GRID_SIZE;
        }
        return X;
         }
    else return GRID_SIZE*NUM_OF_COL;
    }


    public int yInBorder(int Y) {
        if(Y < GRID_SIZE*NUM_OF_ROW){
        if (Y < 0) {
            Y = 0;
        } else {
            Y = Y + GRID_SIZE - Y % GRID_SIZE;
        }
        return Y;
        }
        else return GRID_SIZE*NUM_OF_ROW;
    }

 
    public void createStartAndEndNode(MouseEvent e) {
        int x = e.getX() - GRID_SIZE;
        int y = e.getY() - GRID_SIZE;
        if (e.getButton() == 1 && isStart == true) {
            if (startCell == null) {
                x = xInBorder(x);
                y = yInBorder(y);
                startCell = new Node(x, y);
                System.out.println(startCell.getX() + " " + startCell.getY());
            } else if (startCell != null) {
                startCell = null;
            }
            repaint();
        }
        if (e.getButton() == 1 && isFinish == true) {
            if (endCell == null) {
                x = xInBorder(x);
                y = yInBorder(y);
                endCell = new Node(x, y);
                System.out.println(endCell.getX() + " " + endCell.getY());
            } else if (endCell != null) {
                endCell = null;
            }
            repaint();
        }
    }
    public void createObstacles(MouseEvent e) {
  
        int x = e.getX() - GRID_SIZE;
        int y = e.getY() - GRID_SIZE;
        x = xInBorder(x);
        y = yInBorder(y);
        if (!isReady) {
            if (pF.isInList(pF.getObstaclesList(), new Node(x, y))) {
                if (SwingUtilities.isLeftMouseButton(e) && isEraser == true) {
                    pF.removeObstacle(new Node(x, y));
                    repaint();
                }
            } else {
                if (SwingUtilities.isLeftMouseButton(e) && isWall == true) {
                    pF.addObstacle(new Node(x, y));
                    repaint();
                }
            }
        }
    
    }
    public void runPathFinder() {
        if (startCell != null && endCell != null) {
            pF.setStartCell(startCell);
            pF.setEndCell(endCell);
            pF.setCOL(GRID_SIZE*NUM_OF_COL);
            pF.setROW(GRID_SIZE*NUM_OF_ROW);
            pF.setGRID_SIZE(GRID_SIZE);
            pF.start();
            pF.findNextPath();
            repaint();
        }
    }
    public void clearBoard() {
        index = 0;
        isFinish = false;
        isStart = false;
        isEraser = false;
        isWall = false;
        endCell = null;
        startCell = null;
        isReady = false;
        pF = new pathFinder();
        pF.setComplete(false);
        pF.setObstaclesList(new ArrayList<>());
        pF.setParentList(new ArrayList<>());
        obstacles = pF.getObstaclesList();
        num1.setText(0+"");
        timer.stop();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(47, 59, 79));
        g.fillRect(165, 0, FRAME_WIDTH, FRAME_LENGTH);
        
        g.setColor(new Color(158, 143, 79));
        g.drawString(index +"",GRID_SIZE ,GRID_SIZE);
        pF.drawParentList(g,index); 
        for (int i = 0; i < pF.getObstacleListSize(); i++) {
         // g.setColor(Color.darkGray);
              g.setColor(new Color(38, 38, 44));
            g.fillRect(obstacles.get(i).getX(), obstacles.get(i).getY(), GRID_SIZE, GRID_SIZE);
        }

        if (startCell != null) {
            g.setColor(Color.orange);
            g.fillRect(startCell.getX(), startCell.getY(), GRID_SIZE, GRID_SIZE);
        }


        if (endCell != null) {
            g.setColor(Color.orange);
            g.fillRect(endCell.getX(), endCell.getY(), GRID_SIZE, GRID_SIZE);
        }

            if(index>= pF.getParentList().size()){
        if (startCell != null && endCell != null  ) {
            g.setColor(new Color(209, 140, 2));
            pF.drawPath(g);
        }
    }
       


        for (int y = 0; y < NUM_OF_ROW + 1; y++) {
            for (int x = 11; x < NUM_OF_COL + 1; x++) {
                g.setColor(new Color(95, 95, 95));
                g.drawRect(x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
            }
        }

        spaceIndicator(g);
        if(index>= pF.getParentList().size()){
        if (pF.isComplete()) {
            timer.stop();
            rainbowEffect(g);
            num1.setText(pF.getNumberOfNode()+ " cells");
            g.setColor(Color.BLACK);
            font(g, 45f, "PATH FOUND!", 37, 342);
           
        } else if (pF.isNoPath()) {
            g.setColor(Color.BLACK);
            font(g, 45f, "NO PATH FOUND!", 24, 325);
             num1.setText(-1 + "");
            timer.stop();
        }
    }
}

    public void font(Graphics g, float fontSize, String message, int xPos, int yPos) {
        InputStream is = ASearchController.class.getResourceAsStream("ARCADE_N.TTF");
        try {
                arcadeFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(fontSize);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        g.setFont(arcadeFont);
        g.drawString(message, xPos, yPos);
    }
    public void spaceIndicator(Graphics g) {
        if (!isReady) {
            g.setColor(new Color(221, 221, 221, 100));
            repaint();
        } else {
            g.setColor(new Color(255, 0, 0, 150));
            repaint();
        }
        font(g, 25f, "SPACE", 25, 900);
    }

    public void rainbowEffect(Graphics g) {
        int red = (int) (Math.random() * 225);
        int green = (int) (Math.random() * 225);
        int blue = (int) (Math.random() * 225);
        g.setColor(new Color(red, green, blue, 195));
    }

        @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        createObstacles(e);
        createStartAndEndNode(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        createObstacles(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent arg0) {

    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.index++;
        repaint();
    }
        }


