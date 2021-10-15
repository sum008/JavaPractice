package recursion.practice;

public class StringPermutation {
    static int count = 0;

    private static void getAllPermutationsOfString(String ip, String cStr) {

        if (ip.length() == 0) {
            count++;
            System.out.println(cStr);
            return;
        }
        for (int i = 0; i < ip.length(); i++) {
            getAllPermutationsOfString(ip.substring(0, i) + ip.substring(i + 1, ip.length()), cStr + ip.charAt(i));
        }
    }

    public static void main(String[] args) {
        String ip = "bab";
        getAllPermutationsOfString(ip, "");
        System.out.println(count);
    }
}
