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
content.createItem('crude_knapped_stone')
    .register()
content.createItem('antler')
    .register()

def CRUDE_FIBER_STONE = EnumHelper.addToolMaterial(
    "CRUDE_FIBER_ROCK",
    0,      // harvest level
    32,     // durability
    1.5f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_fiber_crude_shovel',
    new ItemSpade(CRUDE_FIBER_STONE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_SOAKED_RAWHIDE_STONE = EnumHelper.addToolMaterial(
    "CRUDE_SOAKED_RAWHIDE_ROCK",
    0,      // harvest level
    24,     // durability
    1.4f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_soaked_rawhide_crude_shovel',
    new ItemSpade(CRUDE_SOAKED_RAWHIDE_STONE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)

def CRUDE_DRIED_RAWHIDE_STONE = EnumHelper.addToolMaterial(
    "CRUDE_DRIED_RAWHIDE_ROCK",
    0,      // harvest level
    64,     // durability
    1.6f,   // mining speed
    0.0f,   // attack damage
    2       // enchantability
)

content.registerItem('rock_dried_rawhide_crude_shovel',
    new ItemSpade(CRUDE_DRIED_RAWHIDE_STONE) {
        {
            setFull3D()
            setMaxStackSize(1)
        }
    }
)