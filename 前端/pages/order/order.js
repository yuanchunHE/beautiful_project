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
    "time": "12:11",
    "proid": "",
    "tecid": "",
    "busid": ""
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
    var tecid = options.tecid;
    var busid = options.busid;
    wx.request({
      url: 'http://localhost:8080/business/app/busname/' + pid,
      method: "GET",

      success: function (res) {
        //console.log(res);
        that.setData({
          "busname": res.data.data,
          "image": image,
          "proname": proname,
          "proid": pid,
          "tecid": tecid,
          "busid": busid,
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
    console.log(that.data);
    wx.request({
      url: 'http://localhost:8080/order/app/order',
      method: "POST",
      data: {
        "busid": that.data.busid,
        "information": options.detail.value.information,
        "makedate": that.data.date + ' ' + that.data.time,
        "proid": that.data.proid,
        "proname": that.data.proname,
        "tecid": that.data.tecid,
        "username": options.detail.value.username,
        "usertell": options.detail.value.usertell
      },
      success:function(res){
        wx.switchTab({
          url: '/pages/index/index',
        })
      }
    })
  }

})