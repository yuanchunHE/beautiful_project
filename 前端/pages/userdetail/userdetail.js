// pages/userdetail/userdetail.js
const backAddress = getApp().globalData.url;
import {CheckByToken} from "../../utils/Check";
import {updateUser} from "../../utils/Update"
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
  inputPhone: function (e) {
    let nuser = this.data.user;
    nuser.phone = e.detail.value;
    this.setData({
      user: nuser
    });
  },
  inputNickname: function (e) {
    let nuser = this.data.user;
    nuser.nickname = e.detail.value;
    this.setData({
      user: nuser
    });
  },
  onDefaultButtonClick(){
    var userinfo = this.data.user
    updateUser(userinfo,function(res){
      //console.log(res);
    });
    wx.navigateTo({
      url: '/pages/login/login',
    });
  }

})