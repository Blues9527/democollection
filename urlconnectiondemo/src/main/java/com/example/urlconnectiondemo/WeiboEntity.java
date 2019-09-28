package com.example.urlconnectiondemo;

import java.io.Serializable;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:00
 */

public class WeiboEntity implements Serializable {


    private int ok;
    private DataBean data;

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {

        private CardlistInfoBean cardlistInfo;
        private String scheme;
        private int showAppTips;
        private List<CardsBean> cards;

        public CardlistInfoBean getCardlistInfo() {
            return cardlistInfo;
        }

        public void setCardlistInfo(CardlistInfoBean cardlistInfo) {
            this.cardlistInfo = cardlistInfo;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public int getShowAppTips() {
            return showAppTips;
        }

        public void setShowAppTips(int showAppTips) {
            this.showAppTips = showAppTips;
        }

        public List<CardsBean> getCards() {
            return cards;
        }

        public void setCards(List<CardsBean> cards) {
            this.cards = cards;
        }

        public static class CardlistInfoBean implements Serializable {
            /**
             * statistics_from : hotweibo
             * v_p : 42
             * containerid : 102803_ctg1_4388_-_ctg1_4388
             * title_top : 热门微博
             * show_style : 1
             * total : 300
             * since_id : 1
             * cardlist_head_cards : [{"channel_list":null}]
             * can_shared : 1
             * cardlist_title : null
             * desc : null
             * tags : {"keyword":"","labeltype":""}
             */

            private String statistics_from;
            private String v_p;
            private String containerid;
            private String title_top;
            private int show_style;
            private int total;
            private int since_id;
            private int can_shared;
            private Object cardlist_title;
            private Object desc;
            private TagsBean tags;

            public String getStatistics_from() {
                return statistics_from;
            }

            public void setStatistics_from(String statistics_from) {
                this.statistics_from = statistics_from;
            }

            public String getV_p() {
                return v_p;
            }

            public void setV_p(String v_p) {
                this.v_p = v_p;
            }

            public String getContainerid() {
                return containerid;
            }

            public void setContainerid(String containerid) {
                this.containerid = containerid;
            }

            public String getTitle_top() {
                return title_top;
            }

            public void setTitle_top(String title_top) {
                this.title_top = title_top;
            }

            public int getShow_style() {
                return show_style;
            }

            public void setShow_style(int show_style) {
                this.show_style = show_style;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getSince_id() {
                return since_id;
            }

            public void setSince_id(int since_id) {
                this.since_id = since_id;
            }

            public int getCan_shared() {
                return can_shared;
            }

            public void setCan_shared(int can_shared) {
                this.can_shared = can_shared;
            }

            public Object getCardlist_title() {
                return cardlist_title;
            }

            public void setCardlist_title(Object cardlist_title) {
                this.cardlist_title = cardlist_title;
            }

            public Object getDesc() {
                return desc;
            }

            public void setDesc(Object desc) {
                this.desc = desc;
            }

            public TagsBean getTags() {
                return tags;
            }

            public void setTags(TagsBean tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * keyword :
                 * labeltype :
                 */

                private String keyword;
                private String labeltype;

                public String getKeyword() {
                    return keyword;
                }

                public void setKeyword(String keyword) {
                    this.keyword = keyword;
                }

                public String getLabeltype() {
                    return labeltype;
                }

                public void setLabeltype(String labeltype) {
                    this.labeltype = labeltype;
                }
            }
        }

        public static class CardsBean implements Serializable {
            /**
             * card_type : 9
             * card_type_name :
             * itemid : 102803_ctg1_4388_-_ctg1_4388_-_mbloglist_4409230629430129
             * scheme : https://m.weibo.cn/status/I3S86DzcR?mblogid=I3S86DzcR&luicode=10000011&lfid=102803_ctg1_4388_-_ctg1_4388
             * weibo_need : mblog
             * mblog : {"created_at":"16小时前","id":"4409230629430129","idstr":"4409230629430129","mid":"4409230629430129","can_edit":false,"show_additional_indication":0,"text":"懒人版教学，如何让多肉稳定成长\u2026\u2026而且几个月不管的那种，如图： ","textLength":62,"source":"小迷妹iPhone X","favorited":false,"pic_types":"0,0,0,0","thumbnail_pic":"http://wx3.sinaimg.cn/thumbnail/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","bmiddle_pic":"http://wx3.sinaimg.cn/bmiddle/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","original_pic":"http://wx3.sinaimg.cn/large/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","is_paid":false,"mblog_vip_type":0,"user":{"id":2308323314,"screen_name":"小迷妹神吐槽","profile_image_url":"https://tvax3.sinaimg.cn/crop.0.0.639.639.180/899637f2ly8fpl0h6j9asj20hr0hr757.jpg?KID=imgbed,tva&Expires=1566795406&ssig=ED6oZrOoXp","profile_url":"https://m.weibo.cn/u/2308323314?uid=2308323314&luicode=10000011&lfid=102803_ctg1_4388_-_ctg1_4388","statuses_count":19080,"verified":true,"verified_type":0,"verified_type_ext":1,"verified_reason":"知名搞笑幽默博主","close_blue_v":false,"description":"请叫我小迷妹，你们的宝藏女孩，快乐源泉！商务合作VX：xnxnxn95 （备注品牌或合作项目）","gender":"f","mbtype":12,"urank":35,"mbrank":6,"follow_me":false,"following":false,"followers_count":11773300,"follow_count":651,"cover_image_phone":"https://wx1.sinaimg.cn/crop.0.0.640.640.640/899637f2ly1g6aaa0nxxkj20v90v941n.jpg","avatar_hd":"https://wx3.sinaimg.cn/orj480/899637f2ly8fpl0h6j9asj20hr0hr757.jpg","like":false,"like_me":false,"badge":{"bind_taobao":1,"unread_pool":1,"unread_pool_ext":1,"super_star_2017":1,"panda":1,"user_name_certificate":1,"wenchuan_10th":1,"super_star_2018":1,"worldcup_2018":34,"wenda_v2":1,"qixi_2018":1,"weibo_display_fans":1,"relation_display":1,"wbzy_2018":1,"hongbaofei_2019":1,"womensday_2018":1,"suishoupai_2019":2,"wusi_2019":1,"hongrenjie_2019":1,"china_2019":1}},"picStatus":"0:1,1:1,2:1,3:1","reposts_count":1080,"comments_count":847,"attitudes_count":3584,"pending_approval_count":0,"isLongText":false,"reward_exhibition_type":2,"reward_scheme":"sinaweibo://reward?bid=1000293251&enter_id=1000293251&enter_type=1&oid=4409230629430129&seller=2308323314&share=18cb5613ebf3d8aadd9975c1036ab1f47&sign=d1180be3ded54c2a6595e938f8943214","hide_flag":0,"visible":{"type":0,"list_id":0},"mblogtype":0,"rid":"0_0_0_3068403526277895946_0_0_0","more_info_type":0,"cardid":"star_005","extern_safe":0,"number_display_strategy":{"apply_scenario_flag":3,"display_text_min_number":1000000,"display_text":"100万+"},"content_auth":0,"pic_num":4,"weibo_position":1,"show_attitude_bar":0,"buttons":[{"type":"follow","name":"关注","pic":"http://u1.sinaimg.cn/upload/2013/07/02/timeline_card_small_button_icon_add.png","params":{"uid":2308323314},"actionlog":{"act_code":"91","act_type":"1","uicode":"","oid":2308323314,"fid":"102803_ctg1_4388_-_ctg1_4388","cardid":"102803_ctg1_4388_-_ctg1_4388_-_mbloglist_4409230629430129","ext":"uid:2308323314|mid:4409230629430129|act:follow|time:1566784606|source:4388"}}],"from_cateid":"4388","recommend_source":"","mblog_buttons":[{"type":"mblog_buttons_forward","name":"转发","pic":"","actionlog":{"act_code":"1202","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}},{"type":"mblog_buttons_comment","name":"评论","pic":"","actionlog":{"act_code":"130","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}},{"type":"mblog_buttons_like","name":"赞","pic":"","actionlog":{"act_code":"1207","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}}],"bid":"I3S86DzcR","pics":[{"pid":"899637f2ly1g5we8jm5qmj20u00u0n8j","url":"https://wx3.sinaimg.cn/orj360/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx3.sinaimg.cn/large/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","geo":{"width":"1080","height":"1080","croped":false}}},{"pid":"899637f2ly1g5we8jv8mfj20u00u0all","url":"https://wx4.sinaimg.cn/orj360/899637f2ly1g5we8jv8mfj20u00u0all.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx4.sinaimg.cn/large/899637f2ly1g5we8jv8mfj20u00u0all.jpg","geo":{"width":"1080","height":"1080","croped":false}}},{"pid":"899637f2ly1g5we8k55hoj20u00u0amq","url":"https://wx4.sinaimg.cn/orj360/899637f2ly1g5we8k55hoj20u00u0amq.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx4.sinaimg.cn/large/899637f2ly1g5we8k55hoj20u00u0amq.jpg","geo":{"width":"1080","height":"1080","croped":false}}},{"pid":"899637f2ly1g5we8jangyj20u00u0wqe","url":"https://wx1.sinaimg.cn/orj360/899637f2ly1g5we8jangyj20u00u0wqe.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx1.sinaimg.cn/large/899637f2ly1g5we8jangyj20u00u0wqe.jpg","geo":{"width":"1080","height":"1080","croped":false}}}]}
             * show_type : 1
             * mblog_buttons : [{"type":"mblog_buttons_forward","name":"转发","pic":"","actionlog":{"act_code":"1202","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}},{"type":"mblog_buttons_comment","name":"评论","pic":"","actionlog":{"act_code":"130","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}},{"type":"mblog_buttons_like","name":"赞","pic":"","actionlog":{"act_code":"1207","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}}]
             * hot_request_id : 1566784606046371616048947995245
             */

            private int card_type;
            private String card_type_name;
            private String itemid;
            private String scheme;
            private String weibo_need;
            private MblogBean mblog;
            private int show_type;
            private String hot_request_id;
            private List<MblogButtonsBeanX> mblog_buttons;

            public int getCard_type() {
                return card_type;
            }

            public void setCard_type(int card_type) {
                this.card_type = card_type;
            }

            public String getCard_type_name() {
                return card_type_name;
            }

            public void setCard_type_name(String card_type_name) {
                this.card_type_name = card_type_name;
            }

            public String getItemid() {
                return itemid;
            }

            public void setItemid(String itemid) {
                this.itemid = itemid;
            }

            public String getScheme() {
                return scheme;
            }

            public void setScheme(String scheme) {
                this.scheme = scheme;
            }

            public String getWeibo_need() {
                return weibo_need;
            }

            public void setWeibo_need(String weibo_need) {
                this.weibo_need = weibo_need;
            }

            public MblogBean getMblog() {
                return mblog;
            }

            public void setMblog(MblogBean mblog) {
                this.mblog = mblog;
            }

            public int getShow_type() {
                return show_type;
            }

            public void setShow_type(int show_type) {
                this.show_type = show_type;
            }

            public String getHot_request_id() {
                return hot_request_id;
            }

            public void setHot_request_id(String hot_request_id) {
                this.hot_request_id = hot_request_id;
            }

            public List<MblogButtonsBeanX> getMblog_buttons() {
                return mblog_buttons;
            }

            public void setMblog_buttons(List<MblogButtonsBeanX> mblog_buttons) {
                this.mblog_buttons = mblog_buttons;
            }

            public static class MblogBean implements Serializable {
                /**
                 * created_at : 16小时前
                 * id : 4409230629430129
                 * idstr : 4409230629430129
                 * mid : 4409230629430129
                 * can_edit : false
                 * show_additional_indication : 0
                 * text : 懒人版教学，如何让多肉稳定成长……而且几个月不管的那种，如图：
                 * textLength : 62
                 * source : 小迷妹iPhone X
                 * favorited : false
                 * pic_types : 0,0,0,0
                 * thumbnail_pic : http://wx3.sinaimg.cn/thumbnail/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg
                 * bmiddle_pic : http://wx3.sinaimg.cn/bmiddle/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg
                 * original_pic : http://wx3.sinaimg.cn/large/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg
                 * is_paid : false
                 * mblog_vip_type : 0
                 * user : {"id":2308323314,"screen_name":"小迷妹神吐槽","profile_image_url":"https://tvax3.sinaimg.cn/crop.0.0.639.639.180/899637f2ly8fpl0h6j9asj20hr0hr757.jpg?KID=imgbed,tva&Expires=1566795406&ssig=ED6oZrOoXp","profile_url":"https://m.weibo.cn/u/2308323314?uid=2308323314&luicode=10000011&lfid=102803_ctg1_4388_-_ctg1_4388","statuses_count":19080,"verified":true,"verified_type":0,"verified_type_ext":1,"verified_reason":"知名搞笑幽默博主","close_blue_v":false,"description":"请叫我小迷妹，你们的宝藏女孩，快乐源泉！商务合作VX：xnxnxn95 （备注品牌或合作项目）","gender":"f","mbtype":12,"urank":35,"mbrank":6,"follow_me":false,"following":false,"followers_count":11773300,"follow_count":651,"cover_image_phone":"https://wx1.sinaimg.cn/crop.0.0.640.640.640/899637f2ly1g6aaa0nxxkj20v90v941n.jpg","avatar_hd":"https://wx3.sinaimg.cn/orj480/899637f2ly8fpl0h6j9asj20hr0hr757.jpg","like":false,"like_me":false,"badge":{"bind_taobao":1,"unread_pool":1,"unread_pool_ext":1,"super_star_2017":1,"panda":1,"user_name_certificate":1,"wenchuan_10th":1,"super_star_2018":1,"worldcup_2018":34,"wenda_v2":1,"qixi_2018":1,"weibo_display_fans":1,"relation_display":1,"wbzy_2018":1,"hongbaofei_2019":1,"womensday_2018":1,"suishoupai_2019":2,"wusi_2019":1,"hongrenjie_2019":1,"china_2019":1}}
                 * picStatus : 0:1,1:1,2:1,3:1
                 * reposts_count : 1080
                 * comments_count : 847
                 * attitudes_count : 3584
                 * pending_approval_count : 0
                 * isLongText : false
                 * reward_exhibition_type : 2
                 * reward_scheme : sinaweibo://reward?bid=1000293251&enter_id=1000293251&enter_type=1&oid=4409230629430129&seller=2308323314&share=18cb5613ebf3d8aadd9975c1036ab1f47&sign=d1180be3ded54c2a6595e938f8943214
                 * hide_flag : 0
                 * visible : {"type":0,"list_id":0}
                 * mblogtype : 0
                 * rid : 0_0_0_3068403526277895946_0_0_0
                 * more_info_type : 0
                 * cardid : star_005
                 * extern_safe : 0
                 * number_display_strategy : {"apply_scenario_flag":3,"display_text_min_number":1000000,"display_text":"100万+"}
                 * content_auth : 0
                 * pic_num : 4
                 * weibo_position : 1
                 * show_attitude_bar : 0
                 * buttons : [{"type":"follow","name":"关注","pic":"http://u1.sinaimg.cn/upload/2013/07/02/timeline_card_small_button_icon_add.png","params":{"uid":2308323314},"actionlog":{"act_code":"91","act_type":"1","uicode":"","oid":2308323314,"fid":"102803_ctg1_4388_-_ctg1_4388","cardid":"102803_ctg1_4388_-_ctg1_4388_-_mbloglist_4409230629430129","ext":"uid:2308323314|mid:4409230629430129|act:follow|time:1566784606|source:4388"}}]
                 * from_cateid : 4388
                 * recommend_source :
                 * mblog_buttons : [{"type":"mblog_buttons_forward","name":"转发","pic":"","actionlog":{"act_code":"1202","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}},{"type":"mblog_buttons_comment","name":"评论","pic":"","actionlog":{"act_code":"130","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}},{"type":"mblog_buttons_like","name":"赞","pic":"","actionlog":{"act_code":"1207","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}}]
                 * bid : I3S86DzcR
                 * pics : [{"pid":"899637f2ly1g5we8jm5qmj20u00u0n8j","url":"https://wx3.sinaimg.cn/orj360/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx3.sinaimg.cn/large/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","geo":{"width":"1080","height":"1080","croped":false}}},{"pid":"899637f2ly1g5we8jv8mfj20u00u0all","url":"https://wx4.sinaimg.cn/orj360/899637f2ly1g5we8jv8mfj20u00u0all.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx4.sinaimg.cn/large/899637f2ly1g5we8jv8mfj20u00u0all.jpg","geo":{"width":"1080","height":"1080","croped":false}}},{"pid":"899637f2ly1g5we8k55hoj20u00u0amq","url":"https://wx4.sinaimg.cn/orj360/899637f2ly1g5we8k55hoj20u00u0amq.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx4.sinaimg.cn/large/899637f2ly1g5we8k55hoj20u00u0amq.jpg","geo":{"width":"1080","height":"1080","croped":false}}},{"pid":"899637f2ly1g5we8jangyj20u00u0wqe","url":"https://wx1.sinaimg.cn/orj360/899637f2ly1g5we8jangyj20u00u0wqe.jpg","size":"orj360","geo":{"width":360,"height":360,"croped":false},"large":{"size":"large","url":"https://wx1.sinaimg.cn/large/899637f2ly1g5we8jangyj20u00u0wqe.jpg","geo":{"width":"1080","height":"1080","croped":false}}}]
                 */

                private String created_at;
                private String id;
                private String idstr;
                private String mid;
                private boolean can_edit;
                private int show_additional_indication;
                private String text;
                private int textLength;
                private String source;
                private boolean favorited;
                private String pic_types;
                private String thumbnail_pic;
                private String bmiddle_pic;
                private String original_pic;
                private boolean is_paid;
                private int mblog_vip_type;
                private UserBean user;
                private String picStatus;
                private int reposts_count;
                private int comments_count;
                private int attitudes_count;
                private int pending_approval_count;
                private boolean isLongText;
                private int reward_exhibition_type;
                private String reward_scheme;
                private int hide_flag;
                private int mblogtype;
                private String rid;
                private int more_info_type;
                private String cardid;
                private int extern_safe;
                private NumberDisplayStrategyBean number_display_strategy;
                private int content_auth;
                private int pic_num;
                private int weibo_position;
                private int show_attitude_bar;
                private String from_cateid;
                private String recommend_source;
                private String bid;
                private List<ButtonsBean> buttons;
                private List<MblogButtonsBean> mblog_buttons;
                private List<PicsBean> pics;

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getIdstr() {
                    return idstr;
                }

                public void setIdstr(String idstr) {
                    this.idstr = idstr;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public boolean isCan_edit() {
                    return can_edit;
                }

                public void setCan_edit(boolean can_edit) {
                    this.can_edit = can_edit;
                }

                public int getShow_additional_indication() {
                    return show_additional_indication;
                }

                public void setShow_additional_indication(int show_additional_indication) {
                    this.show_additional_indication = show_additional_indication;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getTextLength() {
                    return textLength;
                }

                public void setTextLength(int textLength) {
                    this.textLength = textLength;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public boolean isFavorited() {
                    return favorited;
                }

                public void setFavorited(boolean favorited) {
                    this.favorited = favorited;
                }

                public String getPic_types() {
                    return pic_types;
                }

                public void setPic_types(String pic_types) {
                    this.pic_types = pic_types;
                }

                public String getThumbnail_pic() {
                    return thumbnail_pic;
                }

                public void setThumbnail_pic(String thumbnail_pic) {
                    this.thumbnail_pic = thumbnail_pic;
                }

                public String getBmiddle_pic() {
                    return bmiddle_pic;
                }

                public void setBmiddle_pic(String bmiddle_pic) {
                    this.bmiddle_pic = bmiddle_pic;
                }

                public String getOriginal_pic() {
                    return original_pic;
                }

                public void setOriginal_pic(String original_pic) {
                    this.original_pic = original_pic;
                }

                public boolean isIs_paid() {
                    return is_paid;
                }

                public void setIs_paid(boolean is_paid) {
                    this.is_paid = is_paid;
                }

                public int getMblog_vip_type() {
                    return mblog_vip_type;
                }

                public void setMblog_vip_type(int mblog_vip_type) {
                    this.mblog_vip_type = mblog_vip_type;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public String getPicStatus() {
                    return picStatus;
                }

                public void setPicStatus(String picStatus) {
                    this.picStatus = picStatus;
                }

                public int getReposts_count() {
                    return reposts_count;
                }

                public void setReposts_count(int reposts_count) {
                    this.reposts_count = reposts_count;
                }

                public int getComments_count() {
                    return comments_count;
                }

                public void setComments_count(int comments_count) {
                    this.comments_count = comments_count;
                }

                public int getAttitudes_count() {
                    return attitudes_count;
                }

                public void setAttitudes_count(int attitudes_count) {
                    this.attitudes_count = attitudes_count;
                }

                public int getPending_approval_count() {
                    return pending_approval_count;
                }

                public void setPending_approval_count(int pending_approval_count) {
                    this.pending_approval_count = pending_approval_count;
                }

                public boolean isIsLongText() {
                    return isLongText;
                }

                public void setIsLongText(boolean isLongText) {
                    this.isLongText = isLongText;
                }

                public int getReward_exhibition_type() {
                    return reward_exhibition_type;
                }

                public void setReward_exhibition_type(int reward_exhibition_type) {
                    this.reward_exhibition_type = reward_exhibition_type;
                }

                public String getReward_scheme() {
                    return reward_scheme;
                }

                public void setReward_scheme(String reward_scheme) {
                    this.reward_scheme = reward_scheme;
                }

                public int getHide_flag() {
                    return hide_flag;
                }

                public void setHide_flag(int hide_flag) {
                    this.hide_flag = hide_flag;
                }

                public int getMblogtype() {
                    return mblogtype;
                }

                public void setMblogtype(int mblogtype) {
                    this.mblogtype = mblogtype;
                }

                public String getRid() {
                    return rid;
                }

                public void setRid(String rid) {
                    this.rid = rid;
                }

                public int getMore_info_type() {
                    return more_info_type;
                }

                public void setMore_info_type(int more_info_type) {
                    this.more_info_type = more_info_type;
                }

                public String getCardid() {
                    return cardid;
                }

                public void setCardid(String cardid) {
                    this.cardid = cardid;
                }

                public int getExtern_safe() {
                    return extern_safe;
                }

                public void setExtern_safe(int extern_safe) {
                    this.extern_safe = extern_safe;
                }

                public NumberDisplayStrategyBean getNumber_display_strategy() {
                    return number_display_strategy;
                }

                public void setNumber_display_strategy(NumberDisplayStrategyBean number_display_strategy) {
                    this.number_display_strategy = number_display_strategy;
                }

                public int getContent_auth() {
                    return content_auth;
                }

                public void setContent_auth(int content_auth) {
                    this.content_auth = content_auth;
                }

                public int getPic_num() {
                    return pic_num;
                }

                public void setPic_num(int pic_num) {
                    this.pic_num = pic_num;
                }

                public int getWeibo_position() {
                    return weibo_position;
                }

                public void setWeibo_position(int weibo_position) {
                    this.weibo_position = weibo_position;
                }

                public int getShow_attitude_bar() {
                    return show_attitude_bar;
                }

                public void setShow_attitude_bar(int show_attitude_bar) {
                    this.show_attitude_bar = show_attitude_bar;
                }

                public String getFrom_cateid() {
                    return from_cateid;
                }

                public void setFrom_cateid(String from_cateid) {
                    this.from_cateid = from_cateid;
                }

                public String getRecommend_source() {
                    return recommend_source;
                }

                public void setRecommend_source(String recommend_source) {
                    this.recommend_source = recommend_source;
                }

                public String getBid() {
                    return bid;
                }

                public void setBid(String bid) {
                    this.bid = bid;
                }

                public List<ButtonsBean> getButtons() {
                    return buttons;
                }

                public void setButtons(List<ButtonsBean> buttons) {
                    this.buttons = buttons;
                }

                public List<MblogButtonsBean> getMblog_buttons() {
                    return mblog_buttons;
                }

                public void setMblog_buttons(List<MblogButtonsBean> mblog_buttons) {
                    this.mblog_buttons = mblog_buttons;
                }

                public List<PicsBean> getPics() {
                    return pics;
                }

                public void setPics(List<PicsBean> pics) {
                    this.pics = pics;
                }

                public static class UserBean {
                    /**
                     * id : 2308323314
                     * screen_name : 小迷妹神吐槽
                     * profile_image_url : https://tvax3.sinaimg.cn/crop.0.0.639.639.180/899637f2ly8fpl0h6j9asj20hr0hr757.jpg?KID=imgbed,tva&Expires=1566795406&ssig=ED6oZrOoXp
                     * profile_url : https://m.weibo.cn/u/2308323314?uid=2308323314&luicode=10000011&lfid=102803_ctg1_4388_-_ctg1_4388
                     * statuses_count : 19080
                     * verified : true
                     * verified_type : 0
                     * verified_type_ext : 1
                     * verified_reason : 知名搞笑幽默博主
                     * close_blue_v : false
                     * description : 请叫我小迷妹，你们的宝藏女孩，快乐源泉！商务合作VX：xnxnxn95 （备注品牌或合作项目）
                     * gender : f
                     * mbtype : 12
                     * urank : 35
                     * mbrank : 6
                     * follow_me : false
                     * following : false
                     * followers_count : 11773300
                     * follow_count : 651
                     * cover_image_phone : https://wx1.sinaimg.cn/crop.0.0.640.640.640/899637f2ly1g6aaa0nxxkj20v90v941n.jpg
                     * avatar_hd : https://wx3.sinaimg.cn/orj480/899637f2ly8fpl0h6j9asj20hr0hr757.jpg
                     * like : false
                     * like_me : false
                     * badge : {"bind_taobao":1,"unread_pool":1,"unread_pool_ext":1,"super_star_2017":1,"panda":1,"user_name_certificate":1,"wenchuan_10th":1,"super_star_2018":1,"worldcup_2018":34,"wenda_v2":1,"qixi_2018":1,"weibo_display_fans":1,"relation_display":1,"wbzy_2018":1,"hongbaofei_2019":1,"womensday_2018":1,"suishoupai_2019":2,"wusi_2019":1,"hongrenjie_2019":1,"china_2019":1}
                     */

                    private long id;
                    private String screen_name;
                    private String profile_image_url;
                    private String profile_url;
                    private int statuses_count;
                    private boolean verified;
                    private int verified_type;
                    private int verified_type_ext;
                    private String verified_reason;
                    private boolean close_blue_v;
                    private String description;
                    private String gender;
                    private int mbtype;
                    private int urank;
                    private int mbrank;
                    private boolean follow_me;
                    private boolean following;
                    private int followers_count;
                    private int follow_count;
                    private String cover_image_phone;
                    private String avatar_hd;
                    private boolean like;
                    private boolean like_me;

                    public long getId() {
                        return id;
                    }

                    public void setId(long id) {
                        this.id = id;
                    }

                    public String getScreen_name() {
                        return screen_name;
                    }

                    public void setScreen_name(String screen_name) {
                        this.screen_name = screen_name;
                    }

                    public String getProfile_image_url() {
                        return profile_image_url;
                    }

                    public void setProfile_image_url(String profile_image_url) {
                        this.profile_image_url = profile_image_url;
                    }

                    public String getProfile_url() {
                        return profile_url;
                    }

                    public void setProfile_url(String profile_url) {
                        this.profile_url = profile_url;
                    }

                    public int getStatuses_count() {
                        return statuses_count;
                    }

                    public void setStatuses_count(int statuses_count) {
                        this.statuses_count = statuses_count;
                    }

                    public boolean isVerified() {
                        return verified;
                    }

                    public void setVerified(boolean verified) {
                        this.verified = verified;
                    }

                    public int getVerified_type() {
                        return verified_type;
                    }

                    public void setVerified_type(int verified_type) {
                        this.verified_type = verified_type;
                    }

                    public int getVerified_type_ext() {
                        return verified_type_ext;
                    }

                    public void setVerified_type_ext(int verified_type_ext) {
                        this.verified_type_ext = verified_type_ext;
                    }

                    public String getVerified_reason() {
                        return verified_reason;
                    }

                    public void setVerified_reason(String verified_reason) {
                        this.verified_reason = verified_reason;
                    }

                    public boolean isClose_blue_v() {
                        return close_blue_v;
                    }

                    public void setClose_blue_v(boolean close_blue_v) {
                        this.close_blue_v = close_blue_v;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public int getMbtype() {
                        return mbtype;
                    }

                    public void setMbtype(int mbtype) {
                        this.mbtype = mbtype;
                    }

                    public int getUrank() {
                        return urank;
                    }

                    public void setUrank(int urank) {
                        this.urank = urank;
                    }

                    public int getMbrank() {
                        return mbrank;
                    }

                    public void setMbrank(int mbrank) {
                        this.mbrank = mbrank;
                    }

                    public boolean isFollow_me() {
                        return follow_me;
                    }

                    public void setFollow_me(boolean follow_me) {
                        this.follow_me = follow_me;
                    }

                    public boolean isFollowing() {
                        return following;
                    }

                    public void setFollowing(boolean following) {
                        this.following = following;
                    }

                    public int getFollowers_count() {
                        return followers_count;
                    }

                    public void setFollowers_count(int followers_count) {
                        this.followers_count = followers_count;
                    }

                    public int getFollow_count() {
                        return follow_count;
                    }

                    public void setFollow_count(int follow_count) {
                        this.follow_count = follow_count;
                    }

                    public String getCover_image_phone() {
                        return cover_image_phone;
                    }

                    public void setCover_image_phone(String cover_image_phone) {
                        this.cover_image_phone = cover_image_phone;
                    }

                    public String getAvatar_hd() {
                        return avatar_hd;
                    }

                    public void setAvatar_hd(String avatar_hd) {
                        this.avatar_hd = avatar_hd;
                    }

                    public boolean isLike() {
                        return like;
                    }

                    public void setLike(boolean like) {
                        this.like = like;
                    }

                    public boolean isLike_me() {
                        return like_me;
                    }

                    public void setLike_me(boolean like_me) {
                        this.like_me = like_me;
                    }

                }

                public static class NumberDisplayStrategyBean {
                    /**
                     * apply_scenario_flag : 3
                     * display_text_min_number : 1000000
                     * display_text : 100万+
                     */

                    private int apply_scenario_flag;
                    private int display_text_min_number;
                    private String display_text;

                    public int getApply_scenario_flag() {
                        return apply_scenario_flag;
                    }

                    public void setApply_scenario_flag(int apply_scenario_flag) {
                        this.apply_scenario_flag = apply_scenario_flag;
                    }

                    public int getDisplay_text_min_number() {
                        return display_text_min_number;
                    }

                    public void setDisplay_text_min_number(int display_text_min_number) {
                        this.display_text_min_number = display_text_min_number;
                    }

                    public String getDisplay_text() {
                        return display_text;
                    }

                    public void setDisplay_text(String display_text) {
                        this.display_text = display_text;
                    }
                }

                public static class ButtonsBean {
                    /**
                     * type : follow
                     * name : 关注
                     * pic : http://u1.sinaimg.cn/upload/2013/07/02/timeline_card_small_button_icon_add.png
                     * params : {"uid":2308323314}
                     * actionlog : {"act_code":"91","act_type":"1","uicode":"","oid":2308323314,"fid":"102803_ctg1_4388_-_ctg1_4388","cardid":"102803_ctg1_4388_-_ctg1_4388_-_mbloglist_4409230629430129","ext":"uid:2308323314|mid:4409230629430129|act:follow|time:1566784606|source:4388"}
                     */

                    private String type;
                    private String name;
                    private String pic;
                    private ParamsBean params;
                    private ActionlogBean actionlog;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }

                    public ParamsBean getParams() {
                        return params;
                    }

                    public void setParams(ParamsBean params) {
                        this.params = params;
                    }

                    public ActionlogBean getActionlog() {
                        return actionlog;
                    }

                    public void setActionlog(ActionlogBean actionlog) {
                        this.actionlog = actionlog;
                    }

                    public static class ParamsBean {
                        /**
                         * uid : 2308323314
                         */

                        private long uid;

                        public long getUid() {
                            return uid;
                        }

                        public void setUid(long uid) {
                            this.uid = uid;
                        }
                    }

                    public static class ActionlogBean {
                        /**
                         * act_code : 91
                         * act_type : 1
                         * uicode :
                         * oid : 2308323314
                         * fid : 102803_ctg1_4388_-_ctg1_4388
                         * cardid : 102803_ctg1_4388_-_ctg1_4388_-_mbloglist_4409230629430129
                         * ext : uid:2308323314|mid:4409230629430129|act:follow|time:1566784606|source:4388
                         */

                        private String act_code;
                        private String act_type;
                        private String uicode;
                        private long oid;
                        private String fid;
                        private String cardid;
                        private String ext;

                        public String getAct_code() {
                            return act_code;
                        }

                        public void setAct_code(String act_code) {
                            this.act_code = act_code;
                        }

                        public String getAct_type() {
                            return act_type;
                        }

                        public void setAct_type(String act_type) {
                            this.act_type = act_type;
                        }

                        public String getUicode() {
                            return uicode;
                        }

                        public void setUicode(String uicode) {
                            this.uicode = uicode;
                        }

                        public long getOid() {
                            return oid;
                        }

                        public void setOid(long oid) {
                            this.oid = oid;
                        }

                        public String getFid() {
                            return fid;
                        }

                        public void setFid(String fid) {
                            this.fid = fid;
                        }

                        public String getCardid() {
                            return cardid;
                        }

                        public void setCardid(String cardid) {
                            this.cardid = cardid;
                        }

                        public String getExt() {
                            return ext;
                        }

                        public void setExt(String ext) {
                            this.ext = ext;
                        }
                    }
                }

                public static class MblogButtonsBean {
                    /**
                     * type : mblog_buttons_forward
                     * name : 转发
                     * pic :
                     * actionlog : {"act_code":"1202","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}
                     */

                    private String type;
                    private String name;
                    private String pic;
                    private ActionlogBeanX actionlog;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }

                    public ActionlogBeanX getActionlog() {
                        return actionlog;
                    }

                    public void setActionlog(ActionlogBeanX actionlog) {
                        this.actionlog = actionlog;
                    }

                    public static class ActionlogBeanX {
                        /**
                         * act_code : 1202
                         * act_type : 1
                         * fid : 102803_ctg1_4388_-_ctg1_4388
                         * lfid :
                         * oid : 4409230629430129
                         * uicode :
                         * ext : source:4388
                         */

                        private String act_code;
                        private String act_type;
                        private String fid;
                        private String lfid;
                        private String oid;
                        private String uicode;
                        private String ext;

                        public String getAct_code() {
                            return act_code;
                        }

                        public void setAct_code(String act_code) {
                            this.act_code = act_code;
                        }

                        public String getAct_type() {
                            return act_type;
                        }

                        public void setAct_type(String act_type) {
                            this.act_type = act_type;
                        }

                        public String getFid() {
                            return fid;
                        }

                        public void setFid(String fid) {
                            this.fid = fid;
                        }

                        public String getLfid() {
                            return lfid;
                        }

                        public void setLfid(String lfid) {
                            this.lfid = lfid;
                        }

                        public String getOid() {
                            return oid;
                        }

                        public void setOid(String oid) {
                            this.oid = oid;
                        }

                        public String getUicode() {
                            return uicode;
                        }

                        public void setUicode(String uicode) {
                            this.uicode = uicode;
                        }

                        public String getExt() {
                            return ext;
                        }

                        public void setExt(String ext) {
                            this.ext = ext;
                        }
                    }
                }

                public static class PicsBean {
                    /**
                     * pid : 899637f2ly1g5we8jm5qmj20u00u0n8j
                     * url : https://wx3.sinaimg.cn/orj360/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg
                     * size : orj360
                     * geo : {"width":360,"height":360,"croped":false}
                     * large : {"size":"large","url":"https://wx3.sinaimg.cn/large/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg","geo":{"width":"1080","height":"1080","croped":false}}
                     */

                    private String pid;
                    private String url;
                    private String size;
                    private GeoBean geo;
                    private LargeBean large;

                    public String getPid() {
                        return pid;
                    }

                    public void setPid(String pid) {
                        this.pid = pid;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public GeoBean getGeo() {
                        return geo;
                    }

                    public void setGeo(GeoBean geo) {
                        this.geo = geo;
                    }

                    public LargeBean getLarge() {
                        return large;
                    }

                    public void setLarge(LargeBean large) {
                        this.large = large;
                    }

                    public static class GeoBean {
                        /**
                         * width : 360
                         * height : 360
                         * croped : false
                         */

                        private int width;
                        private int height;
                        private boolean croped;

                        public int getWidth() {
                            return width;
                        }

                        public void setWidth(int width) {
                            this.width = width;
                        }

                        public int getHeight() {
                            return height;
                        }

                        public void setHeight(int height) {
                            this.height = height;
                        }

                        public boolean isCroped() {
                            return croped;
                        }

                        public void setCroped(boolean croped) {
                            this.croped = croped;
                        }
                    }

                    public static class LargeBean {
                        /**
                         * size : large
                         * url : https://wx3.sinaimg.cn/large/899637f2ly1g5we8jm5qmj20u00u0n8j.jpg
                         * geo : {"width":"1080","height":"1080","croped":false}
                         */

                        private String size;
                        private String url;
                        private GeoBeanX geo;

                        public String getSize() {
                            return size;
                        }

                        public void setSize(String size) {
                            this.size = size;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }

                        public GeoBeanX getGeo() {
                            return geo;
                        }

                        public void setGeo(GeoBeanX geo) {
                            this.geo = geo;
                        }

                        public static class GeoBeanX {
                            /**
                             * width : 1080
                             * height : 1080
                             * croped : false
                             */

                            private String width;
                            private String height;
                            private boolean croped;

                            public String getWidth() {
                                return width;
                            }

                            public void setWidth(String width) {
                                this.width = width;
                            }

                            public String getHeight() {
                                return height;
                            }

                            public void setHeight(String height) {
                                this.height = height;
                            }

                            public boolean isCroped() {
                                return croped;
                            }

                            public void setCroped(boolean croped) {
                                this.croped = croped;
                            }
                        }
                    }
                }
            }

            public static class MblogButtonsBeanX implements Serializable {
                /**
                 * type : mblog_buttons_forward
                 * name : 转发
                 * pic :
                 * actionlog : {"act_code":"1202","act_type":"1","fid":"102803_ctg1_4388_-_ctg1_4388","lfid":"","oid":"4409230629430129","uicode":"","ext":"source:4388"}
                 */

                private String type;
                private String name;
                private String pic;
                private ActionlogBeanXX actionlog;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public ActionlogBeanXX getActionlog() {
                    return actionlog;
                }

                public void setActionlog(ActionlogBeanXX actionlog) {
                    this.actionlog = actionlog;
                }

                public static class ActionlogBeanXX implements Serializable {
                    /**
                     * act_code : 1202
                     * act_type : 1
                     * fid : 102803_ctg1_4388_-_ctg1_4388
                     * lfid :
                     * oid : 4409230629430129
                     * uicode :
                     * ext : source:4388
                     */

                    private String act_code;
                    private String act_type;
                    private String fid;
                    private String lfid;
                    private String oid;
                    private String uicode;
                    private String ext;

                    public String getAct_code() {
                        return act_code;
                    }

                    public void setAct_code(String act_code) {
                        this.act_code = act_code;
                    }

                    public String getAct_type() {
                        return act_type;
                    }

                    public void setAct_type(String act_type) {
                        this.act_type = act_type;
                    }

                    public String getFid() {
                        return fid;
                    }

                    public void setFid(String fid) {
                        this.fid = fid;
                    }

                    public String getLfid() {
                        return lfid;
                    }

                    public void setLfid(String lfid) {
                        this.lfid = lfid;
                    }

                    public String getOid() {
                        return oid;
                    }

                    public void setOid(String oid) {
                        this.oid = oid;
                    }

                    public String getUicode() {
                        return uicode;
                    }

                    public void setUicode(String uicode) {
                        this.uicode = uicode;
                    }

                    public String getExt() {
                        return ext;
                    }

                    public void setExt(String ext) {
                        this.ext = ext;
                    }
                }
            }
        }
    }
}
