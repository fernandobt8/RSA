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
		p = Primalidade.genPrimo(100);
		q = Primalidade.genPrimo(100);
		n = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		
		e = gerarPublicKey(phi);
		
		d = e.modInverse(phi);
		
		System.out.println("n:" +n+ "\nphi:" + phi + "\nd:" + d);
	}

	public BigInteger gerarPublicKey(BigInteger e) {
		Random random = new Random();
		while(true) {
			BigInteger probable = new BigInteger(2048, random);
			if(probable.bitLength()>1024 && probable.gcd(phi).equals(BigInteger.ONE)){
				return probable;
			}
		}
	}

}
