"""
pip install mersenne-twister-predictor
预测random.getrandbits(32)
根据前624个随机数来预测第625个随机数
这里的随机数长度必须是32的倍数才可以预测
"""
from mt19937predictor import MT19937Predictor
import random, time

random.seed(time.time())

predictor = MT19937Predictor()

l = []
for i in range(624):
    l.append(random.getrandbits(32))

for i in l:
    predictor.setrandbits(i, 32)

# 预测值
print(str(predictor.getrandbits(32)))

# 实际值
print(random.getrandbits(32))
