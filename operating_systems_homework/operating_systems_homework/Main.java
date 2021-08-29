package operating_systems_homework;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println(" Lütfen Proses Sayýsýný Giriniz : ");
        int prosesSayisi = scanner.nextInt();
        
        int[][] prosesMatris = new int[prosesSayisi][2];
        
        System.out.println("Lütfen her bir proses için geliþ zamaný ve patlama zamanýný giriniz");
        System.out.println("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
        for (int i = 0; i < prosesSayisi; i++) {
			for (int j = 0; j < 2; j++) {
					System.out.println((i+1)+". proses deðerleri :");
					prosesMatris[i][j] = scanner.nextInt();
					
			}
		}
        
        System.out.println("###########################################################");
		
		FCFS fcfs = new FCFS(prosesSayisi,prosesMatris);
		SJF_NP sjf_np = new SJF_NP(prosesSayisi,prosesMatris);
		SJF_P sjf_p = new SJF_P(prosesSayisi,prosesMatris);
		
									
	}

}
