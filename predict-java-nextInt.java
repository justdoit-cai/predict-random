/**
java版本：根据前两次nextInt()的值获取下一个nextInt的值
*/
import java.util.Random;
public class Demo01 {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    public static void main(String[] paramArrayOfString) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int a = random.nextInt();
        int b = random.nextInt();
        long oldseed = ((long) a << 16);
        for (int i = 0; i <= 0xffff; i++) {//暴力破解种子
            long nextseed = (oldseed * multiplier + addend) & mask;
            if ((int) (nextseed >>> 16) == b) {
                oldseed = nextseed;
                break;
            }
            oldseed += 1;
        }
        int next_int = (int) (((oldseed * multiplier + addend) & mask) >>> 16);

        System.out.println(next_int);
        System.out.println(random.nextInt());
    }
}