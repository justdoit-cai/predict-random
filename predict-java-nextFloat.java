/**
 * java版本：根据前两个nextFloat()的值获取下一个nextFloat()的值
 * 这种情况存在多解的可能性比较大，需要多预测几次（大约1~3次）才能成功
 */
import java.util.Random;
public class Demo01 {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    public static void main(String[] paramArrayOfString) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        float a0 = (float) (1 << 24);
        float a1 = random.nextFloat();
        float b1 = random.nextFloat();
        int a = (int) (a1 * a0);
        int b = (int) (b1 * a0);
        long oldseed = ((long) a << 24);
        for (int i = 0; i <= 0xffffff; i++) {//暴力破解种子
            long nextseed = (oldseed * multiplier + addend) & mask;
            if ((int) (nextseed >>> 24) == b) {
                int next_int = (int) (((nextseed * multiplier + addend) & mask) >>> 24);
                System.out.println("预测值：" + next_int / a0);
            }
            oldseed += 1;
        }

        System.out.println("实际值：" + random.nextFloat());
    }
}