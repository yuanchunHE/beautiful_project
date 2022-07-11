// index.js
// 获取应用实例
const backAddress = getApp().globalData.url;
import {CheckByToken} from "../../utils/Check";
//import {updateUser} from "../../utils/Update";

Page({
  //属性
  data: {
  },

  onLoad(options) {
    var that = this;
    CheckByToken(
      function(user){
        if (!user.phone){
          console.log("dont have phone")
          wx.navigateTo({
            url: '/pages/userdetail/userdetail',
          })
        }
        else{
          console.log("have phone")
          wx.switchTab({
            url: '/pages/index/index',
          })
        }
      });
  },/*
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
    let userdata = {
      phone:this.data.phoneNumber,
    } 
    updateUser(userdata,
      function(resdata){
        wx.navigateTo({
          url: '/pages/index/index',
        })
    });
  }
*/
})
