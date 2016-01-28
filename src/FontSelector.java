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
	String[] num = {"12","14","16","18","20","22","24"};
	JComboBox size = new JComboBox(num);
	String[] exam = {"The quick brown fox jumped over the lazy dog’s back.",
			"Pack my box with five dozen liquor jugs.","Jackdaws love my big sphinx of quartz.",
			"Mr. Jock, TV quiz PhD, bags few lynx.","abcdefghijklmnopqrstuvwxyz","ABCDEFGHIJKLMNOPQRSTUVWXYZ",
			"01234567890","€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£»®§­¹²³ß×™¨¥","ÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ",
			"àáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ","!#$%&'()*+,-./:;<=>?@[^_z{|}~",
			"uvw wW gq9 2z 5s il17|!j oO08 `' ;:,. m nn rn {[()]}u"
	};
	JComboBox examples = new JComboBox(exam);

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
		
		b1 = new JButton("The quick brown fox jumped over the lazy dog’s back/n"
			+ "Pack my box with five dozen liquor jugs./n"
			+ "Jackdaws love my big sphinx of quartz./n"
			+ "Mr. Jock, TV quiz PhD, bags few lynx./n"
			+ "abcdefghijklmnopqrstuvwxyz/n"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ/n"
			+ "01234567890/n"
			+ "€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£»®§­¹²³ß×™¨¥/n"
			+ "ÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ/n"
			+ "àáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ/n"
			+ "!#$%&'()*+,-./:;<=>?@[^_z{|}~/n"
			+ "uvw wW gq9 2z 5s il17|!j oO08 `' ;:,. m nn rn {[()]}u");
		lab = new JLabel("The quick brown fox jumped over the lazy dog’s back.");
		lab.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		/** 
 		*System.out.println("The quick brown fox jumped over the lazy dog’s back\nPack my box with five dozen liquor jugs.\nJackdaws love my big sphinx of quartz.\nMr. Jock, TV quiz PhD, bags few lynx.\nabcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXYZ\n01234567890\n€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£\"»®§­¹²³ß×™¨¥\nÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ\nàáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ\n!\"#$%&'()*+,-./:;<=>?@[\\^_z{|}~\nuvw wW gq9 2z 5s il17|!j oO08 `\'\" ;:,. m nn rn {[()]}u");
		*/
		
		
		b1.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				String fo = fonts.getSelectedItem().toString();
				String st = styles.getSelectedItem().toString();
				String ex = examples.getSelectedItem().toString();
				int si = Integer.valueOf((String)size.getSelectedItem());
				lab.setFont(new Font(fo, Font.PLAIN, si));
				lab.setText(ex);
			}
		});

		
		p.add(fonts);
		p.add(styles);
		p.add(size);
		p.add(b1);
		p.add(examples);
		p.add(lab);
		f.add(p);
	}
	
	public static void main(String[] args){
		new FontSelector();
		
	}
	
}

