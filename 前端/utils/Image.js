const backAddress = getApp().globalData.url;
function GetImgAddress(datas){
  if (Object.prototype.toString.call(datas) === '[object Array]'){
    for (let i=0;i< datas.length;i++){
      datas[i].imageurl = backAddress + '/images/' + datas[i].imageurl;
    } 
  }
  else{
    datas.imageurl = backAddress + '/images/' + datas.imageurl;
  }
}

export{GetImgAddress}