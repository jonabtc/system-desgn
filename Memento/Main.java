import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
        JFrame frame = new TicTacToeApp().constructApplicationFrame();
        frame.setBounds(300, 300, 400, 400);
        frame.setVisible(true);
    }

}
