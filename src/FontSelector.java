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
		f.setSize(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel(new GridBagLayout());
		p.setLayout(new GridLayout(3,3,10,10));
		p.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		p.setBackground(Color.GRAY);
		
		b1 = new JButton("Select");
		lab = new JLabel("The quick brown fox jumped over the lazy dog’s back.");
		lab.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		b1.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				String fo = fonts.getSelectedItem().toString();
				String st = styles.getSelectedItem().toString();
				lab.setFont(new Font(fo, Font.PLAIN, 15));
			}
		});

		
		p.add(fonts);
		p.add(styles);
		p.add(b1);
		p.add(lab);
		f.add(p);
	}
	
	public static void main(String[] args){
		new FontSelector();
		
	}
	
}

