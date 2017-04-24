import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class RuleInterface extends JFrame{
	//fields
	String StdRulesDesc = "Default Scoring Options and Player Entry";
	String ExtraScoringDesc = "Extra Scoring Options to Enable/Disable";
	String HouseRulesDesc = "Additional Rules";
	String TopDesc = "<html>Adjust the settings for your game. <br>Change the point value of different hands, <br>Choose which rules to turn on/off, <br> add at least 2 players, then click \"Start Game\"";	
	Border padding = BorderFactory.createEmptyBorder(20,20,5,20);
	int numPlayers = 0;
	
	ImageIcon die1 = new ImageIcon("src/icon1.png");
	ImageIcon die2 = new ImageIcon("src/icon2.png");
	ImageIcon die3 = new ImageIcon("src/icon3.png");
	ImageIcon die4 = new ImageIcon("src/icon4.png");
	ImageIcon die5 = new ImageIcon("src/icon5.png");
	ImageIcon die6 = new ImageIcon("src/icon6.png");
	
	//methods
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame settings = new RuleInterface();
            }
        });
	}
	
	public RuleInterface(){
		super();
		add(new RulesTabPane(), BorderLayout.NORTH);
		add(new StartPanel(), BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocation(500,250);
		setTitle("Farkle - Settings");
		setVisible(true);
	}
	
	//subclasses
	
	public class StartPanel extends JPanel{
		public StartPanel(){
			Box format = Box.createVerticalBox();
			format.add(new JLabel(TopDesc));
			format.add(new JButton("Start Game"));
			
			add(format);
		}
	}
	
	public class RulesTabPane extends JTabbedPane{
		//methods
		
		public RulesTabPane(){
			super();
			addTab("Standard Rules", null, new StdRules(), StdRulesDesc);
			addTab("Extra Scoring Rules", null, new ExtraScoring(), ExtraScoringDesc);
			addTab("House Rules", null, new HouseRules(), HouseRulesDesc);
		}
	}
	
	public class StdRules extends JPanel{
		//methods
		public StdRules(){
			super(new GridLayout(1,2));
			setBorder(padding);
			
			add(new StdScoringPane());
			add(new PlayerPane());
			 
		}
		
		//subclasses
		
		public class StdScoringPane extends JPanel{
			//methods
			public StdScoringPane(){
				super(new GridLayout(10,1));
				add(new JLabel("Enter Values for Standard Scoring Rules"));
				Box line1 = Box.createHorizontalBox();
				Box line2 = Box.createHorizontalBox();
				Box line3 = Box.createHorizontalBox();
				Box line4 = Box.createHorizontalBox();
				Box line5 = Box.createHorizontalBox();
				Box line6 = Box.createHorizontalBox();
				Box line7 = Box.createHorizontalBox();
				Box line8 = Box.createHorizontalBox();
				Box line9 = Box.createHorizontalBox();
				
				JTextField score1 = new JTextField("100", 5);
				JTextField score2 = new JTextField("50", 5);
				JTextField score3 = new JTextField("1000", 5);
				JTextField score4 = new JTextField("200", 5);
				JTextField score5 = new JTextField("300", 5);
				JTextField score6 = new JTextField("400", 5);
				JTextField score7 = new JTextField("500", 5);
				JTextField score8 = new JTextField("600", 5);
				JTextField finalScore = new JTextField("10000", 5);
				
				score1.addFocusListener(new IntegerListener(score1.getText()));
				score2.addFocusListener(new IntegerListener(score2.getText()));
				score3.addFocusListener(new IntegerListener(score3.getText()));
				score4.addFocusListener(new IntegerListener(score4.getText()));
				score5.addFocusListener(new IntegerListener(score5.getText()));
				score6.addFocusListener(new IntegerListener(score6.getText()));
				score7.addFocusListener(new IntegerListener(score7.getText()));
				score8.addFocusListener(new IntegerListener(score8.getText()));
				finalScore.addFocusListener(new IntegerListener(finalScore.getText()));
				
				line1.add(new JLabel(die1));
				line1.add(Box.createRigidArea(new Dimension(65,0)));
				line1.add(score1);
				
				line2.add(new JLabel(die5));
				line2.add(Box.createRigidArea(new Dimension(65,0)));
				line2.add(score2);
				
				line3.add(new JLabel(die1));
				line3.add(new JLabel(die1));
				line3.add(new JLabel(die1));
				line3.add(Box.createRigidArea(new Dimension(15,0)));
				line3.add(score3);
				
				line4.add(new JLabel(die2));
				line4.add(new JLabel(die2));
				line4.add(new JLabel(die2));
				line4.add(Box.createRigidArea(new Dimension(15,0)));
				line4.add(score4);
				
				line5.add(new JLabel(die3));
				line5.add(new JLabel(die3));
				line5.add(new JLabel(die3));
				line5.add(Box.createRigidArea(new Dimension(15,0)));
				line5.add(score5);
				
				line6.add(new JLabel(die4));
				line6.add(new JLabel(die4));
				line6.add(new JLabel(die4));
				line6.add(Box.createRigidArea(new Dimension(15,0)));
				line6.add(score6);
				
				line7.add(new JLabel(die5));
				line7.add(new JLabel(die5));
				line7.add(new JLabel(die5));
				line7.add(Box.createRigidArea(new Dimension(15,0)));
				line7.add(score7);
				
				line8.add(new JLabel(die6));
				line8.add(new JLabel(die6));
				line8.add(new JLabel(die6));
				line8.add(Box.createRigidArea(new Dimension(15,0)));
				line8.add(score8);
				
				line9.add(new JLabel("Score to Win -"));
				line9.add(Box.createRigidArea(new Dimension(10,0)));
				line9.add(finalScore);
				
				add(line1);
				add(line2);
				add(line3);
				add(line4);
				add(line5);
				add(line6);
				add(line7);
				add(line8);
				add(line9);				
			}
			
		}
		
		public class PlayerPane extends JPanel{
			//methods
			
			public PlayerPane(){
				super();
				Box playerGrid = Box.createVerticalBox();
				JTextField playerEnter = new JTextField(8);
				JButton adder = new JButton("Add Player");
				
				playerGrid.add(new JLabel("Enter Players"));
				playerGrid.add(playerEnter);
				playerGrid.add(adder);
				playerGrid.add(new PlayerLine("Andrew"));
				playerGrid.add(new PlayerLine("Cole"));
				playerGrid.add(new PlayerLine("Daniel"));
				add(playerGrid);
				
			}
			
			//subclasses
			public class PlayerLine extends JPanel{
				ImageIcon x = new ImageIcon("src/x.png");
				
				public PlayerLine(String name){
					super();
					Box line = Box.createHorizontalBox();
					JLabel delete = new JLabel(x);
					
					line.add(delete);
					line.add(Box.createRigidArea(new Dimension(5,0)));
					line.add(new JLabel(name));
					add(line);
				}
			}
		}
	
		
	}
	
	public class ExtraScoring extends JPanel{
		//methods
		public ExtraScoring(){
			super();
			setBorder(padding);
			Box vertBox = Box.createVerticalBox();
			vertBox.setAlignmentX(LEFT_ALIGNMENT);
			
			Box pairs = Box.createHorizontalBox();
			pairs.setAlignmentX(LEFT_ALIGNMENT);
			Box straight = Box.createHorizontalBox();
			straight.setAlignmentX(LEFT_ALIGNMENT);
			Box FH = Box.createHorizontalBox();
			FH.setAlignmentX(LEFT_ALIGNMENT);
			Box kind = Box.createHorizontalBox();
			kind.setAlignmentX(LEFT_ALIGNMENT);
			
			JCheckBox selectPairs = new JCheckBox();
			JCheckBox selectStraight = new JCheckBox();
			JCheckBox selectFH = new JCheckBox();
			JCheckBox selectKind = new JCheckBox();
			
			JTextField inputPairs = new JTextField("750", 5);
			JTextField inputStraight = new JTextField("1500", 5);
			JTextField inputFH = new JTextField("250", 5);
			
			inputPairs.addFocusListener(new IntegerListener(inputPairs.getText()));
			inputStraight.addFocusListener(new IntegerListener(inputStraight.getText()));
			inputFH.addFocusListener(new IntegerListener(inputFH.getText()));
			
			Box inputKindFormat = Box.createVerticalBox();
			inputKindFormat.setAlignmentX(LEFT_ALIGNMENT);
			ButtonGroup kindGroup = new ButtonGroup();
			
			Box addingLine = Box.createHorizontalBox();
			addingLine.setAlignmentX(LEFT_ALIGNMENT);
			Box doublingLine = Box.createHorizontalBox();
			doublingLine.setAlignmentX(LEFT_ALIGNMENT);
			Box setValueLine = Box.createHorizontalBox();
			setValueLine.setAlignmentX(LEFT_ALIGNMENT);
			
			Box setValueFormat = Box.createVerticalBox();
			Box setValue4Format = Box.createHorizontalBox();
			Box setValue5Format = Box.createHorizontalBox();
			Box setValue6Format = Box.createHorizontalBox();
			
			JLabel addingLabel = new JLabel("Adding");
			JLabel doublingLabel = new JLabel("Doubling");
			JLabel setValueLabel = new JLabel("Set Value");
			
			JRadioButton adding = new JRadioButton();
			JRadioButton doubling = new JRadioButton();
			JRadioButton setValue = new JRadioButton();
			
			kindGroup.add(adding);
			kindGroup.add(doubling);
			kindGroup.add(setValue);
			
			JTextField inputSet4 = new JTextField("1500", 5);
			JTextField inputSet5 = new JTextField("3000", 5);
			JTextField inputSet6 = new JTextField("4500", 5);
			
			inputSet4.addFocusListener(new IntegerListener(inputSet4.getText()));
			inputSet5.addFocusListener(new IntegerListener(inputSet5.getText()));
			inputSet6.addFocusListener(new IntegerListener(inputSet6.getText()));
			
			pairs.add(selectPairs);
			pairs.add(Box.createRigidArea(new Dimension(5,0)));
			pairs.add(new JLabel("3 Pairs"));
			pairs.add(Box.createRigidArea(new Dimension(53,0)));
			pairs.add(inputPairs);
			
			straight.add(selectStraight);
			straight.add(Box.createRigidArea(new Dimension(5,0)));
			straight.add(new JLabel("Straight"));
			straight.add(Box.createRigidArea(new Dimension(48,0)));
			straight.add(inputStraight);
			
			FH.add(selectFH);
			FH.add(Box.createRigidArea(new Dimension(5,0)));
			FH.add(new JLabel("Full House"));
			FH.add(Box.createRigidArea(new Dimension(35,0)));
			FH.add(inputFH);
			
			kind.add(selectKind);
			kind.add(Box.createRigidArea(new Dimension(5,0)));
			kind.add(new JLabel("4/5/6 of a Kind"));
			
			addingLine.add(Box.createRigidArea(new Dimension(50,0)));
			addingLine.add(adding);
			addingLine.add(Box.createRigidArea(new Dimension(5,0)));
			addingLine.add(addingLabel);
			addingLabel.setToolTipText("<html> Adds the 3 of a Kind score for each additional \"Of a Kind\" die;<br>For Example: <br>(3-3-3) = 300  <br>(3-3-3-3) = 600  <br>(3-3-3-3-3) = 900 <br>(3-3-3-3-3-3) = 1200</html>");

			doublingLine.add(Box.createRigidArea(new Dimension(50,0)));
			doublingLine.add(doubling);
			doublingLine.add(Box.createRigidArea(new Dimension(5,0)));
			doublingLine.add(doublingLabel);
			doublingLabel.setToolTipText("<html> Doubles the score for each additional \"Of a Kind\" die; <br>For Example: <br>(3-3-3) = 300  <br>(3-3-3-3) = 600  <br>(3-3-3-3-3) = 1200  <br>(3-3-3-3-3-3) = 2400</html>");
			
			setValueLine.add(Box.createRigidArea(new Dimension(50,0)));
			setValueLine.add(setValue);
			setValueLine.add(Box.createRigidArea(new Dimension(5,0)));
			setValueLine.add(setValueLabel);
			setValueLabel.setToolTipText("Each \"Of a Kind\" combination is scored as a predetermined set value");
			setValueLine.add(Box.createRigidArea(new Dimension(15,0)));
			
			setValue4Format.add(new JLabel("4"));
			setValue4Format.add(Box.createRigidArea(new Dimension(10,0)));
			setValue4Format.add(inputSet4);
			
			setValue5Format.add(new JLabel("5"));
			setValue5Format.add(Box.createRigidArea(new Dimension(10,0)));
			setValue5Format.add(inputSet5);
			
			setValue6Format.add(new JLabel("6"));
			setValue6Format.add(Box.createRigidArea(new Dimension(10,0)));
			setValue6Format.add(inputSet6);
			
			setValueFormat.add(setValue4Format);
			setValueFormat.add(setValue5Format);
			setValueFormat.add(setValue6Format);
			
			inputKindFormat.add(addingLine);
			inputKindFormat.add(doublingLine);
			inputKindFormat.add(setValueLine);
			setValueLine.add(setValueFormat);
			
			
			vertBox.add(pairs);
			vertBox.add(straight);
			vertBox.add(FH);
			vertBox.add(kind);
			vertBox.add(inputKindFormat);
		
			add(vertBox);
			
		}
		
		//subclasses
		
		//listeners
	}

	public class HouseRules extends JPanel{
		
		public HouseRules(){
			Box format = Box.createVerticalBox();
			format.setAlignmentX(LEFT_ALIGNMENT);
			
			Box thresholdLine = Box.createHorizontalBox();
			thresholdLine.setAlignmentX(LEFT_ALIGNMENT);
			Box piggybackLine = Box.createHorizontalBox();
			piggybackLine.setAlignmentX(LEFT_ALIGNMENT);
			Box hotStreakLine = Box.createHorizontalBox();
			hotStreakLine.setAlignmentX(LEFT_ALIGNMENT);
			Box kickEmLine = Box.createHorizontalBox();
			kickEmLine.setAlignmentX(LEFT_ALIGNMENT);
			Box welfareLine = Box.createHorizontalBox();
			welfareLine.setAlignmentX(LEFT_ALIGNMENT);
			
			JCheckBox thresholdSelect = new JCheckBox();
			JCheckBox piggybackSelect = new JCheckBox();
			JCheckBox hotStreakSelect = new JCheckBox();
			JCheckBox kickEmSelect = new JCheckBox();
			JCheckBox welfareSelect = new JCheckBox();
			
			JLabel threshold = new JLabel("Starting Threshold");
			JLabel piggyback = new JLabel("Piggybacking");
			JLabel hotStreak = new JLabel("Hot Streak");
			JLabel kickEm = new JLabel("Kick 'em While They're Down");
			JLabel welfare = new JLabel("Welfare");
			
			JTextField inputThreshold = new JTextField("500", 5);
			JTextField inputKickEm = new JTextField("500", 5);
			
			inputThreshold.addFocusListener(new IntegerListener(inputThreshold.getText()));
			inputKickEm.addFocusListener(new IntegerListener(inputKickEm.getText()));
			
			threshold.setToolTipText("<html> Players must score more than this many points to begin scoring their hands. <br> A player must continue rolling until he scores over this threshold or Farkles. <br> This continues every turn until the threshold is passed.</html>");
			piggyback.setToolTipText("<html>Players may choose to start their turn by rolling the leftover dice from the previous player's roll. <br> If they score, they may add the score of the previous player's hand to their score. <br> If a player ends on Hot Dice, the next player may piggyback with 6 new dice. </html>");
			hotStreak.setToolTipText("<html>Players cannot end their turn on HotDice, and must make at least one additional roll.</html>");
			kickEm.setToolTipText("<html>3 Farkles in a row results in a point deduction. <br> After 3 Farkles, every consecutive Farkle will also deduct this many points until the player scores.</html>");
			welfare.setToolTipText("<html>Players must score EXACTLY the 'winning score' to end the game. <br> If a player scores a hand that would put him above the winning score, all points scored that turn will be given to the player with the least points. <br> If this would put the lowest-score player above the winning score as well, the turn is instead scored as a Farkle.</html>");
			
			thresholdLine.add(thresholdSelect);
			thresholdLine.add(Box.createRigidArea(new Dimension(5,0)));
			thresholdLine.add(threshold);
			thresholdLine.add(Box.createRigidArea(new Dimension(15,0)));
			thresholdLine.add(inputThreshold);
			
			piggybackLine.add(piggybackSelect);
			piggybackLine.add(Box.createRigidArea(new Dimension(5,0)));
			piggybackLine.add(piggyback);
			
			hotStreakLine.add(hotStreakSelect);
			hotStreakLine.add(Box.createRigidArea(new Dimension(5,0)));
			hotStreakLine.add(hotStreak);
			
			kickEmLine.add(kickEmSelect);
			kickEmLine.add(Box.createRigidArea(new Dimension(5,0)));
			kickEmLine.add(kickEm);
			kickEmLine.add(Box.createRigidArea(new Dimension(15,0)));
			kickEmLine.add(inputKickEm);
			
			welfareLine.add(welfareSelect);
			welfareLine.add(Box.createRigidArea(new Dimension(5,0)));
			welfareLine.add(welfare);
			
			format.add(thresholdLine);
			format.add(piggybackLine);
			format.add(hotStreakLine);
			format.add(kickEmLine);
			format.add(welfareLine);
			
			add(format);
		
		}
		
	}

	//listeners
	
	public class IntegerListener implements FocusListener{
		
		String defaultText;
		
		public IntegerListener(String defaultInput){
			super();
			defaultText = defaultInput;
		}

		@Override
		public void focusGained(FocusEvent arg0) {
			//GARBAGE
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			JTextField thisField = (JTextField) arg0.getSource();
			String text = thisField.getText();
			try{
				int textInt = Integer.parseInt(text);
				if (!(textInt > 0)){
					Integer.parseInt("Too Low");
				}
			}
			catch(Exception NumberFormatException){
				JOptionPane.showMessageDialog(null, "Make sure your entries are all integers greater than 0!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				thisField.setText(defaultText);
			}			
		}		
	}

}
