# hello_github(我的个人博客)
这个博客，是根据我之前实践的一个SSM项目修改使用SpringBoot框架Mybatis数据框架编写的个人博客。时间仓促，总共编写时间大概10天，部分功能没有完善。  
## 这个博客主要的展现与功能  
1、概括显示的有文章的标题，标题下面是几行内容的简介，以及发布的时间和文章封面图片(尚未完成)。  
2、页面拥有实时更新的文章幻灯片，根据热度进行特推到首页的幻灯片，仅有5个名额，选取最热的文章推给浏览博客的用户。  
3、下面根据发布时间又新到旧进行排序，使用户持续拥有新的文章进行阅读。  
4、新添加了UE编辑器，大大更新了用户阅读文章的阅读体验，给用户一种美好的视觉冲击，让用户可以愉悦且清晰的阅读完他所需要的文章。  
5、文章详情页面拥有基本的标题以及文章一行的简介，和文章详细的全部内容以及发布时间，因为采用了UE编辑器的样式以及标签，阅读起来格外的清晰。  
6、删除文章(目前仅完成了点击删除，没有加上验证，后期会加上，防止用户不小心甚至恶意删除优秀文章)。  
7、拥有文章评论，但是没有登陆与删除功能，主要因为，如果必须登陆才可以拥有评论权限的话，会打击用户对文章的评论心态，进而可能失去优秀的文章评论。采用了邮箱发送给用户授权码的功能，有效防止了用户刻意刷取用户评论。至于登陆与注册这一块，如果以后需要保护的文件或者资料，会立即添加登陆和注册功能。  
8、至于发布文章这一块信息安全方面，由于没有登陆和注册，所以没有进行管辖，这一块是这个网站的漏洞，后期会补上。UE编辑器发布文章新增加了图片上传的功能，图片上传到本地，获取本地图片的地址进行显示。  
  
有什么好的意见，欢迎大家进行提议。这也是我学习的动力与方向。  


## 这几天更新的内容  
2019-2-27 11:37====================  
1、添加了admin管理页面(显示文章、删除文章)  
2、删除了用户文章阅读页面的删除文章操作  
3、添加了单独的AdminCtronller类对admin管理页面进行相关操作  
  
2019-2-27 19:39===================  
1、新增数据库admin表(adminname,adminpass,login_time)  
2、添加了admin管理员的login登陆页面  
3、对AdminController类添加了登陆管理员登陆功能  
4、对admin页面新添加了判断非法访问  
5、显示管理员头像和账号  
6、增加登陆自定义div提示  
7、增加管理员个人信息页面，管理员数据的获取  
  
  
2019-2-28  9:42=========================  
1、添加管理员除了账号其它信息的修改功能  
2、用户页面新添加了搜索关键字功能  
3、管理员页面新添加了搜索关键字功能  
4、帖子页面新加浏览次数   
  
2019-3-5  10：47=======================  
1、增加了音乐解析页面，调用API进行音乐解析(不过直接下载功能需要完善没有想到什么好办法)，使用Jsoup爬src，会直接反回来无限的乱码，我也不知道什么原因。     
2019-3-7    10:23=========================
1、更新了音乐下载的功能，使用HttpClient=======
  
### 希望有大佬可以帮助解决一波~ (Hope you can work it out and tell us the solution.)
    I call the API of music parsing. Get the address of the audio file, and use Jsoup to get the page source code. Printing out the    source code will be messy and very card. Enter the address of the audio file, and the audio file will be parsed and played directly by   the browser. What shall I do? I want to download this audio file by clicking the button. (The page of this audio file is someone else's)  

Not on my server. Thank you.(已经解决)

## 项目截图:  
![imge](https://github.com/wyf2215087636/myBlog/blob/master/img/1.png)  
![imge](https://github.com/wyf2215087636/myBlog/blob/master/img/2.png)  
![imge](https://github.com/wyf2215087636/myBlog/blob/master/img/3.png)  
![imge](https://github.com/wyf2215087636/myBlog/blob/master/img/4.png)  
![imge](https://github.com/wyf2215087636/myBlog/blob/master/img/5.png)  
![imge](https://github.com/wyf2215087636/hello_github/blob/master/项目截图/6.png)  
![imge](https://github.com/wyf2215087636/myBlog/blob/master/img/7.png)  
