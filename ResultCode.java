package com.pp.learn.demo;

    /**
     * 响应码枚举，参考HTTP状态码的语义
     */
public enum ResultCode {
    SUCCESS(0),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int code;
        private String msg;
    ResultCode(int code) {
        this.code = code;
    }
}
