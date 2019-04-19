package com.github.mvvm.douban.mvp.model.entity;

public class ImagesBean {
        /**
         * small : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2280764377.webp
         * large : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2280764377.webp
         * medium : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2280764377.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }