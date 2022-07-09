// index.js
// 获取应用实例

Page({
  //属性
  data: {
    "banner": [],
    "nav": [],
    "sub": []
  },

  //初始化方法
  onLoad(options) {
    var that = this;
    //ajak
    wx.request({
      url: 'http://localhost:8080/image/banner',
      method: "GET",
      success: function (res) {
        //console.log(res);
        that.setData({
          "banner": res.data.data
        })
      }
    })
    wx.request({
      url: 'http://localhost:8080/image/nav',
      method: "GET",
      success: function (res) {
        //console.log(res);
        that.setData({
          "nav": res.data.data
        })
      }
    })
    wx.request({
      url: 'http://localhost:8080/project/pro/推荐',
      method: "GET",
      success: function (res) {
        //console.log(res);
        that.setData({
          "sub": res.data.data
        })
      }
    })
  },

  //自定义方法
  //中部导航栏的跳转
  navpro: function (options) {
    //console.log(options);
    var that = this;
    var navname = options.currentTarget.dataset.name;
    //console.log(name);
    wx.request({
      url: 'http://localhost:8080/project/pro/' + navname,
      method: "GET",
      success: function (res) {
        //console.log(res);
        that.setData({
          "sub": res.data.data
        })
      }
    })
  },

  //跳转至详情页面
  todetail: function (options) {

    //console.log(options);
    var id = options.currentTarget.dataset.id;
    var img = options.currentTarget.dataset.img;
    wx.navigateTo({
      url: '/pages/detail/detail?id=' + id + '&img=' + img,
    })
  },

  toOrder:function(options){
    //console.log(options);
    var image = options.currentTarget.dataset.img;
    var proname = options.currentTarget.dataset.proname;
    var id = options.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/order/order?image='+image+'&proname='+proname+'&pid='+id,
    })
  },
})
