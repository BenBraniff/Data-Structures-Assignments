// package 2310Proj3;


public class PrioritizedNetworkTraffic {

	private int[] Q;

	private int head = -1;
	private int tail = 0;
	private int length;
	
	// Precondition: Priority queue Q is defined but not created.
	// Postcondition: Priority queue Q is created, and its size is set to "queueSize".
	//                All values of Q are initialized to -1.
	//                length is set to "queueSize".
	public PrioritizedNetworkTraffic(int queueSize)
	{
		// Precondition is already met in line 6
		
		// Postconditions:
		this.Q = new int[queueSize];

		for(int i=0; i<queueSize; i++) {
			Q[i] = -1;
		}

		this.length = queueSize;
	}
	
	
	// Precondition: Priority queue Q is existent.
	//               "tail" is already set to the index of Q where a new packet may be inserted. 
	//               "head" is already set to the index of Q where the packet with the highest priority is stored.
	// Postcondition: A new packet with priority "newElement" is inserted in the priority queue Q.
	//                "head" is set to the index of Q where the packet with the highest priority is stored.
	//                "tail" is set to the next index of Q that is available for storage of a new element.
	//                If Q is full, "tail" is to the index of Q where the packet with the lowest priority is stored.
	public void Enqueue(int newElement)
	{	   
		// preconditions:
		this.head = LocateNextHead(0, this.length-1);
		this.tail = LocateNextTail(0, this.length-1);

		// postconditions:
		int oldTail = this.tail;
		if( Q[tail] == -1) {
			this.Q[tail] = newElement;
		} else {
			this.tail = LocateNextTail(0, this.length-1);
			System.out.println("The queue is full and could not enqueue any more data.\n");
		}
		this.head = LocateNextHead(0, this.length-1);
		this.tail = LocateNextTail(0, this.length-1);


		System.out.println("At Enqueue: inserted " + newElement + " in index " + oldTail + "\n");
	}

	
	// Precondition: Priority queue Q is existent.
	//               "head" is already set to the index of Q where the packet with the highest priority is stored.
	//               If Q is empty, "head" is -1.
	//               "tail" is already set to the index of Q where a new packet may be inserted.
	// Postcondition: The packet with index equal to "head" is removed from Q and is returned to the caller.
	//                -1 is inserted in its place, namely in the cell of Q where the removed packet was previously stored. 
    //                "head" is set to the index of Q where the packet with the highest priority is stored.
    //                "tail" is set to the next index of Q that is available for storage of a new element.
    //                If Q is empty, "head" is set to -1 and "tail" is set to 0. 
	
	public int Dequeue()
	{	  
		// preconditions:
		// Priority queue is assumed to already exist.
		// if "head" is -1, it can be assumed that Q is empty
		this.head = LocateNextHead(0, length-1);

		// postconditions:
		if(this.head == -1) {
			this.tail = 0;
			System.out.println("The queue is empty so disregard the return -420.");
		} else {
			int DequeueNum = Q[head];
			Q[head] = -1;
			int oldHead = head;
			this.head = LocateNextHead(0, length-1);
			this.tail = LocateNextTail(0, length-1);

			System.out.println("At Dequeue: removed " + DequeueNum + " from index " + oldHead + "\n");

			return DequeueNum;
		}

		System.out.println("The Dequeue method did not run properly so diregard the return -421.");
		return -421;
	}
	
	// Precondition: Priority queue Q is existent.
	//               "startIndex" and "endIndex" are indices of Q that define the beginning and the end, respectively, of the subarray of Q that needs to be searched.
	//               "startIndex" and "endIndex" may refer to the entire Q. 
	// Postcondition: The index of Q, where the packet with the highest priority is stored, is found and is returned to the caller. 
	public int LocateNextHead(int startIndex, int endIndex)
	{	 
		// precondition can be assumed to be met

		// postconditions: 

		int max = -1;
		int middleIndex = (startIndex + endIndex)/2;

		// base case
		if(startIndex == endIndex ) {
			return startIndex;
		}

		// recursive case
		int left = LocateNextHead(startIndex, middleIndex);
		int right = LocateNextHead(middleIndex+1, endIndex);

		// find max
		if(Q[left] > Q[right]) {
			max = Q[left];
		} else {
			max = Q[right];
		}

		// return index of first occurence of max
		for(int i=0; i<this.length; i++) {
			if(Q[i] == max) {
				return i;
			}
		}

		// should never run
		System.out.println("LocateNextHead did not run properly, so disregard the return -20.");
		return -20;
	}
	
	
	// Precondition: Priority queue Q is existent.
	//               "startIndex" and "endIndex" are indices of Q that define the beginning and the end, respectively, of the subarray of Q that needs to be searched.
	//               "startIndex" and "endIndex" may refer to the entire Q. 
	// Postcondition: The index of Q, where the packet with the lowest priority is stored, is found and is returned to the caller. 
	public int LocateNextTail(int startIndex, int endIndex)
	{	  
		// preconditions can be assumed to be met

		// postconditions:

		int min = -1;
		int middleIndex = (startIndex + endIndex) / 2;

		// base case
		if(startIndex == endIndex ) {
			return startIndex;
		}

		// recursive case
		int left = LocateNextTail(startIndex, middleIndex);
		int right = LocateNextTail(middleIndex+1, endIndex);

		// find min
		if(Q[left] < Q[right]) {
			min = Q[left];
		} else {
			min = Q[right];
		}

		// return index of min
		for(int i=0; i<this.length; i++) {
			if(Q[i] == min) {
				return i;
			}
		}

		// should never run
		System.out.println("LocateNextTail did not run properly, so disregard the return -35.");
		return -35;
	}
	
	
	// Precondition: Priority queue Q is existent. 
	// Postcondition: The index and priority of each packet in Q are displayed on the monitor.
	public void DisplayPriorityQueue()
	{
		// precondition can be assumed to be met

		// postconditions:

		System.out.println("Displaying IDS priority queue data...");

		for(int i=0; i<this.length; i++) {
			System.out.println("Index: " + i + " Packet Priority: " + this.Q[i]);
		}
		System.out.println("Current head: " + this.head + "; Current tail: " + this.tail +"\n");

	}
	
}

