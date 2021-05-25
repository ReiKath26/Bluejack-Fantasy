//Kathleen Febiola 2301870110
import javax.swing.JFrame;

public class Main extends JFrame{

	public Main() {
		// TODO Auto-generated constructor stub
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new BlueJack());
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
