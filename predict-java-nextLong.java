/**
java版本：根据一个nextLong()的值获取下一个nextLong()的值
nextLong()生成的随机数是第一个nextInt左移32位再加上第二个nextInt，所以预测nextLong()条件更加简单，只需要知道任意一个随机数即可预测后续的随机数，完全没有任何安全性。
需要注意的是，在进行破解时，可能存在多解的情况，所以可能有预测不成功的情况，多试几次就行了，预测成功的概率还是很大的
*/
import java.util.Random;
public class Demo01 {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    public static void main(String[] paramArrayOfString) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        long a1 = random.nextLong();
        int a = (int) (a1 >> 32);//取高32位
        int b = (int) (a1 & 0xffffffff);//取低32位
        long oldseed = ((long) a << 16);
        for (int i = 0; i <= 0xffff; i++) {//暴力破解种子
            long nextseed = (oldseed * multiplier + addend) & mask;
            if ((int) (nextseed >>> 16) == b) {
                oldseed = nextseed;
                break;
            }
            oldseed += 1;
        }
        long nextseed = (oldseed * multiplier + addend) & mask;
        int next_int = (int) (nextseed >>> 16);
        long nextseed2 = (nextseed * multiplier + addend) & mask;
        int next_int2 = (int) (nextseed2 >>> 16);
        long b2 = ((long) next_int << 32) + (long) next_int2;

        System.out.println(b2);
        System.out.println(random.nextLong());
    }
}