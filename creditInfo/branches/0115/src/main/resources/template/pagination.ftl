<#if _cur_page_num lt 1>
<#assign _cur_page_num = 1>
</#if>
<#if _cur_page_num gt _total_pages>
<#assign _cur_page_num = _total_pages>
</#if>
<div class="hx-table-paging-wrap" style="width:815px;">
  <ul class="hx-table-paging clearfix">
<#if _has_prev>
    <li class="hx-table-paging-home">
      <a href="?${_page_param_name}=1&${_page_size_param_name}=${_page_size}${_query_string}"></a>
    </li>
    <li class="hx-table-paging-prev">
      <a href="?${_page_param_name}=${_cur_page_num-1}&${_page_size_param_name}=${_page_size}${_query_string}"></a>
    </li>
<#else>
    <li class="hx-table-paging-home"></li>
    <li class="hx-table-paging-prev"></li>
</#if>
<#if _has_next>
    <li class="hx-table-paging-next">
      <a href="?${_page_param_name}=${_cur_page_num+1}&${_page_size_param_name}=${_page_size}${_query_string}"></a>
    </li>
    <li class="hx-table-paging-tail">
      <a href="?${_page_param_name}=${_total_pages}&${_page_size_param_name}=${_page_size}${_query_string}"></a>
    </li>
<#else>
    <li class="hx-table-paging-next"></li>
    <li class="hx-table-paging-tail"></li>
</#if>
    <li class="hx-table-paging-jumpFlag">
      <input type="text" class="hx-table-paging-jump" id="_go_${_pagination_id}" />
      <a class="hx-table-paging-go" onclick="go_${_pagination_id}()"></a> </li>
    <li>共<span class="hx-table-paging-totData" >${_total_data_size}</span>条数据 <span class="hx-table-paging-curPage">${_cur_page_num}</span>/<span class="hx-table-paging-totPage">${_total_pages}</span>页 </li>
    <li class="format"><span>每页</span>
      <select class="hx-table-paging-eachPage" id="_select_${_pagination_id}" onchange="change_${_pagination_id}(this.value)">
<#assign page_seq = [5,10,20,50,100]>
<#list page_seq as item>
        <option value="${item}" <#if _page_size == item>selected</#if>>${item}</option>
</#list>
      </select>
      <span>条</span> </li>
  </ul>
</div>
<script>
function go_${_pagination_id}(){
	var page=document.getElementById("_go_${_pagination_id}").value;
	location.assign("?${_page_param_name}="+page+"&${_page_size_param_name}=${_page_size}${_query_string}");
}
function change_${_pagination_id}(pagesize){
	location.assign("?${_page_param_name}=${_cur_page_num}&${_page_size_param_name}="+pagesize+"${_query_string}");
}
</script>