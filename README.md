## LiteMemory

LiteMemory是一个用于简化SharePreference的框架，主要用于简化对象在本地的存储。

用途：在本地存储用户配置时一般需要以下代码，以怪兽课表存储的本地配置为例


之前获取配置的方式是这样的：

```java
	int hide = ShareTools.getInt(this, "hidenotcur", 0);
	if (hide == 0) {
		hideNotCurSwitch.setChecked(false);
	} else {
		hideNotCurSwitch.setChecked(true);
	}
```


使用`LiteMemory`可以这样:

```java
	ConfigExample example=LiteMemory.get().from(ConfigExample.class);
	if (!example.isHideNotCur()) {
		hideNotCurSwitch.setChecked(false);
	} else {
		hideNotCurSwitch.setChecked(true);
	}
```


## 简单使用

**引入依赖**[![](https://jitpack.io/v/zfman/LiteMemory.svg)](https://jitpack.io/#zfman/LiteMemory)

**To get a Git project into your build:**

**Step 1. Add the JitPack repository to your build file**

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

**Step 2. Add the dependency**
```
	dependencies {
	        implementation 'com.github.zfman:LiteMemory:1.0.0'
	}
```

**初始化**

- 你需要先执行LiteMemory的初始化操作，一般将该操作放在`Application`中

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LiteMemory.initialize(this);
    }
}
```

- 然后再AndroidManifest.xml中配置`application`

```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.zhuangfei.preference_demo">

    <!--通过android:name配置application-->
    <application
        android:name=".MyApplication"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

**保存数据**

需要保存的数据需要以字段的形式存在于实体类中，假设需要保存用户信息，用户有用户名和年龄两个属性

User类如下:
```java
public class User {
    private String name;
    private int age = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

```

**保存数据**

```java
    User user=new User();
    user.setName("刘壮飞");
    user.setAge(23);

    //保存至本地
    LiteMemory.get().save(user);
```

**获取数据**

```java
    User user=LiteMemory.get().from(User.class);

    //此时user内的属性已被赋值，可以使用
    //若本地不存在，则会使用User类构造一个实例，
    //此时user对象中的属性值可能是空的
    String name=user.getName();
    int age=user.getAge();
```

**删除数据**

```java
    LiteMemory.get().delete(User.class);
```

**判断数据是否存在**

```java
    boolean has=LiteMemory.get().exist(User.class);
```

**混淆**

本库没有混淆，但是内部采用fastjson进行序列化与反序列化，如果你的项目需要混淆的话请自行查阅资料添加