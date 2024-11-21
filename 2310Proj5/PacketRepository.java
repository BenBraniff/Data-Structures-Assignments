// implementation of classes
package Proj5sequenceNumTable;
public class PacketRepository {

public static void main(String[] Args) {
    System.out.println("Code working with Packets and Hashtables ...");

    System.out.println("");

    HT hashTable = new HT(10);

    Packet Packet1 = new Packet(1,"TCP" , 1);
    Packet Packet2 = new Packet(1, "TCP", 1);
    Packet Packet3 = new Packet(1, "TCP", 1);
    Packet Packet4 = new Packet(4, "TCP", 1);
    Packet Packet5 = new Packet(5, "TCP", 1);

    hashTable.hash(Packet1.SequenceNum);
    hashTable.hash(Packet2.SequenceNum);
    hashTable.hash(Packet3.SequenceNum);
    hashTable.hash(Packet4.SequenceNum);
    hashTable.hash(Packet5.SequenceNum);


    hashTable.print();

    hashTable.remove(1);

    hashTable.print();


    System.out.println("\n");
}



}