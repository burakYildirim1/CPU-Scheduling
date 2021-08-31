package operating_systems_homework;

import java.util.Scanner;

class Process {
	int patlamaZ;
	int varisZ;

	public Process(int patlamaZ, int varisZ) {
		this.patlamaZ = patlamaZ;
		this.varisZ = varisZ;
	}
}

public class SJF_P {

	static int prosesSayisi = 0;
	static int[][] prosesMatris;
	static int[] varisZamani;
	static int[] patlamaZamanlari;
	static int[] tamamlanmaZamani;

	public SJF_P(int prosesSayisi, int[][] prosesMatris) {
		System.out.println("SJF_P ALGORITMASI : ");

		this.prosesSayisi = prosesSayisi;
		this.prosesMatris = prosesMatris;

		Process prosesler[] = new Process[prosesSayisi];
		int[] patlamaZamani = new int[prosesSayisi];
		varisZamani = new int[prosesSayisi];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < prosesSayisi; i++) {
			patlamaZamani[i] = prosesMatris[i][0];
			varisZamani[i] = prosesMatris[i][1];
		}

		for (int i = 0; i < prosesSayisi; i++) {
			prosesler[i] = new Process(varisZamani[i], patlamaZamani[i]);
		}

		ortalamaZamaniBul(prosesler, prosesler.length);

	}

	// proseslerin bekleme zamanini bulan fonksiyon
	static void beklemeZamaniBul(Process prosesler[], int prosesSayisi, int beklemeZamani[]) // proses matrisi, proses
																								// sayisi, beklemeZamani
																								// proses sayisi
																								// boyutunda dizi
	{
		patlamaZamanlari = new int[prosesSayisi];

		for (int i = 0; i < prosesSayisi; i++)
			patlamaZamanlari[i] = prosesler[i].patlamaZ;

		int tamamMi = 0;
		int tempValue = 0;
		int ekd = Integer.MAX_VALUE;
		int enKisa = 0;
		int bitisZamani;
		boolean flag = false;

		// prosesler tamamlanana kadar
		while (tamamMi != prosesSayisi) {

			for (int j = 0; j < prosesSayisi; j++) {
				if ((prosesler[j].varisZ <= tempValue) && (patlamaZamanlari[j] < ekd) && patlamaZamanlari[j] > 0) {
					ekd = patlamaZamanlari[j];
					enKisa = j;
					flag = true;
				}
			}

			if (flag == false) {
				tempValue++;
				continue;
			}

			patlamaZamanlari[enKisa]--;

			// en kucuk degerin guncellendigi yer
			ekd = patlamaZamanlari[enKisa];
			if (ekd == 0)
				ekd = Integer.MAX_VALUE;

			if (patlamaZamanlari[enKisa] == 0) {

				tamamMi++;
				flag = false;

				// prosesin bitis zamanini bul
				bitisZamani = tempValue + 1;

				// bekleme zamani hesapla
				beklemeZamani[enKisa] = bitisZamani - prosesler[enKisa].patlamaZ - prosesler[enKisa].varisZ;

				if (beklemeZamani[enKisa] < 0) {
					beklemeZamani[enKisa] = 0;
				}

			}

			tempValue++;
		}
	}

	// donus zamani hesaplayan fonksiyon
	static void donusZamaniHesapla(Process prosesler[], int prosesSayisi, int beklemeZamani[], int donusZamanlari[]) {

		for (int i = 0; i < prosesSayisi; i++)
			donusZamanlari[i] = prosesler[i].patlamaZ + beklemeZamani[i];
	}

	// ortalama zamani hesaplayan fonksiyon
	static void ortalamaZamaniBul(Process prosesler[], int prosesSayisi) {
		int beklemeZamani[] = new int[prosesSayisi];
		int donusZamanlari[] = new int[prosesSayisi];
		int toplamBekleme = 0;
		int toplamDonusZamani = 0;

		beklemeZamaniBul(prosesler, prosesSayisi, beklemeZamani);

		donusZamaniHesapla(prosesler, prosesSayisi, beklemeZamani, donusZamanlari);

		tamamlanmaZamani = new int[prosesSayisi];
		for (int i = 0; i < prosesSayisi; i++) {
			tamamlanmaZamani[i] = donusZamanlari[i] + prosesler[i].varisZ;
		}

		System.out.println(
				"Varýþ Zamaný " + "Patlama Zamaný " + " Bekleme Zamaný " + " Donus Zamani" + " Tamamlanma Zamani");

		for (int i = 0; i < prosesSayisi; i++) {
			toplamBekleme = toplamBekleme + beklemeZamani[i];
			toplamDonusZamani = toplamDonusZamani + donusZamanlari[i];
			System.out.println(prosesler[i].varisZ + "\t\t " + prosesler[i].patlamaZ + "\t\t " + beklemeZamani[i]
					+ "\t\t" + donusZamanlari[i] + "\t\t " + tamamlanmaZamani[i]);
		}

		System.out.println("Ortalama Bekleme Zamaný = " + (float) toplamBekleme / (float) prosesSayisi);
		System.out.println("Ortalama Dönüþ Zamaný = " + (float) toplamDonusZamani / (float) prosesSayisi);
		System.out.println("###########################################################");
	}

}
