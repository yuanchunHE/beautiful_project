// pages/techdetail/techdetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "techInfo":[],
    "techPro":[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    //console.log(options);
    var that = this;
    var techname = options.name;

    wx.request({
      url: 'http://localhost:8080/technician/tech/'+techname,
      method:"GET",
      success:function(res){
        //console.log(res);
        var that2 = that;
        var techId = res.data.data[0].id;
        that.setData({
          "techInfo":res.data.data[0],
        })
        wx.request({
          url: 'http://localhost:8080//tecpro/techpro/'+techId,
          success:function(res){
            //console.log(res);
            that2.setData({
              "techPro":res.data.data,
            })
          }
        })
      }
    })

  },
})