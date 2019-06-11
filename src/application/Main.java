package application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.CellArray;
import data.CellState;
import service.Service;
import java.util.Timer;
import java.util.TimerTask;
public class Main extends JFrame {
	
	private JButton[][] btns;
	private JPanel p;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private Container c;
	private int row =40;
	private int col =40;
	private CellArray cells;
	
	private int generation=0;
	
	public Main(String title) {
		super(title);
		setLocation(500,200);
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c=getContentPane();
	}

	public void initGUI() {
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p.setLayout(new BorderLayout(0,0));
		p1.setLayout(new GridLayout(row, col, 0, 0));
		JLabel label = new JLabel("细胞组行数");
		JTextField tfRow= new JTextField(2);
        tfRow.setText("40");
		JLabel label1 = new JLabel("细胞组列数");
		JTextField tfCol = new JTextField(2);
		tfCol.setText("40");
		JButton btSure = new JButton("确定");

		final JLabel label2 = new JLabel("繁衍代数：0");
		p2.add(label);
		p2.add(tfRow);
		p2.add(label1);
		p2.add(tfCol);
		p2.add(btSure);
		
		p3.add(label2);
		p.add(p2, BorderLayout.NORTH);
		p.add(p3, BorderLayout.SOUTH);

		c.add(p, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);
		btSure.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(!(tfRow.getText().isEmpty()) && !(tfCol.getText().isEmpty())) {
		    		col=Integer.parseInt(tfRow.getText().trim());
		    		row=Integer.parseInt(tfRow.getText().trim());
		    	}
		    	btns=new JButton[row][col];
	    		cells=Service.initMap(row,col);
	    		generation=1;
	    		label2.setText("繁衍代数"+generation);
	    		for (int i = 0; i < row; i++) {
	    			for (int j = 0; j < col; j++) {
	    				btns[i][j] = new JButton();
	    				btns[i][j].setMargin(new Insets(0, 0, 0, 0));
	    				if (cells.getCell(i, j) == CellState.LIVE.getValue()) {
	    					btns[i][j].setBackground(Color.white);
	    					p1.add(btns[i][j]);
	    				} else {
	    					btns[i][j].setBackground(Color.black);
	    					p1.add(btns[i][j]);
	    				}
	    			}
	    	}
	    	/*利用timer定时器对代数更换定时 利用timer.shedule(new TimerTask()//重复的事件 ,延迟时间,间隔时间)*/
	    		Timer timer = new Timer();
	    		timer.schedule(new TimerTask() {
	    			@Override
	    			public void run() {
	    				cells = Service.generate(cells);
	    				generation++;
	    				label2.setText("繁衍代数：" + generation);
	    				for (int i = 0; i < row; i++) {
	    					for (int j = 0; j < col; j++) {
	    						if (cells.getCell(i, j) == CellState.LIVE.getValue()) {
	    							btns[i][j].setBackground(Color.white);

	    						} else {
	    							btns[i][j].setBackground(Color.black);

	    						}

	    					}

	    				}
	    			}
	    		}, 0, 500);
		    	
		    }
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		Main main = new Main("生命游戏");
		main.initGUI();

	}

}
