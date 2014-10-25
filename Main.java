public class Main {

	public static void main(String[] args) {
		// cria os atributos do RSA necessários para cifrar e decifrar uma mensagem
		RSA rsa = new RSA();
		rsa.print();
		while (true) {
			MessageManager.print("Digite 1 e enter para cifrar.\nDigite 2 e enter para decifrar.\nDigite qualquer coisa e enter para sair.");
			String readConsole = MessageManager.readConsole();
			if (readConsole.equals("1")) {
				System.out.println("Digite a mensagem a cifrar.");
				String readConsole2 = MessageManager.readConsole();
				System.out.println("Mensagem cifrada.");
				// cifra a mensagem digitada no console
				System.out.println(rsa.encript(readConsole2));
			} else if (readConsole.equals("2")) {
				System.out.println("Digite a mensagem a decifrar.");
				String readConsole2 = MessageManager.readConsole();
				System.out.println("Mensagem decifrada.");
				// decifra a mensagem digitada no console
				System.out.println(rsa.decript(readConsole2));
			} else {
				return;
			}
		}
	}
}
