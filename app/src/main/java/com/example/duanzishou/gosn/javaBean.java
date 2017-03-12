package com.example.duanzishou.gosn;


import java.util.List;

public class javaBean {

    /**
     * code : 200
     * info :
     * data : [{"item_id":1,"item_title":"北京白马商贸会议启动仪式","item_time":"01-01 10:00","source_from":"易会","poster_img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png","act_place":"解放路123#222"},{"item_id":1,"item_title":"北京白马商贸会议启动仪式","item_time":"01-01 10:00","source_from":"易会","poster_img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png","act_place":"解放路123#222"},{"item_id":1,"item_title":"北京白马商贸会议启动仪式","item_time":"01-01 10:00","source_from":"易会","poster_img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png","act_place":"解放路123#222"}]
     */

    private int code;
    private String info;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * item_id : 1
         * item_title : 北京白马商贸会议启动仪式
         * item_time : 01-01 10:00
         * source_from : 易会
         * poster_img : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png
         * act_place : 解放路123#222
         */

        private int item_id;
        private String item_title;
        private String item_time;
        private String source_from;
        private String poster_img;
        private String act_place;

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        public String getItem_title() {
            return item_title;
        }

        public void setItem_title(String item_title) {
            this.item_title = item_title;
        }

        public String getItem_time() {
            return item_time;
        }

        public void setItem_time(String item_time) {
            this.item_time = item_time;
        }

        public String getSource_from() {
            return source_from;
        }

        public void setSource_from(String source_from) {
            this.source_from = source_from;
        }

        public String getPoster_img() {
            return poster_img;
        }

        public void setPoster_img(String poster_img) {
            this.poster_img = poster_img;
        }

        public String getAct_place() {
            return act_place;
        }

        public void setAct_place(String act_place) {
            this.act_place = act_place;
        }
    }
}