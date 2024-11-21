package proj2;


public class StackWork
{
   int[] S0;
   private int S0top;   
   private int S0length;
   
   private int[] S1;
   private int S1top;   
   private int S1length;
   
   private int[] S2;
   private int S2top;   
   private int S2length;
   
   
   // Precondition: S0size, S1size, and S2size are greater than 0.
   // Postcondition: The stacks S0, S1, and S2, are created, and their respective lengths are initialized.
   public StackWork(int S0size, int S1size, int S2size)
   {
      //initialize all the top to invalid number
      this.S0top = -1;
      this.S1top = -1;
      this.S2top = -1;

      this.S0length = S0size;
      this.S1length = S1size;
      this.S2length = S2size;

      this.S0 = new int[S0size];
      this.S1 = new int[S1size];
      this.S2 = new int[S2size];
   }

   // Precondition: StackSelector is equal to 0, 1, or 2.
   // Postcondition: If StackSelector is 0, then the new element x is inserted in stack S0. If StackSelector is 1, 
   // then the new element x is inserted in stack S1. If StackSelector is 2, then the new element x is inserted 
   // in stack S2.
   public void Push(int x, int StackSelector)
   {	 

      switch(StackSelector) {
         case 0:
            if(!(S0top == S0length-1)) {
               this.S0[++S0top] = x;
            }else throw new java.lang.ArrayIndexOutOfBoundsException();
            break;
         case 1:
            if(!(S1top == S1length-1)) {
               this.S1[++S1top] = x;
            }else throw new java.lang.ArrayIndexOutOfBoundsException();
            break;
         case 2:
            if(!(S2top == S2length-1)) {
               this.S2[++S2top] = x;
            }else throw new java.lang.ArrayIndexOutOfBoundsException();
            break;   
         default:
            System.out.println("StackSelector was an invalid number and Push could not run.");
      }


   }
   

   // Precondition: StackSelector is equal to 0, 1, or 2.
   // Postcondition: If StackSelector is 0, then an element is taken out of stack S0 and is returned to the caller. 
   // If StackSelector is 1, then an element is taken out of stack S1 and is returned to the caller.
   // If StackSelector is 2, then an element is taken out of stack S2 and is returned to the caller.
 
   public int Pop(int StackSelector)
   {

      switch(StackSelector) {
         case 0:
            if(!(S0top == -1)) {
               int someNum = this.S0[S0top--];
               return someNum;
            }else throw new java.lang.ArrayIndexOutOfBoundsException();
         case 1:
            if(!(S1top == -1)) {
               int someNum = this.S1[S1top--];
               return someNum;
            }else throw new java.lang.ArrayIndexOutOfBoundsException();
         case 2:
            if(!(S2top == -1)) {
               int someNum = this.S2[S2top--];
               return someNum;
            }else throw new java.lang.ArrayIndexOutOfBoundsException();
         default:
            System.out.println("StackSelector was an invalid number and Push could not run.");
            return 696969;
      }

   }
   
   
   // Precondition: 
   // Postcondition: The elements of the stack S0 are displayed, followed by the elements of the stack S1, and in the end
   // the elements of the Stack S2.
   public void displayStackData()
   {
	   // Print elements of S0
      System.out.println("Elements of S0:");
      for(int i=0; i <= this.S0top; i++) {
         System.out.print(this.S0[i] + " ");
      }
      System.out.println("\n");

      // Print elements of S1
      System.out.println("Elements of S1:");
      for(int i=0; i <= this.S1top; i++) {
         System.out.print(this.S1[i] + " ");
      }
      System.out.println("\n");
      
      // Print elements of S2
      System.out.println("Elements of S2:");
      for(int i=0; i <= this.S2top; i++) {
         System.out.print(this.S2[i] + " ");
      }
      System.out.println("\n");



   }

      
   // Precondition: The StackWork object exists.
   // Postcondition: The instance variable S0top is returned.
   public int getS0top()   
   {
      return this.S0top;

   }
   
}	