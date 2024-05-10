# 介绍
记录不同语言生成随机数的方法的预测脚本。

注意在预测 `java` 的随机数生成方法时可能存在多解的情况，但是遇到此情况概率不大，如果利用的时候发现没预测成功多试几次就行了。还有 `java` 中 `nextBoolean()` 是无法预测的。

`php` 中 `mt_rand()` 生成的随机数可以采用 http://www.openwall.com/php_mt_seed 爆破种子来预测。

# 参考文章

```
# js
https://blog.csdn.net/qq_45894840/article/details/127910796
# python
https://blog.csdn.net/qq_42557115/article/details/128228201
# java
https://zgjx6.github.io/2019/06/11/Java%20Random%E5%AE%89%E5%85%A8%E6%80%A7%E5%88%86%E6%9E%90/
https://xz.aliyun.com/t/5284
# php
https://blog.csdn.net/qq_45521281/article/details/107302795
```