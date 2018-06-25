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
</head>
<body>
<div id="searchDiv" style="text-align: center;height:auto;">
    <datalist id="enterList"></datalist>
    <input type="text" id="searchText" onkeyup="getAllEnters()" list="enterList" style="font-size: 14px;"/>
    <button id="searchButton" value="搜索" onclick="search()">搜索</button>
</div>
<div id="enterListDiv" style="margin-top:20px;"></div>
<div id="bottomDiv" style="text-align: center;margin-bottom:40px;margin-top:40px">
    <input type="button" id="backPage" value="往前一页" onclick="backOne()" />
    <input type="button" id="frontPage" value="往后一页" onclick="frontOne()" />
</div>
<script>
    var arr = [];
    var len = 0;
    window.onload = divide();
    function search(){
        var text = document.getElementById("searchText").value;
        if(text!=null&&text!=""){
            sessionStorage.setItem("corp", text);
            window.location.href = "/corpList";
        }
        else {
            alert("输入不能为空");
        }
    };
    function divide(){
        sessionStorage.setItem("curPage",1);
        var searchInput = sessionStorage.getItem("corp");
        $("#searchText").val(searchInput);
        $.ajax({
            type: "get",
            async: false,
            url: "../search",
            dataType: "json",
            data: {"name": searchInput},
            success: function (result) {
                var judge = result.isSuccess;
                var errorMessage = result.errorInfo;
                if (errorMessage != null) {
                    alert(errorMessage);
                }
                else {
                    len = result.object.length;
                    for(var i=0;i<len;i++){
                        arr[i]=result.object[i];
                    }
                    var curPage = sessionStorage.getItem("curPage");
                    var div = dividePage(len,curPage,10);
                    $("#enterListDiv").empty();
                    $("#enterListDiv").append(div);
                }
            }
        });
    };

    function backOne() {
        var curPage = sessionStorage.getItem("curPage");
        var newPage = parseInt(curPage)-parseInt(1);
        sessionStorage.setItem("curPage",newPage);
        var div = dividePage(len,newPage,10);
        $("#enterListDiv").empty();
        $("#enterListDiv").append(div);
    };
    function frontOne() {
        var curPage = sessionStorage.getItem("curPage");
        var newPage = parseInt(curPage)+parseInt(1);
        sessionStorage.setItem("curPage",newPage);
        var div = dividePage(len,newPage,10);
        $("#enterListDiv").empty();
        $("#enterListDiv").append(div);
    };
    function dividePage(len,curPage,psize){
        var div = document.createElement("div");
        div.style.textAlign="center";
        div.style.marginLeft="450px";
        var pages = parseInt(len/psize)+1;
        var edge = 0;

        if(pages==1){
            edge = len%psize;
            document.getElementById("backPage").style.display="none";
            document.getElementById("frontPage").style.display="none";
        }
        else{
            edge = curPage*psize;
            if(curPage==1){
                document.getElementById("backPage").style.display="none";
            }
            else{
                document.getElementById("backPage").style.display="";
            }
            if(curPage==pages){
                edge = len%psize+(curPage-1)*psize;
                document.getElementById("frontPage").style.display="none";
            }
            else{
                document.getElementById("frontPage").style.display="";
            }
        }

        for (var i = (curPage-1)*psize; i < edge; i++) {
            var indiv = document.createElement("div");
            indiv.style.textAlign = "left";

            var corpName = arr[i].corpName;
            var corpStatus = arr[i].corpStatus;//经营状态
            var regCapi = arr[i].regCapi;//注册资本
            var startDate = arr[i].startDate;//注册日期
            var tel = arr[i].tel;//联系电话
            var belongDistOrg = arr[i].belongDistOrg;//所属地区
            var corpState = [];

            if (corpStatus == "01") {
                corpState = "在业";
            }
            else if (corpStatus == "02") {
                corpState = "注销";
            }
            else if (corpStatus == "03") {
                corpState = "吊销";
            }
            else if (corpStatus == "04") {
                corpState = "迁出";
            }
            indiv.innerHTML = '<input type="button" ' + ' id="' + i + '"' + ' style="outline:none;font-size: 18px;border:0px;margin:0;padding:0;cursor:hand"' + '  value="' + corpName + '" onclick="selectOneEnter(this)"/>'
                + '<Button style="outline: none;color:rgb(255,215,80);background-color:white;border-color:rgb(255,215,80)">' + corpState + '</Button>' +
                '<br><label style="font-size: 12px">注册资本:' + regCapi + '</label><br>' +
                '<label style="font-size: 12px">注册时间:' + startDate + '</label><br>' +
                '<label style="font-size: 12px">联系电话:' + tel + '</label><br>' +
                '<label style="font-size: 12px">所属地区:' + belongDistOrg + '</label>';
            var leftDiv = document.createElement("div");
            leftDiv.innerHTML='<img src="/css/iii.png" alt="暂无图片"/> ';

            var pdiv = document.createElement("table");
            var tr = document.createElement("tr");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            td1.append(leftDiv);
            indiv.style.marginLeft="15px";
            td2.append(indiv);
            tr.append(td1);
            tr.append(td2);
            pdiv.append(tr);
            pdiv.style.marginBottom="25px";
            div.append(pdiv);
        }
        return div;
    }
    function selectOneEnter(obj) {
        sessionStorage.setItem("index",obj.id);
        searchEnterprise();
    };
</script>
</body>
</html>
