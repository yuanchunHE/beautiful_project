// pages/my/my.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "username":"username",
  },

  /**
   * 页面初始化函数
   */
  onLoad(options) {

  },

  /**
   * 自定义函数
   */
  viewUserDetail:function(options){
    //console.log(options);
    // var id = options.currentTarget.dataset.id;
    var username = options.currentTarget.dataset.username;
    wx.navigateTo({
      url: '/pages/userdetail/userdetail?username='+username,
    })
  },

  viewUserWallet:function(options){
    wx.navigateTo({
      url: '/pages/userwallet/userwallet',
    })
  }
})


