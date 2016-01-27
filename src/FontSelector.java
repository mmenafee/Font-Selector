import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.awt.GraphicsEnvironment;


public class FontSelector { 
	
	private JFrame f;
	private JPanel p;
	private JButton b1;
	private JLabel lab;
	
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] names = ge.getAvailableFontFamilyNames();
	JComboBox fonts = new JComboBox(names);
	String[] iBold ={"ITALIC","BOLD","PLAIN"};
	JComboBox styles = new JComboBox(iBold);
	
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
		lab.setFont(new Font("Chalkduster", Font.ITALIC, 12));
		
		
		b1.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				String fo = fonts.getSelectedItem().toString();
				String st = styles.getSelectedItem().toString();
				lab.setFont(new Font(fo, Font.PLAIN, 30));
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 4;
		p.add(lab,c);
		c.gridx = 0;
		c.gridy = 1;
		p.add(fonts,c);
		c.gridx = 0;
		c.gridy = 2;
		p.add(b1,c);
		f.add(p);
	}
	
	public static void main(String[] args){
		new FontSelector();
		
	}
	
}

