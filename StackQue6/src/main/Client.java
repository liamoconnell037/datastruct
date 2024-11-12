package main;

import java.util.ArrayList;

public class Client {
	public static final int NUM_STATIONS = 5;
	public static final int TRAIN_CAPACITY = 50;
	public static final int TRAIN_INTERVAL = 10;
	public static final int TIME_INTERVAL = 200;
	public static int trainCount = 0;
	public static int passengersOnTrains = 0;
	public static int passengersDelivered = 0;
	public static int passengersWaiting = 0;
	
	public static void main(String[] args) {
		ArrayList<Station> stations = new ArrayList<>();
		LinkedQueue<Train> trains = new LinkedQueue<>();
		LinkedQueue<Passenger> passengers = new LinkedQueue<>();
		createStations(stations);
		for(int i = 0; i <= TIME_INTERVAL;i++) {
			System.out.println("\n\n\n\t\t TIME: " + i + " / " + TIME_INTERVAL);
			System.out.println("Passengers Waiting: " + passengersWaiting);
			System.out.println("Passengers On Trains: " + passengersOnTrains);
			System.out.println("Passengers Delivered: " + passengersDelivered);
			startNewTrain(trains, i);
			generatePassengers(passengers, stations);
			moveTrains(trains, stations, i);
		}
		finalReport(TIME_INTERVAL, passengersWaiting, passengers);
	}
	public static void createStations(ArrayList<Station> stations) {
		for(int i = 0;i < NUM_STATIONS;i++) {
			stations.add(new Station((int)(Math.random()*5+14)));
			System.out.println("New station: " + stations.get(i));
			passengersWaiting++;
		}
	}
	public static void startNewTrain(LinkedQueue<Train> trains, int time) {
		if(time % TRAIN_INTERVAL == 0) {
			trains.enqueue(new Train(TRAIN_CAPACITY));
			trainCount++;
		}
	}
	
	public static void generatePassengers(LinkedQueue<Passenger> passengers, ArrayList<Station> stations) {
		for(int i = 0; i < (int)(Math.random()*5+1);i++) {
			int start = (int)(Math.random()*NUM_STATIONS);
			int end = (int)(Math.random()*NUM_STATIONS);
			while(start >= end) {
				start = (int)(Math.random()*NUM_STATIONS);
				end = (int)(Math.random()*NUM_STATIONS);
			}
			Passenger pass = new Passenger(start, end);
			stations.get(start).addPassenger(pass);
			passengers.enqueue(pass);
			passengersWaiting++;
		}
	}
	
	public static void moveTrains(LinkedQueue<Train> trains, ArrayList<Station> stations, int time) {
		int numTrains = trainCount;
		for(int i = 0; i < numTrains;i++) {
			Train train = trains.dequeue();
			train.move();
			
			if(train.timeToNext() == 0) { 
				int left = train.unloadPassengers(train.nextStation());
				passengersOnTrains -= left;
				passengersDelivered += left;
				int on = train.loadPassengers(stations.get(train.nextStation()), time);
				passengersOnTrains += on;
				passengersWaiting -= on;
				train.updateStation(1);
			}
			if(train.nextStation() < NUM_STATIONS) {
				train.setTimeToNext(stations.get(train.nextStation()).getTimeToNextStation());
				trains.enqueue(train);
			} else {
				trainCount--;
			}
		}
	}
	public static void finalReport(int clock, int passengersCreated,
			 QueueInterface<Passenger> passengers)
			{
			System.out.println("Final Report");
			System.out.println("The total number of passengers is " +
			 passengersCreated);
			System.out.println("The number of passengers currently on a train " +
			 passengersOnTrains );
			System.out.println("The number of passengers delivered is " +
			 passengersDelivered);
			int waitBoardedSum = 0;
			int waitNotBoardedSum = 0;
			for (int i=0; i < passengersCreated; i++)
			{	
				if(passengers.isEmpty()) break;
				Passenger p = passengers.dequeue();
				if(p.boarded())
				waitBoardedSum += p.waitTime(clock);
				else
				waitNotBoardedSum += p.waitTime(clock);
			} // end for
			System.out.println("The average wait time for passengers " +
			 "that have boarded is");
			System.out.println((double)waitBoardedSum/(passengersOnTrains +
			 passengersDelivered));
			System.out.println("The average wait time for passengers " + 
			"that have not yet boarded is");
			System.out.println((double)waitNotBoardedSum /
			(passengersCreated - passengersOnTrains -passengersDelivered));
			} // end finalReport
}
