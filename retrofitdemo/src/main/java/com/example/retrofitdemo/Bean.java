package com.example.retrofitdemo;

import java.util.List;

public class Bean {

    /**
     * error : false
     * results : [{"_id":"5c2df1479d2122759a04b597","createdAt":"2019-01-03T11:25:59.115Z","desc":"Android 一键加入侧滑返回 (类似\u201c小米MIX\u201d和新版\u201c即刻\u201d滑动返回)","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze96rdfhmg308w0ft7wh","https://ww1.sinaimg.cn/large/0073sXn7ly1fze96s6tdag308w0ftjvw"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/qinci/AndroidSlideBack","used":true,"who":"qinci"},{"_id":"5c30271a9d2122759a04b59d","createdAt":"2019-01-05T03:40:10.216Z","desc":"一个漂亮的卡片式切换菜单","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze96t2usdg30m80gogrr"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/notice501/coolMenu","used":true,"who":"foocoder"},{"_id":"5c3089459d2122759d3e5ff4","createdAt":"2019-01-05T10:39:01.88Z","desc":"仿QQ图片发送挺炫效果的加载View,效果赞","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze96wakcng30dc0ngb29"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/hewking/HaloImageProgressView","used":true,"who":"hewking"},{"_id":"5c36dc329d212264ce006f29","createdAt":"2019-01-10T05:46:26.150Z","desc":"结合 Zxing Zbar，并处理优化的极速扫码","publishedAt":"2019-01-21T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/nanchen2251/AiYaScanner","used":true,"who":"LiuShilin"},{"_id":"5c384b029d212264ce006f2d","createdAt":"2019-01-11T07:51:30.67Z","desc":"一起来复现网易云音乐引导页效果","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze972ev1og309z0gok3u","https://ww1.sinaimg.cn/large/0073sXn7ly1fze973gq93g309c0godph"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/wobiancao/Music163GuideDemo","used":true,"who":"兔子吃过窝边草"},{"_id":"5c3853279d212264d4501d23","createdAt":"2019-01-11T08:26:15.564Z","desc":"升级UETool，可查看修改任意安装App的布局参数","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze97bnyefg30dc0o0kjn"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/zhangke3016/VirtualUETool","used":true,"who":"张珂"},{"_id":"5c3ecde79d212264d4501d2c","createdAt":"2019-01-16T06:23:35.316Z","desc":"💍一个简洁而优雅的Android原生UI框架，解放你的双手！","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze97f16k0j305e09mq3e","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97fg7orj305e09maag","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97fxcgxj305e09mq5n","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97g6ey1j305e09mq3g","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97ge8pij305e09mjru"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/xuexiangjys/XUI","used":true,"who":"xuexiangjys"},{"_id":"5c4572419d212264cbcc5bd7","createdAt":"2019-01-21T07:18:25.158Z","desc":"此库应用视频过滤器生成Mp4和ExoPlayer视频以及使用Camera2进行视频录制。","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze97qh5sxg308w050tkd","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97s5aung308w050qks","https://ww1.sinaimg.cn/large/0073sXn7ly1fze97u1e6mg308w050nh3"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/MasayukiSuda/GPUVideo-android","used":true,"who":"lijinshanmx"},{"_id":"5c4572d69d212264cbcc5bd8","createdAt":"2019-01-21T07:20:54.364Z","desc":"一个易于使用的表格验证器为Kotlin和Android。","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze97ui6cpj30uk0kiq5m"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/afollestad/vvalidator","used":true,"who":"lijinshanmx"},{"_id":"5c4573b89d212264d18bb26d","createdAt":"2019-01-21T07:24:40.432Z","desc":"初学者入门学习Bloc模式，RxDart，sqflite，Fluro和Dio来构建一个flutter的项目。","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fze97znin9g308w0i57wi"],"publishedAt":"2019-01-21T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/KingWu/flutter_starter_kit","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5c2df1479d2122759a04b597
         * createdAt : 2019-01-03T11:25:59.115Z
         * desc : Android 一键加入侧滑返回 (类似“小米MIX”和新版“即刻”滑动返回)
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7ly1fze96rdfhmg308w0ft7wh","https://ww1.sinaimg.cn/large/0073sXn7ly1fze96s6tdag308w0ftjvw"]
         * publishedAt : 2019-01-21T00:00:00.0Z
         * source : web
         * type : Android
         * url : https://github.com/qinci/AndroidSlideBack
         * used : true
         * who : qinci
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Bean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
