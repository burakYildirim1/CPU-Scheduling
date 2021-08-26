package operating_systems_homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// FCFS icin inputlar -> 1,5 / 0,7 / 7,2 / 2,3 / 8,5 seklinde olacak
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println(" L�tfen Proses Say�s�n� Giriniz : ");
        int prosesSayisi = scanner.nextInt();
        
        int[][] prosesMatris = new int[prosesSayisi][2];
        
        System.out.println("L�tfen her bir proses i�in geli� zaman� ve patlama zaman�n� giriniz");
        for (int i = 0; i < prosesSayisi; i++) {
			for (int j = 0; j < 2; j++) {
					prosesMatris[i][j] = scanner.nextInt();
			}
		}
        

		
		FCFS fcfs = new FCFS(prosesSayisi,prosesMatris);
		
									
	}

}
