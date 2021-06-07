package com.example.mydemo.bean;

import java.util.List;

/**
 * @data on 5/14/21 10:09 PM
 * @auther KC
 * @describe
 */
public class DataBean {
    /**
     * rows : {"cached":0,"error_code":0,"error_msg":"SUCCESS","log_id":2397880092,"result":{"face_list":[{"face_token":"0e9f7967f55c16066a19f5b566badc19","location":{"height":291,"left":188.91,"rotation":0,"top":497.42,"width":318},"user_list":[{"group_id":"wshh","score":99.362655639648,"user_id":"57","user_info":"符德众,group1/M00/00/1C/rBsQDmAXm_mAWLEYAABCIARA6pQ459.jpg"}]}],"face_num":1},"timestamp":1620466797}
     */

    private RowsBean rows;

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "FaceBean{" +
                "rows=" + rows +
                '}';
    }

    public static class RowsBean {
        /**
         * cached : 0
         * error_code : 0
         * error_msg : SUCCESS
         * log_id : 2397880092
         * result : {"face_list":[{"face_token":"0e9f7967f55c16066a19f5b566badc19","location":{"height":291,"left":188.91,"rotation":0,"top":497.42,"width":318},"user_list":[{"group_id":"wshh","score":99.362655639648,"user_id":"57","user_info":"符德众,group1/M00/00/1C/rBsQDmAXm_mAWLEYAABCIARA6pQ459.jpg"}]}],"face_num":1}
         * timestamp : 1620466797
         */

        private String cached;
        private String error_code;
        private String error_msg;
        private String log_id;
        private ResultBean result;
        private String timestamp;

        public String getCached() {
            return cached;
        }

        public void setCached(String cached) {
            this.cached = cached;
        }

        public String getError_code() {
            return error_code;
        }

        public void setError_code(String error_code) {
            this.error_code = error_code;
        }

        public String getError_msg() {
            return error_msg;
        }

        public void setError_msg(String error_msg) {
            this.error_msg = error_msg;
        }

        public String getLog_id() {
            return log_id;
        }

        public void setLog_id(String log_id) {
            this.log_id = log_id;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "cached='" + cached + '\'' +
                    ", error_code='" + error_code + '\'' +
                    ", error_msg='" + error_msg + '\'' +
                    ", log_id='" + log_id + '\'' +
                    ", result=" + result +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }

        public static class ResultBean {
            /**
             * face_list : [{"face_token":"0e9f7967f55c16066a19f5b566badc19","location":{"height":291,"left":188.91,"rotation":0,"top":497.42,"width":318},"user_list":[{"group_id":"wshh","score":99.362655639648,"user_id":"57","user_info":"符德众,group1/M00/00/1C/rBsQDmAXm_mAWLEYAABCIARA6pQ459.jpg"}]}]
             * face_num : 1
             */

            private String face_num;
            private List<FaceListBean> face_list;

            public String getFace_num() {
                return face_num;
            }

            public void setFace_num(String face_num) {
                this.face_num = face_num;
            }

            public List<FaceListBean> getFace_list() {
                return face_list;
            }

            public void setFace_list(List<FaceListBean> face_list) {
                this.face_list = face_list;
            }

            @Override
            public String toString() {
                return "ResultBean{" +
                        "face_num='" + face_num + '\'' +
                        ", face_list=" + face_list +
                        '}';
            }

            public static class FaceListBean {
                /**
                 * face_token : 0e9f7967f55c16066a19f5b566badc19
                 * location : {"height":291,"left":188.91,"rotation":0,"top":497.42,"width":318}
                 * user_list : [{"group_id":"wshh","score":99.362655639648,"user_id":"57","user_info":"符德众,group1/M00/00/1C/rBsQDmAXm_mAWLEYAABCIARA6pQ459.jpg"}]
                 */

                private String face_token;
                private LocationBean location;
                private List<UserListBean> user_list;

                public String getFace_token() {
                    return face_token;
                }

                public void setFace_token(String face_token) {
                    this.face_token = face_token;
                }

                public LocationBean getLocation() {
                    return location;
                }

                public void setLocation(LocationBean location) {
                    this.location = location;
                }

                public List<UserListBean> getUser_list() {
                    return user_list;
                }

                public void setUser_list(List<UserListBean> user_list) {
                    this.user_list = user_list;
                }

                @Override
                public String toString() {
                    return "FaceListBean{" +
                            "face_token='" + face_token + '\'' +
                            ", location=" + location +
                            ", user_list=" + user_list +
                            '}';
                }

                public static class LocationBean {
                    /**
                     * height : 291
                     * left : 188.91
                     * rotation : 0
                     * top : 497.42
                     * width : 318
                     */

                    private String height;
                    private String left;
                    private String rotation;
                    private String top;
                    private String width;

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getLeft() {
                        return left;
                    }

                    public void setLeft(String left) {
                        this.left = left;
                    }

                    public String getRotation() {
                        return rotation;
                    }

                    public void setRotation(String rotation) {
                        this.rotation = rotation;
                    }

                    public String getTop() {
                        return top;
                    }

                    public void setTop(String top) {
                        this.top = top;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }

                    @Override
                    public String toString() {
                        return "LocationBean{" +
                                "height='" + height + '\'' +
                                ", left='" + left + '\'' +
                                ", rotation='" + rotation + '\'' +
                                ", top='" + top + '\'' +
                                ", width='" + width + '\'' +
                                '}';
                    }
                }

                public static class UserListBean {
                    /**
                     * group_id : wshh
                     * score : 99.362655639648
                     * user_id : 57
                     * user_info : 符德众,group1/M00/00/1C/rBsQDmAXm_mAWLEYAABCIARA6pQ459.jpg
                     */

                    private String group_id;
                    private float score;
                    private String user_id;
                    private String user_info;
                    private boolean isNew;

                    public boolean isNew() {
                        return isNew;
                    }

                    public void setNew(boolean aNew) {
                        isNew = aNew;
                    }

                    public String getGroup_id() {
                        return group_id;
                    }

                    public void setGroup_id(String group_id) {
                        this.group_id = group_id;
                    }

                    public float getScore() {
                        return score;
                    }

                    public void setScore(float score) {
                        this.score = score;
                    }

                    public String getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(String user_id) {
                        this.user_id = user_id;
                    }

                    public String getUser_info() {
                        return user_info;
                    }

                    public void setUser_info(String user_info) {
                        this.user_info = user_info;
                    }

                    @Override
                    public String toString() {
                        return "UserListBean{" +
                                "group_id='" + group_id + '\'' +
                                ", score='" + score + '\'' +
                                ", user_id='" + user_id + '\'' +
                                ", user_info='" + user_info + '\'' +
                                ", isNew='" + isNew + '\'' +
                                '}';
                    }
                }
            }
        }
    }
}
