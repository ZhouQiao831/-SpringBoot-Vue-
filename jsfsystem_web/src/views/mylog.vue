<template>
  <div class="rouglobal">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item><a>我的课程</a></el-breadcrumb-item>
    </el-breadcrumb>
 

 
    <el-table ref="table" :data="tableData" border :height="tableHeight">
      <el-table-column type="index" label="序号" width="100"> </el-table-column>
      <el-table-column prop="kcname" label="名称"> </el-table-column>
     
      <el-table-column prop="timelong" label="时长"> </el-table-column>
      <el-table-column prop="jiaolian" label="教练"> </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="text" class="bianji"  @click="open(scope.row)">退课</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div>
    
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
      form2:{},
      tableHeight: "",
    };
  },
  mounted() {
     this.form2 = JSON.parse(window.localStorage.getItem("key"));
    this.$nextTick(() => {
      this.tableHeight = window.innerHeight - 250;

      // 监听窗口大小变化
      let self = this;
      window.onresize = () => {
        self.tableHeight = window.innerHeight - 250;
      };
    });

    this.getdata1()
    //this.$refs.table.$el.offsetTop：表格距离浏览器的高度 //50表示你想要调整的表格距离底部的高度（你可以自己随意调整），因为我们一般都有放分页组件的，所以需要给它留一个高度
  },
  methods: {
     open(i) {
      this.$confirm(" 是否确认退课？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          const res = await service.get("/baoming/shanchu", {
            params: {
              id: i.id,
            },
          });
          console.log(res);
          if (res.code == 200) {
            this.$message({
              type: "success",
              message: "退课成功!",
            });
            this.getdata1();
          }
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
      async getdata1() {
      const res = await service.get("/baoming/index", {
        params: {
          huiyuanid: this.form2.id,
        },
      });
      console.log(res);
      this.tableData = res.data;
      //   this.tableData.forEach((el) => {
      //     el.srcList = [];
      //     el.srcList.push(el.hyimg);
      //   });
    },

    shanchu(i) {
      this.$confirm(" 是否删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          const res = await service.get("/subject/shanchu", {
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
      const res = await service.get("/subject/index", {
        params: this.form,
      });
      console.log(res);
      this.tableData = res.data;
      this.total = res.total;
    //   this.tableData.forEach((el) => {
    //     el.srcList = [];
    //     el.srcList.push(el.hyimg);
    //   });
    },
    add() {
      this.$router.push({
        path: "/kcsave",
      });
    },
    bianji(row) {
      this.$router.push({
        path: "/kcsave",
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