package srm580;

/**
 * SRM 580 - Round 1 - 250 pts
 * Contest Won - 26/05/13 - Room 57
 *
 * Problem Statement
     
 Rabbit went to a river to catch eels. All eels are currently swimming down the stream at the same speed. Rabbit is standing by the river, downstream from all the eels.  Each point on the river has a coordinate. The coordinates increase as we go down the stream. Initially, Rabbit is standing at the origin, and all eels have non-positive coordinates.  You are given two int[]s: l and t. These describe the current configuration of eels. The speed of each eel is 1 (one). For each i, the length of eel number i is l[i]. The head of eel number i will arrive at the coordinate 0 precisely at the time t[i]. Therefore, at any time T the eel number i has its head at the coordinate T-t[i], and its tail at the coordinate T-t[i]-l[i].  Rabbit may only catch an eel when some part of the eel (between head and tail, inclusive) is at the same coordinate as the rabbit. Rabbit can catch eels at most twice. Each time he decides to catch eels, he may catch as many of the currently available eels as he wants. (That is, he can only catch eels that are in front of him at that instant, and he is allowed and able to catch multiple eels at once.)  Return the maximal total number of eels Rabbit can catch.
 Definition
     
 Class:
 srm580.EelAndRabbit250
 Method:
 getmax
 Parameters:
 int[], int[]
 Returns:
 int
 Method signature:
 int getmax(int[] l, int[] t)
 (be sure your method is public)
     

 Constraints
 -
 l will contain between 1 and 50 elements, inclusive.
 -
 Each element of l will be between 1 and 1,000,000,000, inclusive.
 -
 l and t will contain the same number of elements.
 -
 Each element of t will be between 0 and 1,000,000,000, inclusive.
 Examples
 0)

     
 {2, 4, 3, 2, 2, 1, 10}
 {2, 6, 3, 7, 0, 2, 0}
 Returns: 6
 Rabbit can catch 6 eels in the following way:
 At time 2, catch Eel 0, Eel 4, Eel 5, and Eel 6.
 At time 8, catch Eel 1 and Eel 3.
 1)

     
 {1, 1, 1}
 {2, 0, 4}
 Returns: 2
 No two eels are in front of Rabbit at the same time, so Rabbit can catch at most two eels.
 2)

     
 {1}
 {1}
 Returns: 1

 3)

     
 {8, 2, 1, 10, 8, 6, 3, 1, 2, 5}
 {17, 27, 26, 11, 1, 27, 23, 12, 11, 13}
 Returns: 7

 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class EelAndRabbit250 {

    public int getmax(int[] l, int[] t) {
        int maxTime=getMaxTime(t);

        int maxA=0;
        int time=0;
        int tmp;

        //looking the max eels a same time (testing all times phases)
        for (int i=0; i<maxTime+1;i++)  {

            tmp=0;
            for(int j=0;j<t.length;j++) {

                if(t[j]-i<=0 && (t[j]+l[j]-i)>=0 ) {
                    tmp++;
                }
            }
            if (tmp>maxA) { time=i;
                maxA=tmp;

            }
        }

        //removing eels at time computed
        for(int j=0;j<t.length;j++) {
            if(t[j]-time<=0 && (t[j]+l[j]-time)>=0 ) {

                l[j]=0; //so the eel cannot be counted again
                t[j]=-1;
            }
        }
        System.out.println("=> Total "+maxA+" eels at round one");

        int maxB=0;
        //looking the max eels a same time (testing all times phases)
        for (int i=0; i<maxTime+1;i++)  {
            tmp=0;
            for(int j=0;j<t.length;j++) {
                if(t[j]-i<=0 && (t[j]+l[j]-i)>=0 ) {
                    tmp++;
                }
            }
            if (tmp>maxB) { time=i;
                maxB=tmp;


            }
        }
        System.out.println("=> Total "+maxB+" eels at round two");



        return (maxA+maxB);
    }

    private int getMaxTime(int[] t) {
        int max=0;
        for(int i=0;i<t.length;i++)
            if(t[i]>max)
                max=t[i];
        return max;
    }
}