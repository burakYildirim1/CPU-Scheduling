package operating_systems_homework;

import java.util.Scanner;

class Process {
	int burstTime;
	int arrivalTime;

	public Process(int burstTime, int arrivalTime) {
		this.burstTime = burstTime;
		this.arrivalTime = arrivalTime;
	}
}

public class SJF_P {

	static int processNumb = 0;
	static int[][] processMatrix;
	static int[] arrivalTimeMatrix;
	static int[] burstTimeMatrix;
	static int[] completionTimeMatrix;
	

	public SJF_P(int processNumb, int[][] processMatrix) {
		System.out.println("SJF_P Algorithm : ");

		this.processNumb = processNumb;
		this.processMatrix = processMatrix;

		Process processesMatrix[] = new Process[processNumb];
		int[] burstTimeM = new int[processNumb];
		arrivalTimeMatrix = new int[processNumb];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < processNumb; i++) {
			burstTimeM[i] = processMatrix[i][0];
			arrivalTimeMatrix[i] = processMatrix[i][1];
		}

		for (int i = 0; i < processNumb; i++) {
			processesMatrix[i] = new Process(arrivalTimeMatrix[i], burstTimeM[i]);
		}

		findAverageTime(processesMatrix, processesMatrix.length);

	}

	
	static void findWaitingTime(Process processesMatrix[], int processNumb, int waitingTimeMatrix[]) 
																							
																								
	{
		burstTimeMatrix = new int[processNumb];

		for (int i = 0; i < processNumb; i++)
			burstTimeMatrix[i] = processesMatrix[i].burstTime;

		int complete  = 0;
		int tempValue = 0;
		int minm  = Integer.MAX_VALUE;
		int shortest = 0;
		int finishTime;
		boolean flag = false;

		
		while (complete  != processNumb) {

			for (int j = 0; j < processNumb; j++) {
				if ((processesMatrix[j].arrivalTime <= tempValue) && (burstTimeMatrix[j] < minm ) && burstTimeMatrix[j] > 0) {
					minm  = burstTimeMatrix[j];
					shortest = j;
					flag = true;
				}
			}

			if (flag == false) {
				tempValue++;
				continue;
			}

			burstTimeMatrix[shortest]--;

			
			minm  = burstTimeMatrix[shortest];
			if (minm  == 0)
				minm  = Integer.MAX_VALUE;

			if (burstTimeMatrix[shortest] == 0) {

				complete ++;
				flag = false;

				finishTime = tempValue + 1;

				waitingTimeMatrix[shortest] = finishTime - processesMatrix[shortest].burstTime - processesMatrix[shortest].arrivalTime;

				if (waitingTimeMatrix[shortest] < 0) {
					waitingTimeMatrix[shortest] = 0;
				}

			}

			tempValue++;
		}
	}

	
	static void findTurnAroundTime(Process processesMatrix[], int processNumb, int waitingTimeMatrix[], int turnAroundTimeMatrix[]) {

		for (int i = 0; i < processNumb; i++)
			turnAroundTimeMatrix[i] = processesMatrix[i].burstTime + waitingTimeMatrix[i];
	}

	
	static void findAverageTime(Process processesMatrix[], int processNumb) {
		int waitingTimeMatrix[] = new int[processNumb];
		int turnAroundTimeMatrix[] = new int[processNumb];
		int totalWaiting = 0;
		int totalTurnAroundTime = 0;

		findWaitingTime(processesMatrix, processNumb, waitingTimeMatrix);

		findTurnAroundTime(processesMatrix, processNumb, waitingTimeMatrix, turnAroundTimeMatrix);

		completionTimeMatrix = new int[processNumb];
		for (int i = 0; i < processNumb; i++) {
			completionTimeMatrix[i] = turnAroundTimeMatrix[i] + processesMatrix[i].arrivalTime;
		}

		System.out.println(
				"Arrival Time " + "Burst Time " + " Waiting Time " + " Turn Around Time" + " Completion Time");

		for (int i = 0; i < processNumb; i++) {
			totalWaiting = totalWaiting + waitingTimeMatrix[i];
			totalTurnAroundTime = totalTurnAroundTime + turnAroundTimeMatrix[i];
			System.out.println(processesMatrix[i].arrivalTime + "\t\t " + processesMatrix[i].burstTime + "\t\t " + waitingTimeMatrix[i]
					+ "\t\t" + turnAroundTimeMatrix[i] + "\t\t " + completionTimeMatrix[i]);
		}

		System.out.println("Average waiting time = " + (float) totalWaiting / (float) processNumb);
		System.out.println("Average turn around time = " + (float) totalTurnAroundTime / (float) processNumb);
		System.out.println("###########################################################");
	}

}
