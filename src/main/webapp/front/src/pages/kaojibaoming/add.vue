<template>
<div :style='{"width":"1200px","padding":"20px","margin":"10px auto","position":"relative","background":"#f5f5f5"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="报名编号" prop="baomingbianhao">
              <el-input v-model="ruleForm.baomingbianhao" placeholder="报名编号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="课程名称" prop="kechengmingcheng">
            <el-input v-model="ruleForm.kechengmingcheng" 
                placeholder="课程名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="课程分类" prop="kechengfenlei">
            <el-input v-model="ruleForm.kechengfenlei" 
                placeholder="课程分类" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="课程类型" prop="kechengleixing">
            <el-input v-model="ruleForm.kechengleixing" 
                placeholder="课程类型" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="考级级别" prop="kaojijibie">
            <el-input v-model="ruleForm.kaojijibie" 
                placeholder="考级级别" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="价格" prop="jiage">
            <el-input v-model="ruleForm.jiage" 
                placeholder="价格" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="报名时间" prop="baomingshijian" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.baomingshijian" 
                  type="date"
                  placeholder="报名时间">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="研究生账号" prop="yanjiushengzhanghao">
            <el-input v-model="ruleForm.yanjiushengzhanghao" 
                placeholder="研究生账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="研究生姓名" prop="yanjiushengxingming">
            <el-input v-model="ruleForm.yanjiushengxingming" 
                placeholder="研究生姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"transparent"}' label="专业" prop="zhuanye">
            <el-input v-model="ruleForm.zhuanye" 
                placeholder="专业" clearable ></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"20px 20px 0 0","background":"#4D8CD0","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"cursor":"pointer","border":"none","padding":"0","margin":"0","outline":"none","color":"#4D8CD0","borderRadius":"20px 20px 0 0","background":"#D4E7FF","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            baomingbianhao : false,
            kechengmingcheng : false,
            kechengfenlei : false,
            kechengleixing : false,
            kaojijibie : false,
            jiage : false,
            baomingshijian : false,
            yanjiushengzhanghao : false,
            yanjiushengxingming : false,
            zhuanye : false,
            ispay : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          baomingbianhao: this.getUUID(),
          kechengmingcheng: '',
          kechengfenlei: '',
          kechengleixing: '',
          kaojijibie: '',
          jiage: '',
          baomingshijian: '',
          yanjiushengzhanghao: '',
          yanjiushengxingming: '',
          zhuanye: '',
          ispay: '',
        },
        rules: {
          baomingbianhao: [
          ],
          kechengmingcheng: [
          ],
          kechengfenlei: [
          ],
          kechengleixing: [
          ],
          kaojijibie: [
          ],
          jiage: [
          ],
          baomingshijian: [
          ],
          yanjiushengzhanghao: [
          ],
          yanjiushengxingming: [
          ],
          zhuanye: [
          ],
          ispay: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.baomingshijian = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='baomingbianhao'){
              this.ruleForm.baomingbianhao = obj[o];
              this.ro.baomingbianhao = true;
              continue;
            }
            if(o=='kechengmingcheng'){
              this.ruleForm.kechengmingcheng = obj[o];
              this.ro.kechengmingcheng = true;
              continue;
            }
            if(o=='kechengfenlei'){
              this.ruleForm.kechengfenlei = obj[o];
              this.ro.kechengfenlei = true;
              continue;
            }
            if(o=='kechengleixing'){
              this.ruleForm.kechengleixing = obj[o];
              this.ro.kechengleixing = true;
              continue;
            }
            if(o=='kaojijibie'){
              this.ruleForm.kaojijibie = obj[o];
              this.ro.kaojijibie = true;
              continue;
            }
            if(o=='jiage'){
              this.ruleForm.jiage = obj[o];
              this.ro.jiage = true;
              continue;
            }
            if(o=='baomingshijian'){
              this.ruleForm.baomingshijian = obj[o];
              this.ro.baomingshijian = true;
              continue;
            }
            if(o=='yanjiushengzhanghao'){
              this.ruleForm.yanjiushengzhanghao = obj[o];
              this.ro.yanjiushengzhanghao = true;
              continue;
            }
            if(o=='yanjiushengxingming'){
              this.ruleForm.yanjiushengxingming = obj[o];
              this.ro.yanjiushengxingming = true;
              continue;
            }
            if(o=='zhuanye'){
              this.ruleForm.zhuanye = obj[o];
              this.ro.zhuanye = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yanjiushengzhanghao!=''&&json.yanjiushengzhanghao) || json.yanjiushengzhanghao==0){
                this.ruleForm.yanjiushengzhanghao = json.yanjiushengzhanghao
            }
            if((json.yanjiushengxingming!=''&&json.yanjiushengxingming) || json.yanjiushengxingming==0){
                this.ruleForm.yanjiushengxingming = json.yanjiushengxingming
            }
            if((json.zhuanye!=''&&json.zhuanye) || json.zhuanye==0){
                this.ruleForm.zhuanye = json.zhuanye
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('kaojibaoming/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('kaojibaoming/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('kaojibaoming/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('kaojibaoming/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
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
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #000;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #000;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
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
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed #999;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #999;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #999;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #000;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
