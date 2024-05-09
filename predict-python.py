"""
根据624个random.getrandbits(32)的值来预测下一个random.random()或者random.randrange()的值
"""
import random, time
from randcrack import RandCrack

random.seed(time.time())

l = []
for i in range(624):
    l.append(random.getrandbits(32))

rc = RandCrack()
for i in l:
    rc.submit(i)

print("Random result: {}\nCracker result: {}".format(random.randrange(0, 4294967295),
                                                     rc.predict_randrange(0, 4294967295)))
print(random.random())
print(rc.predict_random())