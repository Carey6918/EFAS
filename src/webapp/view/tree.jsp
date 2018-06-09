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
    <div id="inner" style="height:400px;"></div>
    <br>
    <div id="outer" style="height:400px;"></div>
    <script type="text/javascript">
        var inner = echarts.init(document.getElementById('inner'));
        inner.showLoading();
        $.get('/inner?org=876&id=120000&seqId=99', function (data) {
            inner.hideLoading();

            echarts.util.each(data.children, function (datum, index) {
                index % 2 === 0 && (datum.collapsed = true);
            });

            inner.setOption(option = {
                title: {
                    text: 'inner'
                },
                tooltip: {
                    trigger: 'item',
                    triggerOn: 'mousemove'
                },
                series: [
                    {
                        type: 'tree',

                        data: [data],

                        top: '1%',
                        left: '7%',
                        bottom: '1%',
                        right: '20%',

                        symbolSize: 7,

                        label: {
                            normal: {
                                position: 'left',
                                verticalAlign: 'middle',
                                align: 'right',
                                fontSize: 9
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
    <script type="text/javascript">
        var outer = echarts.init(document.getElementById('outer'));
        outer.showLoading();
        $.get('/outer?org=876&id=120000&seqId=99', function (data) {
            outer.hideLoading();

            echarts.util.each(data.children, function (datum, index) {
                index % 2 === 0 && (datum.collapsed = true);
            });

            outer.setOption(option = {
                title: {
                    text: 'outer'
                },
                tooltip: {
                    trigger: 'item',
                    triggerOn: 'mousemove'
                },
                series: [
                    {
                        type: 'tree',

                        data: [data],

                        top: '1%',
                        left: '7%',
                        bottom: '1%',
                        right: '20%',

                        symbolSize: 7,

                        label: {
                            normal: {
                                position: 'left',
                                verticalAlign: 'middle',
                                align: 'right',
                                fontSize: 9
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
