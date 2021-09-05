package operating_systems_homework;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Please Enter Number of Processes : ");
		int processNumb = scanner.nextInt();

		int[][] processMatrix = new int[processNumb][2];

		System.out.println("Please enter the arrival time and burst time for each process.");
		System.out.println("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
		for (int i = 0; i < processNumb; i++) {
			for (int j = 0; j < 2; j++) {
				processMatrix[i][j] = scanner.nextInt();

			}
		}

		System.out.println("###########################################################");

		FCFS fcfs = new FCFS(processNumb, processMatrix);
		SJF_NP sjf_np = new SJF_NP(processNumb, processMatrix);
		SJF_P sjf_p = new SJF_P(processNumb, processMatrix);

	}

}
