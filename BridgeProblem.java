/**
 * [Problem Statement]
 * The “Bridge and Torch” problem states that you are given an array of time a person needs to cross the bridge.
 * Since it is time, it comprises positive integers.
 * Along with the time we are given a bridge, which a person needs to cross.
 * The bridge allows only two people at a time to cross. They carry a torch while crossing.
 * And since there is a single torch.
 * One of the people from the other side should return and take the torch back to the starting side.
 * When two people cross the bridge, they can cross at the speed of a slower person.
 * Find the minimum total time in which all persons can cross the bridge.
 */
public class BridgeProblem {
    public static void main(String[] args) {
        int[] t = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // input

        int[] opt = new int[t.length];
        opt[0] = t[0]; // fast person
        opt[1] = t[1]; // second fast person

        // imaging that the fast and the second fast person just run back and forth to pass the torch and save the time
        // although the number of runs has increased, but the total time-cost is decreasing
        // to show that greedy will be slower: 
        // (1&10=10)+1ran-back+(1&9=9)+1ran-back+...+(1&3=3)+1ran-back+(1&2=2)=(10+1)+(9+1)+...+(3+1)+2=62
        for (int i = 2; i < t.length; i++) {
            opt[i] = Math.min(opt[i - 1] + t[0] + t[i],
                    opt[i - 2] + t[0] + t[i] + (2 * t[1]));
            for (int o : opt)
                System.out.print(o + " ");
            System.out.println();
        }

        System.out.println(opt[opt.length - 1]);
    }
}
