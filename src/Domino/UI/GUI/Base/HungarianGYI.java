package Domino.UI.GUI.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.LINE_END;
import static javax.swing.SwingConstants.CENTER;

public class HungarianGYI extends JPanel implements ActionListener{
    private String name;
    private int players;
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

            setLayout(null);
            setVisible(true);
            setSize(500,500);
            setBounds(0,0,500,500);

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
            }
            setVisible(false);
        }
        public boolean visible()
        {
            if(isVisible())
            return true;
            else
               return false;
        }
    }
    public class GYIplayers implements ActionListener {
        private JButton pl[];

        public GYIplayers() {
            super();
            setLayout(null);
            setVisible(false);
            setSize(500, 500);
            setBounds(0, 0, 500, 500);

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
                }
            }
            System.out.println(players);
        }
    }
    public HungarianGYI()
    {
        super();
        setLayout(null);
        setVisible(true);
        setSize(500,500);
        setBounds(0,0,500,500);
      GYIname onoma=new GYIname();
        GYIplayers pl=new GYIplayers();

      /*  pl=new JButton[3];
        pl[0].setText("Players 2");
        pl[1].setText("Players 3");
        pl[2].setText("Players 4"); */


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        }

    public static void main(String args[]) {
        HungarianGYI gui=new HungarianGYI();
        JFrame fr=new JFrame("windows");
        fr.setLayout(null);
        fr.setSize(800,800);
        fr.setLocation(50,50);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(gui);
        fr.setVisible(true);

    }
}
