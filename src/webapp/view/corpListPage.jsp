<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/6/9
  Time: 下午1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EFAS</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/echarts.min.js"></script>
    <script type="text/javascript" src="/js/searchEnterprise.js"></script>
    <link rel="stylesheet" href="/css/MainFrame.css"/>
    <script>
        window.onload = function (){
            var searchInput = sessionStorage.getItem("corp");
            $("#searchText").val(searchInput);
            console.log("searchInput:"+searchInput);
            $.ajax({
                type: "get",
                async: false,
                url: "../search",
                dataType: "json",
                data: {"name": searchInput},
                success: function (result) {
                    console.log(result.isSuccess);
                    console.log(result.errorInfo);
                    var judge = result.isSuccess;
                    var errorMessage = result.errorInfo;
                    if (errorMessage != null) {
                        alert(errorMessage);
                    }
                    else {
                        var len = result.object.length;
                        console.log(len);
                        var div = document.createElement("div");
                        div.style.textAlign="center";

                        for(var i=0;i<len;i++) {
                            var indiv = document.createElement("div");
                            indiv.style.textAlign="left";
                            indiv.style.border="3px";
                            indiv.style.borderColor="#9c9c9c";
                            indiv.style.width="800px";
                            indiv.style.marginLeft="500px";

                            var corpName = result.object[i].corpName;
                            var corpStatus = result.object[i].corpStatus;//经营状态
                            var regCapi = result.object[i].regCapi;//注册资本
                            var startDate = result.object[i].startDate;//注册日期
                            var tel = result.object[i].tel;//联系电话
                            var belongDistOrg = result.object[i].belongDistOrg;//所属地区
                            var corpState = [];

                            if(corpStatus=="01"){
                                corpState = "在业";
                            }
                            else if (corpStatus=="02"){
                                corpState = "注销";
                            }
                            else if (corpStatus=="03"){
                                corpState = "吊销";
                            }
                            else if (corpStatus=="04"){
                                corpState = "迁出";
                            }
                            indiv.innerHTML='<p></p><input type="button"'+'id="'+i+'"'+' style="outline:none;font-size: 18px;border:0px;margin:0;padding:0;text-decoration: none" value="'+corpName+'" onclick="selectOneEnter(this)"/>'
                                +'<Button style="outline: none;color:rgb(255,215,80);backroung-color:white;border-color:rgb(255,215,80)">'+corpState+'</Button>' +
                                '<p></p><label style="font-size: 12px">注册资本:'+regCapi+'</label><p style="font-size: 5px"></p>' +
                                '<label style="font-size: 12px">注册时间:'+startDate+'</label><p style="font-size: 5px"></p>' +
                                '<label style="font-size: 12px">联系电话:'+tel+'</label><p style="font-size: 5px"></p>' +
                                '<label style="font-size: 12px">所属地区:'+belongDistOrg+'</label>';
                            div.append(indiv);
                        }
                        $("#enterListDiv").append(div);
                    }
                }
            });
        };
        function selectOneEnter(obj) {
          sessionStorage.setItem("index",obj.id);
          searchEnterprise();
        };
    </script>
</head>
<body>
<div id="searchDiv" style="text-align: center;height:auto;">
    <datalist id="enterList"></datalist>
    <input type="text" id="searchText" onkeyup="getAllEnters()" list="enterList" style="font-size: 14px;"/>
    <button id="searchButton" value="搜索" onclick="searchEnterprise()">搜索</button>
</div>
<div id="enterListDiv">
</div>
</body>
</html>
