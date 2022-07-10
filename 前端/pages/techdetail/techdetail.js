// pages/techdetail/techdetail.js
const backAddress = getApp().globalData.url;
import {GetImgAddress} from "../../utils/Image";
Page({

  data: {
    "technician":"",
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
      url: backAddress + '/technician/tech/' + techname,
      method:"GET",
      success:function(res){
        //todo 修改为不要数组的
        GetImgAddress(res.data.data[0]);
        that.setData({
          "technician": res.data.data[0],
        });
        wx.request({
          url: backAddress + '/tecpro/tech/'+res.data.data[0].id,
          success:function(res){
            GetImgAddress(res.data.data);
            that.setData({
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