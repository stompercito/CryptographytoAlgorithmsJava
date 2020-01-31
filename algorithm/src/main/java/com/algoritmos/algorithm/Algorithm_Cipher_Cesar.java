package com.algoritmos.algorithm;

public class Algorithm_Cipher_Cesar {
	public void cesar(String str){
		String result;
		int index = 0;
		String in = str;
		//String[] ABC = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				//"T", "U", "V", "W", "X", "Y", "Z" };
		String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";	

		for (int n = 0; n < 26; n++) {
			result = "";
			for (int j = 1; j <= in.length(); j++) {
				int i = 0;
				if (in.substring(j - 1, j).equals(" ")) {
					result += " ";
				} else {
					/*while (!(ABC[i].equals(in.substring(j - 1, j)))) {
						i++;
					}*/
					i = ABC.indexOf(in.substring(j - 1, j));

					if (i < n) {
						index = 26-(n-i);
					} else {
						index = (i - n) % 26;
					}
					//index = index + 1;
					result += ABC.substring(index, index+1);
					//result += ABC[index];
				}
			}
			System.out.println("[" + n % 26 + "] " + result);
		}

	}
	
	public static void main(String[] args) {

		String in = "VCTFU ZXFJV TIVKF UVVJK VVORD VEVJR OIPYE";
		
		Algorithm_Cipher_Cesar c = new Algorithm_Cipher_Cesar();

		c.cesar(in);
	}

}
