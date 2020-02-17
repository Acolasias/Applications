package com.bawei.applications.model.bean;

import java.util.List;

/**
 * Time:2020/2/14 0014下午 03:32202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class OrderformBean {
    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/5.jpg","commodityPrice":19,"orderDetailId":14724}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021415314278628237","orderStatus":1,"orderTime":1581665503000,"payAmount":76,"payMethod":1,"userId":28237},{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":13128}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021113504267928237","orderStatus":3,"orderTime":1581400243000,"payAmount":36,"payMethod":1,"userId":28237}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":4,"commodityId":4,"commodityName":"佩佩防晕染眼线液笔","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/5.jpg","commodityPrice":19,"orderDetailId":14724}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020021415314278628237
         * orderStatus : 1
         * orderTime : 1581665503000
         * payAmount : 76
         * payMethod : 1
         * userId : 28237
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 4
             * commodityId : 4
             * commodityName : 佩佩防晕染眼线液笔
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/2/5.jpg
             * commodityPrice : 19
             * orderDetailId : 14724
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
