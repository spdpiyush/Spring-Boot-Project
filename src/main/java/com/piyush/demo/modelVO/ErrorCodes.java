package com.piyush.demo.modelVO;

/**
 * Created By : Piyush Kumar
 */

public enum ErrorCodes {


        USER_ALREADY_EXIST(1000,"User Already Exist"),
        USER_NOT_CREATED(1001,"Error in Creating the User"),
        USERS_NOT_CREATED(1002,"Error in Creating List of Users"),
        USER_NOT_PRESENT(1003,"No User with that UserId"),
        NO_USERS_PRESENT(1004,"No Users are ther"),
        ERROR_IN_GET_USER(1005,"Error Occured to get an User"),
        ERROR_IN_GET_USERS(1006,"Error Occured to get all the User"),
        ERROR_IN_PUT_USER(1007,"Error Occured to put a User"),
        ERROR_IN_PUT_USERS(1008,"Error Occured to put List of Users");

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


