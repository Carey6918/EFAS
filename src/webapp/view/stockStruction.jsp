<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/6/21
  Time: 上午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StockStruction</title>
    <script src="/js/echarts.min.js"></script>
    <script src="/js/jquery.min.js"></script>
</head>
<body>
<h3 id="stockstructureH" style="text-align: center;margin-top:40px">股权结构</h3>
<div id="stockDiv" style="text-align: center"></div>
<script type="text/javascript">
    var stock = document.getElementById("stockDiv");
    var corpName = sessionStorage.getItem("corpName");
    var org = sessionStorage.getItem("org");
    var id = sessionStorage.getItem("id");
    var seqId = sessionStorage.getItem("seqId");
    $.get('/stock?&id=' + id + '&org=' + org + '&seqId=' + seqId, function (data) {
        console.log(data);
        if(data.errorInfo!=null){
            document.getElementById("stockstructureH").style.display="none";
        }
        else{
            var result = data.object;
            var len = result.length;
            console.log(len);
            var div = document.createElement("div");
            div.style.textAlign="center";
            div.style.margin="0 auto";
            var pButton = document.createElement("input");
            pButton.setAttribute("type","button");
            pButton.setAttribute("value",corpName);
            pButton.style.width="400px";
            pButton.style.display="block";
            pButton.style.height="55px";
            pButton.style.fontSize="18px";
            pButton.style.borderLeftWidth="6px";
            pButton.style.borderLeftColor="blue";
            pButton.style.textAlign="left";
            pButton.style.margin="0 auto";
            var colorDiv = document.createElement("div");
            colorDiv.style.margin="0 auto";
            colorDiv.innerHTML='<Button style="background-color:#67b995;height:16px;width:16px;border-radius: 4px;"></Button>'+'自然人股东'+'' +
                '<Button style="background-color:#ac8acb;height:16px;width:16px;border-radius: 4px;"></Button>'+ '企业股东'+
                    '<Button style="background-color:#e84c4c;height:16px;width:16px;border-radius: 4px;"></Button>'+'大股东';
            div.append(colorDiv);
            div.append(pButton);
            var childDiv = document.createElement("div");
            childDiv.style.marginLeft="12px";
            for(var i=0;i<len;i++) {
                var cname = result[i].stockName;
                var ccapi = result[i].stockCapi;
                var cper = result[i].stockPercent;
                var ctype = result[i].stockType;
                var cButton = document.createElement("button");
                cButton.style.fontSize="18px";
                cButton.style.textAlign="left";
                cButton.style.display="block";
                cButton.style.width="400px";
                cButton.style.height="55px";
                cButton.style.margin="0 auto";

                cButton.innerHTML=cname+"<br>"+"股权比例："+'<font color="#F9CB54">'+cper+'</font>'
                    +"     "+"认缴金额："+'<font color="#F9CB54">'+ccapi+"元"+'</font>';
                if(ctype=="大股东"){//red
                    cButton.style.borderLeftColor="e84c4c";
                    cButton.style.borderLeftWidth="6px";
                }
                else if(ctype=="自然人"){//green
                    cButton.style.borderLeftColor="#67b995";
                    cButton.style.borderLeftWidth="6px";
                }
                else if(ctype=="企业"){//purple
                    cButton.style.borderLeftColor="ac8acb";
                    cButton.style.borderLeftWidth="6px";
                }
                childDiv.append(cButton);
            }
            var pdiv = document.getElementById("stockDiv");
            div.append(childDiv);
            pdiv.append(div);
        }
    });
</script>
</body>
</html>
