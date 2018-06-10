<%--
  Created by IntelliJ IDEA.
  User: qianzhihao
  Date: 2018/6/9
  Time: 上午11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>tree</title>
    <script src="../js/echarts/echarts.js"></script>

    <%--<script src="../js/echarts/chart/force.js"></script>--%>
    <script src="../js/jquery.min.js"></script>
</head>
<body>
    <div id="relation" style="height:400px;"></div>
    <script type="text/javascript">
        require.config({
            paths: {
                echarts: '../js/echarts'
            }
        });
        require(
            [
                'echarts',
                'echarts/chart/force'
            ],
            function (ec) {
                var myChart = ec.init(document.getElementById('relation'));
                $.get('/relation?org=876&id=120000&seqId=99', function (data) {
                    option = {
                        title: {
                            text: '疑似关系图',
                            subtext: 'subtext',
                            x: 'right',
                            y: 'bottom'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} : {b}'
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                restore: {show: true},
                                magicType: {show: true, type: ['force', 'chord']},
                                saveAsImage: {show: true}
                            }
                        },
                        legend: {
                            x: 'left',
                            data: ['家人', '朋友']
                        },
                        series: [
                            {
                                type: 'force',
                                name: "人物关系",
                                ribbonType: false,
                                categories: [
                                    {
                                        name: '人物'
                                    },
                                    {
                                        name: '家人',
                                        symbol: 'diamond'
                                    },
                                    {
                                        name: '朋友'
                                    }
                                ],
                                itemStyle: {
                                    normal: {
                                        label: {
                                            show: true,
                                            textStyle: {
                                                color: '#333'
                                            }
                                        },
                                        nodeStyle: {
                                            brushType: 'both',
                                            borderColor: 'rgba(255,215,0,0.4)',
                                            borderWidth: 1
                                        }
                                    },
                                    emphasis: {
                                        label: {
                                            show: false
                                            // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                                        },
                                        nodeStyle: {
                                            //r: 30
                                        },
                                        linkStyle: {}
                                    }
                                },
                                minRadius: 15,
                                maxRadius: 25,
                                gravity: 1.1,
                                scaling: 1.2,
                                draggable: false,
                                linkSymbol: 'arrow',
                                steps: 10,
                                coolDown: 0.9,
                                //preventOverlap: true,
                                nodes:
                                    data.nodeList
                                ,
                                links:
                                    data.linkList
                            }
                        ]
                    };
                    var ecConfig = require('echarts/config');

                    function focus(param) {
                        var data = param.data;
                        var links = option.series[0].links;
                        var nodes = option.series[0].nodes;
                        if (
                            data.source != null
                            && data.target != null
                        ) { //点击的是边
                            var sourceNode = nodes.filter(function (n) {
                                return n.name == data.source
                            })[0];
                            var targetNode = nodes.filter(function (n) {
                                return n.name == data.target
                            })[0];
//                            console.log("选中了边 " + sourceNode.name + ' -> ' + targetNode.name + ' (' + data.weight + ')');
                        } else { // 点击的是点
//                            console.log("选中了" + data.name + '(' + data.value + ')');
                        }
                    }

                    myChart.on(ecConfig.EVENT.CLICK, focus)

//                    myChart.on(ecConfig.EVENT.FORCE_LAYOUT_END, function () {
//                        console.log(myChart.chart.force.getPosition());
//                    });

                    myChart.setOption(option);
                })
            }
        );
    </script>
</body>
</html>
