import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;

public class RSA {
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;

	public RSA() {
		// Gera dois primos p e q aleatórios com até 100 casas decimais
		this.p = Primalidade.genPrimo(100);
		this.q = Primalidade.genPrimo(100);
		// n = p * q.
		this.n = this.p.multiply(this.q);
		// phi = (p-1)*(q-1)
		this.phi = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));

		// e tal que gcd(phi,e) = 1 e 1 < e < phi
		this.e = this.gerarPublicKey(this.phi);
		// d = e^-1 (mod phi)
		this.d = this.e.modInverse(this.phi);
	}

	public BigInteger gerarPublicKey(BigInteger e) {
		Random random = new Random();
		// gera um e aleatório tal que gcd(phi,e) = 1 e 1 < e < phi
		while (true) {
			BigInteger probable = new BigInteger(2048, random);
			if (probable.bitLength() > 1024 && probable.gcd(this.phi).equals(BigInteger.ONE)) {
				return probable;
			}
		}
	}

	public void print() {
		MessageManager.print("p: " + this.p + "\nq: " + this.q + "\nn: " + this.n + "\nphi: " + this.phi + "\ne: " + this.e + "\nnumero bits em e: " + this.e.bitLength() + "\nd: "
				+ this.d + "\nnumero bits em d: " + this.d.bitLength());
	}

	// cifra uma mensagem
	public String encript(String message) {
		BigInteger number;
		try {
			// primeiro converte a mensagem para bytes e pega o numero conrresponde aos bytes.
			number = new BigInteger(message.getBytes("UTF-8"));
			// se der um numero menor que n, cifra ele, c = m^e mod n.
			if (number.compareTo(this.n) < 0) {
				return number.modPow(this.e, this.n).toString(36);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// decifra a mensagem
	public String decript(String message) {
		// pega a mensagem e decifra, m = c^d mod n.
		BigInteger number = new BigInteger(message, 36);
		BigInteger modPow = number.modPow(this.d, this.n);
		try {
			return new String(modPow.toByteArray(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
