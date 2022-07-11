// index.js
// 获取应用实例
const backAddress = getApp().globalData.url;
import { GetImgAddress } from "../../utils/Image";

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
      url: backAddress + '/image/banner',
      method: "GET",
      success: function (res) {
        GetImgAddress(res.data.data);
        that.setData({
          "banner": res.data.data
        })
      }
    })
    wx.request({
      url: backAddress + '/image/nav',
      method: "GET",
      success: function (res) {
        GetImgAddress(res.data.data);
        that.setData({
          "nav": res.data.data
        })
      }
    })
    wx.request({
      url: backAddress + '/project/pro/推荐',
      method: "GET",
      success: function (res) {
        GetImgAddress(res.data.data);
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
      url: backAddress + '/project/pro/' + navname,
      method: "GET",
      success: function (res) {
        GetImgAddress(res.data.data);
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

  toOrder: function (options) {
    //console.log(options);
    var image = options.currentTarget.dataset.img;
    var proname = options.currentTarget.dataset.proname;
    var busid = options.currentTarget.dataset.busid;
    var tecid = options.currentTarget.dataset.tecid;
    var proid = options.currentTarget.dataset.id;

    wx.navigateTo({
      url: '/pages/order/order?image=' + image + '&proname=' + proname + '&busid=' + busid + '&tecid=' + tecid + '&proid=' + proid,
    })
  },

})
