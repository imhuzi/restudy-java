package com.uyibai.base.bytecode;

/**
 *
 * 编译java文件：javac  xx.java
 * 查看java字节码： javap -c xx
 *
 * vim 查看 class文件：
 *
 * vim -b xx.class
 *
 * 进入16进制模式：%!xxd
 * 退出16进制模式命令: %!xxd -r
 *
 * 00000000: cafe babe 0000 003d 0010 0a00 0200 0307  .......=........
 * 00000010: 0004 0c00 0500 0601 0010 6a61 7661 2f6c  ..........java/l
 * 00000020: 616e 672f 4f62 6a65 6374 0100 063c 696e  ang/Object...<in
 * 00000030: 6974 3e01 0003 2829 5607 0008 0100 2663  it>...()V.....&c
 * 00000040: 6f6d 2f75 7969 6261 692f 6261 7365 2f62  om/uyibai/base/b
 * 00000050: 7974 6563 6f64 652f 4865 6c6c 6f42 7974  ytecode/HelloByt
 * 00000060: 6543 6f64 650a 0007 0003 0100 0443 6f64  eCode........Cod
 * 00000070: 6501 000f 4c69 6e65 4e75 6d62 6572 5461  e...LineNumberTa
 * 00000080: 626c 6501 0004 6d61 696e 0100 1628 5b4c  ble...main...([L
 * 00000090: 6a61 7661 2f6c 616e 672f 5374 7269 6e67  java/lang/String
 * 000000a0: 3b29 5601 000a 536f 7572 6365 4669 6c65  ;)V...SourceFile
 * 000000b0: 0100 1248 656c 6c6f 4279 7465 436f 6465  ...HelloByteCode
 * 000000c0: 2e6a 6176 6100 2100 0700 0200 0000 0000  .java.!.........
 * 000000d0: 0200 0100 0500 0600 0100 0a00 0000 1d00  ................
 * 000000e0: 0100 0100 0000 052a b700 01b1 0000 0001  .......*........
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/7
 */
public class HelloByteCode {
  public static void main(String[] args) {
    HelloByteCode obj = new HelloByteCode();
  }
}
