package com.lgq.nettypractice;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * netty服务端
 *
 * @author jokeloo
 */
public class NettyServer {

    public NettyServer start(int port) {
        Thread thread = new Thread(new TcpServerWork(port));
        thread.setName("tcp service port monitoring thread -> " + port);
        thread.start();
        return this;

    }

    private static final class TcpServerWork implements Runnable {
        //
        private NioEventLoopGroup boosGroup;
        //
        private NioEventLoopGroup workerGroup;
        //
        private int port;

        TcpServerWork(int port) {
            this.port = port;
        }

        public void run() {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {

                        }
                    }).option(ChannelOption.SO_BACKLOG, 1024);
            ChannelFuture f = bootstrap.bind(port);
        }
    }


}
