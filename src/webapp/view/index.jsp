<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>EFAS</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/echarts.min.js"></script>
    <link rel="stylesheet" href="/css/MainFrame.css"/>
    <script type="text/javascript">
        window.onload = function () {
            var errorInfo = "${errorInfo}";
            console.log(errorInfo);
        };
        function searchEnterprise() {
            var searchInput = document.getElementById("searchText").value;
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
                    else{
                        var enterpriseInformation = result.object[0];
                        console.log(enterpriseInformation);
                        var addr = enterpriseInformation.addr;
                        var admitMain = enterpriseInformation.admitMain;
                        var belongDistOrg = enterpriseInformation.belongDistOrg;
                        var belongOrg = enterpriseInformation.belongOrg;
                        var belongTrade = enterpriseInformation.belongTrade;
                        var checkDate = enterpriseInformation.checkDate;
                        var corpName = enterpriseInformation.corpName;
                        var corpStatus = enterpriseInformation.corpStatus;
                        var econKind = enterpriseInformation.econKind;
                        var email = enterpriseInformation.email;
                        var englishName = enterpriseInformation.englishName;
                        var fareScope = enterpriseInformation.fareScope;
                        var operManIdentNo = enterpriseInformation.operManIdentNo;
                        var operManName = enterpriseInformation.operManName;
                        var orgInstCode = enterpriseInformation.orgInstCode;
                        var regCapi = enterpriseInformation.regCapi;
                        var regNo = enterpriseInformation.regNo;
                        var staffSize = enterpriseInformation.staffSize;
                        var taxpayNum = enterpriseInformation.taxpayNum;
                        var tel = enterpriseInformation.tel;
                        var webUrl = enterpriseInformation.webUrl;
                        var startDate = enterpriseInformation.startDate;
                        var uniScid = enterpriseInformation.uniScid;
                        var fareTermStart = enterpriseInformation.fareTermStart;
                        var fareTermEnd = enterpriseInformation.fareTermEnd;
                        var formerName = enterpriseInformation.formerName;

                        sessionStorage.setItem("fareTermStart",fareTermStart);
                        sessionStorage.setItem("fareTermEnd",fareTermEnd);
                        sessionStorage.setItem("formerName",formerName);

                        sessionStorage.setItem("uniScid",uniScid);
                        sessionStorage.setItem("startDate",startDate);
                        sessionStorage.setItem("addr",addr);
                        sessionStorage.setItem("admitMain",admitMain);
                        sessionStorage.setItem("belongDistOrg",belongDistOrg);
                        sessionStorage.setItem("belongOrg",belongOrg);
                        sessionStorage.setItem("belongTrade",belongTrade);
                        sessionStorage.setItem("checkDate",checkDate);
                        sessionStorage.setItem("corpName",corpName);
                        sessionStorage.setItem("corpStatus",corpStatus);
                        sessionStorage.setItem("econKind",econKind);
                        sessionStorage.setItem("email",email);
                        sessionStorage.setItem("englishName",englishName);
                        sessionStorage.setItem("fareScope",fareScope);
                        sessionStorage.setItem("operManIdentNo",operManIdentNo);
                        sessionStorage.setItem("operManName",operManName);
                        sessionStorage.setItem("orgInstCode",orgInstCode);
                        sessionStorage.setItem("regCapi",regCapi);
                        sessionStorage.setItem("regNo",regNo);
                        sessionStorage.setItem("staffSize",staffSize);
                        sessionStorage.setItem("taxpayNum",taxpayNum);
                        sessionStorage.setItem("tel",tel);
                        sessionStorage.setItem("webUrl",webUrl);

                        window.location.href = "/corpInfo";
                    }
                },
                error:function (msg) {
                    alert("msg: "+msg);
                }
            });
        }
    </script>
</head>
<body>
<div id="searchDiv" style="width: 500px;height: 200px;position:absolute;left:50%;top:50%;transform: translate(-50%,-50%);text-align: center">
    <input type="text" id="searchText"/>
    <button id="searchButton" value="搜索" onclick=searchEnterprise()>搜索</button>
</div>
</body>
</html>
