// pages/my/my.js
const backAddress = getApp().globalData.url;
import {GetImgAddress} from "../../utils/Image";
    //todo getuserName and getHeader
Page({
  data: {
    "username"  : "username",
    "userHeader": ""
  },
  onLoad(options) {
    //call getuserName and getHeader
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
  },
  viewUserOrders:function(options){
    wx.navigateTo({
      url: '/pages/myorders/myorders',
    })
  }
})


