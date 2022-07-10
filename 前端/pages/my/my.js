// pages/my/my.js
import {CheckByToken} from "../../utils/Check";
Page({

  data: {
    "username":"username",
    "user":[],
  },

  onLoad(options) {
    var user = CheckByToken();
    this.setData({
      "user":user,
      "username":user.username,
    })
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


