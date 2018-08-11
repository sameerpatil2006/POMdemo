package PageObjects;

import java.util.List;

public class Registration {

        public String name;
        public String lastName;
        public List<Long> dob;
        public List<String> status;
        public String country;
        public String desc;
        public List<String> hobby;
        public String number;
        public String email;
        public String password;
        public String confmPassword;
        public String error;
        public String usrNm;

        public static class Builder {

            public String name;
            public String lastName;
            public List<Long> dob;
            public List<String> status;
            public String country;
            public String desc;
            public List<String> hobby;
            public String number;
            public String email;
            public String password;
            public String confmPassword;
            public String error;
            public String usrNm;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder usrNm(String usrNm) {
                this.usrNm = usrNm;
                return this;
            }

            public Builder dob(List<Long> dob) {
                this.dob = dob;
                return this;
            }

            public Builder status(List<String> status) {
                this.status = status;
                return this;
            }

            public Builder country(String country) {
                this.country = country;
                return this;
            }
            public Builder desc(String desc) {
                this.desc = desc;
                return this;
            }
            public Builder hobby(List<String> hobby) {
                this.hobby = hobby;
                return this;
            }
            public Builder number(String number) {
                this.number = number;
                return this;
            }
            public Builder email(String email) {
                this.email = email;
                return this;
            }
            public Builder password(String password) {
                this.password = password;
                return this;
            }
            public Builder confmPassword(String confmPassword) {
                this.confmPassword = confmPassword;
                return this;
            }
            public Builder error(String error) {
                this.error =  error;
                return this;
            }
            public Registration build() {
                Registration registration = new Registration(this);
                return registration;
            }
        }

        public Registration(Builder builder) {
            this.name = builder.name;
            this.lastName = builder.lastName;
            this.dob = builder.dob;
            this.status = builder.status;
            this.confmPassword = builder.confmPassword;
            this.email = builder.email;
            this.error = builder.error;
            this.desc = builder.desc;
            this.country = builder.country;
            this.hobby = builder.hobby;
            this.password = builder.password;
            this.number = builder.number;
            this.usrNm = builder.usrNm;
        }
}
