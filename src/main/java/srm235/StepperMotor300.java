package srm235;

/**
 * SRM 235 - DIV 1 - 300 pts
 * Practice in progress - 26/05/13
 *
 * Problem Statement
     
 A stepper motor consists of a metal rotor surrounded by several identical electromagnets.
 When a pulse of current is sent through the appropriate electromagnet, the rotor rotates by a fixed angular increment known as one "step".
 A simple computer known as the motion controller regulates the electromagnets and keeps track of the current position of the rotor as an integer.
 A clockwise step adds 1 and a counterclockwise step subtracts 1 from this position, which is relative to an arbitrary zero point and can be negative.
 Since stepper motors provide precise control over the motion of the rotor, they have applications ranging from floppy drives to medical imaging devices
 to industrial fabrication machinery.
 You are writing software that communicates with the motion controller for a stepper motor with n steps in one complete revolution.
 The apparatus driven by your motor is purely rotational, so rotor position p is identical to position p+i*n, where i is any integer.
 You have the rotor's current position and a list of target positions, and you wish to move the rotor to the nearest position
 that is identical to one of the target positions.
 Write a class StepperMotor with a method rotateToNearest that takes an int n, an int current, and a int[] target,
 and returns an int that is the minimum number of steps (signed positive for clockwise or negative for counterclockwise)
 necessary to reach one of the targets from position current. If there is a tie between a positive number and negative number
 for the smallest value, return the positive number.
 Definition
     
 Class:
 StepperMotor
 Method:
 rotateToNearest
 Parameters:
 int, int, int[]
 Returns:
 int
 Method signature:
 int rotateToNearest(int n, int current, int[] target)
 (be sure your method is public)
     

 Notes
 -
 The answer will always be between -floor((n-1)/2) and floor(n/2), inclusive.
 -
 Beware of overflow.
 Constraints
 -
 n will be between 1 and 2147483647, inclusive.
 -
 current will be between -2147483648 and 2147483647, inclusive.
 -
 target will contain between 1 and 50 elements, inclusive.
 -
 Each element of target will be between -2147483648 and 2147483647, inclusive.
 Examples
 0)

     
 10
 0
 {-2, -3, 4, 5, 6, 9999999}
 Returns: -1
 From position 0, rotating one step counterclockwise puts the rotor in position -1, which is equivalent to 9999999.
 1)

     
 2
 314159
 {10, 8, 6, 4, 2}
 Returns: 1
 With only two different positions, one step either clockwise or counterclockwise will move the rotor from an odd position to an even position. The tiebreaker favors +1 over -1.
 2)

     
 1
 -2147483648
 {-2147483648, -2147483648, 2147483647, 2147483647}
 Returns: 0
 A step here just causes the rotor to spin in a full circle, so all positions are identical.
 3)

     
 23
 10
 {64077, -567273, 105845, -279980, 35557,
 -286190, -652879, -431665, -634870, -454044}
 Returns: -11

 4)

     
 1000000000
 1403466951
 {1233321992, 11423750, 1356595134, 1130863021, 1183514764,
 1943494859, 1714480374, 1529875954, 1738756510, 1190153525}
 Returns: -46871817

 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class StepperMotor300 {
    public int rotateToNearest(int n, int current, int[] target) {
        // Step 1 normalize the initial step value and each target
        System.out.print("Old current : "+current);
        current = current%n;
        if(current <0)
            current=n+current;
        System.out.println(", current normalized : "+current);

        for (int i=0; i<target.length;i++) {
            System.out.print("Old target["+i+"] : "+target[i]);
            target[i]=target[i]%n;
            if(target[i]<0)
                target[i]=n+target[i];
            System.out.println(", normalized target["+i+"] : "+target[i]);
        }

        int minValue=n;
        int minIndex=0;
        int step, antistep;
        boolean negative=false;

        for (int i=0; i<target.length;i++) {
            System.out.print("testing position : "+i);
            if(current == target[i])
                return 0;
            // Check positive move
            if(current < target[i]) {
                step = target[i] -current;
            } else {
                step = n-current+target[i];
            }

            // Check negative move
            if(target[i]<current) {
                antistep = current - target[i];
            } else {
                antistep = current+n-target[i];
            }
            System.out.println(", one way : "+step+", other way : "+antistep);
            if(step==0 || antistep ==0) return 0;

            if(antistep<minValue) {
                minValue=antistep;
                negative=true;
            }
            if(step<=minValue) {
                minValue=step;
                negative = false;
            }
        }
        if(negative)
            return 0-minValue;
        else return minValue;

    }
}
