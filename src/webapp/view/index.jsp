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
            var errorInfo = "${errorInfo}";
            console.log(errorInfo);
        };
        function search(){
            sessionStorage.setItem("corp",document.getElementById("searchText").value);
            window.location.href="/corpList";
            sessionStorage.setItem("curPage",1);
        };
    </script>
</head>
<body>
<div id="searchDiv" style="width: 500px;height: 200px;position:absolute;left:50%;top:50%;transform: translate(-50%,-50%);text-align: center">
    <%--<form>--%>
        <datalist id="enterList"></datalist>
        <input type="text" id="searchText" onkeyup="getAllEnters()" list="enterList"/>
        <button id="searchButton" value="搜索" onclick="search()">搜索</button>
    <%--</form>--%>
</div>
</body>
</html>
