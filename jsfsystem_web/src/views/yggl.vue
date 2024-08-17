<template>
  <div class="rouglobal">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item><a>员工管理</a></el-breadcrumb-item>
    </el-breadcrumb>
    <div class="chaxun">
      <el-input
        placeholder="请输入姓名查询"
        v-model="form.name"
        class="w20mr"
      ></el-input>
      <el-button type="primary" @click="chaxun">查询</el-button>
      <el-button @click="chongzhi()">重置</el-button>
      <el-button type="primary" @click="add">新增</el-button>
    </div>
    <el-table ref="table" :data="tableData" border :height="tableHeight">
      <el-table-column prop="id" label="工号"> </el-table-column>
      <el-table-column prop="name" label="姓名"> </el-table-column>
      <el-table-column prop="sex" label="性别"> </el-table-column>
      <el-table-column prop="year" label="年龄"> </el-table-column>
      <el-table-column prop="ruzhitime" label="入职时间"> </el-table-column>
      <el-table-column prop="zhiwu" label="职务"> </el-table-column>
      <el-table-column prop="remark" label="备注"> </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="text" class="bianji" @click="bianji(scope.row)"
            >编辑</el-button
          >
          <el-button type="text" class="shanchu" @click="shanchu(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="form.pageNum"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="form.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>
    </div>
  </div>
</template>
<script>
import service from "@/request";

export default {
  data() {
    return {
      tableData: [],
      total: 0,
      form: {
        name: "",
        pageNum: 1,
        pageSize: 10,
      },
      tableHeight: "",
    };
  },
  mounted() {
    this.$nextTick(() => {
      this.tableHeight = window.innerHeight - 250;

      // 监听窗口大小变化
      let self = this;
      window.onresize = () => {
        self.tableHeight = window.innerHeight - 250;
      };
    });
    this.getdata();
    //this.$refs.table.$el.offsetTop：表格距离浏览器的高度 //50表示你想要调整的表格距离底部的高度（你可以自己随意调整），因为我们一般都有放分页组件的，所以需要给它留一个高度
  },
  methods: {
    shanchu(i) {
      this.$confirm(" 是否删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          const res = await service.get("/yuangong/delete", {
            params: {
              id: i,
            },
          });
          console.log(res);
          if (res.code == 200) {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            this.getdata();
          }
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    async getdata() {
      const res = await service.get("/yuangong/index", {
        params: this.form,
      });
      console.log(res);
      this.tableData = res.data;
      this.total = res.total;
      this.tableData.forEach((el) => {
        el.srcList = [];
        el.srcList.push(el.hyimg);
      });
    },
    add() {
      this.$router.push({
        path: "/yuangongadd",
      });
    },
    bianji(row) {
      this.$router.push({
        path: "/yuangongadd",
        query: {
          row: JSON.stringify(row),
        },
      });
    },
    handleSizeChange(e) {
      this.form.pageSize = e;
      this.getdata();
    },
    handleCurrentChange(e) {
      this.form.pageNum = e;
      this.getdata();
    },
    chongzhi() {
      this.form.name = "";
      this.form.pageNum = 1;
      this.form.pageSize = 10;
      this.getdata();
    },
    chaxun() {
      this.form.pageNum = 1;
      this.form.pageSize = 10;
      this.getdata();
    },
  },
};
</script>
<style scoped>
.w20mr {
  margin-right: 10px;
  width: 200px;
}
.chaxun {
  width: 100%;
  height: auto;
  margin-top: 10px;
  margin-bottom: 10px;
}
.bianji {
  color: #f56c6c;
}
.shanchu {
  color: #409eff;
}
</style>