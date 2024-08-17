<template>
  <div class="global">
    <div class="login">
      <p class="title">健身房管理系统</p>
      <el-form :model="form">
        <el-form-item>
          <el-input placeholder="请输入账号" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            placeholder="请输入密码"
            v-model="form.password"
            type="password"
          ></el-input>
        </el-form-item>

        <div class="logincz">
          <el-button type="success" @click="login">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>
<script>
import service from "@/request";
export default {
  data() {
    return {
      button: "转到会员登录",
      form: {
        type: 1,
      },
    };
  },
  methods: {
    async login() {
      console.log(this.form.type)
      
      if ((this.form.type == 1)) {
        const res = await service.get("/user/login", {
          params: {
            username: this.form.username,
            password: this.form.password,
            type: this.form.type,
          },
        });
        console.log(res);
        if (res.code == 200) {
          this.$message.success(`${res.msg}`);
          window.localStorage.setItem("key", JSON.stringify(res.data[0]));
          window.localStorage.setItem("type", this.form.type);

          this.$router.push({
            path: "/index1",
          });
        } else {
          this.$message.warning(`${res.msg}`);
        }
      }else if(this.form.type == 2){
         const res = await service.get("/user/hylogin", {
        params: {
          cardno: this.form.username,
          pass: this.form.password,
          type: this.form.type,
        },
      });
      console.log(res);
      if (res.code == 200) {
        this.$message.success(`${res.msg}`);
        window.localStorage.setItem("key", JSON.stringify(res.data[0]));
        window.localStorage.setItem("type", this.form.type);

        this.$router.push({
          path: "/my",
        });
      } else {
        this.$message.warning(`${res.msg}`);
      }
      }
    },
    zhuan() {
      console.log(this.button);
      if (this.button == "转到会员登录") {
        this.button = "转到管理员登录";
        this.form.type = 2;
      } else {
        this.button = "转到会员登录";

        this.form.type = 1;
      }
      console.log(this.form.type)
    },
  },
};
</script>
<style scoped>
.logincz {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
.login {
  width: 50%;
  height: auto;
  position: absolute;
  top: 30%;
  left: 24%;
  padding: 20px;
  box-sizing: border-box;
  background: #fff;
}
.global {
  width: 100%;
  height: 100%;
  background: url("@/assets/jsf.jpg") no-repeat;
  background-size: 100% 100%;
  position: relative;
}
.title {
  text-align: center;
  font-size: 20px;
}
</style>