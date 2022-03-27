
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.spring.util.Request" %>
<%@ page import="com.spring.util.Query" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/datepicker/WdatePicker.js"></script>

    <script src="js/highcharts/highcharts.js"></script>
    <script src="js/highcharts/modules/exporting.js"></script>
    <script src="js/highcharts/modules/series-label.js"></script>
    <script src="js/highcharts/modules/oldie.js"></script>
</head>
<body>

<form action="?" method="get">
    开始日期:<input sype="text" name="kaishiriqi" value="<%=Request.get("kaishiriqi")%>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',lang:'zh-cn'})">
    结束日期:<input sype="text" name="jieshuriqi" value="<%=Request.get("jieshuriqi")%>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',lang:'zh-cn'})">
    <button type="submit">提交</button>
</form>

<div  class="">
    <table CLASS="table">
        <thead>
        <tr>
            <th>营收总销售额</th>
        </tr>

        </thead>
        <tbody>
        <tr>
            <td style="text-align: center">
                <%
                    String where1 = "1=1 ";
                    if (!Request.get("kaishiriqi").equals("")) {
                        where1 += " and addtime>='"+Request.get("kaishiriqi")+" 00:00:00' ";
                    }
                    if (!Request.get("jieshuriqi").equals("")) {
                        where1 += " and addtime<='"+ Request.get("jieshuriqi")+" 23:59:59' ";
                    }
                    double jintianyingyee = Query.make("xiaoshou")
                            .where(where1)
                            .sum("xiaoji");

                %>
                <%=jintianyingyee%>
                <!--营业额--></td>






        </tr>
        </tbody>




    </table>

</div>


<%
    //if (Request.get("kaishiriqi").equals("") && !Request.get("jieshuriqi").equals("")){
%>

<%
    String where = "1=1 ";
    if (!Request.get("kaishiriqi").equals("")) {
        where += " and addtime>='"+Request.get("kaishiriqi")+" 00:00:00' ";
    }
    if (!Request.get("jieshuriqi").equals("")) {
        where += " and addtime<='"+Request.get("jieshuriqi")+" 23:59:59' ";
    }
    List<HashMap> list = Query.make("xiaoshou").field("fenlei , COUNT(*) count , SUM(xiaoshoushuliang) xiaoshoushuliang , SUM(xiaoji) xiaoji")
            .where(where)
            .group("fenlei")
            .order("SUM(xiaoji) desc")
            .select();
%>


<table class="table">
    <thead>
    <tr>
        <th>商品分类</th>
        <th>销售数量</th>
        <th>销售次数</th>
        <th>销售金额</th>
    </tr>
    </thead>
    <tbody>
    <%for (HashMap map:list)  {%>
    <tr>
        <td>
            <%  Map mapcangkufenlei = Query.make("shangpinfenlei").where("id" , map.get("fenlei")).find(); %><%=mapcangkufenlei.get("fenlei")%>
        </td>
        <td><%=map.get("xiaoshoushuliang")%></td>
        <td><%=map.get("count")%></td>
        <td><%=map.get("xiaoji")%></td>
    </tr>
    <% } %>
    </tbody>



</table>
<div id="container" style="max-width:800px;height:400px"></div>
<script>
    Highcharts.chart('container', {
        credits: {
            enabled: false , // 禁用版权信息
            text: 'HCharts.cn',
            href: 'http://www.hcharts.cn'
        },
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '商品销售数据分析'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [ <%for (HashMap map:list)  {%>
                {
                    name :'<%  Map mapcangkufenlei = Query.make("shangpinfenlei").where("id" , map.get("fenlei")).find(); %><%=mapcangkufenlei.get("fenlei")%>',
                    y: <%=map.get("xiaoshoushuliang")%>,
                },
                <% } %>

            ]
        }]
    });
</script>

<% //} %>
</body>
</html>
