// model a network packet
package Proj5sequenceNumTable;
public class Packet {

long SequenceNum;
String protocal;
int port;


public Packet(long SequenceNum, String protocal, int port) {
    this.SequenceNum = SequenceNum;
    this.protocal = protocal;
    this.port = port;
}

}