# ProjectAPI - Extension for standard class JavaPlugin from Bukkit

### Compatible with Spigot 1.16
### DEV version! Do not use it in a production deployment yet!

## Implementation as a bukkit plugin
```
import com.mkproject.ProjectAPI.PapiPlugin.PapiPlugin;

public final class PapiCore extends PapiPlugin
{
    private static PapiCore plugin;

    @Override
    public void onEnable() {
        // TODO: Plugin run logic
    }

    @Override
    public void onDisable() {
        // TODO: Plugin shutdown logic
    }
}
```

### Builder SQL example:

#### SELECT
```
ResultSQL resultSQL = papiMySQL.builder_v1_0()
.select()
.add("u","username","user")
.from()
.add("users","u")
.end()
.execute();
```

#### INSERT INTO
```
ResultSQL resultSQL = papiMySQL.builder_v1_0()
.insertInto("users")
.columns("email","name")
.valuesArray(new String[] { "test@test.pl", "Test Test" })
.end()
.execute();
```
