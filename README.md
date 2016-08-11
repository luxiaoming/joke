# joke
一个笑话app


![](http://upload-images.jianshu.io/upload_images/1603789-9b84fe9e340099fb?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


基于  Dagger2 + RxJava + Retrofit + Material Design + MVVM  的一个笑话app

先看效果：
![](http://upload-images.jianshu.io/upload_images/1603789-ce2023d975c78a3c?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

时序图：

![](http://upload-images.jianshu.io/upload_images/1603789-28210588c35aeab1?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

基本是一个MVVM的演示app，代码不太标准，自己过滤阅读了。

***其中里面资源：***

笑话从百度api拿到
妹子图从干货集中营获取

**MVVM 优势**：将**findviewbyid**直接去掉了，并且将回调等等逻辑都可以推出去，直接效果是**View**里面很干净，只需要初始化一下即可。其余的核心都是有**View****Model**的通知数据改变，然后在数据绑定里面自动实现了界面更新。

 代码地址

https://github.com/luxiaoming/joke

界面绘图使用：

http://echoma.github.io/text_sequence_diagram/

![](http://upload-images.jianshu.io/upload_images/1603789-e8f0c5782013c8db?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
