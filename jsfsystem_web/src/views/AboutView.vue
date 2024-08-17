<template>
  <el-upload
    class="avatar-uploader"
    action="http://demonuxtapi.dishait.cn/admin/s/upload"
    :headers="headers"
    :show-file-list="false"
    :on-success="handleAvatarSuccess"
    :before-upload="beforeAvatarUpload"
  >
    <img v-if="imageUrl" :src="imageUrl" class="avatar" />
    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
  </el-upload>
</template>

<script>
import axios from "axios";
import service from "@/request";

export default {
  data() {
    return {
      imageUrl: "http://demo-mp3.oss-cn-shenzhen.aliyuncs.com/egg-edu-demo/f4653d576bd10ed91393.jpg",
      headers: {
        schoolid: 11,
        token:
          "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6IjQ1NioqKkBxcS5jb20iLCJwaG9uZSI6IjEzNyoqKio1NDQ5IiwiaWQiOjEsInVzZXJuYW1lIjoiY2VzaGkxIiwibmlja25hbWUiOiIiLCJwYXNzd29yZCI6IjA5MTNmYWIyOWY4YWE5MmY5N2ZlNjQ2ODM5NDA5ZjM3MjZjNGQzZGM2NGY0NDlmMTA2MjJhNTUwMGM3NDBjMDIiLCJhdmF0YXIiOiIiLCJ3ZWl4aW5fdW5pb25pZCI6bnVsbCwic2V4Ijoi5pyq55-lIiwiZGVzYyI6IiIsInN0YXR1cyI6MSwiY3JlYXRlZF90aW1lIjoiMjAyMS0wMi0yMVQxNDowNDowMi4wMDBaIiwidXBkYXRlZF90aW1lIjoiMjAyMy0xMC0wNFQxNjo0ODo0MC4wMDBaIiwiaWF0IjoxNjk4NTYyOTU4fQ.MLAxkr9JkR9lIxEZbufSuBDB_kz-GR8UYEvwB3NslcA",
      },
    };
  },
  mounted() {
    this.login();
  },
  methods: {
    async login() {
      const res = await service.post(
        "http://demonuxtapi.dishait.cn/user/login",
        {
          username: "ceshi1",
          password: "ceshi1",
        }
      );
      console.log(res);
    },
    beforeAvatarUpload(e) {
      console.log(e);
    },
    handleAvatarSuccess(e) {
      console.log(e);
    
    },
  },
};
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>