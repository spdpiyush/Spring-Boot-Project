package com.piyush.demo.modelVO;

/**
 * Created By : Piyush Kumar
 */

public enum ErrorCodes {


        USER_ALREADY_EXIST(1000,"User Already Exist"),
        USER_NOT_CREATED(1001,"Error in Creating the User");

        private final Integer value;
        private final String phrase;

        ErrorCodes(Integer value, String phrase) {
            this.value = value;
            this.phrase = phrase;
        }

        public Integer getValue() {
            return value;
        }

        public String getPhrase() {
            return phrase;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }


}


