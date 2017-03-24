import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class Game extends Frame implements WindowListener,ActionListener{
    TextField text = new TextField(25);
    TextField error = new TextField(25);
    Button b;
    Button c;
    Button d;
    Button e;
    Button f;
    Label labelB;
    Label labelC;
    Label labelD;
    Label labelE;
    Label labelF;
    Label Clicks;
    int numClicks = 0;
    int costC = 10;
    int costD = 50;
    int costE = 200;
    int costF = 500;
    int CPS = 0;
    public static void main(String[] args) {
        Game myWindow = new Game("Java Clicker Game by The Romano");
        myWindow.setSize(700,200);
        myWindow.setVisible(true);
    }

    public Game(String title) {
        super(title);
        addWindowListener(this);
        ImageIcon Lev1Button = new ImageIcon("Level1Clicker.png");
        b = new Button("Click");
        c = new Button("Level 1 Clicker");
        d = new Button("Level 2 Clicker");
        e = new Button("Level 3 Clicker");
        f = new Button("Level 4 Clicker");
        labelB = new Label("Click!");
        labelC = new Label("Clicker Costs: "+costC);
        labelD = new Label("Clicker Costs: "+costD);
        labelE = new Label("Clicker Costs: "+costE);
        labelF = new Label("Clicker Costs: "+costF);
        Clicks = new Label(CPS + " Clicks per second ");
        
        labelB.setBounds(220, 140, 200, 20);
        add(labelB);
        b.setBounds(100, 100, 100, 100);
        add(b);
        labelC.setBounds(220, 260, 200, 20);
        add(labelC);
        c.setBounds(100, 220, 100, 100);
        add(c);
        labelD.setBounds(220, 380, 200, 20);
        add(labelD);
        d.setBounds(100, 340, 100, 100);
        add(d);
        labelE.setBounds(220, 500, 200, 20);
        add(labelE);
        e.setBounds(100, 460, 100, 100);
        add(e);
        labelF.setBounds(220, 620, 200, 20);
        add(labelF);
        f.setBounds(100, 580, 100, 100);
        add(f);
        
        text.setBounds(400, 100, 200, 40);
        add(text);
        Clicks.setBounds(400, 150, 200, 40);
        add(Clicks);
        error.setBounds(600, 200, 200, 40);
        add(error);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
    }

    public class Lev1 implements Runnable {
        public void run(){
            CPS = CPS + 1;
            Clicks.setText(CPS + " Clicks per second ");
            while(true){
                try{
                    Thread.sleep(1000);
                    numClicks++;
                    text.setText("Button Clicked " + numClicks+ " times");
                    labelC.setText("Clicker Costs: "+costC);
                }
                catch (InterruptedException w) {
                    ;
                }
            }
        }
    }

    public class Lev2 implements Runnable {
        public void run(){
            CPS = CPS + 3;
            Clicks.setText(CPS + " Clicks per second ");
            while(true){
                try{
                    Thread.sleep(1000);
                    numClicks = numClicks + 3;
                    text.setText("Button Clicked " + numClicks+ " times");
                    labelD.setText("Clicker Costs: "+costD);
                }
                catch (InterruptedException w) {
                    ;
                }
            }
        }
    }
    
        public class Lev3 implements Runnable {
        public void run(){
            CPS = CPS + 5;
            Clicks.setText(CPS + " Clicks per second ");
            while(true){
                try{
                    Thread.sleep(1000);
                    numClicks = numClicks + 5;
                    text.setText("Button Clicked " + numClicks+ " times");
                    labelE.setText("Clicker Costs: "+costE);
                }
                catch (InterruptedException w) {
                    ;
                }
            }
        }
    }
    
        public class Lev4 implements Runnable {
        public void run(){
            CPS = CPS + 10;
            Clicks.setText(CPS + " Clicks per second ");
            while(true){
                try{
                    Thread.sleep(1000);
                    numClicks = numClicks + 10;
                    text.setText("Button Clicked " + numClicks+ " times");
                    labelF.setText("Clicker Costs: "+costF);
                }
                catch (InterruptedException w) {
                    ;
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "Click"){
            numClicks++;
            text.setText("Button Clicked " + numClicks+ " times");
            error.setText("");
        }
        else if(e.getActionCommand() == "Level 1 Clicker" && numClicks >= costC){
            numClicks = numClicks - costC;
            costC = costC *2;
            Thread t = new Thread(new Lev1());
            t.start();
            error.setText("");
        }
        else if(e.getActionCommand() == "Level 1 Clicker" && numClicks < costC){
            error.setText("You need "+costC+" clicks to buy this");
        }
        else if(e.getActionCommand() == "Level 2 Clicker" && numClicks >= costD){
            numClicks = numClicks - costD;
            costD = costD *2;
            Thread t = new Thread(new Lev2());
            t.start();
            error.setText("");
        }
        else if(e.getActionCommand() == "Level 2 Clicker" && numClicks < costD){
            error.setText("You need "+costD+" clicks to buy this");
        }
        else if(e.getActionCommand() == "Level 3 Clicker" && numClicks >= costE){
            numClicks = numClicks - costE;
            costE = costE *2;
            Thread t = new Thread(new Lev3());
            t.start();
            error.setText("");
        }
        else if(e.getActionCommand() == "Level 3 Clicker" && numClicks < costE){
            error.setText("You need "+costE+" clicks to buy this");
        }
        else if(e.getActionCommand() == "Level 4 Clicker" && numClicks >= costF){
            numClicks = numClicks - costF;
            costF = costF *2;
            Thread t = new Thread(new Lev4());
            t.start();
            error.setText("");
        }
        else if(e.getActionCommand() == "Level 4 Clicker" && numClicks < costF){
            error.setText("You need "+costF+" clicks to buy this");
        }
    }

    
    
    
    
    
    
    
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

    public void windowClosed(WindowEvent e) {}

}    
