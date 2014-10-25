public class Main {

	public static void main(String[] args) {
		// cria os atributos do RSA necessarios para cifra e decifra uma mensagem
		RSA rsa = new RSA();
		rsa.print();
		while (true) {
			MessageManager.print("Digite 1 para cifrar.\nDigite 2 para decifrar.\nDigite qualquer coisa para sair.");
			String readConsole = MessageManager.readConsole();
			if (readConsole.equals("1")) {
				System.out.println("Digite a mensagem a cifrar");
				String readConsole2 = MessageManager.readConsole();
				System.out.println("Mensagem cifrada.");
				System.out.println(rsa.encript(readConsole2));
			} else if (readConsole.equals("2")) {
				System.out.println("Digite a mensagem a decifrar");
				String readConsole2 = MessageManager.readConsole();
				System.out.println("Mensagem decifrada.");
				System.out.println(rsa.decript(readConsole2));
			} else {
				return;
			}
		}
	}
}
