// pages/techdetail/techdetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "techname":"",
    "busid":"",
    "imageurl":"",
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
    var imageurl = options.imageurl;
    var busid = options.busid;

    wx.request({
      url: 'http://localhost:8080/technician/tech/'+techname,
      method:"GET",
      success:function(res){
        //console.log(res);
        var that2 = that;
        var techId = res.data.data[0].id;
        that.setData({
          "techInfo":res.data.data[0],
          "imageurl":imageurl,
        })
        wx.request({
          url: 'http://localhost:8080/tecpro/tech/'+techId,
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

  toOrder:function(options){
    //console.log(options);
    var image = options.currentTarget.dataset.img;
    var proname = options.currentTarget.dataset.proname;
    var proid = options.currentTarget.dataset.id;
    var tecid = options.currentTarget.dataset.tecid;

    wx.navigateTo({
      url: '/pages/order/order?image='+image+'&proname='+proname+'&proid='+proid+'&tecid='+tecid+'&proid='+proid,
    })
  },
})