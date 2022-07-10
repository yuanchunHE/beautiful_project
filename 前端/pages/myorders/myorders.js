// pages/myorders/myorders.js
const backAddress = getApp().globalData.url;
import {GetImgAddress} from "../../utils/Image";

Page({
  data: {
    "phoneNum" : "15892222603",
    "orders":[],
    "orderNum" : 0,
    "username":"username",
    "userHeader": ""
  },

  onLoad(options) {
    var that = this;
    wx.request({
      url: backAddress + '/order/app/order/'+this.data.phoneNum,
      method:"GET",
      success:function(res){
        console.log(res);
        that.setData({
          "orders":res.data.data,
          "orderNum":res.data.data.length
        })
      }
    })
  },
  toOrderDetail:function(options){
    //console.log(options);
    var usertell = options.currentTarget.dataset.usertell;
    wx.navigateTo({
      url: '/pages/orderdetail/orderdetail?usertell='+usertell,
    })
  },

})