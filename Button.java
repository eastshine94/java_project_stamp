package Project;
import java.awt.*;
import javax.swing.*;

public class Button extends JButton {
	public Button(String title) {
		setText(title);
		setFont(new Font("Calibri", Font.PLAIN, 20));
		setBackground(new Color(0x2dce98));
		setForeground(Color.white);
		setUI(new StyledButtonUI());
	}
}
