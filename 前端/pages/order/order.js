// pages/order/order.js
//todo!!
const backAddress = getApp().globalData.url;

Page({

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
    "flag": 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this;
    console.log(options);
    var image = options.image;
    var proname = options.proname;
    var pid = options.proid;
    var busid = options.busid;
    this.setData({
      "image": image,
      "proname": proname,
      "busid": busid,
    })
    //console.log();
    if (options.tecid=="null"){
      var tecid = "1";
    }else{
      var tecid = options.tecid;
      that.setData({
        "flag":1,
      })
    }

    wx.request({
      url: backAddress + '/business/app/busname/' + pid,
      method: "GET",

      success: function (res) {
        //console.log(res);
        that.setData({
          "busname": res.data.data,
        })

      }
    }),
    wx.request({
      url: backAddress + '/tecpro/techpro/'+pid,
      method:"GET",

      success: function (res){
        that.setData({
          "techlist":res.data.data,
        })
      }
    }),
    wx.request({
      url: backAddress + '/technician/techid/' + tecid,
      method:"GET",
      success:function(res){
        //console.log(res);
        that.setData({
          "techname":res.data.data[0].techname,
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
      url: backAddress + '/order/app/order',
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