eoeGeekCamp-201312
==================

2013年12月极客训练营

## 配置学习环境流程

我们这里讲解如何在自己的计算机上配置自己的学习环境


### 1. fork 自己的代码库

1.1 打开 github，登录自己的帐号

https://github.com/

1.2 打开如下链接

https://github.com/eoeSchool/eoeGeekCamp-201312

fork 这个项目为自己的项目，得到地址，例如
https://github.com/IceskYsl/eoeGeekCamp-201312

### 2. 本地操作

2.1 创建学习用的文件夹

在自己电脑的 D 盘下创建一个名字为『eoeschool』的文件夹，用来存放我们的代码和教案文档，参考资料等

2.2 创建存放代码的目录

在『eoeschool』下创建一个存放学习代码的文件夹叫『sources』，存放文档和教案用的文件夹『docs』

2.3 clone 代码到本地

在『sources』目录下，鼠标右键选择『Git Bash Here』，进入命令行输入
```
git clone git@github.com:iceskysl/eoeGeekCamp-201312.git (注意：这个地方用你自己的git库地址，不要用我的！！)
```

2.4 创建自己的文件夹

进入 clone 下来的目录『eoeGeekCamp-201312』，创建自己的文件夹（用英文 ID 命名），比如 iceskysl


### 3. 设置 ADT 环境

3.1 创建 ADT 的工作空间

打开ADT，重新创建一个工作空间（workspace），选择位置到上面一步创建的自己的目录
（只做这一次，在学习期间不要更改自己的工作空间）

3.2 在 ADT 创建一个自己的项目『HelloIceskysl』

（每个例子或者项目都可以创建一个新的项目）


### 4. 提交代码到 git 仓库和 github

4.1 提交代码到本地git 仓库

回到前面的『Git Bash Here』窗口，进入『eoeGeekCamp-201312』文件夹，按如下步骤提交代码到本地git 仓库
```
git status
git add .
git commit -m "add HelloIceskysl project"
```

（每做完一个项目的一个 task就执行一下这个步骤）

4.2 提交到 github中

```
git push origin master
```
（每做完一个项目就执行一次）

4.3 推送到eoeschool 主仓库

（每天学习完成执行一次）

以后每天都重复上面的3和4的步骤就可以了~
另外，切记，只提交代码，不要提交文档，压缩包等大文件~

4.4