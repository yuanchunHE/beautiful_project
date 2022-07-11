// pages/userdetail/userdetail.js
const backAddress = getApp().globalData.url;
import {CheckByToken} from "../../utils/Check";
Page({

  data: {
    user:""
  },

  onLoad(options) {
    var that = this;
    CheckByToken(function(resdata){
      that.setData({
        user:resdata
      })
    })
  },

})