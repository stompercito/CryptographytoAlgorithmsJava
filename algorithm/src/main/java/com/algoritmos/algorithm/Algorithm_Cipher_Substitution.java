package com.algoritmos.algorithm;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Algorithm_Cipher_Substitution {

	static class ABC implements Comparable<ABC> {

		private String letter;
		private int FRC;

		public ABC(String letter, int FRC) {
			super();
			this.letter = letter;
			this.FRC = FRC;
		}

		public String getletter() {
			return letter;
		}

		public void setletter(String letter) {
			this.letter = letter;
		}

		public int getFRC() {
			return FRC;
		}

		public void setFRC(int FRC) {
			this.FRC = FRC;
		}

		public int compareTo(ABC compareABC) {

			int compareFRC = ((ABC) compareABC).getFRC();

			// ascending order
			// this.FRC - compareFRC;

			// descending order
			return compareFRC - this.FRC;

		}
	}

	public static void main(String[] args) {
		String in = "zit rtlokt ygk ltekten iql dtqfz ziqz fqzogfl iqctghtkqztr egrtdqaofu rthqkzdtfzl ktlhgflowst ygk tflxkofu zitltexkozn gy egddxfoeqzogfl wn ofctfzofu qfr odhstdtfzofu zitwtlz hgllowst egrtl qz zit lqdt zodt tftdn egrtwktqatkl iqctqzztdhztr zg wktqa zitlt egrtl qfr lztqs ltektzl zit iolzgkngy egrtl qfr eohitkl ol zit lzgkn gy zit etfzxkotl gsr wqzzstwtzvttf egrtdqatkl qfr egrtwkqatkl qf ofztsstezxqs qkdl kqetziqz iql iqr q rkqdqzoe odhqez gf zit egxklt gy iolzgkn";

		String result;
		int index = 0;

		Algorithm_Cipher_Substitution.ABC[] abc = new Algorithm_Cipher_Substitution.ABC[26];

		String[] ABCFRC = { "e", "t", "a", "o", "i", "n", "s", "h", "r", "d", "l", "c", "u", "m", "w", "f", "g", "y",
				"p", "b", "v", "k", "j", "x", "q", "z" };
		String abecedario = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 1; i <= 26; i++) {
			abc[i - 1] = new ABC(abecedario.substring(i - 1, i), 0);
			for (int j = 1; j <= in.length(); j++) {
				if (abc[i - 1].letter.equals(in.substring(j - 1, j))) {
					abc[i - 1].FRC += 1;
				}
			}
		}

		Arrays.sort(abc);
		// Arrays.sort(SortFRC);

		result = "";
		for (int j = 1; j <= in.length(); j++) {
			index = 0;
			if (in.substring(j - 1, j).equals(" ")) {
				result += " ";
			} else {

				while (!(abc[index].letter.equals(in.substring(j - 1, j)))) {
					index++;
				}

				result += ABCFRC[index];
			}
		}

		System.out.println(result);
		System.out.println("");
		Scanner scan = new Scanner(System.in); // Create a Scanner object
		System.out.println("How many changes want to do?");
		int numLetters = Integer.parseInt(scan.nextLine());

		do {
			for (int n = 0; n < numLetters; n++) {
				result = "";
				int oldl = 0;
				int newl = 0;
				System.out.println("[Letter want change] [New letter]");
				String[] change = (scan.nextLine()).split(" ");

				while (!(ABCFRC[oldl].equals(change[0])))
					oldl++;

				while (!(ABCFRC[newl].equals(change[1])))
					newl++;

				ABCFRC[oldl] = change[1];
				ABCFRC[newl] = change[0];

				for (int j = 1; j <= in.length(); j++) {
					index = 0;
					if (in.substring(j - 1, j).equals(" ")) {
						result += " ";
					} else {

						while (!(abc[index].letter.equals(in.substring(j - 1, j)))) {
							index++;
						}

						result += ABCFRC[index];
					}
				}

			}

			System.out.println(result);
			System.out.println("");

			System.out.println("How many changes want to do?");
			numLetters = Integer.parseInt(scan.nextLine());
		} while (numLetters != 0);
		scan.close();
	}

}