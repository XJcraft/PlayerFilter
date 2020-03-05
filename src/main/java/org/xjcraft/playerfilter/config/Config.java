package org.xjcraft.playerfilter.config;

import lombok.Data;
import org.xjcraft.annotation.Instance;
import org.xjcraft.annotation.RConfig;

@RConfig
@Data
public class Config {
    @Instance
    public static Config config = new Config();
    Boolean nameBlocker = true;
    String nameRegex = "[a-zA-z0-9_]{3,16}";
    Boolean modBlocker=true;
    String modMessage = "请更换无mod的纯净客户端！";

}
