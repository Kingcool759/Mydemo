package com.example.mydemo.entity;

/**
 * @data on 2020/11/13 6:05 PM
 * @auther
 * @describe
 */
public class javatest {

    /**
     * error : 0
     * data : {"role_name":"PLANTING_EXPERTS","title":"果蔬专家","id":"307","position":"","city_id":"","regional":"50000","uid":"14212","is_white":"0","avatar":null,"realname":"房锦超","create_time":"2020-11-05T14:26:58","district_id":"","update_time":"2020-11-06T10:50:21","province_id":"330000000000","doctor_uid":"14212","third_uid":"dev_14212","field":"果蔬种植作物","role_id":"60","price":"0.00"}
     */

    private int error;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * role_name : PLANTING_EXPERTS
         * title : 果蔬专家
         * id : 307
         * position :
         * city_id :
         * regional : 50000
         * uid : 14212
         * is_white : 0
         * avatar : null
         * realname : 房锦超
         * create_time : 2020-11-05T14:26:58
         * district_id :
         * update_time : 2020-11-06T10:50:21
         * province_id : 330000000000
         * doctor_uid : 14212
         * third_uid : dev_14212
         * field : 果蔬种植作物
         * role_id : 60
         * price : 0.00
         */

        private String role_name;
        private String title;
        private String id;
        private String position;
        private String city_id;
        private String regional;
        private String uid;
        private String is_white;
        private Object avatar;
        private String realname;
        private String create_time;
        private String district_id;
        private String update_time;
        private String province_id;
        private String doctor_uid;
        private String third_uid;
        private String field;
        private String role_id;
        private String price;

        public String getRole_name() {
            return role_name;
        }

        public void setRole_name(String role_name) {
            this.role_name = role_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getRegional() {
            return regional;
        }

        public void setRegional(String regional) {
            this.regional = regional;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getIs_white() {
            return is_white;
        }

        public void setIs_white(String is_white) {
            this.is_white = is_white;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getDistrict_id() {
            return district_id;
        }

        public void setDistrict_id(String district_id) {
            this.district_id = district_id;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getDoctor_uid() {
            return doctor_uid;
        }

        public void setDoctor_uid(String doctor_uid) {
            this.doctor_uid = doctor_uid;
        }

        public String getThird_uid() {
            return third_uid;
        }

        public void setThird_uid(String third_uid) {
            this.third_uid = third_uid;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
