package Domino.UI.GUI.GameModes;

import Domino.GameModes.Cardinal.Cardinal;
import Domino.GameModes.Hungarian.Bot;
import Domino.GameModes.Hungarian.Player;
import Domino.GameModes.Hungarian.Round;
import Domino.UI.GUI.Base.TableGUI;
import Domino.UI.GUI.Base.TilesTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CardinalGUI extends JPanel implements ActionListener {
    private String name;
    private int players = 2;
    private Cardinal game;
    private JButton turn;
    private ArrayList<JPanel> panels;
    private boxScore box;
    private TilesTable my;
    private TableGUI table;
private JButton draw;
    public CardinalGUI() {
        super();
        setLayout(null);
        setVisible(true);
        setBounds(0, 0, 800, 800);
        setBackground(Color.orange);
        turn = new JButton();
        panels = new ArrayList<>();

        GYIname onoma = new GYIname(this);


    }

    public static void main(String args[]) {

        JFrame fr = new JFrame("windows");
        fr.setLayout(null);
        fr.setSize(820, 801);
        fr.setLocation(50, 50);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        CardinalGUI gui = new CardinalGUI();
        fr.add(gui);
        fr.setVisible(true);

    }

    public void constructor()//arxikopoiei gia to paixnidi ta antikeimena
    {
        game = new Cardinal(players, name);
        JLabel your = new JLabel(game.my_player().get_name());
        your.setBounds(100, 620, 100, 10);
        add(your);
        box = new boxScore(680, 0, 100, 75);
        add(box);
        turn.setBounds(660, 630, 130, 130);
        turn.setBackground(Color.pink);
        add(turn);
        for (int i = 0; i < game.get_numberTile(); i++) {
            panels.add(new JPanel());
        }

draw=new JButton();
        draw.setBounds(0,0,175,75);
        draw.setText("Draw");
        add(draw);
        draw.addActionListener(this);
    }

    public void Hands_Tiles() {
        game.Cardinal_start_game();
        int x = 0, y = 0;
        if (players == 2) {
            x = y = 0;
        } else if (players == 3) {
            x = 100;
            y = 10;
        } else if (players == 4) {
            x = 200;
            y = 20;
        }
        if (players == 2)
            players_2(game.get_numberTile());
        else if (players == 3)
            players_3(game.get_numberTile());
        else if (players == 4)
            players_4(game.get_numberTile());
        JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(100, 100, 600, 500);
        a.setBackground(Color.GREEN);
        add(a);
        table = new TableGUI(game.get_Table_Cardinal(), a);
        table.set_Player(game.my_player());
        my = new TilesTable(100, 650, 600, 200, game.my_player().Tiles(), 68, this, table);
        table.set_TilesTable(my);
        repaint();
//gia to tamlo arxikopoisi
        setVisible(true);

    }

    public void players_2(int x) {
        JLabel la2 = new JLabel("bot1");
        la2.setBounds(200, 0, 75, 10);
        int y = 100 * (players - 2);
        // panels.get(0).setVisible(false);
        panels.get(0).setLayout(new GridLayout(1, game.get_numberTile(), 0, 0));
        panels.get(0).setBounds(200, 20, 400 - y, 70);
        add_button(panels.get(0), x);
        add(la2);
        add(panels.get(0));
        // panels.get(0).repaint();panels.get(0).setVisible(true);
    }

    public void players_3(int x) {
        JLabel la3 = new JLabel("bot2");
        la3.setBounds(30, 136, 70, 10);
        players_2(x);
        int y = 100 * (players - 2);

        //panels.get(1).setVisible(false);
        panels.get(1).setLayout(new GridLayout(game.get_numberTile(), 1, 0, 0));
        panels.get(1).setBounds(20, 150, 70, 400 - y);
        add_button(panels.get(1), x);
        add(panels.get(1));
        add(la3);
        //panels.get(1).repaint();panels.get(1).setVisible(true);
    }

    public void players_4(int x) {
        JLabel la4 = new JLabel("bot3");
        la4.setBounds(730, 136, 70, 10);
        players_3(x);
        int y = 100 * (players - 2);

        //panels.get(2).setVisible(false);
        panels.get(2).setLayout(new GridLayout(game.get_numberTile(), 1, 0, 0));
        panels.get(2).setBounds(720, 150, 70, 400 - y);
        add_button(panels.get(2), x);
        add(panels.get(2));
        add(la4);
        // panels.add(panels.get(2));
        //panels.get(2).repaint();panels.get(2).setVisible(true);

    }

    /* public class Interrupt9 implements Runnable
     {
         public void run() {
             for(JPanel jp:panels)
             {add_button(jp,game.Cardinal_get_numberTile());
             }
         }
     }*/
    private void add_button(JPanel pan, int number) {
        pan.removeAll();
        for (int i = 0; i < number; i++) {
            JButton b = new JButton();
            b.setBackground(Color.red);
            b.setVisible(false);
            pan.add(b);
            b.setVisible(true);
            b.repaint();
        }
    }

    public void startGameHungarian() {
        int k;
        constructor();
        while (!game.finishGame()) {
            //sto telos sta grafika
            k = game.get_numberTile();
            Thread t = new Thread(new Interrupt2());
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
            }
            System.out.println("Round " + game.getRound().numRound() + "os");
            sleep();
            while (game.cardinal_movesPlayers()&&! game.cardinal_not_tile()) {
                for (int i = 0; i < players; i++) {
                    draw.setText("It has"+game.get_Stack().size_Dominoes()+" tiles");
                    if (game.turn_Bot(i)) {
                        while (game.Cardinal_has_move_bot_andStack(i)) {//&&!game.is_empty_tiles(game.get_Player(i))
                            boolean lr;
                            if (my.enable)
                                my.removeMouseListenet();
                            turn.setLabel(game.get_Player(i).get_name() + " turn");
                            //  if(game.is_empty_tiles(game.get_Player(i))){}
                               if(game.Cardinal_has_move_bot(i)){
                                  lr=game.Cardinal_move_bot(i);
                                  Thread x = new Thread(new Interrupt3(lr));
                                  x.start();
                                  try {
                                      x.join();
                                  } catch (InterruptedException e) {
                                  }


                                   JPanel len=null;
                                   if(game.get_Player(i).get_name().equals("bot1"))
                                       len=panels.get(0);
                                   else if(game.get_Player(i).get_name().equals("bot2"))
                                       len=panels.get(1);
                                   else if(game.get_Player(i).get_name().equals("bot3"))
                                       len=panels.get(2);
                                   sleep();
                                   Interrupt10 inter11 = new Interrupt10(len,game.get_Player(i).Tiles().size());
                                   Thread p11 = new Thread(inter11);
                                   p11.start();
                                   try {
                                       p11.join();
                                   } catch (InterruptedException e) {
                                   }
                            draw.setText("It has"+game.get_Stack().size_Dominoes()+" tiles");}
                            else
                            {
                                while(!game.Cardinal_has_move_bot(i)&&game.get_Stack().size_Dominoes()>2)
                                    game.draw_Tile(game.get_Player(i));
                            }
                        }

                    } else {
                        if (!my.enable)
                            my.addMouseListener();
                        turn.setLabel(game.get_Player(i).get_name() + " turn");
                        boolean bool = true;
                        while (bool) {
                            Interrupt4 inter = new Interrupt4();
                            Thread my_turn = new Thread(inter);
                            my_turn.start();
                            try {
                                my_turn.join();
                            } catch (InterruptedException e) {
                            }
                            bool = inter.get_bool();
                            if(!bool)
                            {
                                while(!game.Cardinal_playerTurn() && game.get_Stack().size_Dominoes()>2)
                                {game.draw_Tile(game.my_player());
                                    my.add_draw(game.my_player().Tiles().get(game.my_player().Tiles().size()-1));
                                    draw.setText("It has"+game.get_Stack().size_Dominoes()+" tiles");
                                }
                                if(game.Cardinal_playerTurn())
                                    bool=true;
                                else
                                    bool=false;
                            }
                        }

                    }
                }
            }
            System.out.println("Finish round " + game.getRound().numRound());
            game.cardinal_finishRound();
            box.finish_round();
            game.newRound();
            game.deleteHands();
            remove(table.get_panel());
            table = null;
            my.removes_all_DraggableImage();
        }
        if (game.getRound().pointPlayer(game.my_player()) >= 100) {
            System.out.println("You win");
            removeAll();
            repaint();
            JOptionPane.showMessageDialog(null,
                    "You Win");
        } else {
            System.out.println("You lost");
            removeAll();
            repaint();
            JOptionPane.showMessageDialog(null,
                    "You Lost");
        }
    }

    public int remove_Hands(int i, int k) {
        if (game.get_Player(i).get_name().equals("bot1")) {
            k--;
            panels.get(0).remove(k);
            panels.get(0).setBounds(panels.get(0).getX(), panels.get(0).getY(), panels.get(0).getWidth() - 30, panels.get(0).getHeight());
            panels.get(0).repaint();
        } else if (game.get_Player(i).get_name().equals("bot2")) {
            panels.get(1).remove(0);
            panels.get(1).repaint();
        } else if (game.get_Player(i).get_name().equals("bot3")) {
            panels.get(2).remove(0);
            panels.get(2).repaint();
        }
        return k;
    }

    //threads sto remove hands kai sto panel na krataei ta button kai aplos na ta krybi setvisible(false)!!!!!!!!
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(draw.getActionCommand())&& my.enable )
        {System.out.println(1111);
           if(game.draw_Tile(game.my_player()))
           {
               my.add_draw(game.my_player().Tiles().get(game.my_player().Tiles().size()-1));
               draw.setText("It has"+game.get_Stack().size_Dominoes()+" tiles");
           }
        }
    }

    public class GYIname implements ActionListener {
        private JTextField onoma;
        private JButton ok;
        private JLabel keys;
        private JPanel p;

        public GYIname(JPanel p) {
            super();
            this.p = p;

            onoma = new JTextField();
            JLabel keys = new JLabel("Your name:");
            ok = new JButton("OK");

            onoma.setBounds(250, 250, 200, 30);
            onoma.addActionListener(this);
            p.add(onoma);

            keys.setBounds(170, 250, 100, 30);
            p.add(keys);

            ok.addActionListener(this);
            ok.setBounds(220, 300, 200, 40);
            p.add(ok);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(ok.getActionCommand())) {
                if (onoma.getText().equals(""))
                    return;
                name = onoma.getText();
                System.out.println(name);
                p.setVisible(false);
                // remove(keys);
                p.remove(ok);
                p.remove(onoma);
                p.removeAll();
                p.setVisible(true);
                GYIplayers kat = new GYIplayers(p);
            }
        }


    }

    public class GYIplayers implements ActionListener {
        public Thread thread1;
        private JButton pl[];
        private JPanel p;

        public GYIplayers(JPanel p) {
            super();

            this.p = p;

            pl = new JButton[3];
            pl[0] = new JButton("Players 2");
            pl[1] = new JButton("Players 3");
            pl[2] = new JButton("Players 4");

            pl[0].setBounds(250, 200, 200, 50);
            pl[1].setBounds(250, 300, 200, 50);
            pl[2].setBounds(250, 400, 200, 50);
            for (int i = 0; i < 3; i++) {
                pl[i].addActionListener(this);
                p.add(pl[i]);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 3; i++) {
                if (e.getActionCommand().equals(pl[i].getActionCommand())) {
                    players = i + 2;
                    p.setVisible(false);
                    p.remove(pl[0]);
                    p.remove(pl[1]);
                    p.remove(pl[2]);

                    //thread1.start();
                    //paei sto kanonik;o gamesleep();
                    Thread t = new Thread(new Interrupt1());
                    t.start();

                }
            }
        }
    }

    public class boxScore extends JPanel {
        private Round round;
        private ArrayList<Bot> bots;
        private HashMap<Player, JLabel> score;

        public boxScore(int x, int y, int w, int h) {
            round = game.getRound();
            setLayout(new GridLayout(players + 1, 1));
            setBounds(x, y, w, h);
            score = new HashMap<>();
            setBackground(Color.pink);
            for (Player p : game.getplayers()) {
                score.put(p, new JLabel(p.get_name() + " " + round.pointPlayer(p) + " points"));
                add(score.get(p));
            }

        }

        public void finish_round() {
            for (Player p : score.keySet()) {
                score.get(p).setText(p.get_name() + " " + round.pointPlayer(p) + " points");
            }
        }
    }

    public class Interrupt2 implements Runnable {
        public void run() {
            Hands_Tiles();
        }
    }

    public class Interrupt4 implements Runnable {
        private boolean bool = true;

        public boolean get_bool() {
            return bool;
        }

        public void run() {
            bool = game.Cardinal_playerTurn();//game.Cardinal_my_player().show();
        }
    }

    public class Interrupt10 implements Runnable {
        private JPanel pann;
        private int i;

        public Interrupt10(JPanel pann,int i) {
            this.pann = pann;
            this.i = i;
        }



        public void run() {add_button(pann,i);

        }
    }

    public class Interrupt1 implements Runnable {//anagkasthika gt allios den se paei sto game

        public void run() {
            startGameHungarian();

        }
    }

    public class Interrupt3 implements Runnable {
        boolean lr;

        public Interrupt3(boolean lr) {
            this.lr = lr;
        }

        public void run() {
            table.add_TableGUI(lr);
        }
    }
}
