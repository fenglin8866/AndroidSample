1、注解变量是否可以使用lateinit？ 是否可以使用val？
可以延时加载，但不能使用val，因为需要赋值操作

2、构造方法注入，怎么添加作用域？
类添加@xxxScope注解
猜想：绑定在添加的Scope对应的组件上，

3、注解@InstallIn修饰的元素

4、hilt的适用性：封装dagger使用于Android。核心是封装Android常用系统类。

5、作用域，Scope与InstallIn的关系，是否必须一致？
猜想：InstallIn是绑定的组件对象，获取实例默认是创建，使用Scope是限定范围，但不能超出绑定对象的范围。

6、module可以定义抽象类，将接口和实例放在一起。


========
一个类有多个构造方法时，注意依赖注入项的区分。
===================================================================
dagger1应用：
示例：https://developer.android.google.cn/codelabs/android-dagger#0

github：https://github.com/android/codelab-android-dagger/tree/main



架构蓝图
github：https://github.com/android/architecture-samples/tree/dev-dagger



