<template>
    <div class="rouglobal">
            <el-breadcrumb separator="/">
      <el-breadcrumb-item><a>报名信息</a></el-breadcrumb-item>
    </el-breadcrumb>
     <el-table ref="table" :data="tableData" border :height="tableHeight">
      <el-table-column type="index" label="序号" width="100"> </el-table-column>
      <el-table-column prop="huiyuanname" label="学员"> </el-table-column>
     </el-table>
    </div>
</template>
<script>
import service from "@/request";

export default {
  data() {
    return {
      tableData: [],
      total: 0,
      form1: {},
      form: {
        name: "",
        pageNum: 1,
        pageSize: 10,
      },
      form2: {},
      tableHeight: "",
      data1: [],
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
    this.getdata1();
 
  },
  methods: {
    open(row) {
      this.form1 = {
        kcid: row.id,
        kcname: row.name,
        time: row.time,
        jiaolian: row.jiaolian,
        huiyuanid: this.form2.id,
        huiyuanname: this.form2.name,
      };
      let sf = false;
      let arr = [];
      let sf1 = "";
      this.data1.forEach((el) => {
        arr.push(el.kcid);
      });
      if (arr.indexOf(row.id) !== -1) {
        this.$message.warning("不能重复报名课程");
      } else {
        this.$confirm("是否确认报名该课程?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(async () => {
            const res = await service.post("/baoming/add", this.form1);
            console.log(res);
            if (res.code == 200) {
              this.$message.success("报名成功");
              this.$router.push("/my");
            }
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消",
            });
          });
      }
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
    async getdata1() {
      const res = await service.get("/baoming/index1", {
        params: {
     kcid: this.$route.query.id,
        },
      });
      console.log(res);
      this.tableData = res.data;
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