package srm479;

/**
 * SRM 479 - DIV 1 - 350 pts
 * Practice success - 26/05/13

 Problem Statement
     
 John and Brus are flying on an airplane and now it's coffee time.  There are n seats in the plane numbered from 1 to n, one seat in each row. All seats are occupied, thus there are n passengers overall (including John and Brus). A stewardess will serve a cup of coffee or tea to each passenger. She needs to serve tea to all passengers whose seat numbers are listed in int[] tea, and she needs to serve coffee to all other passengers.  A coffee and tea machine is located just before the first seat of the plane. The stewardess has a flask that can contain enough coffee or tea to serve at most 7 passengers. Initially, the stewardess is located near the coffee and tea machine and the flask is empty.  The stewardess can perform the following kinds of actions:
 Move from the coffee and tea machine to seat 1 or move from seat 1 to the coffee and tea machine. Each of these two actions takes 1 second.
 Move from seat i, i > 1, to seat i-1. It takes 1 second.
 Move from seat i, i < n, to seat i+1. It takes 1 second.
 If she is near seat i, the passenger at this seat has not yet been served and the current type of drink in the flask is the same as the drink this passenger wants, she can serve this passenger with a cup of drink he/she wants. It takes 4 seconds.
 If she is near the coffee and tea machine and the flask is empty, she can fill the flask with either tea or coffee (but not both simultaneously). It takes 47 seconds. Note that she can fill the flask partially (to serve less than 7 passengers), but it still takes 47 seconds.
 Given int n and int[] tea, return the minimal time needed for the stewardess to serve all passengers with proper drinks and return to the coffee and tea machine.
 Definition
     
 Class:
 TheCoffeeTimeDivOne
 Method:
 find
 Parameters:
 int, int[]
 Returns:
 long
 Method signature:
 long find(int n, int[] tea)
 (be sure your method is public)
     

 Constraints
 -
 n will be between 2 and 44,777,777, inclusive.
 -
 tea will contain between 1 and 47 elements, inclusive.
 -
 Each element of tea will be between 1 and n, inclusive.
 -
 All elements of tea will be distinct.
 Examples
 0)

     
 2
 {1}
 Returns: 108
 The stewardess will serve coffee in 47+2+4+2=55 seconds and tea in 47+1+4+1=53 seconds.
 1)

     
 2
 {2, 1}
 Returns: 59
 Here she only needs to serve tea.
 2)

     
 15
 {1, 2, 3, 4, 5, 6, 7}
 Returns: 261
 The stewardess will fill the flask three times overall: once with tea and two times with coffee.
 3)

     
 47
 {1, 10, 6, 2, 4}
 Returns: 891

 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class TheCoffeeTimeDivOne250 {
    public long find(int n, int[] tea) {
        long totalTime=0;
        boolean[] served = new boolean[n+1];
        int unservedTea= tea.length;
        int unservedCoffee= n- unservedTea;

        for(int i =0;i<=n;i++)
            served[i]=false;
        served[0]=true;

        int flask=0;
        int currentPosition=0;
        int currentTeaPassenger=0;
        //this assume that the table is ordered
        orderTable(tea) ;

        //first, serve all tea
        while(unservedTea>0) {
            if(flask==0)  {// if empty go recharge flask
                System.out.println("go recharge tea Flask");
                totalTime+=currentPosition; // way back to coffee machine
                currentPosition=0;
                totalTime+=47;
                flask=7;
            }

            //go to next tea passenger and serve him
            totalTime+=tea[currentTeaPassenger]-currentPosition;
            currentPosition=tea[currentTeaPassenger];
            System.out.println("serving passenger at rows : "+currentPosition);

            served[tea[currentTeaPassenger]]=true;
            currentTeaPassenger++;
            totalTime+=4;
            unservedTea--;
            flask--;
            System.out.println("remaining tea passengers : "+unservedTea+", remaing flask content : "+flask);
            System.out.println("total time : "+totalTime);
        }

        //now serve coffee (starting from the end)
        flask=0;
        while(unservedCoffee>0) {
            if(flask==0)  {// if empty go recharge flask
                System.out.println("go recharge coffee Flask");
                totalTime+=currentPosition; // way back to coffee machine
                currentPosition=0;
                totalTime+=47;
                flask=7;

                //go to last passenger
                int last = n;
                while(served[last])  last--;
                totalTime+=last;
                currentPosition=last;

            }
            while(served[currentPosition]) {
                totalTime++;
                currentPosition--;
                System.out.println("going back one row");
            }

            System.out.println("serving passenger at rows : "+currentPosition+", total time : "+totalTime);
            served[currentPosition]=true;
            totalTime+=4;
            unservedCoffee--;
            flask--;
            System.out.println("remaining coffee passengers : "+unservedCoffee+", remaing flask content : "+flask);
            System.out.println("total time : "+totalTime);
        }
        // way back
        totalTime+=currentPosition;

        System.out.println("everybody served, total time : "+totalTime+"\n\n ****\n");
        return totalTime;
    }

    public void orderTable(int[] unSortedTable) {
        int[] orderedTable = new int[unSortedTable.length];
        int tmp;
        int j;
        for(int i=1;i<unSortedTable.length;i++) {
            tmp=unSortedTable[i];
            j=i;
            while(j>0 && unSortedTable[j-1]>tmp) {
                unSortedTable[j]=unSortedTable[j-1];
                j--;
            }
            unSortedTable[j]=tmp;
        }
    }
}
