// pages/my/my.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "name": "张三",
    "enjoy": "喜欢5号技师",
    "type": [{
      "name": "李四",
      "sex": "男",
      "age": "18"
    },
    {
      "name": "如花",
      "sex": "女",
      "age": "18"
    }
    ]
  },

  /**
   * 页面初始化函数
   */
  onLoad(options) {

  },

  /**
   * 自定义函数
   */

  //点击事件
  toindex: function (options) {
    //console.log(options);
    var name = options.currentTarget.dataset.name;
    //console.log(name);
    wx.navigateTo({
      url: '/pages/order/order?name='+name,
    })
  },
})