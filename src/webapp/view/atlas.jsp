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
    <script src="/js/echarts.min.js"></script>
    <script src="/js/jquery.min.js"></script>
</head>
<body>
<h3 style="text-align: center;margin-top:40px">投资图谱</h3>
    <div id="atlas" style="height:400px;text-align: center"></div>
    <script type="text/javascript">
            var atlas = echarts.init(document.getElementById('atlas'));
            atlas.showLoading();
            var org = sessionStorage.getItem("org");
            var id = sessionStorage.getItem("id");
            var seqId = sessionStorage.getItem("seqId");

            $.get('/atlas?&id=' + id + '&org=' + org + '&seqId=' + seqId, function (data) {
                atlas.hideLoading();

                echarts.util.each(data.children, function (datum, index) {
                    index % 2 === 0 && (datum.collapsed = true);
                });

                atlas.setOption(option = {
//                title: {
//                    text: 'atlas'
//                },
                    tooltip: {
                        trigger: 'item',
                        triggerOn: 'mousemove'
                    },
                    series: [
                        {
                            type: 'tree',

                            data: [data.object],

                            top: '0%',
                            left: '23%',
                            bottom: '1%',
                            right: '25%',

                            symbolSize: 7,

                            label: {
                                normal: {
                                    position: 'left',
                                    verticalAlign: 'middle',
                                    align: 'right',
                                    fontSize: 14
                                }
                            },

                            leaves: {
                                label: {
                                    normal: {
                                        position: 'right',
                                        verticalAlign: 'middle',
                                        align: 'left'
                                    }
                                }
                            },

                            expandAndCollapse: true,
                            animationDuration: 550,
                            animationDurationUpdate: 750
                        }
                    ]
                });
            });
    </script>
</body>
</html>
