/**
 * HW7 for 08671.
 * This is a class for Whack-a-mole Game.
 * @author Hao Wang (haow2)
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Game class.
 * */
public class Game {
    /**
     * Static Variable: total number of buttons.
     */
    private static final int NUM_BUTTONS = 21;
    /**
     * Static Variable: total number of rows.
     */
    private static final int NUM_ROW = 3;
    /**
     * Static Variable: total number of columns.
     */
    private static final int NUM_COL = NUM_BUTTONS / NUM_ROW;
    /**
     * Instance Variable: the width of frame.
     */
    private final int frameWidth = 600;
    /**
     * Instance Variable: the height of frame.
     */
    private final int frameHeight = 200;
    /**
     * Instance Variable: the start button.
     */
    private JButton startButton;
    /**
     * Instance Variable: time left for the game.
     */
    private JTextArea timeLeft;
    /**
     * Instance Variable: score.
     */
    private JTextArea score;
    /**
     * Instance Variable: buttons.
     */
    private JButton[][] buttons = new JButton[NUM_ROW][NUM_COL];
    /**
     * Static Variable: Time left in integer.
     * All the class are the subclass of this class, can we needn't to let
     * classes from outside to change this variable, so should use private static
     */
    private static int timeLeftSec = 0;

    /**
     * Constructor for Game.
     * */
    public Game() {
//      Font
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);

//      Frame
        JFrame frame = new JFrame("Whack-a-mole Game - Hao Wang (haow2)");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      Pane for all
        JPanel pane = new JPanel();

//      Pane with Texts
        JPanel pane1 = new JPanel();
        startButton = new JButton("Start");
        startButton.setFont(font);
        startButton.setOpaque(true);
        startButton.addActionListener(new MyActionListener());
        pane1.add(startButton);

        JLabel label1 = new JLabel("Time Left: ");
        label1.setFont(font);

        timeLeft = new JTextArea(1, 10);
        timeLeft.setEditable(false);

        JLabel label2 = new JLabel("Score: ");
        label2.setFont(font);

        score = new JTextArea(1, 10);
        score.setEditable(false);

        pane1.add(label1);
        pane1.add(timeLeft);
        pane1.add(label2);
        pane1.add(score);

//      Pane with buttons
        JPanel pane2 = new JPanel();

