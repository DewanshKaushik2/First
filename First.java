

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import java.util.*;

public class First{
    public static final int FIVE_SECOND=5000;
    public static final int MAX_Y=5000;
    public static final int MAX_X=5000;
    public static final Boolean variable=true;

    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    First(){
        JFrame f = new JFrame();
        JButton b = new JButton();
        JLabel textFieldA = new JLabel("Status");
        b.setBounds(10,100,100,40);
        f.add(b);
        JButton b2 = new JButton();
        b2.setBounds(160,100,100,40);
        f.add(b2);
        JButton b3 = new JButton();
        b3.setBounds(90,150,100,100);
        f.add(b3);
        textFieldA.setBounds(50,50,100,40);
        f.add(textFieldA);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    exec = Executors.newSingleThreadScheduledExecutor();
                    textFieldA.setText("Started");
                    Robot robot = new Robot();
                    Random random = new Random();
                    exec.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            robot.mouseMove(random.nextInt(MAX_X),random.nextInt(MAX_Y));
                        }
                    },0,5,TimeUnit.SECONDS);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exec.shutdown();
                textFieldA.setText("Stopped");
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               System.exit(0);
            }
        });
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String... s){
        new First();
    }
}
























