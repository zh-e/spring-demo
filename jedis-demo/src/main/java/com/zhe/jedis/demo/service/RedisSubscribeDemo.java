package com.zhe.jedis.demo.service;

import redis.clients.jedis.JedisPubSub;

public class RedisSubscribeDemo extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        //订阅消息处理
        System.out.println("onMessage " + channel + " == " + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        //初始化订阅
        System.out.println("onSubscribe 成功");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        //取消订阅
        System.out.println("onUnsubscribe 成功");
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        //按表达式的方式订阅的消息
        super.onPMessage(pattern, channel, message);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
    }

}
