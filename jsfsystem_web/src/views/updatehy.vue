<template>
  <div class="global">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item
        ><a>{{ title }}</a></el-breadcrumb-item
      >
    </el-breadcrumb>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="会员账号">
        <el-input
          v-model="form.cardno"
          placeholder="会员卡号为自动生成8位数字"
          readonly
        ></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.name" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input
          v-model="form.pass"
          type="password"
          
          placeholder="初始密码为123456"
        ></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.sex" style="width:100%">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="form.year" placeholder="年龄"></el-input>
      </el-form-item>
      <el-form-item label="办卡时间">
        <el-date-picker
          v-model="form.createTime"
          value-format="yyyy-MM-dd"
          placeholder="办卡时间"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="联系方式">
        <el-input v-model="form.phone" placeholder="联系方式"></el-input>
      </el-form-item>
      <el-form-item label="身高">
        <el-input v-model="form.height" placeholder="身高"></el-input>
      </el-form-item>
      <el-form-item label="体重">
        <el-input v-model="form.weight" placeholder="体重"></el-input>
      </el-form-item>
      <el-form-item label="购买课时">
        <el-input v-model="form.buytime" placeholder="购买课时"></el-input>
      </el-form-item>
      <el-form-item label="会员头像">
        <el-upload
          class="avatar-uploader"
          action="http://demonuxtapi.dishait.cn/admin/s/upload"
          :headers="headers"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
        >
          <img v-if="form.hyimg !== ''" :src="form.hyimg" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="add()">确定</el-button>
        <el-button type="primary" @click="qx()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import service from "@/request";
export default {
  data() {
    return {
      title: "新增",
      headers: {
        schoolid: 11,
        token:
          "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6IjQ1NioqKkBxcS5jb20iLCJwaG9uZSI6IjEzNyoqKio1NDQ5IiwiaWQiOjEsInVzZXJuYW1lIjoiY2VzaGkxIiwibmlja25hbWUiOiIiLCJwYXNzd29yZCI6IjA5MTNmYWIyOWY4YWE5MmY5N2ZlNjQ2ODM5NDA5ZjM3MjZjNGQzZGM2NGY0NDlmMTA2MjJhNTUwMGM3NDBjMDIiLCJhdmF0YXIiOiIiLCJ3ZWl4aW5fdW5pb25pZCI6bnVsbCwic2V4Ijoi5pyq55-lIiwiZGVzYyI6IiIsInN0YXR1cyI6MSwiY3JlYXRlZF90aW1lIjoiMjAyMS0wMi0yMVQxNDowNDowMi4wMDBaIiwidXBkYXRlZF90aW1lIjoiMjAyMy0xMC0wNFQxNjo0ODo0MC4wMDBaIiwiaWF0IjoxNjk4NTYyOTU4fQ.MLAxkr9JkR9lIxEZbufSuBDB_kz-GR8UYEvwB3NslcA",
      },
      form: {
        cardno: "",
        pass: "123456",
        hyimg: "",
      },
    };
  },
  mounted() {
    this.form = JSON.parse(this.$route.query.row);
  },
  methods: {
    beforeAvatarUpload() {},
    handleAvatarSuccess(e) {
      console.log(e);
      this.form.hyimg = e.data;
    },

    async add() {
      this.form.shengyutime = this.form.buytime;
      const res = await service.post("/huiyuan/update", this.form);
      console.log(res);
      if (res.code == 200) {
        this.$message.success("修改成功");
        this.qx();
      }
    },
    qx() {
      this.$router.go(-1);
    },
  },
};
</script>