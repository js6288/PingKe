# PingKe

## 项目简介
PingKe是本人大学生创新创业训练作品，在大学生创新创业训练项目中获得
校级立项，原为大学生拼单平台，后改为为大学生和老师制作思政宣传海报、PPT、
光盘等的平台。

## 主要模块与功能
- 包括前台主页、我的项目、发起项目、客服咨询，后台管理系统等模块
- 基于Spring Boot构建的单体项目
- 使用Spring Security和JWT实现登录和权限控制
- 使用WebSocket实现客服单聊功能
- 使用Redis存储聊天记录
- 使用quartz定时将redis中的数据定时写入MySQL
- 使用docker部署，nginx反向代理后端接口
- 文件管理：Aliyun OSS 签名直传 

## 技术栈
- 前端：Vue、Element UI
- 后端：Spring Boot、Mybatis-plus、Lombok 、MySQL、Redis、Spring Securit
y、JWT 、quartz、Websocket、Docker
