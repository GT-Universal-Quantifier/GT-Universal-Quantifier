import net.minecraft.item.ItemSpade
import net.minecraft.item.Item
import net.minecraft.item.Item.ToolMaterial
import net.minecraftforge.common.util.EnumHelper

content.createItem('stone_shard')
    .register()
content.createItem('rawhide')
    .register()
content.createItem('soaked_rawhide')
    .register()
content.createItem('dried_rawhide')
    .register()

def CRUDE_STONE = EnumHelper.addToolMaterial(
    "CRUDE_ROCK",
    0,      // harvest level (wood)
    32,     // durability (very low, realistic)
    1.5f,   // mining speed (slow)
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_fiber_crude_shovel',
    new ItemSpade(CRUDE_STONE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)