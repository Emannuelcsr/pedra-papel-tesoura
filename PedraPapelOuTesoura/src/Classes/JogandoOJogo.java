package Classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JogandoOJogo extends JDialog {

    private String [] mao = {"Pedra","Papel", "Tesoura"};
    
    private JPanel jPanel = new JPanel(new GridBagLayout());
    
    private JLabel jLabel1 = new JLabel("Jogador 1");
    private JComboBox<String> jComboBox1 = new JComboBox<>(mao);       
    private JLabel jLabel2 = new JLabel("X");    
    private JLabel jLabel3 = new JLabel("Jogador 2");
    private JComboBox<String> jComboBox2 = new JComboBox<>(mao);
    
    private JLabel divisao = new JLabel("==================================");
      
    private JTextField jTextField3 = new JTextField();
    
    private JButton resultado = new JButton("Ver resultado");
    
    public JogandoOJogo() {
        setTitle("Jogo: Pedra, Papel ou Tesoura");
        setSize(new Dimension(270,270));
        setLocationRelativeTo(null);
        setResizable(false);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.anchor=gridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(5, 10, 5, 30);

        
        jLabel1.setPreferredSize(new Dimension(60,30));
        jPanel.add(jLabel1,gridBagConstraints);
        
        gridBagConstraints.gridx++;
        
        jComboBox1.setPreferredSize(new Dimension(90,20));
        jPanel.add(jComboBox1,gridBagConstraints);
              
        gridBagConstraints.gridy++;

        jLabel2.setPreferredSize(new Dimension(20,30));
        jPanel.add(jLabel2,gridBagConstraints);
        
        gridBagConstraints.gridy++;
        
        gridBagConstraints.gridx=0;
        jLabel3.setPreferredSize(new Dimension(90,30));
        jPanel.add(jLabel3, gridBagConstraints);
        
        gridBagConstraints.gridx++;
        
        jComboBox2.setPreferredSize(new Dimension(90,20));
        jPanel.add(jComboBox2,gridBagConstraints);
                
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridwidth=3;

        divisao.setPreferredSize(new Dimension(240,50));
        jPanel.add(divisao,gridBagConstraints);
        
        gridBagConstraints.gridy++;
                
        resultado.setPreferredSize(new Dimension(120,30));
        jPanel.add(resultado,gridBagConstraints);

        gridBagConstraints.gridx++;
        
        gridBagConstraints.gridwidth=3;
        jTextField3.setPreferredSize(new Dimension(110,30));
        jTextField3.setEditable(false);
        jPanel.add(jTextField3,gridBagConstraints);
                         
        resultado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String escolhaJogador1 = (String) jComboBox1.getSelectedItem();
		        String escolhaJogador2 = (String) jComboBox2.getSelectedItem();
				
		        if (escolhaJogador1.equals(escolhaJogador2)) {
		            jTextField3.setText("Empate!");
		        } else if (escolhaJogador1.equals("Pedra") && escolhaJogador2.equals("Tesoura") ||
		                   escolhaJogador1.equals("Tesoura") && escolhaJogador2.equals("Papel") ||
		                   escolhaJogador1.equals("Papel") && escolhaJogador2.equals("Pedra")) {
		            jTextField3.setText("Jogador 1 venceu!");
		        } else {
		            jTextField3.setText("Jogador 2 venceu!");
		        }
								
			}
		});
                
        add(jPanel,BorderLayout.WEST);
        setVisible(true);
    }
}