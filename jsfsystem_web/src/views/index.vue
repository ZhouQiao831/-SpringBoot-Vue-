<template>
  <div class="rouglobal">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item><a>首页</a></el-breadcrumb-item>
    </el-breadcrumb>
    <div>
      <el-row :gutter="20">
        <el-col :span="6">
          <div>
            <el-statistic title="健身房总人数">
              <template slot="formatter"> {{all}} </template>
            </el-statistic>
          </div>
        </el-col>
         <el-col :span="6">
          <div>
            <el-statistic title="会员数">
              <template slot="formatter"> {{huiyuanshu}} </template>
            </el-statistic>
          </div>
        </el-col>
                 <el-col :span="6">
          <div>
            <el-statistic title="器材数">
              <template slot="formatter"> {{qicaishu}} </template>
            </el-statistic>
          </div>
        </el-col>
                 <el-col :span="6">
          <div>
            <el-statistic title="课程数">
              <template slot="formatter"> {{subjectshu}} </template>
            </el-statistic>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
import service from "@/request";

export default {
  data() {
    return {
      all: "",
      huiyuanshu: "",
      qicaishu: "",
      subjectshu: "",
    };
  },
  mounted() {
    this.getdata();
  },
  methods: {
    async getdata() {
      const res = await service.get("/shouye/index");
      console.log(res);
      this.all = res.all;
      this.huiyuanshu = res.huiyuanshu;
      this.qicaishu = res.qicaishu;
      this.subjectshu = res.subjectshu;
    },
  },
};
</script>