package operating_systems_homework;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println(" L�tfen Proses Say�s�n� Giriniz : ");
        int prosesSayisi = scanner.nextInt();
        
        int[][] prosesMatris = new int[prosesSayisi][2];
        
        System.out.println("L�tfen her bir proses i�in geli� zaman� ve patlama zaman�n� giriniz");
        System.out.println("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
        for (int i = 0; i < prosesSayisi; i++) {
			for (int j = 0; j < 2; j++) {
					System.out.println((i+1)+". proses de�erleri :");
					prosesMatris[i][j] = scanner.nextInt();
					
			}
		}
        
        System.out.println("###########################################################");
		
		FCFS fcfs = new FCFS(prosesSayisi,prosesMatris);
		SJF_NP sjf_np = new SJF_NP(prosesSayisi,prosesMatris);
		SJF_P sjf_p = new SJF_P(prosesSayisi,prosesMatris);
		
									
	}

}
