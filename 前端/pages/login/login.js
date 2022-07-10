// index.js
// 获取应用实例
const backAddress = getApp().globalData.url;
import {CheckByToken} from "../../utils/Check";

Page({
  //属性
  data: {
    notHasRequired: true,
    phoneNumber : ''
  },

  onLoad(options) {
    var that = this;
    CheckByToken(
      function(user){
        console.log(user.id);
        if (!user.phone){
          console.log("dont have phone")
        }
        else{
          this.data.notHasRequired = false;
          console.log("have phone")
        }
      });
  },
  bindPhoneInput(e){
    let phoneNum = e.detail.value;
    //todo 检测是否为手机
    this.setData({
      phoneNumber: phoneNum
    })
  },
  clear(){
    this.setData({
      phoneNumber: ''
    })
  },
  yes(){
    let token = wx.getStorageSync('Token');
    wx.request({
      //todo setPhone
      url: backAddress + 'user/setPhone/' + token + this.data.phoneNumber,
      success:function(res){
        //todo 页面跳转
        console.log(res);
      }
    })
  }

})
