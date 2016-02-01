package net.java.dev.designgridlayout;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*; 
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.GraphicsEnvironment;
import java.awt.Font;



public class FontSelector { 
	
	private JFrame f;
	private JTabbedPane tPane;
	private JPanel preview;
	private JPanel fPane;
	private JPanel tColor;
	private JPanel bColor;
	private JButton b1;
	private JLabel lab;
	
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    JColorChooser txtChoose = new JColorChooser();
    JColorChooser bacChoose = new JColorChooser();
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
	JSlider slide = new JSlider(5,30,14);
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
		//removes preview panel in JColor Chooser
		txtChoose.setPreviewPanel(new JPanel());
		bacChoose.setPreviewPanel(new JPanel());
		text.setSize(new Dimension(1000,1000));
		preview = new JPanel();
		fPane = new JPanel();
		tColor = new JPanel();
		bColor = new JPanel();
		
		final JRadioButton bold = new JRadioButton("Bold");
	    final JRadioButton italic = new JRadioButton("Italic");

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
				
		JTabbedPane tPane = new JTabbedPane();
		 tPane.addTab("Font,Size,Style", fPane);
		    tPane.addTab("Text Color", tColor);
		    tPane.addTab("Background Color", bColor);
		    topPanel.add(tPane, BorderLayout.CENTER );
		
		    //item listeners for radio buttons
		    italic.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent itemEvent) {
		     
		          int state = itemEvent.getStateChange();
		          if (state == ItemEvent.SELECTED) {
		        	  text.setFont(text.getFont().deriveFont(Font.ITALIC));
		          }
		          if (state == ItemEvent.SELECTED && bold.isSelected()){
		        	  text.setFont(text.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		          }
		          if (state == ItemEvent.DESELECTED && bold.isSelected()){
		        	  text.setFont(text.getFont().deriveFont(Font.BOLD));
		          }
		          if(state == ItemEvent.DESELECTED){
		        	  text.setFont(text.getFont().deriveFont(Font.PLAIN));
		          }
		        }
		      });

		    bold.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent itemEvent) {
		     
		          int state = itemEvent.getStateChange();
		          if (state == ItemEvent.SELECTED) {
		        	  text.setFont(text.getFont().deriveFont(Font.BOLD));
		          }
		          if (state == ItemEvent.SELECTED && italic.isSelected()){
		        	  text.setFont(text.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		          }
		          if (state == ItemEvent.DESELECTED && italic.isSelected()){
		        	  text.setFont(text.getFont().deriveFont(Font.ITALIC));
		          }
		          if(state == ItemEvent.DESELECTED){
		        	  text.setFont(text.getFont().deriveFont(Font.PLAIN));
		          }
		        }
		      });
		      
		     //so with every selection the font changes
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
	    
	    ColorSelectionModel bModel = bacChoose.getSelectionModel();
	    //every color change
	    ChangeListener bchangeListener = new ChangeListener() { 
	      public void stateChanged(ChangeEvent changeEvent) {
	        Color newBackgroundColor = bacChoose.getColor();
	        text.setBackground(newBackgroundColor);
	      }
	    };
 
	    model.addChangeListener(changeListener);
	    bModel.addChangeListener(bchangeListener);
	    
	    //slider 
	    slide.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent evt) {
	          JSlider slider = (JSlider) evt.getSource();
	          if (slider.getValueIsAdjusting()) {
	            float value = slider.getValue();
	            
	            text.setFont(text.getFont().deriveFont(value));
	          }
	        }
	      });
		
	    
		fPane.add(scrollPane);
		fPane.add(slide);
		fPane.add(bold);
		fPane.add(italic);
		tColor.add(txtChoose);
		bColor.add(bacChoose);
		preview.add(txtScroll);
		
		//add split pane for good ui
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setTopComponent(preview);
		split.setBottomComponent(topPanel);
		split.setDividerLocation(0.5);
		split.setResizeWeight(0.5);      

		
		f.add(split);
	
		
	}
	
	public static void main(String[] args){
		new FontSelector();
		
			
	}
	
}

