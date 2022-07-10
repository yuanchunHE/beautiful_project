// pages/teach/teach.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "sub": [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this;

    wx.request({
      url: 'http://localhost:8080/technician/tech/全部',
      method:"GET",
      success:function(res){
        //console.log(res);

        that.setData({
          "sub":res.data.data
        })
      }
    })
  },

  totechdetail:function(options){
    //console.log(options);
    var name = options.currentTarget.dataset.name;

    wx.navigateTo({
      url: '/pages/techdetail/techdetail?name='+name,
    })
  },
})