        for (int i = 0; i < NUM_COL; i++) {
//          set every button to default state (neither happy nor sad)
            buttons[0][i] = new JButton("   ");
            buttons[0][i].setBackground(Color.LIGHT_GRAY);
            buttons[0][i].setFont(font);
            buttons[0][i].setOpaque(true);
            buttons[0][i].addActionListener(new MyActionListener());
            pane2.add(buttons[0][i]);
        }
        JPanel pane3 = new JPanel();
        for (int i = 0; i < NUM_COL; i++) {
//          set every button to default state (neither happy nor sad)
            buttons[1][i] = new JButton("   ");
            buttons[1][i].setBackground(Color.LIGHT_GRAY);
            buttons[1][i].setFont(font);
            buttons[1][i].setOpaque(true);
            buttons[1][i].addActionListener(new MyActionListener());
            pane3.add(buttons[1][i]);
        }
        JPanel pane4 = new JPanel();
        for (int i = 0; i < NUM_COL; i++) {
//          set every button to default state (neither happy nor sad)
            buttons[2][i] = new JButton("   ");
            buttons[2][i].setBackground(Color.LIGHT_GRAY);
            buttons[2][i].setFont(font);
            buttons[2][i].setOpaque(true);
            buttons[2][i].addActionListener(new MyActionListener());
            pane4.add(buttons[2][i]);
        }

//      Set layout
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        pane1.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane3.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane4.setLayout(new FlowLayout(FlowLayout.CENTER));

//      Add panes to pane
        pane.add(pane1);
        pane.add(pane2);
        pane.add(pane3);
        pane.add(pane4);

//      Show the pane
        frame.setContentPane(pane);
        frame.setVisible(true);
    }

    /**
     * Class for StartActionListener.
     */
    private class MyActionListener implements ActionListener {
        /**
         * Listen to the performed action.
         * @param event action event.
         */
        public void actionPerformed(ActionEvent event) {
//          If no event found
            if (event == null) {
                return;
            }

//          If found startButton
            if (event.getSource() == startButton) {
                startButton.setEnabled(false);
                TimerThread timerThread = new TimerThread(timeLeft, startButton);
                timerThread.start();

//              Start all the ButtonThread
                for (int i = 0; i < NUM_ROW; i++) {
                    for (int j = 0; j < NUM_COL; j++) {
                        ButtonThread buttonThread = new ButtonThread(buttons[i][j]);
                        buttonThread.start();
                    }
                }
                return;
            }

//            Check buttons only if there are still time
//            System.out.println(timeLeftSec);
            if (timeLeftSec <= 0) {
                return;
            }

    // Should be the event of buttons
            for (int i = 0; i < NUM_ROW; i++) {
                for (int j = 0; j < NUM_COL; j++) {
                    if (event.getSource() == buttons[i][j]) {
//                        System.out.println(event.getSource());
                        if (buttons[i][j].getText().equals("Here")) {
//                          Clicked the right button
                            int tempScore = 0;
                            if (score.getText() == null || score.getText().length() == 0) {
                                tempScore = 0;
                            } else {
                                tempScore = Integer.parseInt(score.getText());
                            }
                            tempScore++;
                            score.setText("" + tempScore);
                            buttons[i][j].setText(":-)");
                        } else {
//                          Clicked the wrong button
                            buttons[i][j].setText(":-(");
                        }
                    }
                }
            }
        }

        /**
         * Nested class that extends Thread for buttons.
         */
        private class ButtonThread extends Thread {
            /**
             * Instance Variable: target button.
             */
            private JButton button;
            /**
             * Instance Variable: random number generator.
             */
            private Random random = new Random();
            /**
             * Instance Variable: time for down.
             */
            private int downTime;
            /**
             * Instance Variable: time for up.
             */
            private int upTime;

            /**
             * Constructor.
             * @param button the targeted button.
             */
            public ButtonThread(JButton button) {
                this.button = button;
            }

            /**
             * Implement run method of Thread class.
             */
            @Override
            public void run() {
                button.setText("   ");
                try {
//                  Run till the time runs out
                    while (timeLeftSec > 0) {
                        button.setText("   ");
                        downTime = random.nextInt(5) + 2;
                        Thread.sleep(downTime * 1000);

                        if (timeLeftSec > 0) {
                            button.setText("Here");
                            upTime = random.nextInt(3) + 1;
                            Thread.sleep(upTime * 1000);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                button.setText("   ");
            }
        }

        /**
         * Nested class for TimerThread.
         */
        private class TimerThread extends Thread {
            /**
             * Instance Variable: time left text area.
             */
            private JTextArea timeLeft;
            /**
             * Instance Variable: the start button.
             */
            private JButton startButton;
            /**
             * Instance Variable: the start time.
             */
            private final int startTime = 20;
            /**
             * Instance Variable: interval for Thread.sleep.
             */
            private final int sleepInterval = 1000;
            /**
             * Instance Variable: sleep interval after finished.
             */
            private final int sleepAfterFinished = 5000;

            /**
             * Constructor.
             * @param timeLeft the time left area.
             * @param startButton the start button.
             */
            public TimerThread(JTextArea timeLeft, JButton startButton) {
                this.timeLeft = timeLeft;
                this.startButton = startButton;
            }

            /**
             * Implement run method of Thread class.
             */
            @Override
            public void run() {
                score.setText("0");

//              Count time from 20 to 0
                try {
                    for (int time = startTime; time >= 0; time--) {
                        timeLeftSec = time;
                        timeLeft.setText("" + time);
                        Thread.sleep(sleepInterval);
                    }
//                  Means time runs out
                    timeLeftSec = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }

//              Clear the text of all the buttons immdediately when time runs out
                for (int i = 0; i < NUM_ROW; i++) {
                    for (int j = 0; j < NUM_COL; j++) {
                        buttons[i][j].setText("   ");
                    }
                }

//              Delay 5 seconds
                try {
                    Thread.sleep(sleepAfterFinished);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                startButton.setEnabled(true);
            }
        }
    }

    /**
     * Main function.
     * @param args the input String.
     */
    public static void main(String[] args) {
        new Game();
    }
}
