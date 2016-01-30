import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.GraphicsEnvironment;
import java.awt.Font;


public class FontSelector { 
	
	private JFrame f;
	private JPanel p;
	private JButton b1;
	private JLabel lab;
	
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    JColorChooser txtChoose = new JColorChooser();
    String swag = 
     		("The quick brown fox jumped over the lazy dog’s back."
     		 + "\nPack my box with five dozen liquor jugs."
     		 + "\nJackdaws love my big sphinx of quartz."
     		 + "\nMr. Jock, TV quiz PhD, bags few lynx."
     		 + "\nabcdefghijklmnopqrstuvwxyz"
     		 + "\nABCDEFGHIJKLMNOPQRSTUVWXYZ"
     		 + "\n01234567890"
     		 + "\n€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£\"»®§­¹²³ß×™¨¥"
     		 + "\nÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ"
     		 + "\nàáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ"
     		 + "\n!\"#$%&'()*+,-./:;<=>?@[\\^_z{|}~"
     		 + "\nuvw wW gq9 2z 5s il17|!j oO08 `\'\" ;:,. m nn rn {[()]}u");
    		
    JTextArea text = new JTextArea(swag);
    JScrollPane txtScroll = new JScrollPane(text);
    String[] names = ge.getAvailableFontFamilyNames();
	JList fonts = new JList(names);
	JSlider slide = new JSlider(4,96,12);
	JScrollPane scrollPane = new JScrollPane(fonts);
	
	
	
	//constructor
	public FontSelector(){
		gui();
		fonts.setCellRenderer(new FontCellRenderer());
	}
	
	class FontCellRenderer extends DefaultListCellRenderer {

	    public Component getListCellRendererComponent(
	        JList list,
	        Object value,
	        int index,
	        boolean isSelected,
	        boolean cellHasFocus) {
	        JLabel label = (JLabel)super.getListCellRendererComponent(
	            list,value,index,isSelected,cellHasFocus);
	        Font font = new Font((String)value, Font.PLAIN, 20);
	        label.setFont(font);
	        return label;
	    }
	}
	

	public void gui(){
		f = new JFrame("Font Selector");
		f.setVisible(true);
		f.setSize(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slide.setMajorTickSpacing(10);
		slide.setMinorTickSpacing(1);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		p = new JPanel(new GridBagLayout());
		p.setLayout(new GridLayout(3,3,10,10));
		p.setBackground(Color.LIGHT_GRAY);
		
		b1 = new JButton("Click Here to See Font");
		lab = new JLabel("The quick brown fox jumped over the lazy dog’s back.");
		lab.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
	    fonts.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) // value in list changes so example text does
			{ 
				int size = slide.getValue();
				String fo = fonts.getSelectedValue().toString();
				text.setFont(new Font(fo, Font.PLAIN, size));
			}
	      });
		
	    ColorSelectionModel model = txtChoose.getSelectionModel();
	    //every color change
	    ChangeListener changeListener = new ChangeListener() { 
	      public void stateChanged(ChangeEvent changeEvent) {
	        Color newForegroundColor = txtChoose.getColor();
	        text.setForeground(newForegroundColor);
	      }
	    };
	    model.addChangeListener(changeListener);
	    //slider text size
	    
	    slide.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent evt) {
	          JSlider slider = (JSlider) evt.getSource();
	          if (slider.getValueIsAdjusting()) {
	            float value = slider.getValue();
	            
	            text.setFont(text.getFont().deriveFont(value));
	          }
	        }
	      });
		
		p.add(scrollPane);
		p.add(slide);
		p.add(txtChoose);
		p.add(txtScroll);
		p.add(b1);
		f.add(p);
	}
	
	public static void main(String[] args){
		new FontSelector();
			
	}
	
}

