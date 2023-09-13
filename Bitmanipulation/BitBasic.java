//! Get , Set and clear ith bit of the number.
//? You have a 32-bit unsigned integer called 'num' and another integer called 'i'!
//? You need to perform the following operations on the 'num' integer based on the value of 'i':
//? 1. Get the bit value at the "i"th position of "num".
//? 2. Set the bit at the "i"th position of "num".
//? 3. Clear the bit at the "i"th position of "num".
//? We are starting bits from 1 instead of 0. (1-based)

//? Example: N=25 i=3
//? Output: 0 29 25
//? Bit at the 3rd position from LSB is 0. (1 1 0 0 1)
//? The value of the given number after setting the 3rd bit is 29. (1 1 1 0 1)
//? The value of the given number after clearing the 3rd bit is 25. (1 1 0 0 1)

public class BitBasic {
    public static int[] bitManipulation(int num, int i) {

        int ansArr[] = new int[3];
        int mask = 1 << i - 1;
        // to get the bit at ith place 
        // num & mask is mask if ith place is 1 else zero.
        ansArr[0] = (num & (mask)) != 0 ? 1 : 0;
        //set the num ith position as 1.
        ansArr[1] = num | (mask);
        // if the ith position is 1, subtract it with mask to remove 1.
        ansArr[2] = ansArr[0] == 1 ? num - (mask) : num;
        // also num & (~mask) yield same results
        return ansArr;
    }

}
