<template>
<div class="center-preview" :style='{"width":"1200px","margin":"0px auto","position":"relative","background":"#fff"}'>
	<div class="title" :style='{"margin":"10px 0 0","color":"#fff","borderRadius":"25px 25px 0 0","textAlign":"center","background":"#4D8CD0","fontSize":"20px","lineHeight":"54px"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"background":"#4D8CD0"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="80px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="研究生账号" prop="yanjiushengzhanghao">
            <el-input v-model="sessionForm.yanjiushengzhanghao" placeholder="研究生账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="研究生姓名" prop="yanjiushengxingming">
            <el-input v-model="sessionForm.yanjiushengxingming" placeholder="研究生姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="yanjiushengtouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","width":"200px","fontSize":"32px","lineHeight":"200px","height":"200px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="电话号码" prop="dianhuahaoma">
            <el-input v-model="sessionForm.dianhuahaoma" placeholder="电话号码" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="专业" prop="zhuanye">
            <el-input v-model="sessionForm.zhuanye" placeholder="专业" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="家庭住址" prop="jiatingzhuzhi">
            <el-input v-model="sessionForm.jiatingzhuzhi" placeholder="家庭住址" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="身份证" prop="shenfenzheng">
            <el-input v-model="sessionForm.shenfenzheng" placeholder="身份证" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="导师工号">
            <el-select v-model="sessionForm.daoshigonghao" placeholder="请选择导师工号" @change="daoshigonghaoChange" >
              <el-option v-for="(item, index) in dynamicProp.daoshigonghao" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='yanjiusheng'" label="导师姓名" prop="daoshixingming">
            <el-input v-model="sessionForm.daoshixingming" placeholder="导师姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoshi'" label="导师工号" prop="daoshigonghao">
            <el-input v-model="sessionForm.daoshigonghao" placeholder="导师工号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoshi'" label="导师姓名" prop="daoshixingming">
            <el-input v-model="sessionForm.daoshixingming" placeholder="导师姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoshi'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoshi'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoshi'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="daoshitouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","width":"200px","fontSize":"32px","lineHeight":"200px","height":"200px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' v-if="userTableName=='daoshi'" label="电话号码" prop="dianhuahaoma">
            <el-input v-model="sessionForm.dianhuahaoma" placeholder="电话号码" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"20px 20px 0 0","background":"#4D8CD0","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"0px solid #4D8CD0","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#4D8CD0","borderRadius":"20px 20px 0 0","background":"#D4E7FF","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="充值金额" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
            <el-button type="primary" @click="chongzhi">确认充值</el-button>
          </div>
        </el-dialog>
        <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="会员卡" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/年"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">取 消</el-button>
            <el-button type="primary" @click="chongzhivip">确认支付</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'yanjiushengzhanghao', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'yanjiushengxingming', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'dianhuahaoma', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'zhuanye', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'jiatingzhuzhi', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'shenfenzheng', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'daoshigonghao', null);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.sessionForm, 'daoshixingming', null);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'daoshigonghao', null);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'daoshixingming', null);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'dianhuahaoma', null);
      }

      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.rules, 'yanjiushengzhanghao', [{ required: true, message: '请输入研究生账号', trigger: 'blur' }]);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.rules, 'yanjiushengxingming', [{ required: true, message: '请输入研究生姓名', trigger: 'blur' }]);
      }
      if ('yanjiusheng' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('yanjiusheng' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('yanjiusheng' == this.userTableName) {
        this.$set(this.rules, 'dianhuahaoma', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.rules, 'daoshigonghao', [{ required: true, message: '请输入导师工号', trigger: 'blur' }]);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.rules, 'daoshixingming', [{ required: true, message: '请输入导师姓名', trigger: 'blur' }]);
      }
      if ('daoshi' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('daoshi' == this.userTableName) {
        this.$set(this.rules, 'dianhuahaoma', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('yanjiusheng' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
				if ('yanjiusheng' == this.userTableName) {
          this.$http.get('option/daoshi/daoshigonghao', {emulateJSON: true}).then(res => {
            if (res.data.code == 0) {
              this.dynamicProp.daoshigonghao = res.data.data;
            }
          });
        }    
        if ('daoshi' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
      daoshigonghaoChange(value) {
        this.$http.get('follow/daoshi/daoshigonghao', {params: {columnValue: value}}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm.daoshixingming = res.data.data.daoshixingming;
          }
        });
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: '更新成功',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      yanjiushengtouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('yanjiusheng' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      daoshitouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('daoshi' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择支付方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == '是') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "是"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '会员购买成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '我的发布':
            tab.$router.push('/index/myForumList');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 0;
	margin: 0;
	background: #4D8CD0;
	width: 180px;
	border-color: #eee;
	border-width: 0 1px 0 0;
	position: relative;
	float: left;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	border-radius: 10px 10px 0 0;
  	padding: 0 10px;
  	margin: 10px auto;
  	color: #4D8CD0;
  	background: #D4E7FF;
  	font-weight: 500;
  	width: calc(100% - 40px);
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border-radius: 10px 10px 0 0;
  	padding: 0 10px;
  	margin: 10px auto;
  	color: #000;
  	background: #fff;
  	font-weight: 500;
  	width: calc(100% - 40px);
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	border-radius: 10px 10px 0 0;
  	padding: 0 10px;
  	margin: 10px auto;
  	color: #000;
  	background: #fff;
  	font-weight: bold;
  	width: calc(100% - 40px);
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 10px;
  	background: #fff;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #000;
  	font-weight: 500;
  	width: 80px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 80px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #000;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #000;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #000;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #000;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid #000;
  	border-radius: 0;
  	padding: 0 10px 0 30px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #000;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px dashed #999;
  	cursor: pointer;
  	border-radius: 6px;
  	color: #999;
  	width: 200px;
  	font-size: 32px;
  	line-height: 200px;
  	text-align: center;
  	height: 200px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #000;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #000;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
