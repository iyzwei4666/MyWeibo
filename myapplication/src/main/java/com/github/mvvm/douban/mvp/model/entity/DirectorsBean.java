package com.github.mvvm.douban.mvp.model.entity;

public class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1406354/
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1544189025.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1544189025.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1544189025.81.webp"}
         * name : 克里斯托弗·布鲁斯
         * id : 1406354
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

      
    }