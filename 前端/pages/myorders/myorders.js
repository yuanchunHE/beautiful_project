// pages/myorders/myorders.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "phoneNum" : "15892222603",
    "orders":[],
    "orderNum" : 0,
    "username":"username",
  },

  onLoad(options) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/order/app/order/'+this.data.phoneNum,
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