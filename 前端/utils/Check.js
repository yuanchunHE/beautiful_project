const backAddress = getApp().globalData.url;
function Login(callback){
  wx.login({
    success: res => {
      wx.request({
        url: backAddress + '/user/onLogin/'+res.code,
        success: function (res) {
          let user = res.data.data;
          if (user.id){
            
            wx.setStorage({
              key:"Token",
              data:user.token,
            });
            console.log("Token " + user.token + " saved");
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
  console.log(token);
  if(!token){
    console.log("dont have token")
    Login(callback);
  }
  else{
    wx.request({
      url: backAddress + '/user/check/token/' + token,
      method: "GET",
      success: function (res) {
        console.log(res.data.data);
        if (res.data.data.id){
          callback(res.data.data);
        }
        else{
          Login(callback);
        }
      },
    })
  }
  
}

/*
checkByLogin(){
  
}*/
export {CheckByToken, Login}