package com.algoritmos.algorithm;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class ejemplo {

	public BigInteger xeuclid(BigInteger a, BigInteger b){
	   	
	   BigInteger zero = new BigInteger("0");	
	   BigInteger bOriginal = b;
       BigInteger[] x = new BigInteger[2];
       BigInteger[] y = new BigInteger[2];
       BigInteger q, r, xx, yy;
       int sign;
       // Initializes the coefficients
       x[0] = BigInteger.ONE;  x[1] = BigInteger.ZERO;
       y[0] = BigInteger.ZERO;  y[1] = BigInteger.ONE;
       sign = 1;
       // As long as b != 0 we replace a by b and b by a % b.
       while( !b.equals( BigInteger.ZERO ) )
       {
               r = a.mod( b );
               q = a.divide( b );
               a = b;
               b = r;
               xx = x[1];
               yy = y[1];
               x[1] = ( q.multiply( x[1] ).add( x[0] ) );
               y[1] = ( q.multiply( y[1] ).add( y[0] ) );
               x[0] = xx;
               y[0] = yy;
               sign = -sign;
       }
       // Final computation of the coefficients
       x[0] = x[0].multiply( new BigInteger( String.valueOf( sign ) ) );
       y[0] = y[0].multiply( new BigInteger( String.valueOf( -sign ) ) );
       System.out.println(" x : " + x[0] );
       System.out.println(" y : " + y[0] );
      
       
       if(x[0].compareTo(zero) < 0) {
           System.out.println("El inverso es: " + (bOriginal.add(x[0])));
    	   return bOriginal.add(x[0]);
       } else {
    	   System.out.println("El inverso es: " + x[0]);
    	   return x[0];
       }
       // return gcd( a, b )
	}
	
	public static void main(String[] args){
		/*
		 * Algoritmo para calcular inverso multiplicativo ( Extended Euclidean Algorithm )
		 * */
		BigInteger prueba = new BigInteger("64");
		
		BigInteger a = new BigInteger("2"); //Número menor
		BigInteger b = new BigInteger("17"); //Número mayor (módulo)
		ejemplo ea = new ejemplo();
		System.out.println(ea.xeuclid(a,b));
		//parejas();
		
		List<String> caracteres = new ArrayList<>();
		
		
		/*for(int i = 32; i <= 122; i++) {
			BigInteger message = new BigInteger(Integer.toString(i));
			int exp = 65537;		
			BigInteger n = new BigInteger("2199055761527");
			BigInteger power = message.pow(exp);
			BigInteger x = power.mod(n);
			System.out.println(String.format("%c = ",  i) + " " + x);
			caracteres.add(x.toString());
		}
		
		String mensaje [] = {"336067595008", "1682970026313", "2195342536774", "1012748295869",
							"1331711163998", "510154320953", "676512275779", "2195342536774",
							"1012748295869","2052401454061", "510154320953", "510154320953", "12175999401"};
		
		for(int i = 0; i < mensaje.length; i++) {
			for(int j = 0; j < caracteres.size(); j++) {
				if(mensaje[i].compareTo(caracteres.get(j)) == 0) {
					System.out.print(String.format("%c", j+32));
				}
			}
		}*/
		//Esta parte hace la fórmula para encriptar o desencriptar RSA
		BigInteger message = new BigInteger("100");
		BigInteger exp = new BigInteger("2678069755");		
        BigInteger n = new BigInteger("4315438828");
        
        BigInteger power = message.pow(exp.intValue());
        
		BigInteger x = power.mod(n);
		System.out.println("El mensaje es = " + x);
		
		parejas();
		
		//Ejercicio 11 y 12
		/*BigInteger modulus = new BigInteger("944206676646927606005795318580408485693681389594857707886165592007262592579810404395012689829410815780120729890657025809657220260425568442599422306808959415964159268451857187801089420271825622825296148642614351900686221003124975594592756373475607969244307796292726853747104856631452573224770327700627223726172273942464604738676005388912308777907726129175866153368352567754072488787919536801102688353811822643423322994042794987393137018661717819971095681658758172348450165745046894416379469712486100936693683432548705480267402719524319905818147011641734297458858871855354860455485105130751558862236492438226970544477837167901744260206355592107809853721778047245597089090500846252389898201359330320901923578952439178313756737974194837572231075572350955815545564557593567685692532720800667505417971843697140232967364445807935158080136894482538557180603453164729238969028240341711011023876147130821629757471378185502796505508964093569895366514115422452852315923231393934119823054101536499682784358411439872083080183332431192226620818623023704011064703004657195284877410285328363428963400104756613016886437250058049693373636713722332457514112448114825020720147702520486260509924470255737647218711902470267843850339737926741867602428768351");
		BigInteger prime1 = new BigInteger("31889652419877453181188037256245847641657599433884993706552623638751209613100572547720117257750133544653103446410360692860637887927824455716796576827220866968455509702300350151071366985708913207020431898280902111346349314257559804373710547026355334384752775895945723415680598783729338060031289598525406227459986454280575692726081015074898563204517748720569508853212224940059792492777386529742241327248838735885499246814514821590427770943440186336381535359251993478949541705371443924425594955622422533013598892037236989231245326686239048908034672476204919471344064730862381958031536519116331640246437670173464464685719");
		BigInteger prime2 = new BigInteger("29608559673682264637345622276493934808472141610684645315156446009059593070777167910615593127723662991623135739370161711222233504648696409720417547981277021615693988395526579418815005616991922427560016468170195544204672639291181667663301014851196912161996325975568139247334657469576841765926142639935420176257766698511353101069772135760106735063091637886022999480643307486182660308805256508809917580626723207202090972020490401793681826950330564292859838168311888046222653613773877533655362601185129506251877376715115508595222012610651791171617372017336329444666089510699523067003488178077087969351548525162171111217529");
		BigInteger publicExponent = new BigInteger("65537");
		
		prime1.subtract(new BigInteger("1"));
		prime2.subtract(new BigInteger("1"));
		BigInteger phiN = prime1.multiply(prime2);
		a = new BigInteger(publicExponent.toString()); //Número menor
		b = new BigInteger(phiN.toString()); //Número mayor (módulo)
		ejemplo ea1 = new ejemplo();
		System.out.println(ea1.xeuclid(a,b));*/
		
		//12
		/*
		BigInteger modulus = new BigInteger("25498652368904324381272476093668570283290393753046816699681350960793073500045699484952045657308041287115682929464405267592272946176943892884833822942795051656801186190944539083450048792147795257177659192438205043906464067746746215722041556517501751181297178506729113500086518213915455227362346401463904480672400814371765185277690678181286955944518763817977988355843892748498502107647955634552091674220452650435835640219274255935348854422794654966855402624123801326242240500892028034574349484031542509235325168727546214924950125121426443740882141036534485896803639006064371198230079606620643677408522820536022662741849");
		BigInteger prime1 = new BigInteger("171897554616692674786489559872322398103689562259926706901701080518924846735196639394345380431947778715535276564374661102394907193028425582795127704125169998194213179376895984566628222578909577359283104649382706835750150511909597256495344578825340697889163721823727378253597492024318065685021368347488846622207");
		BigInteger prime2 = modulus.divide(prime1);
		BigInteger publicExponent = new BigInteger("65537");
		BigInteger privateExponent = new BigInteger("17465469961092438187212131343283673650257194799491456759520512758136641430292070889413572936761798272405252097344357423474024330590094318501002339318279290612536509881616496932359929357149618217109497248097273668629341776418686202050176930162666182622464109482690234600590258977717393001759246379323354321030405683172452724033593500341072324512102406218830132898248383479845830044416390692447827232787519919010789817611641721943007217126088947351355962092859100321012131966997180256632208265853674531540495997297907297042664518691657083975989012598316032894238967301328256584252435205554436624848085755417762375448393");
		

		prime1.subtract(new BigInteger("1"));
		prime2.subtract(new BigInteger("1"));
		BigInteger phiN = prime1.multiply(prime2);
		a = new BigInteger(publicExponent.toString()); //Número menor
		b = new BigInteger(phiN.toString()); //Número mayor (módulo)
		ejemplo ea1 = new ejemplo();
		System.out.println(ea1.xeuclid(a,b));*/
		
		
		
		
		//System.out.println("Mensaje: " + x);
		
		
		//parejas();
		
		/*
		int primos[] = {1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		int N = 2623;
		
		for(int i = 0; i < primos.length; i++) {
			for(int j = 1; j < primos.length; j++) {
				if((primos[i]*primos[j]) == N) {
					System.out.println("Los números son " + primos[i] + " y " + primos[j]);
					break;
				}
			}
		}*/
	}
	
	
	/*
	 * *Algoritmo para encontrar parejas para RSA
	 * */
	public static void parejas() {
		int p = 17;
		int q = 87;
		int phi = (p-1)*(q-1);
		int n = p * q;
		
		List<BigInteger> numeros = new ArrayList<>();
		BigInteger phiBig = new BigInteger(String.format("%d", phi));
		BigInteger inv;
		
		//gcd(num, phi(n)) = 1
		for(int i = 2; i < phi; i++) {
			int x = gcd(i, phi);
			if(x==1) {
				BigInteger number = new BigInteger(String.format("%d", i));
				/*if(number.isProbablePrime(1)) {
					numeros.add(new BigInteger(number.toString()));
				}	*/
				numeros.add(new BigInteger(number.toString()));
			}
		}
				
		System.out.println(numeros);
		ejemplo ea = new ejemplo();
		List<List<BigInteger>> parejasNum = new ArrayList<>();
		
		//Posibles parejas
		for(int i = 0; i < numeros.size(); i++) {
			inv = ea.xeuclid(numeros.get(i), phiBig);
			if(inv.compareTo(numeros.get(i)) == 0) {
				System.out.println(numeros.get(i) + " es inverso de sí mismo");
				continue;
			} else {
				List<BigInteger> nums = new ArrayList<>();
				nums.add(numeros.get(i));
				nums.add(inv);
				parejasNum.add(nums);
				numeros.remove(inv);
			}
			//System.out.println(parejasNum);
		}
		
		System.out.println(parejasNum);
		
		
	}
	
	public static int gcd(int x, int y) {
		int res, z, neg;
		int oriX = x, oriY = y;
		
		z = x % y;
		
		while (z != 0) {
			z = x % y;
			x = y;
			y = z;
		}
		
		/*
		if(x == 1) {
			res = oriX+neg;
			System.out.println("El inverso de " + oriY + " es: " + res);
		}*/
		
		//System.out.println(ejemplo(oriX, oriY));
		
		return x;
	}
	
	
}

