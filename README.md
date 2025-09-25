# Supermarket Manage Server
基于 Spring Boot + MyBatis-Plus 的超市后台管理系统 API 服务

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.x-6DB33F?logo=springboot)](https://spring.io/projects/spring-boot)
[![MyBatis-Plus](https://img.shields.io/badge/MyBatis--Plus-3.5.x-FF5722?logo=MyBatis)](https://baomidou.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![JDK](https://img.shields.io/badge/JDK-17+-green.svg)](https://openjdk.org/)

---

## 🧭 项目简介
supermarket-manage-server 是“超市进销存+权限管理”一体化后台，提供商品、分类、订单、库存、用户、角色、菜单等完整 REST 接口，可直接对接 Vue2/3 或小程序前端。

**技术栈**
- 主框架：Spring Boot 3.0.x
- 数据层：MyBatis-Plus + MySQL 9.1
- 文档：SpringDoc
- 工具：Lombok
- 部署：Docker + Maven 多环境配置（dev/test/prod）

---

## 📦 快速开始
### 1. 克隆代码
```bash
git clone https://github.com/HuangYuan1024/supermarket-manage-server.git
cd supermarket-manage-server
