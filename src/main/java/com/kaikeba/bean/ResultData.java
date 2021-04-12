package com.kaikeba.bean;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Gyx
 * @Date: 2021/2/25 22:15
 */
@Component("resultData")
public class ResultData<T> {

    /**
     *   每次查询的数据集合
     */
    private List<T> rows = new ArrayList<>();

    /**
     * 总数量
     */
    private int total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
