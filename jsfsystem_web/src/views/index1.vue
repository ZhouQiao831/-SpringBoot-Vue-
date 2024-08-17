<template>
  <el-container class="contain">
    <el-header>
      <div class="headtitle">健身房管理系统</div>
      <div>
        <el-dropdown>
          <img :src="avator" class="avator" alt="" />

          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="tcdl">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container class="content">
      <el-aside width="200px">
        <el-menu
          :default-active="active"
          class="el-menu-vertical-demo"
          background-color="#fafafa"
          router
        >
          <el-menu-item v-for="item in menu" :index="item.path">
            <i class="el-icon-menu"></i>
            <span slot="title">{{ item.name }}</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>
<script>
import service from "@/request";
export default {
  data() {
    return {
      form: {},
      type: "",
      menu: [],
      avator: "",
      active: "/index",
    };
  },
  watch: {
    $route: {
      handler(val, oldVal) {
        console.log(val);
        this.active = val.path;
      },
      // 深度观察监听
      deep: true,
      immediate: true,
    },
  },
  mounted() {
    this.form = JSON.parse(window.localStorage.getItem("key"));
    console.log(this.form);
    this.getmenu();
  },
  methods: {
    async getmenu() {
      this.type = window.localStorage.getItem("type");
      if (this.type == 1) {
        this.avator = this.form.avator;
      } else {
        this.avator = this.form.hyimg;
      }
      const res = await service.get("/menu/index", {
        params: {
          type: this.type,
        },
      });
      console.log(res);
      this.menu = res.data;
      //   this.active = this.menu[0].path;
    },
    tcdl() {
      this.$router.push("/");
      window.localStorage.clear();
    },
  },
};
</script>
<style>
.content {
  width: 100%;
  height: calc(100% - 60px);
}
.el-menu {
  width: 100%;
  height: 100%;
}
.contain {
  width: 100%;
  height: 100%;
}
.avator {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  vertical-align: middle;
}
.headtitle {
  font-size: 20px;
}
.el-header {
  background: #000;
  display: flex;
  align-items: center;
  justify-content: space-between;
  color: #fff;
}
.el-aside {
  overflow-x: hidden;
}
</style>