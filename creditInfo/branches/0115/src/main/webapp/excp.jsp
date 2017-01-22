<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>跳转提示</title>
<style type="text/css">
*{ padding: 0; margin: 0; }
body{
background-image:url(<s:url value='/images/nhexception.gif'/>);
background-repeat: no-repeat;
background-size:180%;
background: font-family: '微软雅黑'; color: #fff; font-size: 16px; }
.system-message{ padding: 24px 48px; }
.system-message h1{ font-size: 80px; font-weight: normal; line-height: 120px; margin-bottom: 12px }
.system-message h2{ font-size: 60px; font-weight: normal; line-height: 120px; margin-bottom: 12px }
</style>
</head>
<body>
<div class="system-message">
<h1>你的缘分与你擦肩而过了！！！</h1>
<h2>静待缘分吧...</h2>
</div>
</body>
</html>