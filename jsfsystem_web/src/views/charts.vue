<template>
  <div id="echartsid" style="height: 300px; width: 300px"></div>
</template>
<script>
import highcharts from "highcharts";

export default {
  data() {
    return{
    dataList: 
     [
        {
          name: "红草莓",
          y: 2,
          h: 10,
          bfb: 0
        },
        {
          name: "白草莓",
          y: 8,
          h: 6,
          bfb: 0
        },
       
      ]
    }
   

    
  },
 
  mounted() {

    this.initOption();

   
  },

  methods: {
    initOption() {
   
      // 修改3d饼图绘制过程
      var each = highcharts.each,
        round = Math.round,
        cos = Math.cos,
        sin = Math.sin,
        deg2rad = Math.deg2rad;
      highcharts.wrap(
        highcharts.seriesTypes.pie.prototype,
        "translate",
        function (proceed) {
          proceed.apply(this, [].slice.call(arguments, 1));
          // Do not do this if the chart is not 3D
          if (!this.chart.is3d()) {
            return;
          }
          var series = this,
            chart = series.chart,
            options = chart.options,
            seriesOptions = series.options,
            depth = seriesOptions.depth || 0,
            options3d = options.chart.options3d,
            alpha = options3d.alpha,
            beta = options3d.beta,
            z = seriesOptions.stacking
              ? (seriesOptions.stack || 0) * depth
              : series._i * depth;
          z += depth / 2;
          if (seriesOptions.grouping !== false) {
            z = 0;
          }
          each(series.data, function (point) {
            var shapeArgs = point.shapeArgs,
              angle;
            point.shapeType = "arc3d";
            var ran = point.options.h;
            shapeArgs.z = z;
            shapeArgs.depth = depth * 0.75 + ran;
            shapeArgs.alpha = alpha;
            shapeArgs.beta = beta;
            shapeArgs.center = series.center;
            shapeArgs.ran = ran;
            angle = (shapeArgs.end + shapeArgs.start) / 2;
            point.slicedTranslation = {
              translateX: round(
                cos(angle) * seriesOptions.slicedOffset * cos(alpha * deg2rad)
              ),
              translateY: round(
                sin(angle) * seriesOptions.slicedOffset * cos(alpha * deg2rad)
              ),
            };
          });
        }
      );
 
      highcharts.chart("echartsid", {
        chart: {
          animation: false,
          backgroundColor: "none",
          type: "pie", //饼图
          margin: [0, 0, 0, 0],
          options3d: {
            enabled: true, //使用3d功能
            alpha: 58, //延y轴向内的倾斜角度
            beta: 0,
          },
          events: {
            load: function () {
              var each = highcharts.each,
                points = this.series[0].points;
              each(points, function (p, i) {
                p.graphic.attr({
                  translateY: -p.shapeArgs.ran,
                });
                p.graphic.side1.attr({
                  translateY: -p.shapeArgs.ran,
                });
                p.graphic.side2.attr({
                  translateY: -p.shapeArgs.ran,
                });
              });
            },
          },
        },
        legend: {
          enabled: false, // 关闭图例
          align: "right", //水平方向位置
          verticalAlign: "top", //垂直方向位置
          layout: "vertical",
          x: -20,
          y: 30,
          show:false,
          symbolWidth: 10,
          symbolHeight: 10,
          symbolRadius: "50%", // 修改成圆
          itemMarginBottom: 8,
          useHTML: true,
          //labelFormat: '{name}&nbsp;&nbsp;&nbsp;&nbsp;{y}',
          labelFormatter: function () {
            return (
              '<div style="width: .3125rem;display: inline-block">' +
              this.name +
              ':&nbsp;&nbsp;</div><div style="color: #00d7da;display: inline-block">' +
              this.y +
              "</div>"
            );
          },
          itemStyle: {
            color: "#f4f4f6",
            fontSize: 12,
          },
        },
        title: {
          // enabled: false,
          text: "",
        },
        subtitle: {
          text: "",
        },
        plotOptions: {
          pie: {
            allowPointSelect: false, // 禁用点击
            cursor: "pointer",
            depth: 0,
            showInLegend: true,
            size: "35%", // 外圈直径大小
            innerSize: 90, // 内圈直径大小
            center: ["30%", "50%"],
            colors: [
              "rgb(22,147,39)",
              "rgb(234,219,54)",
              "rgb(12,214,137)",
              "rgb(25,234,219)",
              "rgb(13,145,239)",
              "rgb(167,67,234)",
            ],
            dataLabels: {
              useHTML: true,
              enabled: false, //是否显示饼图的线形tip
              distance: 5,
              borderColor: '#007acc',
              align: "center",
              // verticalAlign: 'top',
              position: "right",
              format: "{point.bfb}%",
              // formatter: (point,b) => {
              //   console.log(point,'ponit-->>')
              //   console.log(b,'ponit-->>')
              // },
              color: "#ffffff",
              style: {
                textOutline: "none",
                fontSize: 13,
              },
            },
          },
        },
        credits: {
          enabled: false, // 禁用版权信息
        },
        series: [
          {
            type: "pie",
            name: "数量",
            data: this.dataList,
          },
        ],
      });
    },
  },
};
</script>