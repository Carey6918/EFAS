<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/6/3
  Time: 下午8:06
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
    <script type="text/javascript">
        window.onload = function () {

            var addr = sessionStorage.getItem("addr");
            var admitMain = sessionStorage.getItem("admitMain");
            var belongDistOrg = sessionStorage.getItem("belongDistOrg");
            var belongOrg = sessionStorage.getItem("belongOrg");
            var belongTrade = sessionStorage.getItem("belongTrade");
            var checkDate = sessionStorage.getItem("checkDate");
            var corpName = sessionStorage.getItem("corpName");
            var corpStatus = sessionStorage.getItem("corpStatus");
            var econKind = sessionStorage.getItem("econKind");
            var email = sessionStorage.getItem("email");
            var englishName = sessionStorage.getItem("englishName");
            var fareScope = sessionStorage.getItem("fareScope");
            var operManIdentNo = sessionStorage.getItem("operManIdentNo");
            var operManName = sessionStorage.getItem("operManName");
            var orgInstCode = sessionStorage.getItem("orgInstCode");
            var regCapi = sessionStorage.getItem("regCapi");
            var regNo = sessionStorage.getItem("regNo");
            var staffSize = sessionStorage.getItem("staffSize");
            var taxpayNum = sessionStorage.getItem("taxpayNum");
            var tel = sessionStorage.getItem("tel");
            var webUrl = sessionStorage.getItem("webUrl");
            var startDate = sessionStorage.getItem("startDate");
            var uniScid = sessionStorage.getItem("uniScid");
            var fareTermStart = sessionStorage.getItem("fareTermStart");
            var formerName = "无";
            if(!sessionStorage.getItem("formerName")){
                formerName=sessionStorage.getItem("formerName");
            }
            var fareTermEnd = sessionStorage.getItem("fareTermEnd");

            document.getElementById("tel").innerHTML = tel;
            document.getElementById("webUrl").innerHTML = webUrl;
            document.getElementById("addr").innerHTML = addr;
            document.getElementById("email").innerHTML = email;

            document.getElementById("regCapi").innerHTML = regCapi;
            if(startDate==null){
                console.log("无");
                startDate = "无";
            }
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
            if(uniScid==null){
                uniScid="无";
            }
            if(fareTermStart==null){
                fareTermStart="无";
                document.getElementById("zhi").style.display="none";
                document.getElementById("fareTermEnd").style.display="none";
            }
            if(checkDate==null){
                checkDate="无";
            }

            document.getElementById("searchText").value = corpName;
            document.getElementById("startDate").innerHTML = startDate;
            document.getElementById("corpStatus").innerHTML = corpState;
            document.getElementById("regNo").innerHTML = regNo;
            document.getElementById("taxpayNum").innerHTML = taxpayNum;
            document.getElementById("uniScid").innerHTML = uniScid;
            document.getElementById("orgInstCode").innerHTML = orgInstCode;
            document.getElementById("econKind").innerHTML = econKind;
            document.getElementById("staffSize").innerHTML = staffSize;
            document.getElementById("fareTermStart").innerHTML = fareTermStart;
            document.getElementById("fareTermEnd").innerHTML = fareTermEnd;
            document.getElementById("belongOrg").innerHTML = belongOrg;
            document.getElementById("checkDate").innerHTML = checkDate;
            document.getElementById("englishName").innerHTML = englishName;
            document.getElementById("formerName").innerHTML = formerName;
            document.getElementById("belongDistOrg").innerHTML = belongDistOrg;
            document.getElementById("belongTrade").innerHTML = belongTrade;
            document.getElementById("fareScope").innerHTML = fareScope;
        };

        function search(){
            sessionStorage.setItem("corp",document.getElementById("searchText").value);
            window.location.href="/corpList";
        };
    </script>
</head>
<body>
<div id="searchDiv" style="text-align: center;height:auto;">
    <datalist id="enterList"></datalist>
    <input type="text" id="searchText" onkeyup="getAllEnters()" list="enterList" style="font-size: 14px;"/>
    <button id="searchButton" value="搜索" onclick="search()">搜索</button>
</div>
<div style="margin-left:480px;height: auto">
    <h3><label id="name" class="name"></label> </h3>
    <table>
        <tr><label>电话：</label><label id="tel" class="tel"></label></tr><br>
        <tr><label>官网：</label><label id="webUrl" class="webUrl"></label></tr><br>
        <tr><label>地址：</label><label id="addr" class="addr"></label></tr><br>
        <tr><label>邮箱：</label><label id="email" class="email"></label></tr><br>
    </table>
</div>
<div style="text-align: center;margin-top:-180px">
    <table id="colorTable" border="1" cellpadding="0"  style="width: 800px;margin:auto">
        <tr style="height:40px">
            <td bgcolor="#f0f8ff" style="width: 20%"><label style="width:150px;display:inline-block">注册资本：</label></td>
            <td style="width: 30%"><label id="regCapi" class="regCapi"></label></td>
            <td bgcolor="#f0f8ff" style="width: 20%"><label style="width:150px;display:inline-block">成立日期：</label></td>
            <td style="width: 30%"><label id="startDate" class="startDate"></label></td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">经营状态：</label></td>
            <td><label id="corpStatus" class="corpStatus"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">统一社会信用代码：</label></td>
            <td><label id="regNo" class="regNo"></label></td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">纳税人识别号：</label></td>
            <td><label id="taxpayNum" class="taxpayNum"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">注册号：</label></td>
            <td><label id="uniScid" class="uniScid"></label></td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">组织机构代码：</label></td>
            <td><label id="orgInstCode" class="orgInstCode"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">公司类型：</label></td>
            <td><label id="econKind" class="econKind"></label></td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">人员规模：</label></td>
            <td><label id="staffSize" class="staffSize"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">营业期限：</label></td>
            <td>
                <label id="fareTermStart" class="fareTermStart"></label>
                <label id="zhi">至</label>
                <label id="fareTermEnd" class="fareTermEnd"></label>
            </td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">登记机关：</label></td>
            <td><label id="belongOrg" class="belongOrg"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">核准日期：</label></td>
            <td><label id="checkDate" class="checkDate"></label></td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">英文名：</label></td>
            <td><label id="englishName" class="englishName"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">曾用名：</label></td>
            <td><label id="formerName" class="formerName"></label></td>
        </tr>
        </br>
        <tr style="height:40px">
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">所属地区：</label></td>
            <td><label id="belongDistOrg" class="belongDistOrg"></label></td>
            <td bgcolor="#f0f8ff"><label style="width:150px;display:inline-block">所属行业：</label></td>
            <td><label id="belongTrade" class="belongTrade"></label></td>
        </tr>
        </br>
    </table>
    <table style="width: 800px;margin:auto;margin-top:0px">
        <tr style="height:40px">
            <td bgcolor="#f0f8ff" style="width: 20%;"><label style="width:150px;display:inline-block">经营范围：</label></td>
            <td style="width: 80%"><label id="fareScope" class="fareScope"></label></td>
        </tr></br>
    </table>
</div>
<div style="margin-bottom: 50px"><jsp:include page="stockStruction.jsp"/></div>
<div style="margin-bottom: 50px;text-align:center"><jsp:include page="atlas.jsp"/></div>
<div style="margin-bottom: 50px;text-align:center"><jsp:include page="relation.jsp"/></div>
<div style="margin-bottom: 50px;text-align:center"><jsp:include page="tree.jsp"/></div>
</body>
</html>
