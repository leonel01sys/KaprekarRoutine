/**
 * 
 */
package com.leonelvalora.kaprekar;
import java.util.Scanner;

/**
 * @author leonel
 *
 */
public class KaprekarConstant {
	String numAscen, numDescen;
	int[] auxOrd = new int[4];
	Scanner leer = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KaprekarConstant kc = new KaprekarConstant();
		System.out.println("Introduce un numero");
		int numero = kc.leer.nextInt();
		kc.routineKaprekar(numero);
		//System.out.print(kc.ascendNumber("3087")+"\n");
		//System.out.print(kc.descendNumber("3087"));
	}
	
	public void routineKaprekar(int num) {
		String n = Integer.toString(num);
		while(n.length() < 4) {
			n = 0 + n;
		}
		System.out.println("       "+"       "+n);
		for(int i=1;i <= 7; i++) {
			numAscen = ascendNumber(n);
			numDescen = descendNumber(n);
			n = Integer.toString(
				Integer.parseInt(numAscen)-Integer.parseInt(numDescen));
			System.out.println(numAscen+" - "+numDescen+" = "+n);
			if(Integer.parseInt(n) == 6174) {
				//System.out.println(n);
				break;
			}
		}
		
	}
	
	public String ascendNumber(String num) {
		for(int i=0; i < num.length();i++) {
			auxOrd[i] = Character.getNumericValue(num.charAt(i));
		}
		//System.out.print("Aux Array: "+auxOrd[0]+auxOrd[1]+auxOrd[2]+auxOrd[3]+"\n");
		for(int i=0; i< auxOrd.length;i++) {
			for(int j=0; j < auxOrd.length; j++) {
				if(auxOrd[i] > auxOrd[j]) {
					int temp = auxOrd[i];
					auxOrd[i] = auxOrd[j];
					auxOrd[j] = temp;
					
				}
				
			}
			//System.out.print(""+auxOrd[0]+auxOrd[1]+auxOrd[2]+auxOrd[3]+"\n");
		}
		return ""+auxOrd[0]+auxOrd[1]+auxOrd[2]+auxOrd[3];
	}
	
	public String descendNumber(String num) {
		for(int i=0; i < num.length();i++) {
			auxOrd[i] = Character.getNumericValue(num.charAt(i));
		}
		for(int i=0; i< auxOrd.length;i++) {
			for(int j=0; j < auxOrd.length; j++) {
				if(auxOrd[i] < auxOrd[j]) {
					int temp = auxOrd[i];
					auxOrd[i] = auxOrd[j];
					auxOrd[j] = temp;
				}
				
			}
		}
		return ""+auxOrd[0]+auxOrd[1]+auxOrd[2]+auxOrd[3];
	}
}
