package hr.fer.zemris.java.custom.collections.demo;

import javax.sound.midi.SysexMessage;

import hr.fer.zemris.java.custom.collections.EmptyStackException;
import hr.fer.zemris.java.custom.collections.ObjectStack;
/**
 * Program koji prima argumente sa komandne linije te preko stoga računa s njima
 * @author Karlo
 *
 */

public class StackDemo {
	
	/**
	 * Metoda main čita argumente iz komandne linije. Ako je argument broj
	 * stavlja ga na stog, a ako je znak miče zadnja dva broja sa stoga i obavlja
	 * operaciju zadanu znakom
	 * @param args - argumenti sa komandne linije
	 */
	public static void main(String[] args) {
		if (args.length!=1) {
			System.err.println("Krivi broj argumenata.");
			return;
		}
		try {
			String[] unos = args[0].split(" ");
			ObjectStack stack = new ObjectStack();
			for (String i : unos) {
			try {
				stack.push(Integer.parseInt(i));
				continue;
			}catch (NumberFormatException e) {
				if (i.equals("/")) {
					int a = (Integer)stack.pop();
					int b = (Integer)stack.pop();
					if (a == 0) {
						System.err.println("Ne može se djeliti s 0.");
						return;
					}
					stack.push(b / a);	
				}else if (i.equals("*")) {
					stack.push((Integer)stack.pop() * (Integer)stack.pop());	
				}else if (i.equals("+")) {
					stack.push((Integer)stack.pop() + (Integer)stack.pop());	
				}else if (i.equals("-")) {
					int a = (Integer)stack.pop();
					int b = (Integer)stack.pop();
					stack.push(b - a);
				}else if(i.equals("%")){
					int a = (Integer)stack.pop();
					int b = (Integer)stack.pop();
					stack.push(b % a);
				}
				continue;
			}
		}
			if (stack.size() != 1) {
				System.err.println("Krivo zadani argumenti.");
				return;
			}
			System.out.println("Expression evaluates to: " + stack.pop());
		}catch(EmptyStackException f) {
			System.err.println("Krivo zadani argumenti.");
			return;
		}
	}
}
