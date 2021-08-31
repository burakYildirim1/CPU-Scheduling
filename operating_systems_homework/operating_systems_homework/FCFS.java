package operating_systems_homework;

public class FCFS {

	int prosesSayisi;

	int toplamIslemSuresi = 0;
	int tamamlanmaSuresi = 0;
	float bekleme = 0;
	float ortBekleme;

	int[] tamamlanmaZamani;

	public FCFS(int prosesSayisi, int[][] prosesMatris) {
		System.out.println("FCFS ALGORITMASI : ");

		this.prosesSayisi = prosesSayisi;
		sirala(prosesMatris);

		int[] varisSure = new int[prosesSayisi];
		int[] patlamaZamani = new int[prosesSayisi];
		int[] beklemeSuresi = new int[prosesSayisi];
		int donusZamanlari[] = new int[prosesSayisi];
		tamamlanmaZamani = new int[prosesSayisi];
		int toplamDonusZamani = 0;

		for (int i = 0; i < prosesSayisi; i++) {
			varisSure[i] = prosesMatris[i][0];

			patlamaZamani[i] = prosesMatris[i][1];
		}

		int toplamBekleme;
		toplamBekleme = totalWaitingTime(prosesMatris, prosesSayisi);

		// Bekleme zamanlarýnýn hesaplanmasý.
		for (int i = 1; i < prosesSayisi; i++) {
			beklemeSuresi[i] = patlamaZamani[i - 1] + beklemeSuresi[i - 1];
		}

		// Donus zamanlarýnýn hesaplanmasý.
		for (int i = 0; i < prosesSayisi; i++) {
			donusZamanlari[i] = patlamaZamani[i] + beklemeSuresi[i];
		}

		for (int i = 0; i < prosesSayisi; i++) {
			tamamlanmaZamani[i] = donusZamanlari[i] + varisSure[i];
		}

		System.out.println(
				"Varýþ Zamaný " + "Patlama Zamaný " + " Bekleme Zamaný " + " Donus Zamaný" + " Tamamlanma Zamani");

		for (int i = 0; i < prosesSayisi; i++) {
			// toplamBekleme = toplamBekleme + beklemeSuresi[i];
			toplamDonusZamani = toplamDonusZamani + donusZamanlari[i];
			System.out.println(varisSure[i] + "\t\t " + patlamaZamani[i] + "\t\t " + beklemeSuresi[i] + "\t\t"
					+ donusZamanlari[i] + "\t\t " + tamamlanmaZamani[i]);
		}

		System.out.println("Ortalama Bekleme Zamaný = " + (float) toplamBekleme / (float) prosesSayisi);
		System.out.println("Ortalama Dönüþ Zamaný = " + (float) toplamDonusZamani / (float) prosesSayisi);
		System.out.println("###########################################################");

	}

	public static int totalWaitingTime(int[][] array, int len) {
		int result = 0;
		int sum = 0;
		for (int i = 1; i < len; i++) {
			sum += (array[i - 1][1]);
			result += sum;
		}

		return result;
	}

	public static double avarageTime(int sum, int len) {
		return (double) sum / (double) len;
	}

	public void sirala(int array[][]) {
		boolean sorted = false;
		int temp;
		int temp2;

		for (int i = 0; i < prosesSayisi; i++) {

			for (int j = 0; j < 1; j++) {

				while (!sorted) {
					sorted = true;
					for (int k = 0; k < array.length - 1; k++) {
						if (array[k][0] > array[k + 1][0]) {
							temp = array[k][0];
							temp2 = array[k][1];
							array[k][0] = array[k + 1][0];
							array[k][1] = array[k + 1][1];
							array[k + 1][0] = temp;
							array[k + 1][1] = temp2;
							sorted = false;
						}
					}
				}

			}

		}

	}

}
