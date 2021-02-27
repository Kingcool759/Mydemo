package com.example.mydemo.entity;

import java.util.List;

/**
 * @data on 2/28/21 1:30 AM
 * @auther armStrong759
 * @describe  百度第三方SDK-OCR图片识别文字接入返回json转databean
 */
public class OCRResultBean {

    /**
     * log_id : 4694100800134148699
     * direction : 0
     * words_result_num : 3
     * words_result : [{"words":" HERO"},{"words":" WARS"},{"words":"杀死地精"}]
     */

    private long log_id;
    private int direction;
    private int words_result_num;
    /**
     * words :  HERO
     */

    private List<WordsResultBean> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
