
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeApp {

    /**
     * Used for integration into the universal demo application.
     */
    private int numClicks = 0;
    private JPanel panel;
    JTextField cmdField;
    private String strSymbol;
    private static TicTacToeApp ticTacToeInst = new TicTacToeApp();

    public JFrame constructApplicationFrame() {
        JFrame frame = new JFrame();
        panel = new TicTacToePanel();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    /**
     * Application starter.
     */
    public static void main(String[] args) {
        JFrame frame = ticTacToeInst.constructApplicationFrame();
        frame.setBounds(300, 300, 400, 400);
        frame.setVisible(true);
        Adapter.getAdapterInst().initAdapter();
        new TextCmd();
    }

    /**
     * Simple panel to control the game.
     */
    private class TicTacToePanel extends JPanel implements ActionListener {

        private static final long serialVersionUID = 1L;

        JButton clearButton;
        JButton[] squares;

        TicTacToePanel() {
            this.setLayout(new BorderLayout());
            JPanel btnsContainer = new JPanel();

            clearButton = new JButton("Clear");

            clearButton.addActionListener(this);
            btnsContainer.add(clearButton);
            cmdField = new JTextField("              ");

            btnsContainer.add(cmdField);
            add(btnsContainer, BorderLayout.NORTH);
            JPanel spanel = new JPanel();
            spanel.setLayout(new GridLayout(3, 3));
            add(spanel, BorderLayout.CENTER);
            squares = new JButton[9];
            Font f = new java.awt.Font(Font.SANS_SERIF, Font.PLAIN, 32);
            for (int i = 0; i < 9; i++) {
                JButton square = new JButton("");
                square.setFont(f);
                square.setBackground(Color.WHITE);
                square.addActionListener(this);
                squares[i] = square;
                spanel.add(square);
            }

        }

        /**
         * Handles all button events and updates the view.
         */
        @Override
        public void actionPerformed(ActionEvent ae) {

            JButton btnClicked = (JButton) ae.getSource();
            String btnLabel = btnClicked.getText();
            if (btnClicked == clearButton) {
                String val = "";
                for (int i = 0; i < 9; i++) {
                    squares[i].setText(val);
                }
                numClicks = 0;

            }

            if (btnClicked != clearButton && btnLabel.equals("")) {

                if (++numClicks % 2 == 1) {
                    btnClicked.setText("X");

                    strSymbol = "X";
                } else {
                    btnClicked.setText("O");

                    strSymbol = "O";
                }
            }
        }
    }

    public JTextField getCmdField() {
        return cmdField;
    }

    public JPanel getPanel() {
        return panel;
    }

    public static TicTacToeApp getTicTacToeInst() {
        return ticTacToeInst;
    }

}
