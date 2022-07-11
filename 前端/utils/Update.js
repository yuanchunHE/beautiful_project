const backAddress = getApp().globalData.url;
function updateUser(user, callback){
  let token = wx.getStorageSync('Token');
  console.log(token);
  wx.request({
    url: backAddress + '/updateUser/' + token + '/' + 
      user.nickname + '/' + user.imageurl + '/' + user.username + '/' + 
      user.phone + '/' + user.password + '/' +  user.sysToken,
    success:function(res){
      console.log(res.data.data);
      callback(res.data.data);
    }
  })
}

export{updateUser}