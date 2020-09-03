package com.example.mydemo.bean;

import com.example.mydemo.entity.BaseResponse;

import java.util.List;

/**
 * @data on 2020/8/31 4:34 PM
 * @auther
 * @describe
 */
public class HomePageResBean extends BaseResponse {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
       // private String children;
        private String courseId;
        private String id;
        private String name;
        private String order;
        private String parentChapterId;
        private String userControlSetTop;
        private String visible;

//        public String getChildren() {
//            return children;
//        }
//
//        public void setChildren(String children) {
//            this.children = children;
//        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getParentChapterId() {
            return parentChapterId;
        }

        public void setParentChapterId(String parentChapterId) {
            this.parentChapterId = parentChapterId;
        }

        public String getUserControlSetTop() {
            return userControlSetTop;
        }

        public void setUserControlSetTop(String userControlSetTop) {
            this.userControlSetTop = userControlSetTop;
        }

        public String getVisible() {
            return visible;
        }

        public void setVisible(String visible) {
            this.visible = visible;
        }
    }
}
