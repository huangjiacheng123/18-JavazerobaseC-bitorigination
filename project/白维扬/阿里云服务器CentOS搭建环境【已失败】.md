# 阿里云服务器CentOS搭建环境【已失败】

  1. 服务器安装git
  2. 安装java环境【跟macos相似】
  3. jenkins官网安装，官方有centos安装命令【如果启动jenkins的时候报错，看一下错误信息，可能是java路径有问题】。jenkins后面配置过程在自己电脑上用ip:port进行访问，然后在页面进行配置
  4. phpstudy安装，官方一样有命令，直接复制粘贴就行。在本机用浏览器打开网页进行配置。
  5. phpstudy的文件夹下面放入我们网站项目，最好改一下权限，最好777。
  6. phpstudy相当于一个代理服务器，现在我们之前安好的jenkins的页面应该已经打不开了，在phpstudy的面板打开端口，放行，或者关闭防火墙【不建议。
  7. 安装火狐浏览器，也是一行命令的事情，但是最好安装一个可视化界面，我安装了但是用不了，可能是服务器禁止了？

**「java环境要求可以命令行输入  javac   能有反应，有的教程安装完环境不行」**

**最后这一步最为致命，可能是我配置的有问题，没有办法执行我们的UI自动化测试，无奈只能将服务器重置系统镜像为windows 2012R2。然后转交给刘畅继续搭建。**

**PS：阿里云禁用了25端口【stmp端口】，这里是一个坑，需要自己手动改javamail的端口。**

