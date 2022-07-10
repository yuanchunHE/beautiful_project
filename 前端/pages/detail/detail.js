// pages/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "proInfo":[],
    "image":""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    var that = this;
    var pid = options.id;
    console.log(options);
    
    wx.request({
      url: 'http://localhost:8080/project/detail/'+pid,
      method:"GET",
      success:function(res){
        //console.log(res);
        that.setData({
          "proInfo":res.data.data,
        })
      }
    })

  },

  toOrder:function(options){
    //console.log(options);
    var image = options.currentTarget.dataset.img;
    var proname = options.currentTarget.dataset.proname;
    var busid = options.currentTarget.dataset.busid;
    var tecid = options.currentTarget.dataset.tecid;
    var proid = options.currentTarget.dataset.id;

    wx.navigateTo({
      url: '/pages/order/order?image='+image+'&proname='+proname+'&busid='+busid+'&tecid='+tecid+'&proid='+proid,
    })
  },

})