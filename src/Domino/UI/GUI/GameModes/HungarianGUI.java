package Domino.UI.GUI.GameModes;

import Domino.GameModes.Hungarian.Hungarian;
import Domino.UI.GUI.Base.TableGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class HungarianGUI extends JPanel implements ActionListener{
    private String name;
    private int players;
    private JFrame windows;
    Hungarian game;
    private HashMap<JPanel,ArrayList<JLabel>> panel;
    //hashmap για πανελ και player
    public HungarianGUI(JFrame windows)
    {
        super();
        panel=new HashMap<>();
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
            { if(onoma.getText().equals(""))
                    return;
                name=onoma.getText();
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
                    Hands_Tiles();
                }
            }
        }
    }




       public void Hands_Tiles(){
           int x=0,y=0;
           game=new Hungarian(players,name);
           if(players==2)
           {x=y=0;}
           else if(players==3)
           {x=100; y=10;}
           else if(players==4)
           {x=200;y=20;}
           setBounds(0,0,800,600);
           JPanel p1 = new JPanel();

           windows.add(p1);
           p1.setBackground(Color.BLUE);
           p1.setVisible(true);
           GridLayout gl = new GridLayout(1,game.get_numberTile(),0,0);
           p1.setLayout(gl);
           p1.setBounds(x, 600, 800-2*x, 150-2*y);
           for (int i = 0; i < game.get_numberTile(); i++) {
               JButton b1 = new JButton("["+i+"]");
               b1.setBackground(Color.GREEN);
               b1.setSize(20,70);
               p1.add(b1);
               //panel.put(p1,);
           }
           if(players==2)
           players_2(game.get_numberTile());
           else if(players==3)
            players_3(game.get_numberTile());
            else if(players==4)
                players_4(game.get_numberTile());
            TableGUI g=new TableGUI(this);
            g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),true);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);
           g.add_TableGUI(new JButton(),false);


       }
       public void players_2(int x)
       {
           int y=100*(players-2);
           setBounds(100,100,600,500);
           setBackground(Color.cyan);
           JPanel p2=new JPanel();
           p2.setVisible(true);
           p2.setLayout(new GridLayout(1,game.get_numberTile(),0,0));
           p2.setBounds(200,20,400-y,70);
           p2.setBackground(Color.WHITE);
           for(int i=0;i<x;i++)
           {
               JButton b = new JButton();
               b.setBackground(Color.yellow);
               p2.add(b);
           }
           windows.add(p2);
         //  panel.add(p2);
           //removes_Hands(p2,p2.);
       }
       public void players_3(int x)
       {
           players_2(x);
           int y=100*(players-2);
           JPanel p3=new JPanel();
           p3.setVisible(true);
           p3.setLayout(new GridLayout(game.get_numberTile(),1,0,0));
           p3.setBounds(20,150,70,400-y);
           p3.setBackground(Color.BLACK);
           for(int i=0;i<x;i++)
           {
               JButton b = new JButton();
               b.setBackground(Color.yellow);
               p3.add(b);
           }
         //  panel.add(p3);
           windows.add(p3);
       }
       public void players_4(int x)
       {
           players_3(x);
           int y=100*(players-2);
           JPanel p4=new JPanel();
           p4.setVisible(true);
           p4.setLayout(new GridLayout(game.get_numberTile(),1,0,0));
           p4.setBounds(720,150,70,400-y);
           p4.setBackground(Color.BLACK);
           for(int i=0;i<x;i++)
           {
               JButton b = new JButton();
               b.setBackground(Color.yellow);
               p4.add(b);
           }
         //  panel.add(p4);
           windows.add(p4);
       }
       public void removes_Hands(Panel p,int b)
       {

         //  p.setBounds(p.getX(),p.getY(),p.getWidth()-x,p.getHeight());
          // p.remove(b);
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
