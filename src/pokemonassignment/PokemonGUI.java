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
public class PokemonGUI extends JFrame{
    
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    
    public PokemonGUI(){
        super("PokemonGame Version 1.0");
    
        Icon iconEevee     = new ImageIcon(getClass().getResource("pic/Eevee.png"));
        Icon iconLizardo     = new ImageIcon(getClass().getResource("pic/Lizardo.png"));
        Icon iconPikachu     = new ImageIcon(getClass().getResource("pic/Pikachu.png"));
        
        makeMenuBar();
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        
        JPanel head = new JPanel();
        head.setLayout(new GridLayout(1, 2, 10, 7));
        head.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2, 10, 7));
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(6, 2, 5, 10));
        p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel picPokemon = new JLabel("");
        
    
        JLabel lbName = new JLabel("Name : ");
        JLabel lbWeight = new JLabel("Weight : ");
        JLabel lbStepLength = new JLabel("Step Length : ");
        JLabel lbHealth = new JLabel("Health : ");
        JLabel lbSkill = new JLabel("Skills / Damage : ");

        JLabel lbPicture = new JLabel("PICTURE", SwingConstants.CENTER);
        JLabel lbStatus = new JLabel("STATUS", SwingConstants.CENTER);
        
        
        JButton btnCatch = new JButton("Catch Pokemon");
        JButton btnSelect = new JButton("Select Pokemon in the farm");
        JButton btnEat = new JButton("Eat");
        JButton btnExercise = new JButton("Exercise");
        JButton btnWalk = new JButton("Walk");
        JButton btnBattle = new JButton("Battle!");
        
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
        

        String[] pokemonsString = {"Pikachu", "Eevee", "Lizardo"};
        JComboBox pokemonsList = new JComboBox(pokemonsString);
        String[] berryString = {"Berry", "GoldBerry", "MysteryBerry"};
        JComboBox berryList = new JComboBox(berryString);

        
        head.add(lbPicture);
        head.add(lbStatus);
        
        p2.add(lbName);
        p2.add(txtName);
        p2.add(lbWeight);
        p2.add(txtWeight);
        p2.add(lbStepLength);
        p2.add(txtStepLength);
        p2.add(lbHealth);
        p2.add(txtHealth);


         
        p3.add(pokemonsList);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(berryList);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(btnEat);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(btnExercise);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(btnWalk);
        p3.add(Box.createRigidArea(new Dimension(5,0)));
        p3.add(btnBattle);

        
        p1.add(picPokemon);
        p1.add(p2);
        
        c.add(head, BorderLayout.NORTH);
        c.add(p1, BorderLayout.CENTER);
        c.add(p3, BorderLayout.SOUTH);
        
        pokemons.add(new Pikachu());
        pokemons.add(new Eevee());
        pokemons.add(new Lizardo());
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        pokemonsList.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            switch (pokemonsList.getSelectedIndex()) {
                    case 0:
                        int indexPikachu = 0;
                        picPokemon.setIcon(iconPikachu);
                        txtName.setText(pokemons.get(indexPikachu).getName());
                        txtWeight.setText(""+pokemons.get(indexPikachu).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexPikachu).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexPikachu).getHealth());
                        
                        
                        break;
                    case 1:
                        int indexEevee = 1;
                        picPokemon.setIcon(iconEevee);
                        txtName.setText(pokemons.get(indexEevee).getName());
                        txtWeight.setText(""+pokemons.get(indexEevee).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexEevee).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexEevee).getHealth());
                        break;
                    case 2:
                        int indexLizardo = 2;
                        picPokemon.setIcon(iconLizardo);
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
        
        btnEat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            switch (pokemonsList.getSelectedIndex()) {
                    case 0:
                        int indexPikachu = 0;
                        eatBerry(berryList.getSelectedIndex(), 0);
                        picPokemon.setIcon(iconPikachu);
                        txtName.setText(pokemons.get(indexPikachu).getName());
                        txtWeight.setText(""+pokemons.get(indexPikachu).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexPikachu).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexPikachu).getHealth()+" / 200");
                        break;
                    case 1:
                        int indexEevee = 1;
                        eatBerry(berryList.getSelectedIndex(), 1);
                        picPokemon.setIcon(iconEevee);
                        txtName.setText(pokemons.get(indexEevee).getName());
                        txtWeight.setText(""+pokemons.get(indexEevee).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexEevee).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexEevee).getHealth()+" / 200");
                        break;
                    case 2:
                        int indexLizardo = 2;
                        eatBerry(berryList.getSelectedIndex(), 2);
                        picPokemon.setIcon(iconLizardo);
                        txtName.setText(pokemons.get(indexLizardo).getName());
                        txtWeight.setText(""+pokemons.get(indexLizardo).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexLizardo).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexLizardo).getHealth()+" / 200");
                        break;
                    default:
                        break;
                }
            }
        
        });
        
        btnExercise.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            switch (pokemonsList.getSelectedIndex()) {
                    case 0:                       
                        int indexPikachu = 0;
                        pokemons.get(indexPikachu).move();
                        picPokemon.setIcon(iconPikachu);
                        txtName.setText(pokemons.get(indexPikachu).getName());
                        txtWeight.setText(""+pokemons.get(indexPikachu).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexPikachu).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexPikachu).getHealth()+" / 200");
                        break;
                    case 1:
                        int indexEevee = 1;
                        pokemons.get(indexEevee).move();
                        picPokemon.setIcon(iconEevee);
                        txtName.setText(pokemons.get(indexEevee).getName());
                        txtWeight.setText(""+pokemons.get(indexEevee).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexEevee).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexEevee).getHealth()+" / 200");
                        break;
                    case 2:
                        int indexLizardo = 2;
                        pokemons.get(indexLizardo).move();
                        picPokemon.setIcon(iconLizardo);
                        txtName.setText(pokemons.get(indexLizardo).getName());
                        txtWeight.setText(""+pokemons.get(indexLizardo).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexLizardo).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexLizardo).getHealth()+" / 200");
                        break;
                    default:
                        break;
                }
            }
        
        });
        
                btnWalk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            switch (pokemonsList.getSelectedIndex()) {
                    case 0:                       
                        int indexPikachu = 0;
                        pokemons.get(indexPikachu).walk();
                        picPokemon.setIcon(iconPikachu);
                        txtName.setText(pokemons.get(indexPikachu).getName());
                        txtWeight.setText(""+pokemons.get(indexPikachu).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexPikachu).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexPikachu).getHealth()+" / 200");
                        break;
                    case 1:
                        int indexEevee = 1;
                        pokemons.get(indexEevee).walk();
                        picPokemon.setIcon(iconEevee);
                        txtName.setText(pokemons.get(indexEevee).getName());
                        txtWeight.setText(""+pokemons.get(indexEevee).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexEevee).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexEevee).getHealth()+" / 200");
                        break;
                    case 2:
                        int indexLizardo = 2;
                        pokemons.get(indexLizardo).walk();
                        picPokemon.setIcon(iconLizardo);
                        txtName.setText(pokemons.get(indexLizardo).getName());
                        txtWeight.setText(""+pokemons.get(indexLizardo).getWeight());
                        txtStepLength.setText(""+pokemons.get(indexLizardo).getStepLength());
                        txtHealth.setText(""+pokemons.get(indexLizardo).getHealth()+" / 200");
                        break;
                    default:
                        break;
                }
            }
        
        });

            btnBattle.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PokemonBattle battle = new PokemonBattle();
                
            }
        
        });

                
    
    }
    
    private void makeMenuBar(){
          JMenuBar menuBar = new JMenuBar();
          setJMenuBar(menuBar);
          
          JMenu helpMenu = new JMenu("Help");
          menuBar.add(helpMenu);
          
          JMenuItem aboutItem = new JMenuItem("About");
          aboutItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aboutDialog();
            }
          });
          
          helpMenu.add(aboutItem);

    }
    
    private void aboutDialog(){
      JOptionPane.showMessageDialog(null, "Create by Mr. Atthavit Boonraasamee"+"\nPrince Of Songkla University", "About", JOptionPane.PLAIN_MESSAGE);
    }
    
    private void eatBerry(int type, int index){
        Berry berry = new Berry(type);
        pokemons.get(index).eat(berry);
    }
    
    
    
//    public static void main (String args[]){
//       new PokemonGUI();
//    }

}
