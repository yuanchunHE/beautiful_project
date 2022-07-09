// pages/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "busname": "",
    "proname": "",
    "image": "",
    "date": "2022-07-09",
    "time": "12:11"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this;
    //console.log(options);
    var image = options.image;
    var proname = options.proname;
    var pid = options.pid;

    wx.request({
      url: 'http://localhost:8080/business/app/busname/' + pid,
      method: "GET",

      success: function (res) {
        //console.log(res);
        that.setData({
          "busname": res.data.data,
          "image": image,
          "proname": proname
        })

      }
    })

  },

  //自定义方法:

  bindDateChange: function (options) {
    //console.log(options);
    this.setData({
      "date": options.detail.value,
    })
  },
  bindTimeChange: function (options) {
    this.setData({
      "time": options.detail.value,
    })
  },
  formSubmit: function (options) {
    var that = this;
    //console.log(options);
    wx.request({
      url: 'http://localhost:8080/order/app/order',
      method: "POST",
      data: {
        "proname": that.data.proname,
        "makedate": that.data.date + ' ' + that.data.time,
        "username": options.detail.value.username,
        "usertell": options.detail.value.usertell,
        "information": options.detail.value.information,
      },
      success:function(res){
        wx.switchTab({
          url: '/pages/index/index',
        })
      }
    })
  }

})