package operating_systems_homework;

public class SJF_NP {

	int prosesSayisi;
	float bekleme = 0;
	float ortBekleme;
	int[] tamamlanmaZamani;

	public SJF_NP(int prosesSayisi, int[][] prosesMatris) {
		System.out.println("SJF_NP ALGORITMASI : ");

		this.prosesSayisi = prosesSayisi;
		sirala(prosesMatris);

		int[] varisSure = new int[prosesSayisi];
		int[] patlamaZamani = new int[prosesSayisi];
		int[] beklemeSuresi = new int[prosesSayisi];

		int donusZamanlari[] = new int[prosesSayisi];
		tamamlanmaZamani = new int[prosesSayisi];
		int toplamBekleme = 0;
		int toplamDonusZamani = 0;

		for (int i = 0; i < prosesSayisi; i++) {
			varisSure[i] = prosesMatris[i][0];
			patlamaZamani[i] = prosesMatris[i][1];
		}

		beklemeSuresi[0] = 0;
		for (int i = 1; i < prosesSayisi; i++) {
			beklemeSuresi[i] = patlamaZamani[i - 1] + beklemeSuresi[i - 1];
		}

		for (int i : beklemeSuresi) {
			bekleme += i;
		}

		// Donus zamanlarýnýn hesaplanmasý.
		for (int i = 0; i < prosesSayisi; i++) {
			donusZamanlari[i] = patlamaZamani[i] + beklemeSuresi[i];
		}

		for (int i = 0; i < prosesSayisi; i++) {
			tamamlanmaZamani[i] = donusZamanlari[i] + varisSure[i];
		}

		System.out.println("Patlama Zamaný " + " Bekleme Zamaný " + " Donus Zamaný" + " Tamamlanma Zamani");

		for (int i = 0; i < prosesSayisi; i++) {
			toplamBekleme = toplamBekleme + beklemeSuresi[i];
			toplamDonusZamani = toplamDonusZamani + donusZamanlari[i];
			System.out.println(patlamaZamani[i] + "\t\t " + beklemeSuresi[i] + "\t\t" + donusZamanlari[i] + "\t\t "
					+ tamamlanmaZamani[i]);
		}

		System.out.println("Ortalama Bekleme Zamaný = " + (float) toplamBekleme / (float) prosesSayisi);
		System.out.println("Ortalama Dönüþ Zamaný = " + (float) toplamDonusZamani / (float) prosesSayisi);
		System.out.println("###########################################################");

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
						if (array[k][1] > array[k + 1][1]) {
							temp = array[k][1];
							temp2 = array[k][0];
							array[k][1] = array[k + 1][1];
							array[k][0] = array[k + 1][0];
							array[k + 1][1] = temp;
							array[k + 1][0] = temp2;
							sorted = false;
						}
					}
				}

			}

		}

	}

}
