package nettypractice;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.sound.sampled.Port;

/**
 * netty服务端
 *
 * @author jokeloo
 */
public class NettyServer {

    private static final class TcpServerWork implements Runnable {
        //
        private NioEventLoopGroup boosGroup;
        //
        private NioEventLoopGroup workerGroup;

        public void run() {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {

                        }
                    });
        }
    }


}
