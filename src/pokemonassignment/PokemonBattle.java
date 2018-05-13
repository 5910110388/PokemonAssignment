/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
/**
 *
 * @author atthavit
 */
public class PokemonBattle extends JFrame{
    
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    int count = 0;
    
    public PokemonBattle(){
        super("Battle!");
    
        Icon iconEevee     = new ImageIcon(getClass().getResource("pic/Eevee.png"));
        Icon iconLizardo     = new ImageIcon(getClass().getResource("pic/Lizardo.png"));
        Icon iconPikachu     = new ImageIcon(getClass().getResource("pic/Pikachu.png"));
        
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        
        JPanel head = new JPanel();
        head.setLayout(new GridLayout(1, 2, 10, 7));
        head.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2, 10, 7));
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(6, 2, 5, 10));
        p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel p4 = new JPanel();
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        
        JPanel p5 = new JPanel();
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
        
        JLabel picPokemon1 = new JLabel("");
        JLabel picPokemon2 = new JLabel("");
        
    
        JLabel lbName = new JLabel("Name : ");
        JLabel lbWeight = new JLabel("Weight : ");
        JLabel lbStepLength = new JLabel("Step Length : ");
        JLabel lbHealth = new JLabel("Health : ");
        JLabel lbSkill = new JLabel("Skills / Damage : ");
        JLabel lbHealthCompetitor1 = new JLabel("Health Competitor1 : ");
        JLabel lbHealthCompetitor2 = new JLabel("Health Competitor2 : ");

        JLabel lbPicture = new JLabel("Competitor1 & Competitor1", SwingConstants.CENTER);
        JLabel lbStatus = new JLabel("STATUS", SwingConstants.CENTER);
        
        
        JButton btnAttack = new JButton("Attack!");
        JButton btnUltimate = new JButton("Ultimate!");
        
        JTextField txtName = new JTextField();
        txtName.setEditable(false);
        txtName.setHorizontalAlignment(JTextField.CENTER);
        JTextField txtWeight = new JTextField();
        txtWeight.setEditable(false);
        txtWeight.setHorizontalAlignment(JTextField.CENTER);
        JTextField txtStepLength = new JTextField();
        txtStepLength.setEditable(false);
        txtStepLength.setHorizontalAlignment(JTextField.CENTER);
        JTextField txtHealth = new JTextField();
        txtHealth.setEditable(false);
        txtHealth.setHorizontalAlignment(JTextField.CENTER);
        
        JTextField txtHealthCompetitor1 = new JTextField();
        txtHealthCompetitor1.setEditable(false);
        txtHealthCompetitor1.setHorizontalAlignment(JTextField.CENTER);
        
        JTextField txtHealthCompetitor2 = new JTextField();
        txtHealthCompetitor2.setEditable(false);
        txtHealthCompetitor2.setHorizontalAlignment(JTextField.CENTER);
        
        JProgressBar barCompetitor1 = new JProgressBar();
        barCompetitor1.setValue(0);
        
        JProgressBar barCompetitor2 = new JProgressBar();
        barCompetitor2.setValue(0);


        
        String[] pokemonsString = {"Pikachu", "Eevee", "Lizardo"};
        JComboBox pokemonsLisCompetitor1 = new JComboBox(pokemonsString);
        JComboBox pokemonsLisCompetitor2 = new JComboBox(pokemonsString);
        String[] berryString = {"Berry", "GoldBerry", "MysteryBerry"};
        JComboBox berryList = new JComboBox(berryString);

        
        head.add(lbPicture);
        head.add(lbStatus);
        
         
        p3.add(pokemonsLisCompetitor1);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(pokemonsLisCompetitor2);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(btnAttack);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(btnUltimate);

        
        
        p4.add(barCompetitor1);
        p4.add(lbHealthCompetitor1);
        p4.add(txtHealthCompetitor1);
        p5.add(barCompetitor2);
        p5.add(lbHealthCompetitor2);
        p5.add(txtHealthCompetitor2);

        
        p1.add(picPokemon1);
        p1.add(p4);
        p1.add(picPokemon2);
        p1.add(p5);
        
        c.add(head, BorderLayout.NORTH);
        c.add(p1, BorderLayout.CENTER);
        c.add(p3, BorderLayout.SOUTH);
        
        Pikachu pikachuCompetitor1 = new Pikachu();
        Pikachu pikachuCompetitor2 = new Pikachu();
        
        Eevee eeveeCompetitor1 = new Eevee();
        Eevee eeveeCompetitor2 = new Eevee();
        
        Lizardo lizardoCompetitor1 = new Lizardo();
        Lizardo lizardoCompetitor2 = new Lizardo();
        
        pokemons.add(pikachuCompetitor1);
        pokemons.add(eeveeCompetitor1);
        pokemons.add(lizardoCompetitor1);
        pokemons.add(pikachuCompetitor2);
        pokemons.add(eeveeCompetitor2);
        pokemons.add(lizardoCompetitor2);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        pokemonsLisCompetitor1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            switch (pokemonsLisCompetitor1.getSelectedIndex()) {
                    case 0:
                        int indexPikachu = 0;
                        picPokemon1.setIcon(iconPikachu);
                        txtName.setText(pokemons.get(indexPikachu).getName());
                        txtWeight.setText(""+pokemons.get(indexPikachu).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexPikachu).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexPikachu).getHealth());
                        
                        
                        break;
                    case 1:
                        int indexEevee = 1;
                        picPokemon1.setIcon(iconEevee);
                        txtName.setText(pokemons.get(indexEevee).getName());
                        txtWeight.setText(""+pokemons.get(indexEevee).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexEevee).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexEevee).getHealth());
                        break;
                    case 2:
                        int indexLizardo = 2;
                        picPokemon1.setIcon(iconLizardo);
                        txtName.setText(pokemons.get(indexLizardo).getName());
                        txtWeight.setText(""+pokemons.get(indexLizardo).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexLizardo).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexLizardo).getHealth());
                        break;
                    default:
                        break;
                }
            }
        
        });
        
            pokemonsLisCompetitor2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            switch (pokemonsLisCompetitor2.getSelectedIndex()) {
                    case 0:
                        int indexPikachu = 0;
                        picPokemon2.setIcon(iconPikachu);
                        txtName.setText(pokemons.get(indexPikachu).getName());
                        txtWeight.setText(""+pokemons.get(indexPikachu).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexPikachu).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexPikachu).getHealth());
                        
                        
                        break;
                    case 1:
                        int indexEevee = 1;
                        picPokemon2.setIcon(iconEevee);
                        txtName.setText(pokemons.get(indexEevee).getName());
                        txtWeight.setText(""+pokemons.get(indexEevee).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexEevee).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexEevee).getHealth());
                        break;
                    case 2:
                        int indexLizardo = 2;
                        picPokemon2.setIcon(iconLizardo);
                        txtName.setText(pokemons.get(indexLizardo).getName());
                        txtWeight.setText(""+pokemons.get(indexLizardo).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexLizardo).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexLizardo).getHealth());
                        break;
                    default:
                        break;
                }
            }
        
        });
            
            int indexPikachuCompetitor1 = 0;
            int indexEeveeCompetitor1 = 1;
            int indexLizardoCompetitor1 = 2;
            int indexPikachuCompetitor2 = 3;
            int indexEeveeCompetitor2 = 4;
            int indexLizardoCompetitor2 = 5;

            btnAttack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            if (pokemonsLisCompetitor1.getSelectedIndex() == 0 && pokemonsLisCompetitor2.getSelectedIndex() == 0){
                      JOptionPane.showMessageDialog(null, "ไม่สามารถต่อสู้กับตัวเองได้", "Warning", JOptionPane.PLAIN_MESSAGE);
                }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 0 && pokemonsLisCompetitor2.getSelectedIndex() == 1){
                if(count % 2 == 0){
                    pikachuCompetitor1.attack(eeveeCompetitor2);
                }
                else eeveeCompetitor2.attack(pikachuCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexPikachuCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexEeveeCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexPikachuCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexEeveeCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 0 && pokemonsLisCompetitor2.getSelectedIndex() == 2){
                if(count % 2 == 0){
                    pikachuCompetitor1.attack(lizardoCompetitor2);
                }
                else lizardoCompetitor2.attack(pikachuCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexPikachuCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexLizardoCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexPikachuCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexLizardoCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 1 && pokemonsLisCompetitor2.getSelectedIndex() == 0){
                if(count % 2 == 0){
                    eeveeCompetitor1.attack(pikachuCompetitor2);
                }
                else pikachuCompetitor2.attack(eeveeCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexEeveeCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexPikachuCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexEeveeCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexPikachuCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 1 && pokemonsLisCompetitor2.getSelectedIndex() == 1){
                      JOptionPane.showMessageDialog(null, "ไม่สามารถต่อสู้กับตัวเองได้", "Warning", JOptionPane.PLAIN_MESSAGE);
                }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 1 && pokemonsLisCompetitor2.getSelectedIndex() == 2){
                if(count % 2 == 0){
                    eeveeCompetitor1.attack(lizardoCompetitor2);
                }
                else lizardoCompetitor2.attack(eeveeCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexEeveeCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexLizardoCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexEeveeCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexLizardoCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 2 && pokemonsLisCompetitor2.getSelectedIndex() == 0){
                if(count % 2 == 0){
                    lizardoCompetitor1.attack(pikachuCompetitor2);
                }
                else pikachuCompetitor2.attack(lizardoCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexLizardoCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexPikachuCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexLizardoCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexPikachuCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 2 && pokemonsLisCompetitor2.getSelectedIndex() == 1){
                if(count % 2 == 0){
                    lizardoCompetitor1.attack(eeveeCompetitor2);
                }
                else eeveeCompetitor2.attack(lizardoCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexLizardoCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexEeveeCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexLizardoCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexEeveeCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 2 && pokemonsLisCompetitor2.getSelectedIndex() == 2){
                      JOptionPane.showMessageDialog(null, "ไม่สามารถต่อสู้กับตัวเองได้", "Warning", JOptionPane.PLAIN_MESSAGE);
                }
            
            
            }
           
        
        });
            
            btnUltimate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            if (pokemonsLisCompetitor1.getSelectedIndex() == 0 && pokemonsLisCompetitor2.getSelectedIndex() == 0){
                      JOptionPane.showMessageDialog(null, "ไม่สามารถต่อสู้กับตัวเองได้", "Warning", JOptionPane.PLAIN_MESSAGE);
                }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 0 && pokemonsLisCompetitor2.getSelectedIndex() == 1){
                if(count % 2 == 0){
                    pikachuCompetitor1.untimate(eeveeCompetitor2);
                }
                else eeveeCompetitor2.untimate(pikachuCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexPikachuCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexEeveeCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexPikachuCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexEeveeCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 0 && pokemonsLisCompetitor2.getSelectedIndex() == 2){
                if(count % 2 == 0){
                    pikachuCompetitor1.untimate(lizardoCompetitor2);
                }
                else lizardoCompetitor2.untimate(pikachuCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexPikachuCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexLizardoCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexPikachuCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexLizardoCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 1 && pokemonsLisCompetitor2.getSelectedIndex() == 0){
                if(count % 2 == 0){
                    eeveeCompetitor1.untimate(pikachuCompetitor2);
                }
                else pikachuCompetitor2.untimate(eeveeCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexEeveeCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexPikachuCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexEeveeCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexPikachuCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 1 && pokemonsLisCompetitor2.getSelectedIndex() == 1){
                      JOptionPane.showMessageDialog(null, "ไม่สามารถต่อสู้กับตัวเองได้", "Warning", JOptionPane.PLAIN_MESSAGE);
                }
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 1 && pokemonsLisCompetitor2.getSelectedIndex() == 2){
                if(count % 2 == 0){
                    eeveeCompetitor1.untimate(lizardoCompetitor2);
                }
                else lizardoCompetitor2.untimate(eeveeCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexEeveeCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexLizardoCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexEeveeCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexLizardoCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 2 && pokemonsLisCompetitor2.getSelectedIndex() == 0){
                if(count % 2 == 0){
                    lizardoCompetitor1.untimate(pikachuCompetitor2);
                }
                else pikachuCompetitor2.untimate(lizardoCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexLizardoCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexPikachuCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexLizardoCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexPikachuCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 2 && pokemonsLisCompetitor2.getSelectedIndex() == 1){
                if(count % 2 == 0){
                    lizardoCompetitor1.untimate(eeveeCompetitor2);
                }
                else eeveeCompetitor2.untimate(lizardoCompetitor1);
                
                txtHealthCompetitor1.setText(""+pokemons.get(indexLizardoCompetitor1).getHealth()+" / 200");
                txtHealthCompetitor2.setText(""+pokemons.get(indexEeveeCompetitor2).getHealth()+" / 200");
                
                barCompetitor1.setValue((int)pokemons.get(indexLizardoCompetitor1).getHealth() / 2);
                barCompetitor2.setValue((int)pokemons.get(indexEeveeCompetitor2).getHealth() / 2);
                
                count += 1;
            }
            
            else if(pokemonsLisCompetitor1.getSelectedIndex() == 2 && pokemonsLisCompetitor2.getSelectedIndex() == 2){
                      JOptionPane.showMessageDialog(null, "ไม่สามารถต่อสู้กับตัวเองได้", "Warning", JOptionPane.PLAIN_MESSAGE);
                }
            
            
            }
           
        
        });
        
                
    
    }

    
    
    
//    public static void main (String args[]){
//       new PokemonBattle();
//    }

}
