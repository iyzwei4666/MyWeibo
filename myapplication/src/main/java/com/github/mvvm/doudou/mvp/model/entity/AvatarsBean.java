package com.github.mvvm.doudou.mvp.model.entity;

public class AvatarsBean {
        /**
         * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp
         * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp
         * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p568.webp
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