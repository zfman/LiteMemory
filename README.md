## LiteMemory

LiteMemory是一个用于简化SharePreference的框架，主要用于简化对象在本地的存储。

用途：在本地存储用户配置时一般需要以下代码，以怪兽课表存储的本地配置为例

读取时示例：
```java
	int hide = ShareTools.getInt(this, "hidenotcur", 0);
	if (hide == 0) {
		hideNotCurSwitch.setChecked(false);
	} else {
		hideNotCurSwitch.setChecked(true);
	}
```

`switch`按钮切换时执行：
```
	@OnCheckedChanged(R.id.id_switch_hidenotcur)
    public void onHideNotCurSwitchClicked(boolean b) {
        setChangeStatus(true);
        if (b) {
            ShareTools.putInt(this, "hidenotcur", 1);
        } else {
            ShareTools.putInt(this, "hidenotcur", 0);
        }
    }
```

如果属性多了，这段代码非常丑陋。

```java
    User user=new User();
    user.setName("刘壮飞"+Math.random()*100);
    LiteMemory.get().save(user);
```