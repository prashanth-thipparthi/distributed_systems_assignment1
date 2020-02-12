package com.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TimeServer.proto")
public final class TimeServerGrpc {

  private TimeServerGrpc() {}

  public static final String SERVICE_NAME = "TimeServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.TimeServerOuterClass.Msg,
      com.grpc.TimeServerOuterClass.Times> getGetTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTime",
      requestType = com.grpc.TimeServerOuterClass.Msg.class,
      responseType = com.grpc.TimeServerOuterClass.Times.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.TimeServerOuterClass.Msg,
      com.grpc.TimeServerOuterClass.Times> getGetTimeMethod() {
    io.grpc.MethodDescriptor<com.grpc.TimeServerOuterClass.Msg, com.grpc.TimeServerOuterClass.Times> getGetTimeMethod;
    if ((getGetTimeMethod = TimeServerGrpc.getGetTimeMethod) == null) {
      synchronized (TimeServerGrpc.class) {
        if ((getGetTimeMethod = TimeServerGrpc.getGetTimeMethod) == null) {
          TimeServerGrpc.getGetTimeMethod = getGetTimeMethod = 
              io.grpc.MethodDescriptor.<com.grpc.TimeServerOuterClass.Msg, com.grpc.TimeServerOuterClass.Times>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TimeServer", "getTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.TimeServerOuterClass.Msg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.TimeServerOuterClass.Times.getDefaultInstance()))
                  .setSchemaDescriptor(new TimeServerMethodDescriptorSupplier("getTime"))
                  .build();
          }
        }
     }
     return getGetTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TimeServerStub newStub(io.grpc.Channel channel) {
    return new TimeServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TimeServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TimeServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TimeServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TimeServerFutureStub(channel);
  }

  /**
   */
  public static abstract class TimeServerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Obtains the Message and returns the server times.
     * </pre>
     */
    public void getTime(com.grpc.TimeServerOuterClass.Msg request,
        io.grpc.stub.StreamObserver<com.grpc.TimeServerOuterClass.Times> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.TimeServerOuterClass.Msg,
                com.grpc.TimeServerOuterClass.Times>(
                  this, METHODID_GET_TIME)))
          .build();
    }
  }

  /**
   */
  public static final class TimeServerStub extends io.grpc.stub.AbstractStub<TimeServerStub> {
    private TimeServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TimeServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TimeServerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obtains the Message and returns the server times.
     * </pre>
     */
    public void getTime(com.grpc.TimeServerOuterClass.Msg request,
        io.grpc.stub.StreamObserver<com.grpc.TimeServerOuterClass.Times> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TimeServerBlockingStub extends io.grpc.stub.AbstractStub<TimeServerBlockingStub> {
    private TimeServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TimeServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TimeServerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obtains the Message and returns the server times.
     * </pre>
     */
    public com.grpc.TimeServerOuterClass.Times getTime(com.grpc.TimeServerOuterClass.Msg request) {
      return blockingUnaryCall(
          getChannel(), getGetTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TimeServerFutureStub extends io.grpc.stub.AbstractStub<TimeServerFutureStub> {
    private TimeServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TimeServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TimeServerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obtains the Message and returns the server times.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.TimeServerOuterClass.Times> getTime(
        com.grpc.TimeServerOuterClass.Msg request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TIME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TimeServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TimeServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TIME:
          serviceImpl.getTime((com.grpc.TimeServerOuterClass.Msg) request,
              (io.grpc.stub.StreamObserver<com.grpc.TimeServerOuterClass.Times>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TimeServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TimeServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.TimeServerOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TimeServer");
    }
  }

  private static final class TimeServerFileDescriptorSupplier
      extends TimeServerBaseDescriptorSupplier {
    TimeServerFileDescriptorSupplier() {}
  }

  private static final class TimeServerMethodDescriptorSupplier
      extends TimeServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TimeServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TimeServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TimeServerFileDescriptorSupplier())
              .addMethod(getGetTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
