<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","backgroundAttachment":"fixed","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20220805/953d998dd096437abb8ac6688cfebb57.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-start"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"20px 0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"0 0 0 7%","borderRadius":"10px","background":"#fff","width":"800px","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"120px","fontSize":"24px","fontWeight":"bold"}' class="title">基于Web的研究生信息管理系统注册</div>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">研究生账号</div>
					<el-input  v-model="ruleForm.yanjiushengzhanghao"  autocomplete="off" placeholder="研究生账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">研究生姓名</div>
					<el-input  v-model="ruleForm.yanjiushengxingming"  autocomplete="off" placeholder="研究生姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yanjiushengxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yanjiushengtouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">年龄</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">电话号码</div>
					<el-input  v-model="ruleForm.dianhuahaoma"  autocomplete="off" placeholder="电话号码"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">专业</div>
					<el-input  v-model="ruleForm.zhuanye"  autocomplete="off" placeholder="专业"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">家庭住址</div>
					<el-input  v-model="ruleForm.jiatingzhuzhi"  autocomplete="off" placeholder="家庭住址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">身份证</div>
					<el-input  v-model="ruleForm.shenfenzheng"  autocomplete="off" placeholder="身份证"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">导师工号</div>
                    <el-select @change="yanjiushengdaoshigonghaoChange" v-model="ruleForm.daoshigonghao" placeholder="请选择导师工号" >
                        <el-option
                            v-for="(item,index) in yanjiushengdaoshigonghaoOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yanjiusheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">导师姓名</div>
					<el-input  v-model="ruleForm.daoshixingming" readonly autocomplete="off" placeholder="导师姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">导师工号</div>
					<el-input  v-model="ruleForm.daoshigonghao"  autocomplete="off" placeholder="导师工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">导师姓名</div>
					<el-input  v-model="ruleForm.daoshixingming"  autocomplete="off" placeholder="导师姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in daoshixingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="daoshitouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='daoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">电话号码</div>
					<el-input  v-model="ruleForm.dianhuahaoma"  autocomplete="off" placeholder="电话号码"  type="text"  />
				</el-form-item>
				<button :style='{"border":"4px solid #94C4C6","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#94C4C6","display":"block","outline":"none","borderRadius":"30px 30px 0 0","background":"#fff","width":"70%","fontSize":"24px","height":"90px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","color":"rgba(159, 159, 159, 1)","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                xingbie: '',
                daoshixingming: '',
                xingbie: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            yanjiushengxingbieOptions: [],
            yanjiushengdaoshigonghaoOptions: [],
            daoshixingbieOptions: [],
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.yanjiushengxingbieOptions = "男,女".split(',')
        this.$http({
            url: `option/daoshi/daoshigonghao`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.yanjiushengdaoshigonghaoOptions = data.data;
            } else {
                this.$message.error(data.msg);
            }
        });
        this.daoshixingbieOptions = "男,女".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yanjiushengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        // 下二随
        yanjiushengdaoshigonghaoChange () {
            this.$http({
                url: `follow/daoshi/daoshigonghao?columnValue=`+ this.ruleForm.daoshigonghao,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    if(data.data.daoshixingming){
                        this.ruleForm.daoshixingming = data.data.daoshixingming
                    }
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
        daoshitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yanjiushengzhanghao) && `yanjiusheng` == this.tableName){
						this.$message.error(`研究生账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.yanjiushengxingming) && `yanjiusheng` == this.tableName){
						this.$message.error(`研究生姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `yanjiusheng` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yanjiusheng` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`yanjiusheng` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`yanjiusheng` == this.tableName && this.ruleForm.dianhuahaoma&&(!this.$validate.isMobile(this.ruleForm.dianhuahaoma))){
						this.$message.error(`电话号码应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.daoshigonghao) && `daoshi` == this.tableName){
						this.$message.error(`导师工号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.daoshixingming) && `daoshi` == this.tableName){
						this.$message.error(`导师姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `daoshi` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `daoshi` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`daoshi` == this.tableName && this.ruleForm.dianhuahaoma&&(!this.$validate.isMobile(this.ruleForm.dianhuahaoma))){
						this.$message.error(`电话号码应输入手机格式`);
						return
					}
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20220805/953d998dd096437abb8ac6688cfebb57.png);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0 0 6px #94C4C6;
						outline: none;
						color: #000;
						background: #fff;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0 0 6px #94C4C6;
						outline: none;
						color: #000;
						width: 560px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 6px #94C4C6;
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 6px #94C4C6;
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #94C4C6;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #94C4C6;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #94C4C6;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #94C4C6;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #94C4C6;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #94C4C6;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
	}
</style>
