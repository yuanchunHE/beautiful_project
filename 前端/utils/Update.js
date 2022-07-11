const backAddress = getApp().globalData.url;
function updateUser(user, callback){
  let token = wx.getStorageSync('Token');
  console.log(token);
  wx.request({
    url: backAddress + '/user'+'/updateUser/' + token + '/' + 
      user.nickname + '/' + user.imageurl + '/' + user.username + '/' + 
      user.phone + '/' + user.password + '/' +  'null',
    success:function(res){
      //console.log(res.data.data);
      callback(res.data.data);
    }
  })
}

export{updateUser}