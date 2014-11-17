以下内容是对[https://docs.google.com/presentation/d/1l9c9ROjLTD8clOL0yFufAOMbxNC0D-19zCiXMgqtY-M/present?slide=id.g1212e8c74_020](https://docs.google.com/presentation/d/1l9c9ROjLTD8clOL0yFufAOMbxNC0D-19zCiXMgqtY-M/present?slide=id.g1212e8c74_020) 总结

###在富媒体和设备多样http1.1 的不足
*   有限的并行性
*   客户端的请求排队
*   较高的协议开销

###怎么改进
*   减少请求次数
*   根据优先级对资源排序

###http2对http1.1的改进
*   线头阻塞(Server push)
*   报头压缩（header compression）
*	多路复用