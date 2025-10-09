package com.myj.shopping.utils.bean;

import javax.validation.constraints.NotNull;

/**
 * 分页
 */

public class CommonQueryBean {

    //每页数量
    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;

    //页数
    @NotNull(message = "页数不能为空")
    private Integer pageNum;

    //起始
    private Integer start;

    /**
     *返回
     */
    //总数量
    private Integer total;
    //总页数
    private Integer totalPage;


    public static Integer calculateTotalPage(CommonQueryBean commonQueryBean){
        if(commonQueryBean!=null && commonQueryBean.getPageSize()!=null){
            if(commonQueryBean.getTotal()%commonQueryBean.getPageSize()!=0){
                return commonQueryBean.getTotal()/commonQueryBean.getPageSize()+1;
            }else{
                return commonQueryBean.getTotal()/commonQueryBean.getPageSize();
            }
        }
        return -1;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


    @Override
    public String toString() {
        return "CommonQueryBean{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", start=" + start +
                ", total=" + total +
                ", totalPage=" + totalPage +
                '}';
    }
}
