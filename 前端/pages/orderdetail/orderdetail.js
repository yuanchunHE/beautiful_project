// pages/orderdetail/orderdetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "phoneNum" : "15892222603",
    "orders":[],
    "orderNum" : 0
  },

  onLoad(options) {
    var that = this;
    //console.log(options);
      
    wx.request({
      url: 'http://localhost:8080/order/app/order/'+this.data.phoneNum,
      method:"GET",
      success:function(res){
        that.setData({
          "orders":res.data.data,
          "orderNum":res.data.data.length
        })
      }
    })
  },

})