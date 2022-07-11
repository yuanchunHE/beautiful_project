const backAddress = getApp().globalData.url;
function updateUser(user, callback){
  let token = wx.getStorageSync('Token');
  wx.request({
    url: backAddress + '/user'+'/updateUser/' + token + '/' + 
      user.nickname + '/' + user.imageurl + '/' + user.username + '/' + 
      user.phone + '/' + user.password + '/' +  'null',
    success:function(res){
      callback(res.data.data);
    }
  })
}

export{updateUser}