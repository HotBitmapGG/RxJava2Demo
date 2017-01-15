package io.netopen.hotbitmapgg.rxjava2demo;

/**
 * Created by hcc on 2017/1/12 16:46
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG
 */

public class BookInfo {

  private String bookName;

  private int id;

  private String bookType;


  public BookInfo(String bookName, int id, String bookType) {
    this.bookName = bookName;
    this.id = id;
    this.bookType = bookType;
  }


  @Override public String toString() {
    return "BookInfo{" +
        "bookName='" + bookName + '\'' +
        ", id=" + id +
        ", bookType='" + bookType + '\'' +
        '}';
  }


  public String getBookName() {
    return bookName;
  }


  public void setBookName(String bookName) {
    this.bookName = bookName;
  }


  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getBookType() {
    return bookType;
  }


  public void setBookType(String bookType) {
    this.bookType = bookType;
  }
}
