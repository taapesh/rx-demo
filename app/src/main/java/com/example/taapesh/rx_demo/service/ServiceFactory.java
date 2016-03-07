package com.example.taapesh.rx_demo.service;

import retrofit.RestAdapter;

public class ServiceFactory {

    /**
     * Create a retrofit service from an arbitrary class
     * @param clazz Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .build();
        return restAdapter.create(clazz);
    }
}
