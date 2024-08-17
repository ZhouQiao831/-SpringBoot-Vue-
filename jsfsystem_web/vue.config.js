module.exports = {
  lintOnSave: false,
  transpileDependencies: true,
  publicPath: process.env.VUE_APP_OUTPUT_DIR,//生成目录的文件名。
  outputDir: process.env.VUE_APP_ROUTER_URL, //生产环境构建文件的目录
  assetsDir: '',//输出的静态资源目录名 没有默认放到根目录下  static
  productionSourceMap: false,
  devServer: {
    compress: true,
    hot: true,
    port: 8082,//端口号
    proxy: { //配置多个跨域
      '/': {
        target: "http://localhost:7071/", //跨域到的地址
        changeOrigin: true,
        pathRewrite: { "^/": "/" }
      },
    }
  },
}
