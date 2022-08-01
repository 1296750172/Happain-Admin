package cn.happain.admin.common.consts;

public class UserConst {
    /*租户*/
    public static final String WX_KEY = "msb";
    /*微信公众号的id*/
    public static final String YOUYOU_WX_ID = "wxc2be1a790a6f9285";
    /*执行数据库操作错误*/
    public static final String UPDATE_INSERT_ERROR= "execute error";
    /*jwt的盐*/
    public static final String JWT_SALT ="youyou";
    /*token过期时间 2天*/
    public static final int JWT_EXPIRE= 60*60 *24 *2;
    /*token刷新时间临界值*/
    public static final int JWT_EXPIRE_REFURES=  60*60 *24;
    /*微信支付回调*/
    public static final String WX_CALLBACK = "/pay/wechat/callback";
    /*支付状态*/
    public static class  TRADE_STATUS  {
        /*已支付*/
        public static final String PAY = "pay";
        /*未支付*/
        public static final String NOPAY = "nopay";
        /*过期*/
        public static final String EXPIRED = "expired";
    }
    /*商品类型*/
    public static class PRODUCT_TYPE {
        public static final Integer YOUBI = 1;
    }
    /*最大查询个数*/
    public static Integer SEL_MAX = 20;

}
