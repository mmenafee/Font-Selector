import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 


public class FontSelector { 
	
	private JFrame f;
	private JPanel p;
	private JButton b1;
	private JLabel lab;
	
	String[] fonts = {"Times New Roman","Arial","Calibri","Georgia"};
	JComboBox combo = new JComboBox(fonts);
	
	//constructor
	public FontSelector(){
		gui();
	}
	
	public void gui(){
		f = new JFrame("Font Selector");
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel(new GridBagLayout());
		p.setBackground(Color.GRAY);
		
		b1 = new JButton("Select");
		lab = new JLabel("This is where font name goes");
		
		
		b1.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				String s = combo.getSelectedItem().toString();
				lab.setText(s);
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 1;
		p.add(b1,c);
		c.gridx = 0;
		c.gridy = 2;
		p.add(lab,c);
		c.gridx = 0;
		c.gridy = 4;
		p.add(combo,c);
		
		f.add(p);
	}
	
	public static void main(String[] args){
		new FontSelector();
		
	}
	
}

