export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"研究生","menuJump":"列表","tableName":"yanjiusheng"}],"menu":"研究生管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"导师","menuJump":"列表","tableName":"daoshi"}],"menu":"导师管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"导师信息","menuJump":"列表","tableName":"daoshixinxi"}],"menu":"导师信息管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"课程分类","menuJump":"列表","tableName":"kechengfenlei"}],"menu":"课程分类管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除"],"menu":"课程信息","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改","删除"],"menu":"选课报名","menuJump":"列表","tableName":"xuankebaoming"}],"menu":"选课报名管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"考级级别","menuJump":"列表","tableName":"kaojijibie"}],"menu":"考级级别管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"考级信息","menuJump":"列表","tableName":"kaojixinxi"}],"menu":"考级信息管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","修改","删除"],"menu":"考级报名","menuJump":"列表","tableName":"kaojibaoming"}],"menu":"考级报名管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"学籍信息","menuJump":"列表","tableName":"xuejixinxi"}],"menu":"学籍信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"学位","menuJump":"列表","tableName":"xuewei"}],"menu":"学位管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","修改","删除","审核"],"menu":"学位申请","menuJump":"列表","tableName":"xueweishenqing"}],"menu":"学位申请管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","修改","删除"],"menu":"成绩信息","menuJump":"列表","tableName":"chengjixinxi"}],"menu":"成绩信息管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","修改","删除"],"menu":"教务信息","menuJump":"列表","tableName":"jiaowuxinxi"}],"menu":"教务信息管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"学费缴纳","menuJump":"列表","tableName":"xuefeijiaona"}],"menu":"学费缴纳管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","修改","删除"],"menu":"师生对话","menuJump":"列表","tableName":"shishengduihua"}],"menu":"师生对话管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"论坛交流","tableName":"forum"}],"menu":"论坛交流"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["修改","删除","查看"],"menu":"在线留言","tableName":"messages"}],"menu":"在线留言"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","报名缴费"],"menu":"课程信息列表","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","考级报名"],"menu":"考级信息列表","menuJump":"列表","tableName":"kaojixinxi"}],"menu":"考级信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","支付"],"menu":"选课报名","menuJump":"列表","tableName":"xuankebaoming"}],"menu":"选课报名管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","支付"],"menu":"考级报名","menuJump":"列表","tableName":"kaojibaoming"}],"menu":"考级报名管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看"],"menu":"学籍信息","menuJump":"列表","tableName":"xuejixinxi"}],"menu":"学籍信息管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"学位申请","menuJump":"列表","tableName":"xueweishenqing"}],"menu":"学位申请管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看"],"menu":"成绩信息","menuJump":"列表","tableName":"chengjixinxi"}],"menu":"成绩信息管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"教务信息","menuJump":"列表","tableName":"jiaowuxinxi"}],"menu":"教务信息管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","支付"],"menu":"学费缴纳","menuJump":"列表","tableName":"xuefeijiaona"}],"menu":"学费缴纳管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除"],"menu":"师生对话","menuJump":"列表","tableName":"shishengduihua"}],"menu":"师生对话管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","报名缴费"],"menu":"课程信息列表","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","考级报名"],"menu":"考级信息列表","menuJump":"列表","tableName":"kaojixinxi"}],"menu":"考级信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"研究生","tableName":"yanjiusheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看"],"menu":"研究生","menuJump":"列表","tableName":"yanjiusheng"}],"menu":"研究生管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","审核"],"menu":"选课报名","menuJump":"列表","tableName":"xuankebaoming"}],"menu":"选课报名管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除"],"menu":"成绩信息","menuJump":"列表","tableName":"chengjixinxi"}],"menu":"成绩信息管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"教务信息","menuJump":"列表","tableName":"jiaowuxinxi"}],"menu":"教务信息管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","修改","删除","审核"],"menu":"师生对话","menuJump":"列表","tableName":"shishengduihua"}],"menu":"师生对话管理"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["查看","修改","回复","删除"],"menu":"在线留言","tableName":"messages"}],"menu":"在线留言"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","报名缴费"],"menu":"课程信息列表","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","考级报名"],"menu":"考级信息列表","menuJump":"列表","tableName":"kaojixinxi"}],"menu":"考级信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"导师","tableName":"daoshi"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
