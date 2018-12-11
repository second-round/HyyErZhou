package com.example.day13.bean;
import java.util.List;
public class UserBean {
    private List<DataBean> data;
    public List<DataBean> getData() {
        return data;
    }
    public void setData(List<DataBean> data) {
        this.data = data;
    }
    public static class DataBean {
        private int cid;
        private String createtime;
        private String icon;
        private int ishome;
        private String name;
        public int getCid() {
            return cid;
        }
        public void setCid(int cid) {
            this.cid = cid;
        }
        public String getCreatetime() {
            return createtime;
        }
        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }
        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
        public int getIshome() {
            return ishome;
        }
        public void setIshome(int ishome) {
            this.ishome = ishome;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}