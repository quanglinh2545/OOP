import javax.swing.JOptionPane;
public class Calculate {
	public static void main(String[] args) {
		String strNum1, strNum2;
		Double num1, num2, sum, difference, product, quotient;

		strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number:", "Enter the first number",
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number:", "Enter the second number",
				JOptionPane.INFORMATION_MESSAGE);
		num1 = Double.parseDouble(strNum1);
		num2 = Double.parseDouble(strNum2);
		sum = num1 + num2;
		difference = num1 - num2;
		product = num1 * num2;
		quotient = num1 / num2;
		JOptionPane.showMessageDialog(null, sum, " Sum", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, difference, " Difference", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, product, " Product", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, quotient, " Quotient", JOptionPane.INFORMATION_MESSAGE);
	}
}