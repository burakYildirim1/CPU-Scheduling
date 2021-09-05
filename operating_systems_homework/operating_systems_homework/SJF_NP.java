package operating_systems_homework;

public class SJF_NP {

	int processNumb;
	float wait = 0;
	float averageWaitingTime;
	int[] completionTimeMatrix;

	public SJF_NP(int processNumb, int[][] processMatrix) {
		System.out.println("SJF_NP Algorithm : ");

		this.processNumb = processNumb;
		sort(processMatrix);

		int[] arrivalTimeMatrix = new int[processNumb];
		int[] burstTimeMatrix = new int[processNumb];
		int[] waitingTimeMatrix = new int[processNumb];

		int turnAroundTimeMatrix[] = new int[processNumb];
		completionTimeMatrix = new int[processNumb];
		int totalWaiting = 0;
		int totalTurnAroundTime = 0;

		for (int i = 0; i < processNumb; i++) {
			arrivalTimeMatrix[i] = processMatrix[i][0];
			burstTimeMatrix[i] = processMatrix[i][1];
		}

		waitingTimeMatrix[0] = 0;
		for (int i = 1; i < processNumb; i++) {
			waitingTimeMatrix[i] = burstTimeMatrix[i - 1] + waitingTimeMatrix[i - 1];
		}

		for (int i : waitingTimeMatrix) {
			wait += i;
		}

		// Calculation of turn around times
		for (int i = 0; i < processNumb; i++) {
			turnAroundTimeMatrix[i] = burstTimeMatrix[i] + waitingTimeMatrix[i];
		}

		for (int i = 0; i < processNumb; i++) {
			completionTimeMatrix[i] = turnAroundTimeMatrix[i] + arrivalTimeMatrix[i];
		}

		System.out.println("Burst Time " + " Waiting Time " + " Turn Around Time" + " Completion Time");

		for (int i = 0; i < processNumb; i++) {
			totalWaiting = totalWaiting + waitingTimeMatrix[i];
			totalTurnAroundTime = totalTurnAroundTime + turnAroundTimeMatrix[i];
			System.out.println(burstTimeMatrix[i] + "\t\t " + waitingTimeMatrix[i] + "\t\t" + turnAroundTimeMatrix[i] + "\t\t "
					+ completionTimeMatrix[i]);
		}

		System.out.println("Average waiting time = " + (float) totalWaiting / (float) processNumb);
		System.out.println("Average turn around time = " + (float) totalTurnAroundTime / (float) processNumb);
		System.out.println("###########################################################");

	}

	public void sort(int array[][]) {
		boolean sorted = false;
		int temp;
		int temp2;

		for (int i = 0; i < processNumb; i++) {

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
