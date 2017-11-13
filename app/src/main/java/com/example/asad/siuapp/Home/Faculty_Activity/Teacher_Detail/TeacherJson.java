package com.example.asad.siuapp.Home.Faculty_Activity.Teacher_Detail;

import java.util.List;

/**
 * Created by SHOBOJIT on 1/4/2017.
 */

public class TeacherJson {

    private List<CseBean> cse;
    private List<EceBean> ece;
    private List<EngBean> eng;
    private List<BbaBean> bba;
    private List<LawBean> law;

    public List<CseBean> getCse() {
        return cse;
    }

    public void setCse(List<CseBean> cse) {
        this.cse = cse;
    }

    public List<EceBean> getEce() {
        return ece;
    }

    public void setEce(List<EceBean> ece) {
        this.ece = ece;
    }

    public List<EngBean> getEng() {
        return eng;
    }

    public void setEng(List<EngBean> eng) {
        this.eng = eng;
    }

    public List<BbaBean> getBba() {
        return bba;
    }

    public void setBba(List<BbaBean> bba) {
        this.bba = bba;
    }

    public List<LawBean> getLaw() {
        return law;
    }

    public void setLaw(List<LawBean> law) {
        this.law = law;
    }

    public static class CseBean {
        /**
         * name : Prof. Rishi Kesh Ghose
         * designation : Dean and Head
         * mob : 01715357237
         * image : http://siu.edu.bd/wp-content/uploads/2015/10/rishi-kesh-sir-263x229.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class EceBean {
        /**
         * name : Prof. Rishi Kesh Ghose
         * designation : Dean
         * mob : 01715357237
         * image : http://siu.edu.bd/wp-content/uploads/2015/10/rishi-kesh-sir-263x229.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class EngBean {
        /**
         * name : Prof.Syed Muyeejur Rahman
         * designation : Dean
         * mob : 01911177229
         * image : http://siu.edu.bd/wp-content/uploads/2015/09/m.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class BbaBean {
        /**
         * name : Muhammad Ruhul Amin
         * designation : Dean
         * mob : 01711641679
         * image : http://siu.edu.bd/wp-content/uploads/2015/09/Ruhul-Amin-sir.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class LawBean {
        /**
         * name : Humaun Kabir
         * designation : Head
         * mob : 01912834151
         * image : http://siu.edu.bd/wp-content/uploads/2015/09/DSC08064.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
