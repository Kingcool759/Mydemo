package com.example.mydemo.bean;

import java.util.List;

/**
 * @data on 2020/10/21 6:51 PM
 * @auther
 * @describe
 */
public class AreaLinkBean {
    /**
     * code : 11
     * name : 北京市
     * children : [{"code":"1101","name":"市辖区","children":[{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]}]
     */

    private String code;
    private String name;
    private List<AreaThreeLinkBean.DataBean.ChildrenBeanX> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AreaThreeLinkBean.DataBean.ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<AreaThreeLinkBean.DataBean.ChildrenBeanX> children) {
        this.children = children;
    }

    public static class ChildrenBeanX {
        /**
         * code : 1101
         * name : 市辖区
         * children : [{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]
         */

        private String code;
        private String name;
        private List<AreaThreeLinkBean.DataBean.ChildrenBeanX.ChildrenBean> children;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<AreaThreeLinkBean.DataBean.ChildrenBeanX.ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<AreaThreeLinkBean.DataBean.ChildrenBeanX.ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * code : 110101
             * name : 东城区
             */

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
