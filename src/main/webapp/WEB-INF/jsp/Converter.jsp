<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.example.CurrencyConverterApp.data.CcyAmt" %>
<%@page import="com.example.CurrencyConverterApp.data.ConversionCurrency" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Currency Converter</title>
    </head>
    <body>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">Currency Converter</h1>
    </div>
</div>
<%
    ConversionCurrency currency = (ConversionCurrency) request.getAttribute("currency");
%>

<form method="POST" action="result">
<div class="col-md-4">
  <label for="fromcurrencies">From:</label><br>
  <select name="from" id="fromcurrencies">

  <%
        List<CcyAmt> list = (List<CcyAmt>) request.getAttribute("list");
        for(CcyAmt ccyAmt : list) {
  %>
        <option name="from" value="<%=ccyAmt.getCcy()%>"><%=ccyAmt.getCcy()%></option>
  <%
        }
  %>

  </select>
  <br><br>
  <label for="tocurrencies">To:</label><br>
  <select name="to" id="tocurrencies">

  <%
        List<CcyAmt> list1 = (List<CcyAmt>) request.getAttribute("list");
        for(CcyAmt ccyAmt : list1) {
  %>
        <option name="to" value="<%=ccyAmt.getCcy()%>"><%=ccyAmt.getCcy()%></option>
  <%
        }
  %>

  </select>
  <br><br>
  </div>
  <div class="col-md-2">
              <div>
                  <input name="value" value="">
              </div>
              <br>
              <div>
              <input type="submit" value="Convert">

              </div>
          </div>
          </form>

          <div class="col-md-4">
          <br>


                      <h3 id="convertResult"></h3>
                  </div>





    </body>
</html>