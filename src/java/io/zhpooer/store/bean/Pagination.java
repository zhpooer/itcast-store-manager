package io.zhpooer.store.bean;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Pagination {
    private int pageno; // 页码
    private int numberPerPage = 10; // 每页记录条数
    private Map<String, String[]> parameterMap;// request 提供的方法

    // 结果显示数据
    private long totalCount; // / 总记录数
    private int totalPageCount; // 总页数

    private List<?> data; // 当前显示数据

    public String getParamUrl() {
        String paramUrl = "";
        for (Entry<String, String[]> en : parameterMap.entrySet()) {
            for(String v : en.getValue()){
                if(paramUrl!="") paramUrl += "&";
                paramUrl += en.getKey() + "=" + v; 
            }
        }
        return paramUrl;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(int numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
