package srm154;

/**
 * SRM 154 - DIV 1 - 350 pts
 * Practice success - 25/05/13

 Problem Statement
     
 Checking to to see if a player enters a valid cheat code in a game is not just a simple matter of checking that the keypresses exactly line up with the cheat code. It is possible that the player may hold down one key a little too long and consequently it is read as two or more key presses. Ignoring repeated key presses isn't an option either however, because a cheat code may require a key to be used repeatedly. Also, the player may press any number of keys before or after entering the cheat code.  You will be given a String keyPresses which will contain the keys the player pressed. Each character in keyPresses will correspond to one key pressed by the player. The order of characters in keyPresses is the order in which the keys were entered. You will also be given a String[] codes. Each String in codes will be one possible valid cheat code. You are to create a class CheatCode with a method matches which will return a sorted int[] containing the indexes of all codes in codes which potentially match what the player entered. A cheat code matches keyPresses if some substring of keyPresses is the same as the cheat code, except that it may have more than one of the same character, where only one was expected. So, if keyPresses where "ABBCC", it would match the cheat codes "ABC", "BB" and "BC" (and others), but not "ABBB" or "BBCCD".  For example, if keyPresses is "UUDDLRRLLRBASS" (quotes for clarity) and codes is
 { "UUDDLRLRBA",
 "UUDUDLRLRABABSS",
 "DDUURLRLAB",
 "UUDDLRLRBASS",
 "UDLRRLLRBASS" }
 The code "UUDDLRLRBA" matches because the player may enter extra keys after the code has been entered. Also notice that although there is an extra 'R' and 'L' in the middle of keyPresses, the code still matches because the computer may have accidentally detected repeated keys while the player entering a code. The code "UUDUDLRLRABABSS" stops matching at the 4th character, 'U'. The 2nd 'D' in keyPresses is allowed because the player may have held it down too long. However, the 'U' does not match the 'L', which is next in keyPresses. The code "DDUURLRLAB" does not match. Remember though that the beginning of keyPresses, "UU", is ignored here because the player may have done another move before entering the code. The "DD" at the beginning of the code does match with the first "DD" in keyPresses, however next in keyPresses is an 'L' which does not match the 'U' in the code. The code "UUDDLRLRBASS" matches. The code "UDLRRLLRBASS" also matches.  Your program would return
 { 0,  3,  4 }
 for the 0th, 3rd, and 4th codes in codes which match keyPresses.
 Definition
     
 Class:
 CheatCode
 Method:
 matches
 Parameters:
 String, String[]
 Returns:
 int[]
 Method signature:
 int[] matches(String keyPresses, String[] codes)
 (be sure your method is public)
     

 Constraints
 -
 keyPresses will be between 0 and 50 characters in length, inclusive.
 -
 keyPresses will only contain uppercase letters ('A'-'Z').
 -
 codes will contain between 0 and 50 elements, inclusive.
 -
 Each String in codes will be between 1 and 50 characters in length, inclusive.
 -
 Each String in codes will only contain uppercase letters ('A'-'Z').
 Examples
 0)

     
 "UUDDLRRLLRBASS"
 {"UUDDLRLRBA","UUDUDLRLRABABSS","DDUURLRLAB","UUDDLRLRBASS","UDLRRLLRBASS"}
 Returns: { 0,  3,  4 }
 This is the example from above.
 1)

     
 "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
 {"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"}
 Returns: { 0 }
 Watch your time!
 2)

     
 "IDDQDDTSFHHALL"
 {"FHHALL", "FHSHH", "IDBEHOLDA", "IDBEHOLDI", "IDBEHOLDL",
 "IDBEHOLDR", "IDBEHOLDS", "IDBEHOLDV", "IDCHOPPERS", "IDCLEV",
 "IDCLIP", "IDDQD", "IDDT", "IDFA", "IDKFA", "IDMYPOS", "IDMUS"}
 Returns: { 0,  11 }

 3)

     
 "AABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYY"
 {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI",
 "FGHIJ", "GHIJK", "HIJKL", "IJKLM", "JKLMN",
 "KLMNO", "LMNOP", "MNOPQ", "NOPQR", "OPQRS",
 "PQRST", "QRSTU", "RSTUV", "STUVW", "TUVWX",
 "UVWXY", "VWXYZ", "WXYZA", "XYZAB", "YZABC",
 "ZABCD"}
 Returns:
 { 0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  14,  15,
 16,  17,  18,  19,  20 }

 4)

     
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ"
 {"LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSS", "LAKJDGSJKGLSDKHFKDFHDGHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDHHSDKKSJDHFHJGKDKLSLSLJKASSJ",  "AKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKHHSJ",  "LAKDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLJKAHS",   "KJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDHHSDKKSJDHFHJGKDKLLSLJKAHS",    "LAKGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGJKGLSDKHFKDFHDGHHDKKSJDHFHJGKDKLSLSLJKAHS",    "LAKJDGJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHGHHSDKKSJDHFHJGKDKLSLSLJKAHS",   "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSL",
 "LAKJDGSJKGLSDKHFDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHS",   "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLJKAHSJ",
 "LAKJDGSJKGLSDHFKDFHDGHHSDKKSJDHFHJGKDKLSLSJKAHS",    "KGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSL",
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJHFHJGKDKLSLSLJKAHS",   "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKSJHFHJGKDKLSLSLJKAHS",    "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHS",   "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKSJHFHJGKDKLSLSLJKAHS",    "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJKDKLSLSLJKAHSJ",
 "LKJDGSJKGLSDKHFKDFHDGHHSDKKJDHFHJGKDKLSLSLJKAHS",    "AKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHS",
 "LAJDGSJKGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLKAHS",     "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFGKDKLSLSLJKAHSJ",
 "LKJDGSJKLSDKHFKDFHDGHHSDKSJDHFHJGKDKLSLSLJKAHS",     "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHHJGKDKLSLSLJKAHSJ",
 "AKJDGSJKGLSDKFKDFHDGHHSSJDHFJGKDKLSLSLJKAHS",        "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFJGKDKLSLSLJKAHS",   "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJHFHJGKDKLSLSLJKAHSJ",
 "LAKJDSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDLSLSLJKAHS",    "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDLSLSLJKAHS",    "LAKJDGSJKGLSDKHFKDFHDGHHSDKKJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDHHSDKKSJDHFHJGKDKLSLSLJKAHS",   "LAKDGSJKGLSDKHFKDFHDGHHSDKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSDKHFKDFHDGHHSDKSJDHFHJGKDKLSLSLJKAS",    "KJDGSJKGLSDKHFKDFHDGHSDKKSJDHFHJGKDKLSLSLJKAH",
 "LAKJDGSJKGLSDKHFKDFHDGHHDKKSJDHFHJGKDKLSLSLJKAHS",   "LAKDGSJKGLSDKFHDGHHSDKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJKGLSKHFKDFHDHHSDKKSJDHFHJGKDKLSLSLJKAHS",    "LAKJDGSJKGLSDKHFKDFHDGHHSKKSJDHFHJGKDKLSLSLJKAHSJ",
 "LAKJDGSJGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLJKAHS",    "LAKJDGSJKGLSDKHFKDFHDGHHDKKSJDHFHJGKDKLSLSLJKAHSJ"}
 Returns: { 1,  3,  7,  13,  17,  27,  43 }

 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class CheatCode350 {
    public int[] matches(String keyPresses, String[] codes) {
        int[] tmp = new int[codes.length];// max potential good results
        int numberOfmatches=0;

        for(int i =0; i< codes.length; i++) {
            System.out.println("Checking if keypresses matches code n° "+i);
            if (checkCode(keyPresses,codes[i],codes[i],'\0')) {
                tmp[numberOfmatches]=i;
                numberOfmatches++;
            }


        }

        int[] results= new int[numberOfmatches];
        for(int i=0;i<numberOfmatches;i++) {
            results[i]=tmp[i];
            System.out.println("results["+i+"] = "+results[i]);
        }
        return results;
    }

    private boolean checkCode(String keyPresses, String code, String resetCode, char previous) {

        if(code.length()==0)// end of code means all chars have been iterated
            return true;
        else if(keyPresses.length()==0) // end of keypress means the code haven't been retrieved
            return false;
        else if(keyPresses.charAt(0)==code.charAt(0) )
            return checkCode(keyPresses.substring(1), code.substring(1),resetCode,code.charAt(0));
        else if(keyPresses.charAt(0)==previous)
            return checkCode(keyPresses.substring(1), code,resetCode,code.charAt(0));
        else return checkCode(keyPresses.substring(1), resetCode,resetCode,'\0');
    }

}
