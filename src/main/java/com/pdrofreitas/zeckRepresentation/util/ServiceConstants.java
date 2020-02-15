package com.pdrofreitas.zeckRepresentation.util;

public final class ServiceConstants {
    public ServiceConstants() {
    }


    public static final class PARAMS {
        public static final String LOW_NUM_PARAM = "lowNum";
        public static final String HIGH_NUM_PARAM = "highNum";
    }

    public static final class ENDPOINTS {
        public static final String GET_REPRESENTATION = "/represent";
    }

    public static final class API {
        public static final String BASE_URL = "/api";
        public static final String ZECKENDORF_URL = BASE_URL + "/zeckendorf";

    }

}
