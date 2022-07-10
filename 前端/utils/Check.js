const backAddress = getApp().globalData.url;
function Login(callback){
  wx.login({
    success: res => {
      console.log("log Success");
      wx.request({
        url: backAddress + '/user/onLogin/'+res.code,
        success: function (res) {
          let user = res.data.data;
          if (user.id){
            console.log("Token " + user.token + " saved");
            wx.setStorageSync({
              key:"Token",
              data:user.token,
            })
          }
          else{
            console.log("failed");
          }
          callback(user);
        },
      });
    }
  });  
}

function CheckByToken(callback){
  let token = wx.getStorageSync('Token');
  if(!token){
    console.log("dont have token")
    Login(callback);
  }
  else{
    wx.request({
      url: backAddress + '/user/check/token/' + token,
      method: "GET",
      success: function (res) {
        if (res.data.data.id){
          callback(res.data.data);
        }
      },
    })
  }
  
}

/*
checkByLogin(){
  
}*/
export {CheckByToken, Login}