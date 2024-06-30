package com.cac.mpn.item.Item_Swords;

// 导入所需的包
import com.cac.mpn.item.RegisterItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

// 定义名为 DataKnife 的类，继承 ItemSword 类
public class DataKnife extends ItemSword {

    // 定义工具材料常量，参数分别为名称、等级、耐久度、效率（采掘速度）、攻击伤害、附魔能力
    public static final Item.ToolMaterial DATA_SWORD = EnumHelper.addToolMaterial("DATA", 3, 255, 5.5F, 1.5F, 14);

    // 构造方法
    public DataKnife() {
        super(DATA_SWORD); // 调用父类构造方法，传入工具材料(请忽略警告)
        this.setUnlocalizedName("data_knife"); // 设置未本地化的名称
        this.setRegistryName("data_knife"); // 设置注册名称
    }
}
