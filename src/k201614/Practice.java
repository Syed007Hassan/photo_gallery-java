package k201614;



import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.*;  

public class Practice extends JFrame{
	private int currCard = 1;
	private CardLayout layout;
	int[] likeCount= {0,0,0,0};
	int[] dislikeCount= {0,0,0,0};
	public Practice() {
		setTitle("Card Layout Example");
		setSize(400,400);
		
		JPanel panel = new JPanel();
		layout = new CardLayout();
		
		//set layout for your panel
		panel.setLayout(layout);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		//creating labels for each card
		JLabel label1 = new JLabel();
		ImageIcon img1 = new ImageIcon("E:\\eclipse-workspace\\k201614\\src\\k201614\\images\\img1.jpg");
		label1.setIcon(img1);
		JLabel label2 = new JLabel();
		ImageIcon img2 = new ImageIcon("E:\\eclipse-workspace\\k201614\\src\\k201614\\images\\img2.jpg");
		label2.setIcon(img2);
		JLabel label3 = new JLabel();
		ImageIcon img3 = new ImageIcon("E:\\eclipse-workspace\\k201614\\src\\k201614\\images\\img3.jpg");
		label3.setIcon(img3);
		JLabel label4 = new JLabel();
		ImageIcon img4 = new ImageIcon("E:\\eclipse-workspace\\k201614\\src\\k201614\\images\\img4.jpg");
		label4.setIcon(img4);
		
		//placing labels in panel(card)
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		panel4.add(label4);
		
		//adding panels(cards) to the main panel
		panel.add(panel1, "1");
		panel.add(panel2, "2");
		panel.add(panel3, "3");
		panel.add(panel4, "4");
		JLabel likeLabel= new JLabel();
		JLabel dislikeLabel= new JLabel();
		JPanel buttonPanel = new JPanel();
		JPanel likePanel= new JPanel();
		JButton like = new JButton("like");
		JButton dislike = new JButton("Dislike");
		likePanel.add(dislike);
		likePanel.add(dislikeLabel);
		likePanel.add(like);
		
//		JPanel labelPanel = new JPanel();
//		labelPanel.add(likeLabel);
//		labelPanel.add(dislikeLabel);
		likePanel.add(likeLabel);

		
		like.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				likeCount[currCard-1]+=1;
				likeLabel.setText(""+likeCount[currCard-1]);
				System.out.println(likeCount[currCard-1]);
			}
			
		});

		dislike.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dislikeCount[currCard-1]+=1;
				dislikeLabel.setText(""+dislikeCount[currCard-1]);
				
			}
			
		});
	
	
		
		JButton firstB = new JButton("first");
		JButton nextB = new JButton(">>");
		JButton prevB = new JButton("<<");
		JButton lastB = new JButton("last");
		
		buttonPanel.add(firstB);
		buttonPanel.add(nextB);
		buttonPanel.add(prevB);
		buttonPanel.add(lastB);
		
		firstB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.first(panel);
				currCard = 1;
				likeLabel.setText(""+likeCount[currCard-1]);
				dislikeLabel.setText(""+dislikeCount[currCard-1]);
			}
		});
		
		lastB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.last(panel);
				currCard = 4;
				dislikeLabel.setText(""+likeCount[currCard-1]);
				dislikeLabel.setText(""+dislikeCount[currCard-1]);
			}
		});
		
		nextB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currCard < 4) {
					
					currCard += 1;
					layout.show(panel, "" +currCard);
					likeLabel.setText(""+likeCount[currCard-1]);
					dislikeLabel.setText(""+dislikeCount[currCard-1]);
				}
				
			}
		});
		
		prevB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currCard > 1) {
					currCard -= 1;
					layout.show(panel, "" +currCard);
					likeLabel.setText(""+likeCount[currCard-1]);
					dislikeLabel.setText(""+dislikeCount[currCard-1]);
				}
				
			}
		});
		
		// using to get the content pane  
		add(panel, BorderLayout.NORTH);  
		  
		// using to get the content pane  
		add(buttonPanel, BorderLayout.SOUTH); 
		
		add(likePanel,BorderLayout.CENTER);
		
		
	}

	public static void main(String[] args) {
		Practice ex = new Practice();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ex.setVisible(true);

	}

}
