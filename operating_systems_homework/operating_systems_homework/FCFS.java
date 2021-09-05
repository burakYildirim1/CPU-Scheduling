package operating_systems_homework;

public class FCFS {

	int processNumb;

	int totalProcessingTime = 0;
	int completionTime = 0;
	float wait = 0;
	float averageWaitingTime;

	int[] completionTimeMatrix;

	public FCFS(int processNumb, int[][] processMatrix) {
		System.out.println("FCFS Algorithm : ");

		this.processNumb = processNumb;
		sort(processMatrix);

		int[] arrivalTimeMatrix = new int[processNumb];
		int[] burstTimeMatrix = new int[processNumb];
		int[] waitingTimeMatrix = new int[processNumb];
		int turnAroundTimeMatrix[] = new int[processNumb];
		completionTimeMatrix = new int[processNumb];
		int totalTurnAroundTime = 0;

		for (int i = 0; i < processNumb; i++) {
			arrivalTimeMatrix[i] = processMatrix[i][0];

			burstTimeMatrix[i] = processMatrix[i][1];
		}

		int totalWaiting;
		totalWaiting = totalWaitingTime(processMatrix, processNumb);

		// calculation of waiting times
		for (int i = 1; i < processNumb; i++) {
			waitingTimeMatrix[i] = burstTimeMatrix[i - 1] + waitingTimeMatrix[i - 1];
		}

		// Calculation of turn around times
		for (int i = 0; i < processNumb; i++) {
			turnAroundTimeMatrix[i] = burstTimeMatrix[i] + waitingTimeMatrix[i];
		}

		for (int i = 0; i < processNumb; i++) {
			completionTimeMatrix[i] = turnAroundTimeMatrix[i] + arrivalTimeMatrix[i];
		}

		System.out
				.println("Arrival Time " + "Burst Time " + " Waiting Time " + " Turn Around Time" + " Completion Time");

		for (int i = 0; i < processNumb; i++) {
			totalTurnAroundTime = totalTurnAroundTime + turnAroundTimeMatrix[i];
			System.out.println(arrivalTimeMatrix[i] + "\t\t " + burstTimeMatrix[i] + "\t\t " + waitingTimeMatrix[i]
					+ "\t\t" + turnAroundTimeMatrix[i] + "\t\t " + completionTimeMatrix[i]);
		}

		System.out.println("Average waiting time = " + (float) totalWaiting / (float) processNumb);
		System.out.println("Average turn around time = " + (float) totalTurnAroundTime / (float) processNumb);
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

	public void sort(int array[][]) {
		boolean sorted = false;
		int temp;
		int temp2;

		for (int i = 0; i < processNumb; i++) {

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
