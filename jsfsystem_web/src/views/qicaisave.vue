<template>
  <div class="global">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item
        ><a>{{ title }}</a></el-breadcrumb-item
      >
    </el-breadcrumb>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="名称">
        <el-input v-model="form.name" placeholder="名称"></el-input>
      </el-form-item>

      <el-form-item label="状态">
        <el-select v-model="form.status" style="width:100%">
          <el-option label="正常" value="正常"></el-option>
          <el-option label="维修中" value="维修中"></el-option>
          <el-option label="损坏" value="损坏"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="位置">
        <el-input v-model="form.location" placeholder="位置"></el-input>
      </el-form-item>

      <el-form-item label="备注">
        <el-input v-model="form.remark" placeholder="备注"></el-input>
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
    if (this.$route.query.row) {
      this.form = JSON.parse(this.$route.query.row);
    }
    // this.form = JSON.parse(this.$route.query.row);
  },
  methods: {
    beforeAvatarUpload() {},
    handleAvatarSuccess(e) {
      console.log(e);
      this.form.hyimg = e.data;
    },

    async add() {
      this.form.shengyutime = this.form.buytime;
      const res = await service.post("/qicai/save", this.form);
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