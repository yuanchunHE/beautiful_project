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
    "busid": "",
    "techlist": ["小乔","大乔","小貂禅"],
    "index": 0,
    "techname":"",
    "flag":0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this;
    //console.log(options);
    var image = options.image;
    var proname = options.proname;
    var pid = options.proid;
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
    }),
    wx.request({
      url: 'http://localhost:8080/tecpro/techpro/'+pid,
      method:"GET",

      success: function (res){
        //console.log(res);
        that.setData({
          "techlist":res.data.data,
        })
      }
    }),
    wx.request({
      url: 'http://localhost:8080/technician/techid/'+tecid,
      method:"GET",
      success:function(res){
        console.log(res);
        that.setData({
          "techname":res.data.data[0].techname,
          "flag":1,
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
    //console.log(that.data);
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
  },
  bindPickerChange: function(e) {
    //console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
  },

})