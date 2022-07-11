// pages/myreservation/myorders.js
const backAddress = getApp().globalData.url;
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
      
    wx.request({
      url: backAddress + '/order/app/order/'+this.data.phoneNum,
      method:"GET",
      success:function(res){
        that.setData({
          "orders":res.data.data,
          "orderNum":res.data.data.length
        })
      }
    })
  },

  toOrderDetail:function(options){
    console.log(options.currentTarget);
    var info1 = options.currentTarget.dataset.placedate;
    var info2 = options.currentTarget.dataset.makedate;
    var info3 = options.currentTarget.dataset.proname;
    var info4 = options.currentTarget.dataset.techname;
    var info5 = options.currentTarget.dataset.usertell;
    var info6 = options.currentTarget.dataset.info;

    wx.navigateTo({
      url: '/pages/orderdetail/orderdetail?placeDate='+info1+'&makeDate='+info2+'&proName='+info3+'&techName='+info4+'&userTell='+info5+'&messInfo=info'+info6
    })
  },
  
})