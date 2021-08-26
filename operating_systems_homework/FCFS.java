package operating_systems_homework;

public class FCFS {
	
	int prosesSayisi; 
	int [][] prosesMatris;
	int toplamIslemSuresi=0;
	int tamamlanmaSuresi=0;
	float ortBekleme=0;
		
	public FCFS(int prosesSayisi, int [][] prosesMatris)
	{
		this.prosesMatris = prosesMatris;
		this.prosesSayisi = prosesSayisi;
		
		
		
		sort(prosesMatris); // gelis sirasina gore matris duzeltildi
		//ortBekleme=prosesMatris[0][0];
		
		
	
		for (int i = 0; i < prosesSayisi; i++) 
		{		
					
				
				
				if(i!=prosesSayisi-1) 
				{
				toplamIslemSuresi += this.prosesMatris[i][1]; 
				ortBekleme+=(toplamIslemSuresi-prosesMatris[i+1][0]);
//				System.out.println("ortBekl--->"+ortBekleme);
//				System.out.println("toplIslem--->"+toplamIslemSuresi);
//				System.out.println("prosesMatris[i+1][0]--->"+prosesMatris[i+1][0]);
				
		
				
				}
			
					
		}
		System.out.println("------------------------------------------------------------");

		System.out.println("ort bekleme: "+(ortBekleme/prosesSayisi));
		

	
	}

	public void sort(int array[][])
	{
	    boolean sorted = false;
	    int temp;
	    int temp2;
		
		for (int i = 0; i < prosesSayisi; i++) 
		{
			
			for (int j = 0; j < 1; j++) 
			{
				

			    while(!sorted) 
			    {
			        sorted = true;
			        for (int k = 0; k < array.length - 1; k++) 
			        {
			            if (array[k][0] > array[k+1][0]) 
			            {
			                temp = array[k][0];
			                temp2 = array[k][1];
			                array[k][0] = array[k+1][0];
			                array[k][1] = array[k+1][1];
			                array[k+1][0] = temp;
			                array[k+1][1] = temp2;
			                sorted = false;
			            }
			        }
			    }
			    

					
				}
				
			}
		
	    for (int b = 0; b < prosesSayisi; b++) 
	    {
			
			for (int m = 0; m < 1; m++) 
			{
				System.out.println("-----------------------------");
				System.out.println(array[b][m]+" "+array[b][m+1]);
			}
			
		}
	}
	
}
