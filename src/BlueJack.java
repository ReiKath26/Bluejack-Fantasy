import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BlueJack extends JPanel implements ActionListener{
	
		private JPanel top, center, bottom, gender;
		private JLabel titleLbl, fullnameLbl, genderLbl, classLbl, raceLbl, bgLbl;
		private JTextField fullnameField, bgField;
		private JRadioButton maleBtn, femaleBtn;
		private String[] classList = {
				"Select Class", "Warrior", "Mage", "Thief", "Summoner"
		};
		private String[] raceList = {
				"Select Race", "Human", "Elf", "Dwarf", "Orc"
		};
		private JComboBox<String> classCB, raceCB;
		private JButton submitBtn, resetBtn;
		private ButtonGroup gendergroup;
		
		public BlueJack()
		{
			setLayout(new BorderLayout());
			initializeComp();
			addComp();
		}
		
		private void addComp()
		{
			gendergroup.add(maleBtn);
			gendergroup.add(femaleBtn);
			
			top.add(titleLbl);
			
			center.add(fullnameLbl);
			center.add(fullnameField);
			center.add(genderLbl);
			center.add(gender);
			center.add(classLbl);
			center.add(classCB);
			center.add(raceLbl);
			center.add(raceCB);
			center.add(bgLbl);
			center.add(bgField);
			
			gender.add(maleBtn);
			gender.add(femaleBtn);
			
			bottom.add(submitBtn);
			bottom.add(resetBtn);
			
			add(top, BorderLayout.NORTH);
			add(center, BorderLayout.CENTER);
			add(bottom, BorderLayout.SOUTH);
			
		}
		
		private void initializeComp()
		{
			top = new JPanel(new FlowLayout());
			top.setBackground(Color.CYAN);
			center = new JPanel(new GridLayout(5, 2, 10, 10));
			center.setBackground(new Color(0.7f, 0.1f, 0.9f));
			center.setBorder(new EmptyBorder(10, 10, 10, 10));
			bottom = new JPanel(new FlowLayout());
			bottom.setBackground(Color.CYAN);
			gender = new JPanel(new FlowLayout());
			gender.setBackground(new Color(0.7f, 0.1f, 0.9f));
			
			titleLbl = initLabel("Bluejack Fantasy", 40);
			fullnameLbl = initLabel("Name", 30);
			genderLbl = initLabel("Gender", 30);
			classLbl = initLabel("Class", 30);
			raceLbl = initLabel("Race", 30);
			bgLbl = initLabel("Background", 30);
			
			maleBtn = initRB("Male");
			femaleBtn = initRB("Female");
			gendergroup = new ButtonGroup();
			
			fullnameField = new JTextField();
			bgField = new JTextField();
			
			classCB = new JComboBox<>(classList);
			raceCB = new JComboBox<>(raceList);
			
			submitBtn = initButton("Submit");
			resetBtn = initButton("Reset");
		}
		
		private JLabel initLabel(String str, int size)
		{
			JLabel lbl = new JLabel(str);
			lbl.setForeground(Color.WHITE);
			
			if(str.equalsIgnoreCase("Bluejack Fantasy"))
			{
				lbl.setFont(new Font("Calibri", Font.BOLD, size));
			}
			
			else
			{
				lbl.setFont(new Font("Calibri", Font.PLAIN, size));
			}
			return lbl;
		}
		
		private JButton initButton(String str) {
			JButton butt = new JButton(str);
			butt.setBackground(Color.GRAY);
			butt.setForeground(Color.WHITE);
			butt.setPreferredSize(new Dimension(80, 30));
			butt.addActionListener(this);
			return butt;
		}
		
		private JRadioButton initRB(String str) {
			JRadioButton rad = new JRadioButton(str);
			rad.setBackground(new Color(0.7f, 0.1f, 0.9f));
			rad.setFont(new Font("Calibri", Font.PLAIN, 20));
			rad.setForeground(Color.WHITE);
			return rad;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submitBtn)
			{
				validateData();
			}
			
			else
			{
				resetForm();
			}
			
		}
		
		public void validateData()
		{
			String fullname = fullnameField.getText();
			String gender = (maleBtn.isSelected()) ? maleBtn.getText() : femaleBtn.getText();
			int indexClass = classCB.getSelectedIndex();
			int indexRace = raceCB.getSelectedIndex();
			String background = bgField.getText();
			
			if(fullname.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Name must be filled", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(fullname.length() < 2)
			{
				JOptionPane.showMessageDialog(null, "Name must consists of 2 or more character", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(!fullname.matches("^[a-zA-Z]*$"))
			{
				JOptionPane.showMessageDialog(null, "Name must only consists of alphabets", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(maleBtn.isSelected() == false && femaleBtn.isSelected() == false)
			{
				JOptionPane.showMessageDialog(null, "Gender must be selected", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(indexClass == 0)
			{
				JOptionPane.showMessageDialog(null, "Class must be selected", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(indexRace == 0)
			{
				JOptionPane.showMessageDialog(null, "Race must be selected", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(background.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Background must be filled", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else if(background.length() > 100)
			{
				JOptionPane.showMessageDialog(null, "Background can't have more than 100 character", "Error"
						, JOptionPane.ERROR_MESSAGE);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Your character has been created!", "Character Creation Success"
						, JOptionPane.INFORMATION_MESSAGE);
				resetData();
			}
		}
		
		public void resetForm()
		{
			int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?", "Reset Form", JOptionPane.YES_NO_OPTION);
			
			if(res == JOptionPane.YES_OPTION)
			{
				resetData();
			}
		}
		
		public void resetData()
		{
			fullnameField.setText("");
			gendergroup.clearSelection();
			classCB.setSelectedIndex(0);
			raceCB.setSelectedIndex(0);
			bgField.setText("");
		}

}
