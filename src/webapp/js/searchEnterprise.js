/**
 * Created by guagua on 18/6/9.
 */
function searchEnterprise() {
    var searchInput = sessionStorage.getItem("corp");
    console.log(searchInput);
    var index = sessionStorage.getItem("index");
    console.log(index);
    $.ajax({
        type: "get",
        async: false,
        url: "../search",
        dataType: "json",
        data: {"name": searchInput},
        success: function (result) {
            var enterpriseInformation = result.object[index];
            console.log(enterpriseInformation);
            var org = enterpriseInformation.corpKey.org;
            var id = enterpriseInformation.corpKey.id;
            var seqId = enterpriseInformation.corpKey.seqId;
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

            sessionStorage.setItem("org",org);
            sessionStorage.setItem("id",id);
            sessionStorage.setItem("seqId",seqId);
            sessionStorage.setItem("fareTermStart", fareTermStart);
            sessionStorage.setItem("fareTermEnd", fareTermEnd);
            sessionStorage.setItem("formerName", formerName);

            sessionStorage.setItem("uniScid", uniScid);
            sessionStorage.setItem("startDate", startDate);
            sessionStorage.setItem("addr", addr);
            sessionStorage.setItem("admitMain", admitMain);
            sessionStorage.setItem("belongDistOrg", belongDistOrg);
            sessionStorage.setItem("belongOrg", belongOrg);
            sessionStorage.setItem("belongTrade", belongTrade);
            sessionStorage.setItem("checkDate", checkDate);
            sessionStorage.setItem("corpName", corpName);
            sessionStorage.setItem("corpStatus", corpStatus);
            sessionStorage.setItem("econKind", econKind);
            sessionStorage.setItem("email", email);
            sessionStorage.setItem("englishName", englishName);
            sessionStorage.setItem("fareScope", fareScope);
            sessionStorage.setItem("operManIdentNo", operManIdentNo);
            sessionStorage.setItem("operManName", operManName);
            sessionStorage.setItem("orgInstCode", orgInstCode);
            sessionStorage.setItem("regCapi", regCapi);
            sessionStorage.setItem("regNo", regNo);
            sessionStorage.setItem("staffSize", staffSize);
            sessionStorage.setItem("taxpayNum", taxpayNum);
            sessionStorage.setItem("tel", tel);
            sessionStorage.setItem("webUrl", webUrl);

            window.location.href="/corpInfo";

        },
        error: function (msg) {
            alert("msg: " + msg);
        }
    });
}
function getAllEnters() {
    $("#enterList").empty();
    var searchInput = document.getElementById("searchText").value;
    var source = new Array();
    $.ajax({
        type: "get",
        async: false,
        url: "../search",
        dataType: "json",
        data: {"name": searchInput},
        success: function (result) {
            var judge = result.isSuccess;
            var errorMessage = result.errorInfo;
            if (errorMessage == null) {
                var len = result.object.length;
                for(var i=0;i<len;i++){
                    source.push(result.object[i].corpName);
                }
                console.log(source);
                for(var i=0;i<len;i++){
                    $("#enterList").append('<option value="'+source[i]+'"></option>');
                }
            }
        }
    });
};