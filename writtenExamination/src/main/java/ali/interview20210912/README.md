##### 2021.09.12 阿里二面 面试官全方位吊打

自我介绍

项目

讲讲hashmap

hashmap的扩容方面对我们的程序会有什么影响，怎么处理呢，平时用的话会给它赋初始值吗

讲一讲线程生命周期，block状态和waiting状态有什么区别，或者说这两种都是等待，为什么还需要设计成这两种呢

从cpu调度角度来看，block和wait对它的执行性能会有什么影响。比如我们在高并发情况下，必然少不了block，它会带来什么样的副作用呢，我们怎么样来尽可能减少block

上面怎么减少block回答了1.切换上下文。2.协程。 3.锁升级。 那来讲讲锁升级

讲讲为什么CAS效率高

总结下什么情况下选择什么样的锁，也就是使用场景，或者说为什么有这些不一样的设计（提示：IO密集型计算和CPU密集型计算）  

讲讲classloader，部署。或者说，spring里面不是有容器吗，spring和springMVC两个容器的隔离是怎么做到的（没具体研究过）

讲讲你学习过程中有没有仔细研究过某一个原理，你深度了解之后尝试着自己去实现它

中间件了解过没有

redis相关的一点东西，比如雪崩、击穿怎么解决，你可能看了书上的理论，但是自己没有去实现
