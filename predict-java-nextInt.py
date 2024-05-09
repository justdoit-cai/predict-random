"""
Random random = new Random();
random.setSeed(System.currentTimeMillis());
for (int i = 1; i <= 3; ++i) {
    System.out.println(random.nextInt());
}
python版本：根据前两次nextInt()的值获取下一个nextInt的值
"""
sequence = [-2037540693, -1544783484]

multiplier = 0x5DEECE66D
addend = 0xB
mask = (1 << 48) - 1


def d(n):  # 补码处理
    if bin(abs(n))[2:].zfill(32)[0] == '1':
        n = ((-n) ^ (0xffffffff)) + 1
    return n


oldseed = sequence[0] << 16
for i in range(0xffff):  # 暴力破解种子
    nextseed = (oldseed * multiplier + addend) & mask
    if d(nextseed >> 16) == sequence[1]:
        oldseed = nextseed
        break
    oldseed += 1
next_int = d(((oldseed * multiplier + addend) & mask) >> 16)

print(next_int)
