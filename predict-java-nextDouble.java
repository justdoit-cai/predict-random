/**
 * java版本：根据一个nextDouble()的值获取下一个nextDouble()的值
 */
import java.util.Random;
public class Demo01 {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16D;

    public static void main(String[] paramArrayOfString) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        double a1 = random.nextDouble();

        int a = (int) ((long) (a1 / DOUBLE_UNIT) >> 27);//取高27位
        int b = (int) ((long) (a1 / DOUBLE_UNIT) & ((1L << 27) - 1));//取低27位
        long oldseed = ((long) a << 22);
        for (int i = 0; i <= ((1L << 22) - 1); i++) {//暴力破解种子
            long nextseed = (oldseed * multiplier + addend) & mask;
            if ((int) (nextseed >>> 21) == b) {
                oldseed = nextseed;
                break;
            }
            oldseed += 1;
        }
        long nextseed = (oldseed * multiplier + addend) & mask;
        int next_int1 = (int) (nextseed >>> 22);
        long nextseed2 = (nextseed * multiplier + addend) & mask;
        int next_int2 = (int) (nextseed2 >>> 21);
        double b2 = (((long) (next_int1) << 27) + next_int2) * DOUBLE_UNIT;

        System.out.println(b2);
        System.out.println(random.nextDouble());
    }
}