// hash table functions that map oacket sequence numbers with indices of an array
package Proj5sequenceNumTable;
public class HT {

int size;
long[] hashTable;

public HT(int size) {
    this.size = size;
    this.hashTable = new long[size];

    // initial every space to -1
    for(int i =0; i<size; i++) {
        hashTable[i] = -1;
    }
}

// adds element to table
public void hash(long sequenceNum) {
    
    long longIndex = sequenceNum % size;
    int initialIndex = (int)longIndex;

    if(hashTable[initialIndex] == -1) {
        hashTable[initialIndex] = sequenceNum;
    }else {
        int nextIndex = next(initialIndex + 1);
        if(nextIndex != -1) {
            hashTable[nextIndex] = sequenceNum;
        }else {
            System.out.println("Could not find an open space, hashtable is full.");
        }
    }
}

// remove hash from hashtable
public void remove(long sequenceNum) {
    if(searchBol(sequenceNum)) {
        int index = searchIndex(sequenceNum);
        hashTable[index] = -1;
    }
}

// returns true or false whether its in the HashTable or not
public boolean searchBol(long sequenceNum) {

    for(int i = 0; i < size; i++) {
        if(hashTable[i] == sequenceNum) {
            return true;
        }
        System.out.println("code works i guess" + i);
    }
    return false;
}

public int searchIndex(long sequenceNum) {
    if(searchBol(sequenceNum)) {
        for(int i = 0; i < this.size; i++) {
            if(hashTable[i] == sequenceNum) {
                return i;
            }
        }
    }else {
        System.out.println("Could not find " + sequenceNum + " in hashTable");
        return -1;
    }

    // code should never run
    return -1;
}

// starting at an index, march down and around until we find an open space
// return the index of open space
// if we dont find a space, return -1
public int next(int index) {
    int laps = 0;
    for(int i = index; i <= this.size; i++) {
        if(i == this.size) {
            i = 0;
            laps++;
        }
        // loops back around doesn't find an open space
        if((i == index)&&(laps == 1)) {
            return -1;
        }
        if(hashTable[i] == -1) {
            return i;
        }
    }

    // code should never run
    return -1;
}

// prints the whole hashtable
public void print() {
    System.out.println("Hash table list of size "+ this.size + ": ");
    for(int i = 0; i < this.size; i++) {
        System.out.println(this.hashTable[i]);
    }
}

}