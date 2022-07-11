// pages/orderdetail/orderdetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "order":"",
    "makeDate" : "0",
    "messInfo": "0",
    "placeDate" : "0",
    "proName" : "0",
    "techName" : "0",
    "userTell" : "0"
  },

  onLoad(options) {
    var that = this;
    //console.log(options);
    that.setData({
      
      "makeDate":options.makeDate,
      "messInfo":options.messInfo,
      "placeDate":options.placeDate,
      "proName":options.proName,
      "techName":options.techName,
      "userTell":options.userTell
    })
    
  },

})