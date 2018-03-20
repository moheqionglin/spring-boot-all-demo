package com.spring.regular.designPattern.模板模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 1:31 PM.
 */
public abstract class AbstractCookTemplate {

     void templateCookMethod(){
          prepareFood();
          prepareTools();
          if(isChineseFood()){
               fireUp();
          }else{
               microwaveOven();
          }
          cook();
          hook();
     }

     protected abstract void prepareFood();
     protected abstract void prepareTools();
     protected void fireUp(){
          System.out.println("=> 生火");
     };
     protected void microwaveOven(){
          System.out.println("=> 打开微波炉");
     }
     protected void cook(){
          System.out.println("=> 烹饪");
     }

     protected abstract boolean isChineseFood();
     protected abstract void hook();
}
