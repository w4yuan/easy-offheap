# Easy-Offheap 框架

## 目标

这个框架的宗旨是为了让 java 开发者更方便的更安全的使用堆外缓存，与其他的堆外框架相比，这个框架具有以下优势

- 操作堆外数据的使用方式和操作 java 堆对象一样，使用更方便
- 支持对单个字段访问，与其他整个对象序列化放入堆外不一样，能支持按需获取
- 无需关注堆外对象的回收，通过虚引用加引用队列自动回收

当然也有一些需要注意的地方

- 操作数组和字符串时，由于是整个堆外数据的拷贝封装，因此速度会比堆对象会慢，如果在速度之间取舍，可以使用 origin
  关键字，让这个字段不成为堆外对象
- 由于 java 对象头以及 cleaner 的封装，引入框架会使得整体内存开销变大

## 使用方式

### 第一步 编写 EO 文件

eo 文件的整体结构如下

``` 
package yourPackage;

struct yourStructName {
    origin? repeated? fieldType yourFieldName = number def? defaultValue;
}

```

保留字解释

- package: 用于表示生成的 java 类包名, 可选填
- struct: 一个类对象的表示 可以理解为 java 的类名
- origin: 是否用 java 原生对象表示，可选填，不填则认为是堆外对象
- repeated: 是否是数组，目前只支持基本数据类型，修饰到 class 对象，String 无效
- def: 可选，用于修饰基本类型，表示默认值，因为基本类型无法判空，所以增加默认值选项来辅助判空，后面 defaultValue 需要满足基本类型范围


fieldType 支持以下关键字

- int: 对应 java 基本类型 int 占堆外 4 字节
- long: 对应 java 基本类型 long 占堆外 8 字节
- byte: 对应 java 基本类型 byte 占堆外 1 字节
- double: 对应 java 基本类型 double 占堆外 8 字节
- float: 对应 java 基本类型 float 占堆外 4 字节
- char: 对应 java 基本类型 char 占堆外 2 字节
- boolean: 对应 java 基本类型 boolean 占堆外 1 字节
- string: 对应 java 对象 String，对应堆外字节数与长度相关
- 如果 fieldType 不是以上关键字，则认为是类对象类型

number 表示字段的顺序，用于表示该堆外对象在堆外的顺序。
示例

```
struct Goods {

  long a = 1;
  string b = 2;
  byte c = 3;
  boolean d = 4;
  float e = 5;
  double f = 6;
  int g = 7;
  repeated long h = 8;
  repeated byte i = 9;
  repeated boolean j = 10;
  repeated float k = 11;
  repeated double l = 12;
  repeated int m = 13;
  Extend n = 14;
  origin double o = 15;
  origin repeated int p = 16;
  Extend q = 17;
}

struct Extend {

  int a = 1;

  repeated boolean b = 2;
}
```

注意文件最好以 .eo 结尾，这样可以使用 maven 插件来生成

### 第二步 生成代码

有两种方式可以生成代码

#### jar 包生成
下载或者打包 easy-offheap-generator jar包，
通过以下命令生成目标代码

```
java -jar easy-offheap-generator arg1 arg2 
```

- arg1 表示 eo 的文件路径
- arg2 表示生成文件的目标路径 可选，不填默认与 eo 同路径

#### 使用 maven 插件

```
<plugin>
    <groupId>io.github.w4yuan.easy-offheap</groupId>
    <artifactId>easy-offheap-plugin</artifactId>
    <version>version</version>
    <configuration>
        <path>yourPath</path>
    </configuration>
</plugin>
```

路径为模块的根目录作为相对路径，例如配置 src/main/java/xxx 可以用目录，会自动扫描该目录下 .eo 作为后缀的文件


### 第三步 依赖 runtime 包
```
<dependency>
    <groupId>io.github.w4yuan.easy-offheap</groupId>
    <artifactId>easy-offheap-runtime</artifactId>
    <version>version</version>
</dependency>
```
依赖 runtime 包，然后将生成的 java 文件引入工作环境即可

## 最佳实践

- 尽量少定义数组和字符串，如果是为了延时，则可以使用 origin 关键词让这部分不用堆外获取，因为数组和字符串涉及到内存拷贝，数据越大延时越高。
- 使用堆外数组如果是获取某个下标的值，可以使用 getRaw{fieldName} 方法获取原始堆外数组对象，通过堆外数组 get(int index)
  方法来获取值
