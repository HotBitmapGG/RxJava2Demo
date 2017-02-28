package io.netopen.hotbitmapgg.rxjava2demo.bean;

import java.util.List;

/**
 * Created by hcc on 2017/2/28 15:27
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG
 */

public class AndroidInfo {

  /**
   * error : false
   * results : [{"_id":"58b22b9b421aa957f9dd6ddf","createdAt":"2017-02-26T09:12:59.137Z","desc":"Appuim源码剖析(Bootstrap)","images":["http://img.gank.io/cb1f4963-e04b-4427-aeb5-e6b3f0fd1f4f"],"publishedAt":"2017-02-28T11:45:44.815Z","source":"web","type":"Android","url":"http://skyseraph.com/2017/01/26/Android/Appuim%E6%BA%90%E7%A0%81%E5%89%96%E6%9E%90(Boottrap)/","used":true,"who":"SkySeraph"},{"_id":"58b242ff421aa93d376f7526","createdAt":"2017-02-26T10:52:47.6Z","desc":"仿微信朋友圈视频播放特效","images":["http://img.gank.io/5b913719-2113-4c93-aeb4-eca03b831755"],"publishedAt":"2017-02-28T11:45:44.815Z","source":"web","type":"Android","url":"https://miaoyongjun.github.io/2017/02/26/2017-2-26-mvideo/","used":true,"who":"miaoyj"},{"_id":"58b25144421aa957f9dd6de3","createdAt":"2017-02-26T11:53:40.563Z","desc":"A
   * media player playing videos from video sites.","images":["http://img.gank.io/27a19529-4ef4-43fc-9e72-9e80e0083197"],"publishedAt":"2017-02-28T11:45:44.815Z","source":"web","type":"Android","url":"https://github.com/TedaLIEz/ParsingPlayer","used":true,"who":"CoXier"},{"_id":"58b4e0ea421aa90f131785cf","createdAt":"2017-02-28T10:31:06.809Z","desc":"漂亮的
   * Android 圆形菜单。","images":["http://img.gank.io/48615451-b5f0-44a7-a250-d706a23c1eae"],"publishedAt":"2017-02-28T11:45:44.815Z","source":"chrome","type":"Android","url":"https://github.com/ImangazalievM/CircleMenu","used":true,"who":"代码家"},{"_id":"58b2a8fb421aa90efc4fb612","createdAt":"2017-02-26T18:07:55.992Z","desc":"Shuttle\b音乐播放器","publishedAt":"2017-02-27T11:31:40.141Z","source":"chrome","type":"Android","url":"https://github.com/timusus/Shuttle","used":true,"who":"Jason"},{"_id":"58b3741a421aa95810795bc1","createdAt":"2017-02-27T08:34:34.20Z","desc":"漂亮，简洁的
   * Android GitHub 客户端。","images":["http://img.gank.io/6c006cb3-2592-4a08-9df5-438bbdce9fe4","http://img.gank.io/5509d84f-d026-4eee-9a66-b1b6de990af4"],"publishedAt":"2017-02-27T11:31:40.141Z","source":"chrome","type":"Android","url":"https://github.com/k0shk0sh/FastHub","used":true,"who":"代码家"},{"_id":"58b391c7421aa90f033450e4","createdAt":"2017-02-27T10:41:11.713Z","desc":"Android
   * 布局多状态维护工具，实用。","images":["http://img.gank.io/40534072-df0d-48c2-8288-3e8fc991af2c"],"publishedAt":"2017-02-27T11:31:40.141Z","source":"chrome","type":"Android","url":"https://github.com/gturedi/StatefulLayout","used":true,"who":"代码家"},{"_id":"58ad9714421aa957ef93531f","createdAt":"2017-02-22T21:50:12.922Z","desc":"基于官方ViewPager，支持水平方向上滑动和竖直方向上的滑动的ViewPager","images":["http://img.gank.io/1ef8c97f-14a8-4a89-946b-46b9aa8bd3b9"],"publishedAt":"2017-02-24T11:47:11.416Z","source":"web","type":"Android","url":"https://github.com/youngkaaa/YViewPagerDemo","used":true,"who":"杨宽同学"},{"_id":"58ae819e421aa93d376f7510","createdAt":"2017-02-23T14:30:54.386Z","desc":"一个简单且可行度高的
   * Rect Native 热更新方案","images":["http://img.gank.io/1b5eece1-d504-4042-9590-b383fafcb61a"],"publishedAt":"2017-02-24T11:47:11.416Z","source":"web","type":"Android","url":"http://solart.cc/2017/02/22/react-native-jsbundle_patch/","used":true,"who":null},{"_id":"58af904f421aa95810795bb2","createdAt":"2017-02-24T09:45:51.79Z","desc":"封装了最新Lua代码的Android库","publishedAt":"2017-02-24T11:47:11.416Z","source":"web","type":"Android","url":"https://github.com/haodynasty/AndroidLuaExample","used":true,"who":"BlakeQu"}]
   */

  private boolean error;
  private List<ResultsBean> results;


  public boolean isError() { return error;}


  public void setError(boolean error) { this.error = error;}


  public List<ResultsBean> getResults() { return results;}


  public void setResults(List<ResultsBean> results) { this.results = results;}


  public static class ResultsBean {
    /**
     * _id : 58b22b9b421aa957f9dd6ddf
     * createdAt : 2017-02-26T09:12:59.137Z
     * desc : Appuim源码剖析(Bootstrap)
     * images : ["http://img.gank.io/cb1f4963-e04b-4427-aeb5-e6b3f0fd1f4f"]
     * publishedAt : 2017-02-28T11:45:44.815Z
     * source : web
     * type : Android
     * url : http://skyseraph.com/2017/01/26/Android/Appuim%E6%BA%90%E7%A0%81%E5%89%96%E6%9E%90(Boottrap)/
     * used : true
     * who : SkySeraph
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


    public String get_id() { return _id;}


    public void set_id(String _id) { this._id = _id;}


    public String getCreatedAt() { return createdAt;}


    public void setCreatedAt(String createdAt) { this.createdAt = createdAt;}


    public String getDesc() { return desc;}


    public void setDesc(String desc) { this.desc = desc;}


    public String getPublishedAt() { return publishedAt;}


    public void setPublishedAt(String publishedAt) { this.publishedAt = publishedAt;}


    public String getSource() { return source;}


    public void setSource(String source) { this.source = source;}


    public String getType() { return type;}


    public void setType(String type) { this.type = type;}


    public String getUrl() { return url;}


    public void setUrl(String url) { this.url = url;}


    public boolean isUsed() { return used;}


    public void setUsed(boolean used) { this.used = used;}


    public String getWho() { return who;}


    public void setWho(String who) { this.who = who;}


    public List<String> getImages() { return images;}


    public void setImages(List<String> images) { this.images = images;}
  }
}
