package io.grpc;

import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import javax.net.ssl.SSLSession;

public final class Grpc {
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_LOCAL_ADDR = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_LOCAL_ADDR");
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR");
    public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_SSL_SESSION");

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransportAttr {
    }

    private Grpc() {
    }

    public static ManagedChannelBuilder<?> newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return ManagedChannelRegistry.getDefaultRegistry().newChannelBuilder(str, channelCredentials);
    }

    public static ManagedChannelBuilder<?> newChannelBuilderForAddress(String str, int i, ChannelCredentials channelCredentials) {
        return newChannelBuilder(authorityFromHostAndPort(str, i), channelCredentials);
    }

    private static String authorityFromHostAndPort(String str, int i) {
        int i2;
        String str2;
        try {
            str2 = str;
            i2 = i;
            try {
                return new URI((String) null, (String) null, str2, i2, (String) null, (String) null, (String) null).getAuthority();
            } catch (URISyntaxException e) {
                e = e;
                throw new IllegalArgumentException("Invalid host or port: " + str2 + " " + i2, e);
            }
        } catch (URISyntaxException e2) {
            e = e2;
            str2 = str;
            i2 = i;
            throw new IllegalArgumentException("Invalid host or port: " + str2 + " " + i2, e);
        }
    }

    public static ServerBuilder<?> newServerBuilderForPort(int i, ServerCredentials serverCredentials) {
        return ServerRegistry.getDefaultRegistry().newServerBuilderForPort(i, serverCredentials);
    }
}
