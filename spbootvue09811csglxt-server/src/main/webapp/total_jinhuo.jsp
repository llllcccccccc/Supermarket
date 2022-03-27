
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
        <tr style="text-align:center">
            <th>总进货金额</th>
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
                    double jintianyingyee = Query.make("jinhuo")
                            .where(where1)
                            .sum("jinhuoxiaoji");

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
    List<HashMap> list = Query.make("jinhuo").field("fenlei , COUNT(*) count ,gongyingshangmingcheng, SUM(jinhuoshuliang) jinhuoshuliang , SUM(jinhuoxiaoji) jinhuoxiaoji")
            .where(where)
            .group("fenlei")
            .order("SUM(jinhuoshuliang) desc")
            .select();
%>


<table class="table">
    <thead>
    <tr>

        <th>商品分类</th>
        <th>供应商</th>
        <th>进货数量</th>
        <th>进货次数</th>
        <th>进货金额</th>
    </tr>
    </thead>
    <tbody>
    <%for (HashMap map:list)  {%>
    <tr>

        <td>
            <%  Map mapcangkufenlei = Query.make("shangpinfenlei").where("id" , map.get("fenlei")).find(); %><%=mapcangkufenlei.get("fenlei")%>
        </td>
        <td><%=map.get("gongyingshangmingcheng")%></td>
        <td><%=map.get("jinhuoshuliang")%></td>
        <td><%=map.get("count")%></td>
        <td><%=map.get("jinhuoxiaoji")%></td>
    </tr>
    <% } %>
    </tbody>



</table>
<div id="container" style="max-width:800px;height:400px"></div>
<script>
    var chart = Highcharts.chart('container', {
        credits: {
            enabled: false , // 禁用版权信息
            text: 'HCharts.cn',
            href: 'http://www.hcharts.cn'
        },

        chart: {
            type: 'bar'
        },

        title: {
            text: '商品进货数据分析'
        },
        subtitle: {
            text: ''
        },

        yAxis: {
            title: {
                text: '数量',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' 数量'
        },
        xAxis:{
            title:{
                text:'商品'
            },

            categories:[
                <% for(HashMap map : list){ %>
                ' <%  Map mapcangkufenlei = Query.make("shangpinfenlei").where("id" , map.get("fenlei")).find(); %><%=mapcangkufenlei.get("fenlei")%>',
                <% } %>

            ]

        },
        /*
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },
        */
        plotOptions: {
            series: {
                label: {
                    connectorAllowed: false
                },
                // pointStart: 2010
            }
        },
        series: [{
            name: '进货数量',
            data: [
                <% for(HashMap map : list){ %>
                <%=map.get("jinhuoshuliang")%>,
                <% } %>
            ]
        }],
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });
</script>

<% //} %>
</body>
</html>
