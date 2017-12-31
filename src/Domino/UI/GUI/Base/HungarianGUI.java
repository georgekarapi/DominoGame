package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HungarianGUI extends JPanel implements ActionListener{
    private String name;
    private int players;
    private JFrame windows;
    public HungarianGUI(JFrame windows)
    {
        super();
        this.windows=windows;
        setLayout(null);
        setVisible(true);
        setBounds(0,0,800,800);
        setBackground(Color.LIGHT_GRAY);
        GYIname onoma=new GYIname();
    }
    public class GYIname implements ActionListener
    {
        private JTextField onoma;
        private JButton ok;
        private JLabel keys;

        public GYIname()
        {
            super();
            onoma=new JTextField();
            JLabel keys=new JLabel("Your name:");
            ok=new JButton("OK");

            onoma.setBounds(250,250,200,30);
            onoma.addActionListener(this);
            add(onoma);

            keys.setBounds(170,250,100,30);
            add(keys);

            ok.addActionListener(this);
            ok.setBounds(220,300,200,40);
            add(ok);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(ok.getActionCommand()))
            { name=onoma.getText();
                System.out.println(name);
                setVisible(false);
                removeAll();
                setVisible(true);
                GYIplayers kat =new GYIplayers();
            }
        }

    }
    public class GYIplayers implements ActionListener {
        private JButton pl[];

        public GYIplayers() {
            super();
            pl = new JButton[3];
            pl[0] = new JButton("Players 2");
            pl[1] = new JButton("Players 3");
            pl[2] = new JButton("Players 4");

            pl[0].setBounds(250, 200, 200, 50);
            pl[1].setBounds(250, 300, 200, 50);
            pl[2].setBounds(250, 400, 200, 50);
            for (int i = 0; i < 3; i++) {
                pl[i].addActionListener(this);
                add(pl[i]);
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 3; i++) {
                if (e.getActionCommand().equals(pl[i].getActionCommand())) {
                    players = i + 2;
                    setVisible(false);
                    removeAll();
                    //paei sto kanonik;o game
                    setVisible(true);
                    Hands_Tiles  t=new Hands_Tiles();
                }
            }
        }
    }

   public class Hands_Tiles
   {
       private ArrayList<JButton> hands;
       private JPanel p1;
       public Hands_Tiles() {
           setBounds(0,0,800,600);
           GridLayout gl = new GridLayout(1,6,0,0);
           hands = new ArrayList<>();
           p1 = new JPanel();
           windows.add(p1);
           p1.setLayout(gl);
           p1.setBounds(0, 600, 800, 150);
           p1.setBackground(Color.BLUE);
           p1.setVisible(true);

           for (int i = 0; i < 6; i++) {
               JButton b1 = new JButton(i+"");
               b1.setBackground(Color.GREEN);
               b1.setSize(20,70);
               hands.add(b1);
               p1.add(b1);
           }

       }

       }



    @Override
    public void actionPerformed(ActionEvent e) {
        }

    public static void main(String args[]) {
        JFrame fr=new JFrame("windows");
        HungarianGUI gui=new HungarianGUI(fr);
        fr.setLayout(null);
        fr.setSize(820,801);
        fr.setLocation(50,50);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(gui);
        fr.setVisible(true);
//fr.setResizable(false);
    }
}
