# Whale

## 实现的功能
- [x] 根据要测试的站点切换相对于的站点和语言
- [x] Page Object设计模式

- 运行测试
```
mvn test -D site=hk
```

- Appium inspector
```json
{
  "platformName": "Android",
  "deviceName": "MuMu",
  "appPackage": "com.zzkko",
  "appActivity": "com.zzkko.bussiness.login.ui.WelcomeActivity",
  "noReset": true
}
```

[站点配置](http://wiki.dotfashion.cn/pages/viewpage.action?pageId=22147546)

### 货到付款(COD模块)

### 用户模块
- [ ] 修改信息
- [ ] 查看收藏
- [ ] 常见问题
- [ ] 查看历史
- [ ] 修改货币

### 商品模块

### 购物车模块
- [x] 添加到购物袋

### 设置模块
- [ ] 修改货币
- [ ] 修改密码
- [ ] 反馈

### 订单模块
- [ ] 取消订单
- [ ] 删除订单
- [ ] 支付订单

### 地址模块
- [x] 添加收货地址
- [ ] 判断要添加地址的地区

### 钱包模块

### 优惠活动