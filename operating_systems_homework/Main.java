package operating_systems_homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// FCFS icin inputlar -> 1,5 / 0,7 / 7,2 / 2,3 / 8,5 seklinde olacak
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println(" Lütfen Proses Sayýsýný Giriniz : ");
        int prosesSayisi = scanner.nextInt();
        
        int[][] prosesMatris = new int[prosesSayisi][2];
        
        System.out.println("Lütfen her bir proses için geliþ zamaný ve patlama zamanýný giriniz");
        for (int i = 0; i < prosesSayisi; i++) {
			for (int j = 0; j < 2; j++) {
					prosesMatris[i][j] = scanner.nextInt();
			}
		}
        

		
		FCFS fcfs = new FCFS(prosesSayisi,prosesMatris);
		
									
	}

}
