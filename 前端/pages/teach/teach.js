// pages/teach/teach.js
const backAddress = getApp().globalData.url;
import {GetImgAddress} from "../../utils/Image";
Page({
  data: {
    "sub": [],
  },

  onLoad(options) {
    var that = this;
    wx.request({
      url: backAddress + '/technician/tech/全部',
      method:"GET",
      success:function(res){
        GetImgAddress(res.data.data);
        that.setData({
          "sub":res.data.data
        })
      }
    })
  },

  totechdetail:function(options){
    //console.log(options);
    var name = options.currentTarget.dataset.techname;
    var busid = options.currentTarget.dataset.busid;
    var imageurl = options.currentTarget.dataset.imageurl;

    wx.navigateTo({
      url: '/pages/techdetail/techdetail?name='+name+'&busid='+busid+'&imageurl='+imageurl,
    })
  },
})